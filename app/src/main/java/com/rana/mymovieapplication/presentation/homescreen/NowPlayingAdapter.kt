package com.rana.mymovieapplication.presentation.homescreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.rana.mymovieapplication.R
import com.rana.mymovieapplication.data.remote.entities.NowPlayingModel
import kotlinx.android.synthetic.main.nowplaying_rv_item.view.*

class NowPlayingAdapter: RecyclerView.Adapter<NowPlayingAdapter.MyViewHolder> () {

    private lateinit var viewModel: HomeViewModel
    lateinit var filmname_Tv: TextView
    lateinit var film_image : TextView
class MyViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.nowplaying_rv_item,
           parent, false)
        return MyViewHolder(view)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.apply {
            filmname_Tv = filmnameTV
            viewModel.getNowPlaying()
            viewModel.result.observeForever() {
            }
        }




       }


    override fun getItemCount(): Int {
    return 5
    }
}