package com.example.hen.sichon.fragments

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.hen.sichon.R
import com.example.hen.sichon.adapters.PhrasesCategoryAdapter
import com.example.hen.sichon.models.PhraseModel
import com.example.hen.sichon.utils.AppUtils
import java.util.*

class PhrasesCategoryFragment : Fragment()
{
    companion object
    {
        fun getInstance(): PhrasesCategoryFragment
        {
            return PhrasesCategoryFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        return inflater?.inflate(R.layout.fragment_phrases_category, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        val phrasesCategoryRecyclerView = view?.findViewById(R.id.recycler_view_phrases_category) as RecyclerView

        val hebRes = AppUtils.getLocalizedResources(activity.baseContext, Locale("iw", "IL"))
        val hebPhrases = hebRes.getStringArray(R.array.transportation)

        val ruRes = AppUtils.getLocalizedResources(activity.baseContext, Locale("ru"))
        val ruPhrases = ruRes.getStringArray(R.array.transportation)

        val phrases = hebPhrases.zip(ruPhrases!!, { hebPhrase, ruPhrase -> PhraseModel(hebPhrase, ruPhrase) })
        val phrasesCategoryAdapter = PhrasesCategoryAdapter(phrases)

        phrasesCategoryRecyclerView.layoutManager = LinearLayoutManager(activity.baseContext, LinearLayout.VERTICAL, false)
        phrasesCategoryRecyclerView.adapter = phrasesCategoryAdapter
    }
}