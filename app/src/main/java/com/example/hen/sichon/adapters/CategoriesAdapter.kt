package com.example.hen.sichon.adapters

import android.support.annotation.ArrayRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.hen.sichon.R
import com.example.hen.sichon.models.CategoryModel

class CategoriesAdapter(items: List<CategoryModel>) : RecyclerView.Adapter<CategoriesAdapter.ViewHolder>()
{
    private val mItems = items
    private var mListener: CategoriesAdapter.OnCategoryClickListener? = null

    override fun getItemCount(): Int
    {
       return mItems.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder
    {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_category, parent, false)
        val viewHolder = ViewHolder(view)
        view.setOnClickListener({mListener?.onCategoryClick(mItems[viewHolder.adapterPosition].category.categoryId)})
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int)
    {
        holder?.image?.setImageResource(mItems[position].category.image)
        holder?.text?.text = mItems[position].category.categoryName
    }

    fun setOnCategoryClickListener(listener: OnCategoryClickListener)
    {
        mListener = listener
    }

    interface OnCategoryClickListener
    {
        fun onCategoryClick(@ArrayRes category : Int)
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val image = view.findViewById(R.id.image_view_category) as ImageView
        val text = view.findViewById(R.id.text_view_category) as TextView
    }
}