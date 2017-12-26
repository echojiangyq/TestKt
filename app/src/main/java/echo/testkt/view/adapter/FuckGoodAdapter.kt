package echo.testkt.view.adapter

import echo.testkt.R
import echo.testkt.bean.FuckGood

/**
 * 作者：EchoJ on 2017/12/20 15:43 <br>
 * 邮箱：echojiangyq@gmail.com <br>
 * 描述：
 */
class FuckGoodAdapter(private val beans: List<FuckGood>): BaseRecyclerAdapter<FuckGood>(beans, R.layout.item_fuckgood) {

    override fun onBindViewHolder(holder: BaseViewHolder?, position: Int) {
        super.onBindViewHolder(holder, position)
        
        holder?.setTextView(R.id.tvTitle, beans[position].desc)
        holder?.setTextView(R.id.tvAuthor, beans[position].who)
        holder?.setTextView(R.id.tvTime, beans[position].create())
        if(beans[position].hasImg()){
            holder?.setImgView(R.id.ivImg, beans[position].images[0])
        }else{
            holder?.setViewGone(R.id.ivImg)
        }
    }
}