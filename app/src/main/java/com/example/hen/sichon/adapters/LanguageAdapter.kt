package com.example.hen.sichon.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.hen.sichon.R
import com.example.hen.sichon.enums.Language
import com.example.hen.sichon.models.LanguageModel

/**
 * Created by slava-android on 6/28/2017.
 * Falcore Ltd.
 */
class LanguageAdapter(items: ArrayList<LanguageModel>) : RecyclerView.Adapter<LanguageAdapter.ViewHolder>()
{

    private var mListener: ((Language) -> Unit)? = null
    private val mItems: ArrayList<LanguageModel>? = ArrayList<LanguageModel>()
    private val mSubItems = items

    init
    {
        mItems?.addAll(mSubItems)
    }

    override fun getItemCount(): Int
    {
        return mSubItems.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder
    {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_language, parent, false)
        val viewHolder = LanguageAdapter.ViewHolder(view)
        view.setOnClickListener({ mListener?.invoke(mSubItems[viewHolder.adapterPosition].language) })
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int)
    {
        holder?.imageViewForeignLanguage?.setImageResource(mSubItems[position].image)
        holder?.textViewForeignLanguage?.text = mSubItems[position].language.languageName
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val imageViewForeignLanguage = view.findViewById(R.id.image_view_language) as ImageView
        val textViewForeignLanguage = view.findViewById(R.id.text_view_language) as TextView
    }

    fun setLanguageClickListener(listener: (Language) -> Unit)
    {
        mListener = listener
    }

    fun removeThisItem(language: Language?)
    {
        mSubItems.clear()
        if (mItems != null)
        {
            for (item in mItems)
            {
                if (item.language != language)
                {
                    mSubItems.add(item)
                }
            }
        }
        notifyDataSetChanged()
    }

}