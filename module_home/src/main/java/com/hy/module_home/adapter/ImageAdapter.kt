package com.hy.module_home.adapter


import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hy.module_home.response.BannerItem
import com.youth.banner.adapter.BannerAdapter
import com.youth.banner.util.BannerUtils

class ImageAdapter(imageUrls: List<BannerItem>) : BannerAdapter<BannerItem, ImageAdapter.ImageHolder>(imageUrls) {

	override fun onCreateHolder(parent: ViewGroup?, viewType: Int): ImageHolder {
		val imageView = ImageView(parent!!.context)
		val params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
		imageView.layoutParams = params
		imageView.scaleType = ImageView.ScaleType.CENTER_CROP
		//通过裁剪实现圆角
		BannerUtils.setBannerRound(imageView, 20f)
		return ImageHolder(imageView)
	}

	override fun onBindView(holder: ImageHolder, data: BannerItem, position: Int, size: Int) {
		Glide.with(holder.itemView)
			.load(data.imagePath)
			.into(holder.imageView)
	}


	class ImageHolder(view: View) : RecyclerView.ViewHolder(view) {
		var imageView: ImageView = view as ImageView
	}

}