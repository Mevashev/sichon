package com.example.hen.sichon.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.hen.sichon.R
import com.example.hen.sichon.adapters.PhrasesAdapter
import com.example.hen.sichon.data.Database
import com.example.hen.sichon.enums.Language
import com.example.hen.sichon.getId
import com.example.hen.sichon.managers.PersistenceManager
import com.example.hen.sichon.models.PhraseModel
import com.example.hen.sichon.utils.AppUtils

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

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        val phrasesRecyclerView = view?.findViewById(R.id.recycler_view_phrases) as RecyclerView

        val fromLanguage = Language.getLanguageFromString(PersistenceManager.getTranslateFromLanguage())
        val fromRes = AppUtils.getLocalizedResources(activity, fromLanguage.locale)

        val toLanguage = Language.getLanguageFromString(PersistenceManager.getTranslteToLanguage())
        val toRes = AppUtils.getLocalizedResources(activity, toLanguage.locale)

        phrasesRecyclerView.layoutManager = LinearLayoutManager(activity.baseContext, LinearLayout.VERTICAL, false)
        val phrases = mutableListOf<PhraseModel>()
        for ((phraseId, categoryId) in Database.getFavorites())
        {
            val fromPhrase = fromRes.getStringArray(categoryId!!).filter { it.getId() == phraseId }[0]
            val toPhrase = toRes.getStringArray(categoryId).filter { it.getId() == phraseId }[0]
            val phraseModel = PhraseModel(fromPhrase, toPhrase, true)
            phrases.add(phraseModel)
        }
        val phrasesAdapter = PhrasesAdapter(phrases)
        phrasesRecyclerView.adapter = phrasesAdapter


    }
}