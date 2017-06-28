package com.example.hen.sichon.activities.interfaces

import android.support.v4.app.Fragment

interface FragmentNavigation
{
    fun replaceFragment(addToBackStack: Boolean, fragment: Fragment)
}