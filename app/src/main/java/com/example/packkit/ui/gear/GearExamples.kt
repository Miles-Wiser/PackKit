package com.example.packkit.ui.gear

import com.example.packkit.ui.trail.Trip
import com.example.packkit.ui.trail.TripData

data class GearItemData(
    val item: String,
    val section: String,
    val isConsume: Boolean = false,
    val isCarry: Boolean = true,
    val weight: Double = 0.0,
    val condition: Int = 2,
    val notes: List<String> = listOf("")
)

data class  GearTripData(
    val trip: TripData,
    val items: List<GearItemData>
)

object Gear {
    val sampleGear = listOf(
        GearItemData(
            item = "TrailMade 2 Tent",
            section = "Essentials",
            weight = 4.625,
            condition = 2,
        ),
        GearItemData(
            item = "Pitchpine VST 1.5 Tent",
            section = "Essentials",
            isConsume = false,
            isCarry = true,
            weight = 1.693,
            condition = 1,
            notes = listOf(
                "Repair hole in the floor.",
                "Rain fly missing hooks."
            )
        ),
        GearItemData(
            item = "Forte 35 Endless promise Sleeping Bag",
            section = "Essentials",
            isConsume = false,
            isCarry = true,
            weight = 2.3125,
            condition = 0,
            notes = listOf(
                "Zipper is broken.",
                "Melted hole in the bottom.",
                "Filling missing from the bottom."
            )
        ),
        GearItemData(
            item = "Aquamira - Water Treatment",
            section = "Essentials",
            isConsume = true,
            isCarry = true,
            weight = 0.3125,
            condition = 2,
        ),
        GearItemData(
            item = "Freeze Dried - Fried Rice",
            section = "Consumables",
            isConsume = true,
            isCarry = true,
            weight = 0.293,
            condition = 2,
        ),
        GearItemData(
            item = "Wool Jacket",
            section = "Essentials",
            isCarry = false,
            weight = 2.5
        ),
        GearItemData(
            item = "Gold Cup",
            section = "Luxury",
            weight = 3.5
        ),
        GearItemData(
            item = "Deletable Gear #1",
            section = "Luxury",
            weight = 0.75
        ),
        GearItemData(
            item = "Deletable Gear #2",
            section = "Consumables",
            weight = 5.0,
        ),
        GearItemData(
            item = "Deletable Gear #3",
            section = "Consumables",
            weight = 4.429,
        )
    )

    val allTrips = Trip.sampleTrips
    val sampleTripData = listOf(
        GearTripData(
            trip = allTrips[0],
            items = listOf(
                sampleGear[1],
                sampleGear[2],
                sampleGear[4],
                sampleGear[4],
                sampleGear[4],
                sampleGear[4],
                sampleGear[5],
                sampleGear[3],
                sampleGear[7],
                sampleGear[6]
            )
        ),
        GearTripData(
            trip = allTrips[2],
            items = listOf(
                sampleGear[0],
                sampleGear[1],
                sampleGear[3],
                sampleGear[7],
                sampleGear[4],
                sampleGear[5],
                sampleGear[6]
            )
        ),
        GearTripData(
            trip = allTrips[3],
            items = listOf(
                sampleGear[0],
                sampleGear[1],
                sampleGear[3],
                sampleGear[4],
                sampleGear[7],
                sampleGear[4],
                sampleGear[5]
            )
        ),
        GearTripData(
            trip = allTrips[1],
            items = listOf(
                sampleGear[0],
                sampleGear[1],
                sampleGear[3],
                sampleGear[4],
                sampleGear[7],
                sampleGear[4],
                sampleGear[5],
                sampleGear[6]
            )
        ),
        GearTripData(
            trip = allTrips[4],
            items = listOf(
                sampleGear[1],
                sampleGear[3],
                sampleGear[4],
                sampleGear[7],
                sampleGear[4],
                sampleGear[5],
                sampleGear[6]
            )
        )
    )
}