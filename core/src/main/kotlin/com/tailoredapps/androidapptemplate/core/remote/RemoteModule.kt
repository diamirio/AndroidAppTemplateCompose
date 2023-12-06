/*
 * Copyright 2020 Tailored Media GmbH.
 * Created by Florian Schuster.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tailoredapps.androidapptemplate.core.remote

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.tailoredapps.androidapptemplate.core.model.AppBuildInfo
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit

internal val remoteModule = module {
    factory { HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY } }
    single { Json { ignoreUnknownKeys = true } }
    single { provideOkHttpClient(loggingInterceptor = get(), appBuildInfo = get()) }
    single { provideApi<MyApi>(okHttpClient = get(), json = get(), appBuildInfo = get()) }
}

private fun provideOkHttpClient(
    loggingInterceptor: HttpLoggingInterceptor,
    appBuildInfo: AppBuildInfo
): OkHttpClient = OkHttpClient().newBuilder().apply {
    if (appBuildInfo.debug) addInterceptor(loggingInterceptor)
}.build()

private inline fun <reified T> provideApi(
    okHttpClient: OkHttpClient,
    json: Json,
    appBuildInfo: AppBuildInfo
): T = Retrofit.Builder().apply {
    baseUrl(appBuildInfo.baseUrl)
    client(okHttpClient)
    addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
}.build().create(T::class.java)