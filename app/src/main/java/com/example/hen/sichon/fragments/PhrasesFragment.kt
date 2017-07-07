package com.example.hen.sichon.fragments

import android.os.Build
import android.os.Bundle
import android.support.annotation.ArrayRes
import android.support.annotation.RequiresApi
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
import com.example.hen.sichon.managers.PersistenceManager
import com.example.hen.sichon.models.PhraseModel
import com.example.hen.sichon.utils.AppUtils

class PhrasesFragment : Fragment()
{
    companion object
    {
        private val ARG_CATEGORY_ID = "arg.CATEGORY_NAME"

        fun getInstance(@ArrayRes categoryId: Int): PhrasesFragment
        {
            val fragment = PhrasesFragment()
            val arguments = Bundle()
            arguments.putInt(ARG_CATEGORY_ID, categoryId)
            fragment.arguments = arguments
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        return inflater?.inflate(R.layout.fragment_phrases, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        val phrasesRecyclerView = view?.findViewById(R.id.recycler_view_phrases) as RecyclerView

        val categoryId = arguments.getInt(ARG_CATEGORY_ID)

        val fromLanguage = Language.getLanguageFromString(PersistenceManager.getTranslateFromLanguage())
        val fromRes = AppUtils.getLocalizedResources(activity.baseContext, fromLanguage.locale)
        val fromPhrases = fromRes.getStringArray(categoryId)

        val toLanguage = Language.getLanguageFromString(PersistenceManager.getTranslteToLanguage())
        val toRes = AppUtils.getLocalizedResources(activity.baseContext, toLanguage.locale)
        val toPhrases = toRes.getStringArray(categoryId)

        val phrases = fromPhrases.zip(toPhrases!!, { fromPhrase, toPhrase -> PhraseModel(fromPhrase, toPhrase) })
        for (i in 0 until phrases.size)
        {
            phrases[i].isFavorite = Database.isFavorite(categoryId, i)
        }
        val phrasesAdapter = PhrasesAdapter(phrases)

        phrasesAdapter.setOnPhraseClickListener(object : PhrasesAdapter.OnPhraseClickListener
        {
            override fun onPhraseClick(textToSpeech: String)
            {
                AppUtils.textToSpeech(activity.baseContext, toLanguage.locale, textToSpeech)
            }

            override fun onFavoriteClick(phraseId: Int)
            {
                val isFavorite = Database.isFavorite(categoryId, phraseId)
                if (isFavorite)
                {
                    Database.deleteFavorite(categoryId, phraseId)
                    phrasesAdapter.setFavorite(false, phraseId)
                }
                else
                {
                    Database.insertFavorite(categoryId, phraseId)
                    phrasesAdapter.setFavorite(true, phraseId)
                }
            }
        })

        phrasesRecyclerView.layoutManager = LinearLayoutManager(activity.baseContext, LinearLayout.VERTICAL, false)
        phrasesRecyclerView.adapter = phrasesAdapter
    }

}

