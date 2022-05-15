package com.user.ingeweb.alcalist_mobile_wms_br.ui.task

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.user.ingeweb.alcalist_mobile_wms_br.model.*
import com.user.ingeweb.alcalist_mobile_wms_br.repository.Resource
import com.user.ingeweb.alcalist_mobile_wms_br.repository.TaskRepository
import javax.inject.Inject

class TaskViewModel @Inject constructor(taskRepository: TaskRepository): ViewModel() {
    private val _userRequest: MutableLiveData<UserRequest> = MutableLiveData()
    private val userRequest: LiveData<UserRequest> = _userRequest

    val loadTask: LiveData<Resource<List<Task>>> = taskRepository.loadTask(UserRequest())
    val status: LiveData<StatusResponse> = taskRepository.status

    fun setUserRequest(userRequest: UserRequest) {
        Log.e("data","${status.value?.Code} -> ${status.value?.Message}")
    }
}