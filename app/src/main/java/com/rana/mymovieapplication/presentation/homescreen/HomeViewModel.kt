package com.rana.mymovieapplication.presentation.homescreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rana.mymovieapplication.BuildConfig
import com.rana.mymovieapplication.data.remote.entities.*
import com.rana.mymovieapplication.data.remote.filtiration.MovieFilter
import com.rana.mymovieapplication.data.remote.repository.MoviesRepository
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

class HomeViewModel(private val moviesRepository: MoviesRepository) : ViewModel() {
    private val compositeDisposable by lazy {
        CompositeDisposable()
    }

    private val nowPlayingResult: MutableLiveData<MoviesModel> by lazy {
        MutableLiveData()
    }
    val nowPlayingLiveData: LiveData<MoviesModel> = nowPlayingResult
    private val nowPlayingMError: MutableLiveData<String> by lazy {
        MutableLiveData()
    }
    val nowPlayingError: LiveData<MoviesModel> by lazy {
        MutableLiveData()
    }


    fun getNowPlaying() {
        moviesRepository.getNowPlayingFilms(page = 1).subscribe({ nowplayingModel ->
            nowPlayingResult.value = nowplayingModel
        },
            { errorThrowable -> nowPlayingMError.value = errorThrowable.localizedMessage })


    }

    private val popularResult: MutableLiveData<MoviesModel> by lazy {
        MutableLiveData()
    }

    val popularModelLiveData: LiveData<MoviesModel> = popularResult

    private val popularMError: MutableLiveData<String> by lazy {
        MutableLiveData()
    }
    val popularError: LiveData<MoviesModel> by lazy {
        MutableLiveData()
    }

    fun getPopular() {
        moviesRepository.getPopular(page = 1).subscribe({ popularModel ->
            popularResult.value = popularModel
        },
            { errorThrowable -> popularMError.value = errorThrowable.localizedMessage })


    }

    private val topRatedResult: MutableLiveData<TopRatedModel> by lazy {
        MutableLiveData()
    }

    val topRatedLiveData: LiveData<TopRatedModel> = topRatedResult


    private val topRatedMError: MutableLiveData<String> by lazy {
        MutableLiveData()
    }
    val topRatedError: LiveData<TopRatedModel> by lazy {
        MutableLiveData()
    }

    fun getTopRated() {
        moviesRepository.getTopRated(page = 1).subscribe({ topratedModel ->
            topRatedResult.value = topratedModel
        },
            { errorThrowable -> topRatedMError.value = errorThrowable.localizedMessage })


    }


    private val moviecategoryResult: MutableLiveData<MovieCategoryModel> by lazy {
        MutableLiveData()
    }

    val MovieCategoryLiveData: LiveData<MovieCategoryModel> = moviecategoryResult


    private val movieCategoryMError: MutableLiveData<String> by lazy {
        MutableLiveData()
    }
    val movieCategoryError: LiveData<TopRatedModel> by lazy {
        MutableLiveData()
    }

    fun getCategory() {
        moviesRepository.getCategory(page = 1).subscribe({ moviecategoryModel ->
            moviecategoryResult.value = moviecategoryModel
        },
            { errorThrowable -> movieCategoryMError.value = errorThrowable.localizedMessage })


    }

    private val movievdetailsResult: MutableLiveData<MovieDetailsModel> by lazy {
        MutableLiveData()
    }

    val MovieDetailsLiveData: LiveData<MovieDetailsModel> = movievdetailsResult


    private val movieDetailsMError: MutableLiveData<String> by lazy {
        MutableLiveData()
    }
    val moviedetailsError: LiveData<MovieDetailsModel> by lazy {
        MutableLiveData()
    }

    fun getDetails(movieId: Long) {
        moviesRepository.getDetails(movieId = movieId, page = 1).subscribe({ moviedetailsModel ->
            movievdetailsResult.value = moviedetailsModel
        },
            { errorThrowable -> movieDetailsMError.value = errorThrowable.localizedMessage })


    }


    private val movievTrailerResult: MutableLiveData<MovieTrailerModel> by lazy {
        MutableLiveData()
    }

    val MovieTrailerLiveData: LiveData<MovieTrailerModel> = movievTrailerResult

    private val movieTrailerMError: MutableLiveData<String> by lazy {
        MutableLiveData()
    }
    val movieTrailerError: LiveData<MovieDetailsModel> by lazy {
        MutableLiveData()
    }

    fun getTrailer(movieId: Long) {
        moviesRepository.getTrailer(movieId = movieId, page = 1).subscribe({ movietrailerModel ->
            movievTrailerResult.value = movietrailerModel
        },
            { errorThrowable -> movieTrailerMError.value = errorThrowable.localizedMessage })


    }


    private val movieReviewsResult: MutableLiveData<MovieReviewsModel> by lazy {
        MutableLiveData()
    }

    val movieReviewsLiveData: LiveData<MovieReviewsModel> = movieReviewsResult

    private val movieReviewsError: MutableLiveData<String> by lazy {
        MutableLiveData()
    }
    val movieReviewsLiveDataError = movieReviewsError

    fun getMovieReviews(movieId: Long) {
        moviesRepository.getReviews(movieId = movieId, page = 1).subscribe({ movieReviewsModel ->
            movieReviewsResult.value = movieReviewsModel
        },
            { errorThrowable -> movieReviewsError.value = errorThrowable.localizedMessage })

    }


    private val movievCastsResult: MutableLiveData<MovieCastsModel> by lazy {
        MutableLiveData()
    }

    val MovieCastsLiveData: LiveData<MovieCastsModel> = movievCastsResult

    private val movieCastsMError: MutableLiveData<String> by lazy {
        MutableLiveData()
    }
    val movieCastsError: LiveData<MovieReviewsModel> by lazy {
        MutableLiveData()
    }

    fun getCasts(movieId: Long) {
        moviesRepository.getCast(movieId = movieId,  apiKey = BuildConfig.API_KEY)
            .subscribe({ moviecastsModel ->
                movievCastsResult.value = moviecastsModel
            },
                { errorThrowable -> movieCastsMError.value = errorThrowable.localizedMessage })


    }
    fun getMovies(filer: MovieFilter ) {
        when (filer) {
            MovieFilter.POPULAR -> getPopular()
            MovieFilter.TOP_RATED -> getTopRated()
            MovieFilter.NOW_PLAYING -> getNowPlaying()
        }
    }



    private fun Disposable.addTo(compositeDisposable: CompositeDisposable) {
        compositeDisposable.add(this)
    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    private val tokenResult: MutableLiveData<RequestTokenModel> by lazy {
        MutableLiveData()
    }

    val tokenLiveData: LiveData<RequestTokenModel> = tokenResult
    private val tokenMError: MutableLiveData<String> by lazy {
        MutableLiveData()
    }
    val tokenError: LiveData<MovieReviewsModel> by lazy {
        MutableLiveData()
    }

    fun getToken() {
        moviesRepository.getToken(apiKey = BuildConfig.API_KEY).subscribe({ requestTokenModel ->
            tokenResult.value = requestTokenModel
        },
            { errorThrowable -> tokenMError.value = errorThrowable.localizedMessage })

    }

}