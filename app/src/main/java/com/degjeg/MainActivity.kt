package com.degjeg

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.degjeg.api.MusicApi
import com.degjeg.api.baidu.BaiduMusicImpl
import com.degjeg.bean.SongListItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View?) {
        var x = 1

        when (v?.id) {
            R.id.btn -> {
                val api: MusicApi = BaiduMusicImpl()
                api.getSongList(1, 10, 0, object : MusicApi.CallBack<List<SongListItem>> {
                    override fun onSuccess(songListItems: List<SongListItem>) {

                    }

                    override fun onFail(code: Int, msg: String, e: Exception) {

                    }
                })
            }

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener(this)
    }
}
