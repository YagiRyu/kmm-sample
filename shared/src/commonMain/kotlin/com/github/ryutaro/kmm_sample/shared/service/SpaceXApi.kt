package com.github.ryutaro.kmm_sample.shared.service

import io.ktor.client.*

expect class SpaceXApi {
    fun httpClient(config: HttpClientConfig<*>.() -> Unit): HttpClient
}
