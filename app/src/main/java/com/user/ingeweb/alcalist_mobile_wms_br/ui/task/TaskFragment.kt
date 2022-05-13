package com.user.ingeweb.alcalist_mobile_wms_br.ui.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.user.ingeweb.alcalist_mobile_wms_br.R
import com.user.ingeweb.alcalist_mobile_wms_br.di.Injectable

class TaskFragment : Fragment(), Injectable {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task, container, false)
    }
}