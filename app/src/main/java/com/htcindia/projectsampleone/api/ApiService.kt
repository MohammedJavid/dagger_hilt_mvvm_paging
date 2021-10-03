package com.htcindia.projectsampleone.api

import com.htcindia.projectsampleone.models.ResponseApi
import com.htcindia.projectsampleone.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getAllCharacters( @Query("page") page: Int ): Response<ResponseApi>
    
}