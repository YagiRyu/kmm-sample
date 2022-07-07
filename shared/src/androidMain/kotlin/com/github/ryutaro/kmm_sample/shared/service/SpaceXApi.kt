package com.github.ryutaro.kmm_sample.shared.service

import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import java.util.concurrent.TimeUnit

actual class SpaceXApi {
    actual fun httpClient(config: HttpClientConfig<*>.() -> Unit) =
        HttpClient(OkHttp) {
            config(this)

            engine {
                config {
                    retryOnConnectionFailure(false)
                    connectTimeout(30, TimeUnit.SECONDS)
                }
            }
        }
}