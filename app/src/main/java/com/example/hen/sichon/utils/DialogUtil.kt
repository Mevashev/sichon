package com.example.hen.sichon.utils

import android.content.Context
import android.support.annotation.StringRes
import com.afollestad.materialdialogs.MaterialDialog

class DialogUtil
{
    companion object
    {
        fun createTwoButtonsConfirmationDialog(context: Context, @StringRes title: Int, @StringRes positiveText: Int, @StringRes negativeText: Int, positiveCallback: MaterialDialog.SingleButtonCallback, negativeCallback: MaterialDialog.SingleButtonCallback): MaterialDialog.Builder
        {
            return MaterialDialog.Builder(context)
                    .cancelable(false)
                    .title(title)
                    .positiveText(positiveText)
                    .negativeText(negativeText)
                    .onPositive(positiveCallback)
                    .onNegative(negativeCallback)
        }
    }
}