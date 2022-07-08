package com.github.ryutaro.kmm_sample

import com.github.ryutaro.kmm_sample.shared.cache.Database
import com.github.ryutaro.kmm_sample.shared.cache.DatabaseDriverFactory
import com.github.ryutaro.kmm_sample.shared.entity.RocketLaunch
import com.github.ryutaro.kmm_sample.shared.service.SpaceXApi

class SpaceXSDK(
    databaseDriverFactory: DatabaseDriverFactory
) {
    private val database = Database(databaseDriverFactory)
    private val api = SpaceXApi()

    @Throws(Exception::class)
    suspend fun getLaunches(forceReload: Boolean): List<RocketLaunch> {
        val cachedLaunches = database.getAllLaunches()
        return if (cachedLaunches.isNotEmpty() && !forceReload) {
            cachedLaunches
        } else {
            api.getAllLaunches().also {
                database.clearDatabase()
                database.createLaunches(it)
            }
        }
    }
}
