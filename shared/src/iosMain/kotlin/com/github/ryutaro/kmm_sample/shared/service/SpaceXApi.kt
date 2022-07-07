package com.github.ryutaro.kmm_sample.shared.service

import io.ktor.client.*
import io.ktor.client.engine.darwin.*

actual class SpaceXApi {
    actual fun httpClient(config: HttpClientConfig<*>.() -> Unit) =
        HttpClient(Darwin) {
            config(this)

            engine {
                configureRequest {
                    setAllowsCellularAccess(true)
                }
            }
        }
}
