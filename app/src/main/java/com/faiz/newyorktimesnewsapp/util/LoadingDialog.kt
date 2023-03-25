package com.faiz.newyorktimesnewsapp.util

import android.app.Dialog
import android.content.Context
import com.faiz.newyorktimesnewsapp.R

class LoadingDialog(context: Context) : Dialog(context) {
    init {
        setContentView(R.layout.loading_layout)
        window?.setBackgroundDrawableResource(android.R.color.transparent)
        setCanceledOnTouchOutside(false)
        show()
    }
}