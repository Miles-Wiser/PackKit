package com.example.packkit.ui.trail

import java.time.LocalDate

data class TripData(
    val trip: String,
    val date: LocalDate,
    val distance: Double,
    val eleGain: Int,
    val isPermit: Boolean,
    val report: String = "",
    val notes: String = ""
)

object Trip {

    val sampleTrips = listOf(
        TripData(
            trip = "Havasupai Trail",
            date = LocalDate.of(2000, 6, 10),
            distance = 20.0,
            eleGain = 2220,
            isPermit = true,
        ),
        TripData(
            trip = "Coyote Gulch",
            date = LocalDate.of(2025, 1, 23),
            distance = 17.0,
            eleGain = 2000,
            isPermit = true,
            report = "Open fire ban.",
        ),
        TripData(
            trip = "Rockwall Trail",
            date = LocalDate.of(2022, 7, 11),
            distance = 34.6,
            eleGain = 3970,
            isPermit = false,
            notes = "Renew passport"
        ),
        TripData(
            trip = "Teton Crest Trail",
            date = LocalDate.of(2026, 5, 17),
            distance = 38.7,
            eleGain = 8500,
            isPermit = true,
            report = "Bear sightings near Death Canyon and Schoolroom Slope.",
            notes = "Check weather one more time!"
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
                    " trails in the future."
        ),
        TripData(
            trip = "Deletable1",
            date = LocalDate.of(2014, 3, 2),
            distance = 8.5,
            eleGain = 700,
            isPermit = false
        ),
        TripData(
            trip = "Deletable2",
            date = LocalDate.of(2014, 9, 2),
            distance = 8.5,
            eleGain = 700,
            isPermit = false
        ),
        TripData(
            trip = "Deletable3",
            date = LocalDate.of(2026, 8, 31),
            distance = 8.5,
            eleGain = 700,
            isPermit = false
        )
    )
}