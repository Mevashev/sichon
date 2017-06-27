package com.example.hen.sichon.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.hen.sichon.R
import com.example.hen.sichon.models.PhraseModel

class PhrasesCategoryAdapter(items: List<PhraseModel>): RecyclerView.Adapter<PhrasesCategoryAdapter.ViewHolder>()
{
    val mItems = items

    override fun getItemCount(): Int
    {
        return mItems.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder
    {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_phrase, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int)
    {
        holder?.translateFrom?.text = mItems[position].translateFrom
        holder?.translateTo?.text = mItems[position].translateTo
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val translateFrom = view.findViewById(R.id.text_view_translate_from) as TextView
        val translateTo = view.findViewById(R.id.text_view_translate_to) as TextView
    }
}