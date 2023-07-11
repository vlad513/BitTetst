package com.textfojin.data.networking.retrofit

import com.textfojin.data.networking.ApiService

class RetrofitCreateRequest (val retrofitBuilder: RetrofitBuilder) {

    val create = retrofitBuilder.retrofit.create(ApiService::class.java)
}