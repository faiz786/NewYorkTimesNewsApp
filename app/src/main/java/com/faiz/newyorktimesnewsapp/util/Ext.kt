package com.faiz.newyorktimesnewsapp.util

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

fun Context.toast(msg: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, msg, length).show()
}


fun showSnackBar(
    activity: Activity, message: String, action: String? = null,
    actionListener: View.OnClickListener? = null, duration: Int = Snackbar.LENGTH_LONG
) {
    val snackBar = Snackbar.make(activity.findViewById(android.R.id.content), message, duration)
        .setBackgroundTint(Color.parseColor("#CC000000"))
        .setTextColor(Color.WHITE)
    if (action != null && actionListener != null) {
        snackBar.setAction(action, actionListener)
    }
    snackBar.show()
}