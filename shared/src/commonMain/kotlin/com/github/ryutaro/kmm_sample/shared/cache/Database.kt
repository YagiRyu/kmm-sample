package com.github.ryutaro.kmm_sample.shared.cache

import com.github.ryutaro.kmm_sample.model.Links
import com.github.ryutaro.kmm_sample.model.Rocket
import com.github.ryutaro.kmm_sample.model.RocketLaunch

internal class Database(
    databaseDriverFactory: DatabaseDriverFactory
) {
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.appDatabaseQueries

    internal fun clearDatabase() {
        dbQuery.transaction {
            dbQuery.removeAllRockets()
            dbQuery.removeAllLaunches()
        }
    }

    internal fun getAllLaunches(): List<RocketLaunch> {
        return dbQuery.selectAllLaunchesInfo(::mapLaunchSelecting).executeAsList()
    }

    private fun mapLaunchSelecting(
        flightNumber: Long,
        missionName: String,
        launchYear: Int,
        rocketId: String,
        details: String?,
        launchSuccess: Boolean?,
        launchDateUTC: String,
        missionPatchUrl: String?,
        articleUrl: String?,
        rocket_id: String?,
        name: String?,
        type: String?
    ): RocketLaunch {
        return RocketLaunch(
            flightNumber = flightNumber.toInt(),
            missionName = missionName,
            launchYear = launchYear,
            details = details,
            launchDateUTC = launchDateUTC,
            launchSuccess = launchSuccess,
            rocket = Rocket(
                rocketId = rocketId,
                name = name!!,
                rocketType = type!!
            ),
            links = Links(
                missionPatch = missionPatchUrl,
                articleLink = articleUrl
            )
        )
    }

    internal fun createLaunches(launches: List<RocketLaunch>) {
        dbQuery.transaction {
            launches.forEach { launch ->
                val rocket = dbQuery.selectRocketById(launch.rocket.rocketId).executeAsOneOrNull()
                if (rocket == null) {
                    insertRocket(launch)
                }
                insertLaunch(launch)
            }
        }
    }

    private fun insertRocket(launch: RocketLaunch) {
        dbQuery.insertRocket(
            id = launch.rocket.rocketId,
            name = launch.rocket.name,
            type = launch.rocket.rocketType
        )
    }

    private fun insertLaunch(launch: RocketLaunch) {
        dbQuery.insertLaunch(
            flightNumber = launch.flightNumber.toLong(),
            missionName = launch.missionName,
            launchYear = launch.launchYear,
            rocketId = launch.rocket.rocketId,
            details = launch.details,
            launchSuccess = launch.launchSuccess ?: false,
            launchDateUTC = launch.launchDateUTC,
            missionPatchUrl = launch.links.missionPatch,
            articleUrl = launch.links.articleLink
        )
    }
}
