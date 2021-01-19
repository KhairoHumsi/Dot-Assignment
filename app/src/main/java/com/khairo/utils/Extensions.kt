package com.khairo.utils

import android.content.Context
import android.net.ConnectivityManager
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.snackbar.Snackbar
import timber.log.Timber

/**
 * these some extensions and functions for repeating using
 *
 */

fun View.snack(@StringRes messageRes: Int, length: Int = Snackbar.LENGTH_LONG) {
    snack(resources.getString(messageRes), length)
}

fun View.snack(message: String, length: Int = Snackbar.LENGTH_LONG) {
    Snackbar.make(this, message, length).show()
}

fun Int.toast(context: Context, duration: Int = Toast.LENGTH_LONG): Toast {
    return context.getString(this).toast(context = context, duration = duration)
}

fun String.toast(context: Context, duration: Int = Toast.LENGTH_LONG): Toast {
    return Toast.makeText(context, this, duration).apply { show() }
}

fun String.log(logging: String) {
    Timber.tag(this).d(logging)
}

fun Context.dpToPx(dp: Int): Int = (dp * resources.displayMetrics.density).toInt()

fun Context.getAspectRatio(): Float {
    val metrics = resources.displayMetrics
    return if (metrics.widthPixels.toFloat() > metrics.heightPixels.toFloat()) metrics.widthPixels.toFloat() / metrics.heightPixels.toFloat()
    else metrics.heightPixels.toFloat() / metrics.widthPixels.toFloat()
}


fun FragmentManager.findNavController(viewId: Int) =
    (findFragmentById(viewId) as NavHostFragment).navController

fun Context.isOnline(): Boolean {
    return try {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo

        //should check null because in airplane mode it will be null
        netInfo != null && netInfo.isConnected
    } catch (e: NullPointerException) {
        e.printStackTrace()
        false
    }
}
