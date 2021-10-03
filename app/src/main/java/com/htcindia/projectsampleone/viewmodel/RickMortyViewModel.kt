package com.htcindia.projectsampleone.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.htcindia.projectsampleone.api.ApiService
import com.htcindia.projectsampleone.paging.RickMortyPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RickMortyViewModel @Inject constructor(private  val apiService: ApiService): ViewModel(){

    val listData = Pager(PagingConfig(pageSize = 1)) {
        RickMortyPagingSource(apiService)
    }.flow.cachedIn(viewModelScope)

}