package com.setjy.automationbusinesstask.di

import com.setjy.automationbusinesstask.data.remote.api.GoodsApi
import com.setjy.automationbusinesstask.data.remote.api.StoreApi
import com.setjy.automationbusinesstask.data.repo.ProductRepoImpl
import com.setjy.automationbusinesstask.data.repo.StoreRepoImpl
import com.setjy.automationbusinesstask.domain.repo.ProductRepo
import com.setjy.automationbusinesstask.domain.repo.StoreRepo
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkService {

    private const val BASE_URL = "http://195.69.218.233:54000/Test/hs/exch/"

    private const val API_HEADER_KEY = "1CSVC"
    private const val API_HEADER_VALUE = "PeplosSVC#2022"

    private val interceptor = Interceptor { chain ->
        val authenticatedRequest =
            chain.request()
                .newBuilder()
                .header(name = API_HEADER_KEY, value = API_HEADER_VALUE)
                .build()
        chain.proceed(authenticatedRequest)
    }

    private val networkInterceptor: HttpLoggingInterceptor by lazy {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient().newBuilder()
            .addInterceptor(interceptor)
            .addNetworkInterceptor(networkInterceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    private val goodsApi: GoodsApi by lazy { retrofit.create(GoodsApi::class.java) }
    private val storeApi: StoreApi by lazy { retrofit.create(StoreApi::class.java) }

    val productRepo: ProductRepo by lazy { ProductRepoImpl(goodsApi) }
    val storeRepo: StoreRepo by lazy { StoreRepoImpl(storeApi) }
}

