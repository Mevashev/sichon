package com.example.hen.sichon.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.hen.sichon.R
import com.example.hen.sichon.models.PhraseModel

class PhrasesAdapter(items: List<PhraseModel>) : RecyclerView.Adapter<PhrasesAdapter.ViewHolder>()
{
    private val mItems = items
    private var mListener: OnPhraseClickListener? = null

    override fun getItemCount(): Int
    {
        return mItems.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder
    {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_phrase, parent, false)
        val viewHolder = ViewHolder(view)
        view.setOnClickListener({ mListener?.onPhraseClick(mItems[viewHolder.adapterPosition].translateTo) })
        viewHolder.favorite.setOnClickListener({ mListener?.onFavoriteClick( viewHolder.adapterPosition) })
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int)
    {
        holder?.translateFrom?.text = mItems[position].translateFrom
        holder?.translateTo?.text = mItems[position].translateTo
        if (mItems[position].isFavorite)
        {
            holder?.favorite?.setImageResource(R.drawable.ic_star)
        }
        else
        {
            holder?.favorite?.setImageResource(R.drawable.ic_star_border)
        }
    }

    fun setOnPhraseClickListener(listener: OnPhraseClickListener)
    {
        mListener = listener
    }

    fun setFavorite(isFavorite: Boolean, index: Int)
    {
        mItems[index].isFavorite = isFavorite
        notifyItemChanged(index)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val translateFrom = view.findViewById(R.id.text_view_translate_from) as TextView
        val translateTo = view.findViewById(R.id.text_view_translate_to) as TextView
        val favorite: ImageView = view.findViewById(R.id.view_favorite) as ImageView
    }

    interface OnPhraseClickListener
    {
        fun onPhraseClick(textToSpeech: String)
        fun onFavoriteClick(phraseIndex: Int)
    }
}