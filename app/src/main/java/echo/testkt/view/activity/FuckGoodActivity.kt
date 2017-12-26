package echo.testkt.view.activity

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import echo.testkt.R
import echo.testkt.bean.FuckGood
import echo.testkt.di.module.FuckGoodModule
import echo.testkt.getApiComponet
import echo.testkt.mvp.contract.FuckGoodContract
import echo.testkt.mvp.presenter.FuckGoodPresenterImpl
import echo.testkt.util.CommonUtils
import echo.testkt.view.adapter.FuckGoodAdapter
import kotlinx.android.synthetic.main.view_recycler.*
import java.net.URLEncoder
import javax.inject.Inject

/**
 * 作者：EchoJ on 2017/12/18 18:19 <br>
 * 邮箱：echojiangyq@gmail.com <br>
 * 描述：
 */
class FuckGoodActivity : AppCompatActivity(), FuckGoodContract.View {
    
 
    @Inject lateinit var mPresenter: FuckGoodPresenterImpl
    private lateinit var mFuckGoodAdapter: FuckGoodAdapter
    private lateinit var mFuckGoodList: ArrayList<FuckGood>
    private var mPage = 1
    private lateinit var mActivity: Activity
    
    override fun onCreate(savedInstanceState: Bundle?) {
        
        super.onCreate(savedInstanceState)
        
        setContentView(R.layout.view_recycler)
        
        initData()
        
        initView()

        setListener()
    }

    private fun initData() {
        getApiComponet().getFuckGood(FuckGoodModule(this)).inject(this)
        mPresenter.getData(mPage)
        mActivity = this
    }

    private fun setListener() {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView?.canScrollVertically(1)!!) {
                    mPresenter.getData(++mPage)
                }
            }
        })
        
        mFuckGoodAdapter.setOnItemClickListener { 
            pos -> run {
                val url = URLEncoder.encode(mFuckGoodList[pos].url)
                val intent = Intent(mActivity, BaseWebActivity::class.java)
                intent.data = Uri.parse(url)
                startActivity(intent)
            } 
        }
    }

    private fun initView() {
        mFuckGoodList = ArrayList()
        mFuckGoodAdapter = FuckGoodAdapter(mFuckGoodList)
        
        val linearLayoutManager = LinearLayoutManager(this)
        //linearLayoutManager.isAutoMeasureEnabled = true // 不设置也可实现item自适应高度
        
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = mFuckGoodAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.unSubscribe()
    }

    override fun setData(data: List<FuckGood>) {
        CommonUtils.logd(getApiComponet().getGson().toJson(data))
        mFuckGoodList.addAll(data)
        mFuckGoodAdapter.notifyDataSetChanged()
    }

}