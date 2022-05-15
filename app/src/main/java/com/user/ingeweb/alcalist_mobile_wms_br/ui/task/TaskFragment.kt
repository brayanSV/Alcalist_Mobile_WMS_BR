package com.user.ingeweb.alcalist_mobile_wms_br.ui.task

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.user.ingeweb.alcalist_mobile_wms_br.AppExecutors
import com.user.ingeweb.alcalist_mobile_wms_br.R
import com.user.ingeweb.alcalist_mobile_wms_br.binding.FragmentDataBindingComponent
import com.user.ingeweb.alcalist_mobile_wms_br.databinding.FragmentTaskBinding
import com.user.ingeweb.alcalist_mobile_wms_br.di.Injectable
import com.user.ingeweb.alcalist_mobile_wms_br.model.UserRequest
import com.user.ingeweb.alcalist_mobile_wms_br.ui.common.TaskCallback
import com.user.ingeweb.alcalist_mobile_wms_br.utils.autoCleared
import javax.inject.Inject

class TaskFragment : Fragment(), Injectable {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var appExecutors: AppExecutors

    var dataBindingComponent: DataBindingComponent = FragmentDataBindingComponent(this)
    var binding by autoCleared<FragmentTaskBinding>()
    var adapter by autoCleared<AdapterTask>()

    val taskViewModel: TaskViewModel by viewModels {
        viewModelFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_task, container, false, dataBindingComponent)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.lifecycleOwner = viewLifecycleOwner

        val rvAdapter = AdapterTask(
            dataBindingComponent = dataBindingComponent,
            appExecutors = appExecutors
        )

        this.adapter = rvAdapter
        this.binding.taskList.adapter = this.adapter



        binding.taskOnclick = object: TaskCallback {
            override fun filter() {
                TODO("Not yet implemented")
            }

            override fun sync() {
                taskViewModel.loadTask.observe(viewLifecycleOwner, Observer { taskList ->
                    Log.e("data 1", taskViewModel.loadTask.value.toString())

                    binding.task = taskViewModel.loadTask

                    Log.e("data 2", "${taskList.data?.size}")

                    adapter.submitList(taskList.data)
                })
            }
        }
    }
}