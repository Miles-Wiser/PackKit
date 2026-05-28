package com.example.packkit.ui.trail


import com.example.packkit.ui.gear.GearItemData
import java.time.LocalDate

data class TripData(
    val trip: String,
    val date: LocalDate,
    val distance: Double,
    val eleGain: Int,
    val isPermit: Boolean,
    val report: String = "",
    val notes: String = "",
    val gear: List<GearItemData> = emptyList()
)

object Trip {

    val sampleTrips = mutableListOf(
        TripData(
            trip = "Havasupai Trail",
            date = LocalDate.of(2000, 6, 10),
            distance = 20.0,
            eleGain = 2220,
            isPermit = true,
//            gear = listOf(
//                sampleGear[1],
//                sampleGear[2],
//                sampleGear[4],
//                sampleGear[4],
//                sampleGear[4],
//                sampleGear[4],
//                sampleGear[5],
//                sampleGear[3],
//                sampleGear[7],
//                sampleGear[6]
//            )
        ),
        TripData(
            trip = "Coyote Gulch",
            date = LocalDate.of(2025, 1, 23),
            distance = 17.0,
            eleGain = 2000,
            isPermit = true,
            report = "Open fire ban.",
//            gear = listOf(
//                sampleGear[1],
//                sampleGear[2],
//                sampleGear[4],
//                sampleGear[4],
//                sampleGear[4],
//                sampleGear[4],
//                sampleGear[5],
//                sampleGear[3],
//                sampleGear[7],
//                sampleGear[6]
//            )
        ),
        TripData(
            trip = "Rockwall Trail",
            date = LocalDate.of(2022, 7, 11),
            distance = 34.6,
            eleGain = 3970,
            isPermit = false,
            notes = "Renew passport",
//            gear = listOf(
//                sampleGear[1],
//                sampleGear[2],
//                sampleGear[4],
//                sampleGear[4],
//                sampleGear[4],
//                sampleGear[4],
//                sampleGear[5],
//                sampleGear[3],
//                sampleGear[7],
//                sampleGear[6]
//            )
        ),
        TripData(
            trip = "Teton Crest Trail",
            date = LocalDate.of(2026, 7, 17),
            distance = 38.7,
            eleGain = 8500,
            isPermit = true,
            report = "Bear sightings near Death Canyon and Schoolroom Slope.",
            notes = "Check weather one more time!",
//            gear = listOf(
//                sampleGear[1],
//                sampleGear[2],
//                sampleGear[4],
//                sampleGear[4],
//                sampleGear[4],
//                sampleGear[4],
//                sampleGear[5],
//                sampleGear[3],
//                sampleGear[7],
//                sampleGear[6]
//            )
        ),
        TripData(
            trip = "Pemigewasset Loop",
            date = LocalDate.of(2026, 9, 23),
            distance = 30.5,
            eleGain = 8500,
            isPermit = true,
            report = "Open fire ban.\n" +
                    "Food Storage Requirement, store all food and scented items in bear resistant" +
                    " containers.\n" +
                    "Trail closure: Lincoln Woods.",
            notes = "Check reports again at the start of September. Forest services may close more" +
                    " trails in the future.",
//            gear = listOf(
//                sampleGear[1],
//                sampleGear[2],
//                sampleGear[4],
//                sampleGear[4],
//                sampleGear[4],
//                sampleGear[4],
//                sampleGear[5],
//                sampleGear[3],
//                sampleGear[7],
//                sampleGear[6]
//            )
        ),
        TripData(
            trip = "Deletable1",
            date = LocalDate.of(2014, 3, 2),
            distance = 8.5,
            eleGain = 700,
            isPermit = false,
//            gear = listOf(
//                sampleGear[1],
//                sampleGear[2],
//                sampleGear[4],
//                sampleGear[4],
//                sampleGear[4],
//                sampleGear[4],
//                sampleGear[5],
//                sampleGear[3],
//                sampleGear[7],
//                sampleGear[6]
//            )
        ),
        TripData(
            trip = "Deletable2",
            date = LocalDate.of(2014, 9, 2),
            distance = 8.5,
            eleGain = 700,
            isPermit = false,
//            gear = listOf(
//                sampleGear[1],
//                sampleGear[2],
//                sampleGear[4],
//                sampleGear[4],
//                sampleGear[4],
//                sampleGear[4],
//                sampleGear[5],
//                sampleGear[3],
//                sampleGear[7],
//                sampleGear[6]
//            )
        ),
        TripData(
            trip = "Deletable3",
            date = LocalDate.of(2026, 8, 31),
            distance = 8.5,
            eleGain = 700,
            isPermit = false,
//            gear = listOf(
//                sampleGear[1],
//                sampleGear[2],
//                sampleGear[4],
//                sampleGear[4],
//                sampleGear[4],
//                sampleGear[4],
//                sampleGear[5],
//                sampleGear[3],
//                sampleGear[7],
//                sampleGear[6]
//            )
        )
    )
}