package com.khairo.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.avatarfirst.avatargenlib.AvatarConstants
import com.avatarfirst.avatargenlib.AvatarGenerator
import com.bumptech.glide.Glide.with
import com.khairo.dotassignment.R

@BindingAdapter("loadImageFromUrl")
fun bindImageFromUrl(view: ImageView, imageUrl: String) {
    if (imageUrl.isNotEmpty())
        with(view.context)
            .load(imageUrl)
            .error(R.drawable.ic_default_placeholder)
            .into(view)
    else
        with(view.context)
            .load(R.drawable.ic_default_placeholder)
            .into(view)

}

@BindingAdapter("loadRoundedImageFromUrl")
fun bindRoundedImageFromUrl(view: ImageView, imageUrl: String) {
    if (imageUrl.isNotEmpty())
        with(view.context)
            .load(imageUrl)
            .circleCrop()
            .error(R.drawable.ic_default_placeholder)
            .into(view)
    else
        with(view.context)
            .load(R.drawable.ic_default_placeholder)
            .circleCrop()
            .into(view)

}

@BindingAdapter("loadImageFromText")
fun bindImageFromText(imageView: ImageView, text: String) {
    with(imageView)
        .load("http://brokenfortest")
        .placeholder(
            AvatarGenerator.avatarImage(
                imageView.context,
                150,
                AvatarConstants.CIRCLE,
                text
            )
        )
        .into(imageView)
}

