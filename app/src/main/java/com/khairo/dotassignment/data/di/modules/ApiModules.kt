package com.khairo.dotassignment.data.di.modules

import com.google.gson.GsonBuilder
import com.khairo.dotassignment.BuildConfig
import com.khairo.dotassignment.data.network.EndPointInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class ApiModules {

    private val okHttpClient: OkHttpClient
        get() =
            OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()

    private val retrofit: Retrofit
        get() = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .build()

    private val getData: EndPointInterface
        get() = retrofit.create(EndPointInterface::class.java)

    @Singleton
    @Provides
    fun providesApi(): EndPointInterface {
        return getData
    }
}
