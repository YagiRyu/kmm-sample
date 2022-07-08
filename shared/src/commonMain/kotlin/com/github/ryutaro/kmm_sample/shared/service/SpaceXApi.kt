package com.github.ryutaro.kmm_sample.shared.service

import com.github.ryutaro.kmm_sample.shared.entity.RocketLaunch
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class SpaceXApi {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                },
                contentType = ContentType.Application.Json
            )
        }
    }

    suspend fun getAllLaunches(): List<RocketLaunch> {
        return client.get(LAUNCHES_ENDPOINT).body()
    }

    companion object {
        private const val LAUNCHES_ENDPOINT = "https://api.spacexdata.com/v3/launches"
    }
}
