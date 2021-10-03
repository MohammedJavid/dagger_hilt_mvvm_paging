package com.htcindia.projectsampleone.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.htcindia.projectsampleone.api.ApiService
import com.htcindia.projectsampleone.paging.RickMortyPagingSource
import javax.inject.Inject

class RickMortyRepository @Inject constructor(private val apiService: ApiService) {

    val listData = Pager(PagingConfig(pageSize = 1)) {
        RickMortyPagingSource(apiService)
    }.flow
}