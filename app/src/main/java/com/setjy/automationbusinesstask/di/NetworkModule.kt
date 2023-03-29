package com.setjy.automationbusinesstask.di

import com.setjy.automationbusinesstask.data.remote.api.GoodsApi
import com.setjy.automationbusinesstask.data.remote.api.StoreApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "http://195.69.218.233:54000/Test/hs/exch/"

    private const val API_HEADER_KEY = "1CSVC"
    private const val API_HEADER_VALUE = "PeplosSVC#2022"

    private const val CONNECT_TIMEOUT = 60L
    private const val READ_TIMEOUT = 60L

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideOkHttpClient(
        interceptor: Interceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        .addInterceptor(interceptor)
        .addNetworkInterceptor(httpLoggingInterceptor)
        .build()

    @Provides
    fun provideInterceptor(): Interceptor = Interceptor { chain ->
        val authenticatedRequest =
            chain.request()
                .newBuilder()
                .header(name = API_HEADER_KEY, value = API_HEADER_VALUE)
                .build()
        chain.proceed(authenticatedRequest)
    }

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Provides
    fun provideGoodsApi(retrofit: Retrofit): GoodsApi = retrofit.create(GoodsApi::class.java)

    @Provides
    fun provideStoreApi(retrofit: Retrofit): StoreApi = retrofit.create(StoreApi::class.java)
}