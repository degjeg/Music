package com.degjeg

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.degjeg.api.MusicApi
import com.degjeg.api.baidu.BaiduMusicImpl
import com.degjeg.bean.SongCategory
import com.degjeg.bean.SongDetail
import com.degjeg.bean.SongListItem
import com.degjeg.util.retrofit.MediaPlayer
import com.jcodecraeer.xrecyclerview.XRecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val songList: MutableList<SongListItem> = mutableListOf()
    val categoryList: MutableList<SongCategory> = mutableListOf()
    private lateinit var songAdapter: RecyclerView.Adapter<VhSong>
    private lateinit var categoryAdapter: RecyclerView.Adapter<VhCategory>

    private var curCategory: SongCategory? = null
    private var curSong: SongListItem? = null
    private var player: MediaPlayer? = null

    private var handler: Handler? = null

    override fun onClick(v: View?) {
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initCategoryList()
        initSongList()
        initPlayer()
    }

    private fun initPlayer() {
        player = MediaPlayer(this)

        handler = Handler(Handler.Callback { msg ->
            when (msg?.what) {
                1 -> {
                    if (player!!.isPlaying) {
                        val cur = player!!.currentPos / 1000
                        val total = player!!.totalLength / 1000

                        tv_time.text = String.format("%02d:%02d/%02d:%02d",
                                cur / 60,
                                cur % 60,
                                total / 60,
                                total % 60
                        )
                        handler?.sendEmptyMessageDelayed(1, 300)
                    }
                }
            }

            true
        })

        btn_play.setOnClickListener {
            if (player!!.isPlaying) {
                btn_play.text="play"
                player?.pausePlay()
            } else {
                btn_play.text="stop"
                player?.continuePlay()
                handler?.sendEmptyMessageDelayed(1, 100)
            }
        }
    }

    /**
     * 左边的分类列表
     */
    private fun initCategoryList() {

        categoryAdapter = object : RecyclerView.Adapter<VhCategory>() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VhCategory? {
                val inflater: LayoutInflater = LayoutInflater.from(this@MainActivity)

                return VhCategory(inflater.inflate(R.layout.song_category_item, parent, false))
            }

            override fun onBindViewHolder(holder: VhCategory, position: Int) {
                holder.bindData(position)
            }

            override fun getItemCount(): Int {
                return categoryList.size
            }
        }
        rv_category.adapter = categoryAdapter
        rv_category.setLoadingMoreEnabled(false)
        rv_category.setPullRefreshEnabled(false)
        rv_category.layoutManager = LinearLayoutManager(this)


        val api: MusicApi = BaiduMusicImpl()
        api.getSongCategories(object : MusicApi.CallBack<List<SongCategory>> {
            override fun onFail(code: Int, msg: String?, e: Throwable?) {

            }

            override fun onSuccess(t: List<SongCategory>?) {
                categoryList.addAll(t!!)
                categoryAdapter.notifyDataSetChanged()
            }
        })

    }


    /**
     * 右边的歌曲列表
     */
    private fun initSongList() {
        rv_song.setLoadingListener(object : XRecyclerView.LoadingListener {
            override fun onLoadMore() {
                val api: MusicApi = BaiduMusicImpl()
                api.getSongList(curCategory?.id, songList.size, 20, object : MusicApi.CallBack<List<SongListItem>> {
                    override fun onSuccess(songListItems: List<SongListItem>) {
                        songList.addAll(songListItems)


                        songAdapter.notifyDataSetChanged()
                        rv_song.refreshComplete()
                        rv_song.loadMoreComplete()
                    }

                    override fun onFail(code: Int, msg: String, e: Throwable) {

                    }
                })

            }

            override fun onRefresh() {
                val api: MusicApi = BaiduMusicImpl()
                api.getSongList(curCategory?.id, 0, 20, object : MusicApi.CallBack<List<SongListItem>> {
                    override fun onSuccess(songListItems: List<SongListItem>) {
                        songList.clear()
                        songList.addAll(songListItems)


                        songAdapter.notifyDataSetChanged()
                        rv_song.refreshComplete()
                        rv_song.loadMoreComplete()
                    }

                    override fun onFail(code: Int, msg: String, e: Throwable) {

                    }
                })
            }
        })


        songAdapter = object : RecyclerView.Adapter<VhSong>() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VhSong? {
                val inflater: LayoutInflater = LayoutInflater.from(this@MainActivity)

                return VhSong(inflater.inflate(R.layout.song_list_item, parent, false))
            }

            override fun onBindViewHolder(holder: VhSong, position: Int) {
                holder.bindData(position)
            }

            override fun getItemCount(): Int {
                return songList.size
            }
        }
        rv_song.adapter = songAdapter
        rv_song.setLoadingMoreEnabled(true)
        rv_song.setPullRefreshEnabled(true)
        rv_song.layoutManager = LinearLayoutManager(this)
    }


    inner class VhSong/*(v: View?)*/ : RecyclerView.ViewHolder/*(v)*/, View.OnClickListener {
        override fun onClick(v: View?) {
            curSong = songList[pos]

            val api: MusicApi = BaiduMusicImpl()
            api.getSongDetail(curSong?.id, object : MusicApi.CallBack<SongDetail?> {
                override fun onFail(code: Int, msg: String?, e: Throwable?) {

                }

                override fun onSuccess(t: SongDetail?) {
                    // player?.playSong(/*songList[pos].*/"http://zhangmenshiting.baidu.com/data2/music/8595c259a7b749c6029da3116c2c4409/565030410/565030410.mp3?xcode=26355d3de8f7acf019a583210f1a2e09")
                    handler?.sendEmptyMessage(1)
                    player?.playSong(t?.fileUrl)
                }
            })
            //
            songAdapter.notifyDataSetChanged()
        }

        private val tvTitle: TextView?
        var pos: Int = 0

        constructor(v: View?) : super(v) {
            tvTitle = v!!.findViewById(R.id.tv_song_name)
            v.setOnClickListener(this)
        }

        fun bindData(position: Int) {
            this.pos = position
            val songItem = songList[pos]
            tvTitle!!.text = String.format("[%d]", position) + songItem.songName
            tvTitle.isSelected = songItem == curSong
        }
    }


    inner class VhCategory/*(v: View?)*/ : RecyclerView.ViewHolder/*(v)*/, View.OnClickListener {
        var pos: Int = 0
        override fun onClick(v: View?) {
            curCategory = categoryList[pos]
            rv_song.refresh()
            categoryAdapter.notifyDataSetChanged()
        }

        private val tvName: TextView?

        constructor(v: View?) : super(v) {
            tvName = v!!.findViewById(R.id.tv_name)
            v.setOnClickListener(this)

        }

        fun bindData(position: Int) {
            this.pos = position
            val category = categoryList[pos];
            tvName!!.text = String.format("[%d]", position) + category.name
            tvName.isSelected = category == curCategory
        }
    }
}
