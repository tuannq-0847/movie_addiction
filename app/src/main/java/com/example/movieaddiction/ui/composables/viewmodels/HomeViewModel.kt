package com.example.movieaddiction.ui.composables.viewmodels

import androidx.lifecycle.MutableLiveData
import com.example.movieaddiction.data.repository.MovieRepository
import com.example.movieaddiction.model.BaseMovieResponse
import com.example.movieaddiction.model.MovieResult
import com.example.movieaddiction.model.MovieVideo
import com.example.movieaddiction.utils.Karl
import com.karleinstein.basemvvm.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class HomeViewModel(private val movieRepository: MovieRepository) : BaseViewModel() {

    val movieResponse: MutableLiveData<BaseMovieResponse<MovieVideo>> = MutableLiveData()

    fun test(){
        CoroutineScope(Dispatchers.Default).launch {
            flowOf(movieRepository.getVideoMovie()).run {
                onStart {
                    loadingEvent.postValue(true)
                }
                onCompletion {
                    loadingEvent.postValue(false)
                }
                collect { data ->
                    movieResponse.postValue(data)
                    Karl.d("Res: $data")
                    Karl.d("Name: ${Thread.currentThread().name}")
                }
                catch { ex ->
                    errorEvent.postValue(ex)
                }
            }
        }
    }
}
