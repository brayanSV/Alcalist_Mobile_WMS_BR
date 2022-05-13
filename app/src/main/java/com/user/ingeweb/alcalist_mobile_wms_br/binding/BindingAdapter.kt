package com.user.ingeweb.alcalist_mobile_wms_br.binding

import android.graphics.drawable.Drawable
import android.media.Image
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


object BindingAdapter {
    @JvmStatic
    @BindingAdapter("visibleGone")
    fun showHide(view: View, show: Boolean) {
        view.visibility = if (show) View.VISIBLE else View.GONE
    }

    @JvmStatic
    @BindingAdapter(value = ["isAnimated","imageSrc"], requireAll = true)
    fun startAnimateImage(view: ImageView, isAnimated: Boolean, imageSrc: Drawable) {
        if (isAnimated) {
            Glide.with(view.context)
                .asGif()  // Load as animated GIF
                .load(imageSrc)  // Call your GIF here (url, raw, etc.)
                .into(view)

            /*Ion.with(view)
                .error(imageSrc)
                .animateGif(AnimateGifMode.ANIMATE)
                .load("android.resource://" + view.context.packageName + "/" + imageSrc)*/
        } else {
            Glide.with(view.context)
                .load(imageSrc)
                .into(view)
        }
    }
}