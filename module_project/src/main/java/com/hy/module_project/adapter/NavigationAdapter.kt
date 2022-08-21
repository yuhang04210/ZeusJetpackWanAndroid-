package com.hy.module_project.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.hy.module_project.R
import com.hy.module_project.bean.NavigationData

class NavigationAdapter(private val list: List<NavigationData>) : RecyclerView
.Adapter<NavigationAdapter.ViewHolder>() {

	private lateinit var onItemClickListener: OnItemClickerListener

	interface  OnItemClickerListener {
		fun onItemClick(article: NavigationData.Article?)
	}

	fun setOnItemClickListener(onItemClickListener: OnItemClickerListener) {
		this.onItemClickListener = onItemClickListener
	}

	class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
		val flowTitle: TextView = view.findViewById(R.id.flow_title)
		val chipGroup: ChipGroup = view.findViewById(R.id.chip_group)
		val context: Context = view.context
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val view = LayoutInflater.from(parent.context).inflate(R.layout.flow_items, parent, false)
		return ViewHolder(view)
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.flowTitle.text = list[position].name ?: ""
		val articles = list[position].articles
		if (articles?.isNotEmpty() == true) {
			for (article in articles) {
				val chip = Chip(holder.context)
				chip.text = article?.title ?: ""
				chip.textSize = 12f
				chip.width = ViewGroup.LayoutParams.WRAP_CONTENT
				chip.height = ViewGroup.LayoutParams.WRAP_CONTENT
				onItemClickListener.let {
					chip.apply {
						setOnClickListener {
							onItemClickListener.onItemClick(article)
						}
					}
				}
				holder.chipGroup.addView(chip)
			}
		}
	}

	override fun getItemCount(): Int {
		return list.size
	}
}