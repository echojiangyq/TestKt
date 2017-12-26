package echo.testkt.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import echo.testkt.util.CommonUtils

/**
 * Created by wing on 11/23/16.
 */
class BaseViewHolder(viewGroup: ViewGroup, resId: Int) :
        RecyclerView.ViewHolder(LayoutInflater.from(viewGroup.context).inflate(resId, viewGroup, false)) {

 fun setTextView(resId: Int, str: String?) = itemView.rootView.findViewById<TextView>(resId)?.setText(str?:"")
 
 fun setImgView(resId: Int, imgResId: Int) = itemView.rootView.findViewById<ImageView>(resId)?.setImageResource(imgResId)
 
 fun setImgView(resId: Int, url: String){
  val img = itemView.rootView.findViewById<ImageView>(resId)
  CommonUtils.loadImage(img, url)
  img.visibility = View.VISIBLE
 }
 
 fun setViewVisiable(resId: Int, visible :Int) {
  itemView.rootView.findViewById<View>(resId)?.visibility = visible
 } 
 fun setViewGone(resId: Int) {
  itemView.rootView.findViewById<View>(resId)?.visibility = View.GONE
 } 
 
}
