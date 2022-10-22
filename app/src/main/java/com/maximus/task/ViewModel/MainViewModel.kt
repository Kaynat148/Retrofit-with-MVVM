package com.maximus.task.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maximus.task.Retrofit.DataRepository
import com.maximus.task.util.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor (private val dataRepository: DataRepository): ViewModel() {

    val _uiState = MutableStateFlow<ApiState<String?>>(ApiState.Loading)

    init {
        fetchRepositories()
    }


    fun fetchRepositories(){
        viewModelScope.launch {
            dataRepository.fetchData().collect(){
                when(it) {
                    is ApiState.Loading -> {
                        _uiState.value = it
                    }

                    is ApiState.Success -> {
                        it.response?.let { res ->

                            Log.i("TAGGGG", it.response.toString())

                            val data = it.response.fact

                            if( null != data && data.isNotEmpty() ){
                                _uiState.value= ApiState.Success(data)
                            }

                        }
                    }

                    is ApiState.Failure -> {
                        _uiState.value = it
                    }

                    else -> {

                    }
                }
            }
        }
    }


}