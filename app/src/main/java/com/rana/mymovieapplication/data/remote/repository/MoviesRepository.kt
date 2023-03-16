package com.rana.mymovieapplication.data.remote.repository

import android.content.SharedPreferences
import com.rana.mymovieapplication.BuildConfig
import com.rana.mymovieapplication.IoTransformers
import com.rana.mymovieapplication.data.remote.entities.*
import com.rana.mymovieapplication.data.remote.entities.MovieCastsModel
import com.rana.mymovieapplication.services.*
import com.rana.mymovieapplication.utils.serialize
import io.reactivex.rxjava3.core.Single


class MoviesRepository(
    private val nowPlayingService: NowPlayingService,
    private val topRatedService: TopRatedService,
    private val popularService: PopularService,
    private val categoryService: MovieCategoryService,
    private val detailsService: MovieDetailsService,
    private val trailerService: MovieTrailerService,
    private val reviewsService: MovieReviewsService,
    private val castsService: MovieCastsService,
    private val requestTokenService: RequestTokenService,
    private val sharedPreferences: SharedPreferences
) {
    private fun <T : Any> getIOTransformer(): IoTransformers<T> = IoTransformers()

    fun getNowPlayingFilms(
        apiKey: String = BuildConfig.API_KEY,
        page: Int
    ): Single<MoviesModel> = nowPlayingService.getNowPlaying(apiKey, page = page)
        .compose(getIOTransformer())


    //zip another services of the rest RVs


    fun getPopular(
        apiKey: String = BuildConfig.API_KEY,
        page: Int
    ): Single<MoviesModel> =
        popularService.getPopular(apiKey, page = page).compose(getIOTransformer())

    fun getTopRated(
        apiKey: String = BuildConfig.API_KEY,
        page: Int
    ): Single<MoviesModel> =
        topRatedService.getTopRated(apiKey, page = page).compose(getIOTransformer())


    fun getCategory(
        apiKey: String = BuildConfig.API_KEY,
        page: Int
    ): Single<MovieCategoryModel> =
        categoryService.getCategory(apiKey, page = page).compose(getIOTransformer()).doOnSuccess {
                val editor = sharedPreferences.edit()

                editor.apply {
                    putString("My Movie Application", it.genres.serialize())
                }

            }


    fun getDetails(
        movieId: Long,
        apiKey: String = BuildConfig.API_KEY,
        page: Int
    ): Single<MovieDetailsModel> =
        detailsService.getDetails(movieId, apiKey, page = page).compose(getIOTransformer())


    fun getTrailer(
        movieId: Long,
        apiKey: String = BuildConfig.API_KEY,
        page: Int
    ): Single<MovieTrailerModel> =
        trailerService.getTrailer(movieId, apiKey, page = page).compose(getIOTransformer())


    fun getReviews(
        apiKey: String = BuildConfig.API_KEY,
        movieId: Long,
        page: Int
    ): Single<MovieReviewsModel> = reviewsService.getMovieReviews(movie_id = movieId, apiKey = apiKey, page = page)
        .compose(getIOTransformer())


    fun getCast(
        apiKey: String = BuildConfig.API_KEY,
        movieId: Long,

    ): Single<MovieCastsModel> = castsService.getMovieCast(movie_id = movieId, apiKey = apiKey)
        .compose(getIOTransformer())




    fun getToken(apiKey: String): Single<RequestTokenModel> = requestTokenService.getToken(apiKey)
        .compose(getIOTransformer())
}









