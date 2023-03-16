package com.rana.mymovieapplication.presentation.moviedetails.recylerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.rana.mymovieapplication.BuildConfig
import com.rana.mymovieapplication.R
import com.rana.mymovieapplication.data.remote.entities.MovieCastsModel
import kotlinx.android.synthetic.main.cast_rv_item.view.*

class MovieCastAdapter :RecyclerView.Adapter<MovieCastAdapter.MyViewHolder>() {
    private var castList = listOf<MovieCastsModel.Cast>()
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)  {
        fun bindData(cast: MovieCastsModel.Cast){
           itemView.movieDetail_casts_userphoto_Tv.load("${BuildConfig.PHOTO_BASE_URL}${cast.profile_path}")
            itemView.movieDetail_casts_username_Tv.text = cast.original_name
            itemView.category_Tv.text = cast.name
        }
    }
    fun setData(casts: List<MovieCastsModel.Cast>){
        castList = casts
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.cast_rv_item,
            parent,
            false
        )
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return castList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(castList[position])
    }
}