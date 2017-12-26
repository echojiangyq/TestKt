package echo.testkt.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * 作者：EchoJ on 2017/12/20 15:43 <br>
 * 邮箱：echojiangyq@gmail.com <br>
 * 描述：
 */
open class BaseRecyclerAdapter<T>(private val beans: List<T>, private val itemLayoutId: Int): RecyclerView.Adapter<BaseViewHolder>() {
    var mListener: ((pos: Int) -> Unit)? = null
    
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder {
        return BaseViewHolder(parent!!, this.itemLayoutId)
    }

    override fun onBindViewHolder(holder: BaseViewHolder?, position: Int) {
        holder?.itemView?.setOnClickListener{
            mListener?.invoke(position)
        }
    }

    override fun getItemCount() = beans.size

    fun setOnItemClickListener(listener: ((pos: Int) -> Unit)) {
        mListener = listener
    }
}