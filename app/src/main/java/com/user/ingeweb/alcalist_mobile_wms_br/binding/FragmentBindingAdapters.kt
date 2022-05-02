package com.user.ingeweb.alcalist_mobile_wms_br.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import javax.inject.Inject

class FragmentBindingAdapters @Inject constructor(private val fragment: Fragment) {
    @BindingAdapter("imageUrl")
    fun bindImage(imageView: ImageView, url: String?) {
        Glide.with(fragment.requireContext()).load(url).into(imageView)
    }
}