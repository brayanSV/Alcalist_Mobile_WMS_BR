package com.user.ingeweb.alcalist_mobile_wms_br.ui.task

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.user.ingeweb.alcalist_mobile_wms_br.AppExecutors
import com.user.ingeweb.alcalist_mobile_wms_br.R
import com.user.ingeweb.alcalist_mobile_wms_br.databinding.TaskItemBinding
import com.user.ingeweb.alcalist_mobile_wms_br.model.Task
import com.user.ingeweb.alcalist_mobile_wms_br.ui.common.DataBoundListAdapter

class AdapterTask (
    private val dataBindingComponent: DataBindingComponent,
    appExecutors: AppExecutors
): DataBoundListAdapter<Task, TaskItemBinding>(
    appExecutors = appExecutors,
    diffCallback = object : DiffUtil.ItemCallback<Task> () {
        override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem.TaskId == newItem.TaskId
        }

        override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem.TaskId == newItem.TaskId && oldItem.ProfileId == newItem.ProfileId
        }
    }
) {
    override fun createBinding(parent: ViewGroup): TaskItemBinding {
        val binding = DataBindingUtil.inflate<TaskItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.task_item,
            parent,
            false,
            dataBindingComponent
        )

        return binding
    }

    override fun bind(binding: TaskItemBinding, item: Task) {
        binding.opetask = item
    }

}