package com.example.dagger2basic

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface QuizService {
    @GET
     fun getLogout(@Url url: String): Call<CourseView>

}