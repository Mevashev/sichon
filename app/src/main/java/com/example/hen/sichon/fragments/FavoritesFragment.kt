package com.example.hen.sichon.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hen.sichon.R

/**
 * Created by slava-android on 6/27/2017.
 * Falcore Ltd.
 */
class FavoritesFragment : Fragment() {
    companion object {
        fun getInstance(): FavoritesFragment {
            return FavoritesFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_favorites, container, false)
    }
}