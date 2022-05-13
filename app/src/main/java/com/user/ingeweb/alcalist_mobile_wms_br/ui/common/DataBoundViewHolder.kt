package com.user.ingeweb.alcalist_mobile_wms_br.ui.common

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class DataBoundViewHolder<out T: ViewDataBinding> constructor(val binding: T): RecyclerView.ViewHolder(binding.root)