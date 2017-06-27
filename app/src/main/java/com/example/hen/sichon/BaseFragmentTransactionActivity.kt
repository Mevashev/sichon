package com.example.hen.sichon

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

/**
 * Created by slava-android on 6/27/2017.
 * Falcore Ltd.
 */
open class BaseFragmentTransactionActivity : AppCompatActivity() {

    fun replaceFragment(addToBackStack: Boolean, fragment: Fragment) {
        val ft = supportFragmentManager.beginTransaction()

        if (addToBackStack) {
            ft.add(R.id.fragments_container, fragment, fragment.javaClass.simpleName).addToBackStack(fragment.javaClass.simpleName).commit()
        } else {
            ft.add(R.id.fragments_container, fragment, fragment.javaClass.simpleName).commit()
        }
    }
}