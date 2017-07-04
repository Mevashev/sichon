package com.example.hen.sichon.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hen.sichon.R
import com.example.hen.sichon.activities.interfaces.FragmentNavigation
import com.example.hen.sichon.adapters.CategoriesAdapter
import com.example.hen.sichon.enums.Category

class CategoryFragment : Fragment()
{
    companion object
    {
        private const val RECYCLER_VIEW_SPAN_COUNT = 3

        fun getInstance(): CategoryFragment
        {
            return CategoryFragment()
        }
    }

    var mFragmentNavigationListener: FragmentNavigation? = null

    override fun onAttach(context: Context?)
    {
        super.onAttach(context)
        mFragmentNavigationListener = context as FragmentNavigation
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        return inflater?.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        val categoryRecyclerView = view?.findViewById(R.id.recycler_view_categories) as RecyclerView
        categoryRecyclerView.layoutManager = StaggeredGridLayoutManager(RECYCLER_VIEW_SPAN_COUNT, StaggeredGridLayoutManager.VERTICAL)

        val categoryAdapter = CategoriesAdapter(Category.values())
        categoryAdapter.setOnCategoryClickListener({ category -> mFragmentNavigationListener?.replaceFragment(true, PhrasesFragment.getInstance(category)) })

        categoryRecyclerView.adapter = categoryAdapter
    }
}