package com.user.ingeweb.alcalist_mobile_wms_br.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.user.ingeweb.alcalist_mobile_wms_br.AppExecutors
import com.user.ingeweb.alcalist_mobile_wms_br.api.ApiResponse
import com.user.ingeweb.alcalist_mobile_wms_br.api.ApplicationApi
import com.user.ingeweb.alcalist_mobile_wms_br.db.TaskDao
import com.user.ingeweb.alcalist_mobile_wms_br.model.ResponseTask
import com.user.ingeweb.alcalist_mobile_wms_br.model.StatusResponse
import com.user.ingeweb.alcalist_mobile_wms_br.model.Task
import com.user.ingeweb.alcalist_mobile_wms_br.model.UserRequest
import com.user.ingeweb.alcalist_mobile_wms_br.utils.AbsentLiveData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskRepository @Inject constructor(
    private val appExecutors: AppExecutors,
    private val taskDao: TaskDao,
    private val applicationApi: ApplicationApi
) {
    private val _status: MutableLiveData<StatusResponse> = MutableLiveData()
    val status: LiveData<StatusResponse> = _status

    fun loadTask(userRequest: UserRequest): LiveData<Resource<List<Task>>> = object: NetworkBoundResource<List<Task>, ResponseTask>(appExecutors) {
        override fun loadFromDataBase(): LiveData<List<Task>> {
            val task: LiveData<List<Task>> = taskDao.load()
            _status.postValue(StatusResponse("000","Cargado de la base local"))

            return taskDao.load()

            /*return if (task.value == null || task.value!!.isEmpty()) {
                AbsentLiveData.create()
            } else {
                task
            }*/
        }

        override fun shouldFetch(data: List<Task>?): Boolean {
            return data == null || data.isEmpty()
        }

        override fun saveCallResult(item: ResponseTask) {
            _status.postValue(item.Status)

            item.Task.forEach { task ->
                Log.e("data", "${task}")
                task.StatusTaskId = 1
                taskDao.insert(task)
            }

            Log.e("data", "total: ${item.Task.size}")
        }

        override fun createCall(): LiveData<ApiResponse<ResponseTask>> {
            return applicationApi.task(userRequest)
        }
    }.asLiveData()
}