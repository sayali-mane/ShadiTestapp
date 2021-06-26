package com.check.shaditestapp

import io.reactivex.Flowable
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/api/?results=10")
    fun getProfileList() : Call<ProfileListResponse>
}
