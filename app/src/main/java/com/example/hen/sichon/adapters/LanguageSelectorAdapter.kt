package com.example.hen.sichon.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import com.example.hen.sichon.R
import com.example.hen.sichon.enums.Language
import com.example.hen.sichon.models.SelectLanguageModel
import java.util.*

/**
 * Created by slava-android on 6/28/2017.
 * Falcore Ltd.
 */
class LanguageSelectorAdapter(items: ArrayList<SelectLanguageModel>) : RecyclerView.Adapter<LanguageSelectorAdapter.ViewHolder>() {

    private var mListenerSelector: LanguageSelectorAdapter.OnLanguageSelectorClickListener? = null
    private val mItems = items


    override fun getItemCount(): Int {
        return mItems.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_radio_button_language, parent, false)
        val viewHolder = LanguageSelectorAdapter.ViewHolder(view)
        view.setOnClickListener {
            for (selector in mItems) {
                selector.isSelected = false
            }
            mItems[viewHolder.adapterPosition].isSelected = true
            notifyDataSetChanged()
            mListenerSelector?.onLanguageSelectedClick(mItems[viewHolder.adapterPosition].language)
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.language?.text = mItems[position].language.languageName
        holder?.radioButton?.isChecked = mItems[position].isSelected
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val radioButton = view.findViewById(R.id.radio_button) as RadioButton
        val language = view.findViewById(R.id.language) as TextView
    }

    fun setLanguageSelectorClickListener(listenerSelector: OnLanguageSelectorClickListener) {
        mListenerSelector = listenerSelector
    }

    interface OnLanguageSelectorClickListener {
        fun onLanguageSelectedClick(selectedLanguage: Language)
    }


    fun getSelectedLanguage(): Language {
        return mItems
                .firstOrNull { it.isSelected }
                ?.language
                ?: Language.ENGLISH
    }
}