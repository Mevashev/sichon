package com.example.hen.sichon.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.hen.sichon.R
import com.example.hen.sichon.models.LanguageModel

/**
 * Created by slava-android on 6/28/2017.
 * Falcore Ltd.
 */
class LanguageAdapter(items: ArrayList<LanguageModel>) : RecyclerView.Adapter<LanguageAdapter.ViewHolder>() {

    private var mListener: LanguageAdapter.OnForeignLanguageClickListener? = null
    private val mItems = items

    override fun getItemCount(): Int {
        return mItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.imageViewForeignLanguage?.setImageResource(mItems[position].image)
        holder?.textViewForeignLanguage?.text = mItems[position].language.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_language, parent, false)
        val viewHolder = LanguageAdapter.ViewHolder(view)
        view.setOnClickListener({ mListener?.onForeignLanguageClick(mItems[viewHolder.adapterPosition].language) })
        return viewHolder
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageViewForeignLanguage = view.findViewById(R.id.image_view_language) as ImageView
        val textViewForeignLanguage = view.findViewById(R.id.text_view_language) as TextView
    }

    fun setForeignLanguageClickListener(listener: OnForeignLanguageClickListener) {
        mListener = listener
    }

    interface OnForeignLanguageClickListener {
        fun onForeignLanguageClick(selectedLanguage: LanguageModel.Language)
    }
}