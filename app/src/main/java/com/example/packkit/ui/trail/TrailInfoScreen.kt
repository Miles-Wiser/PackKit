package com.example.packkit.ui.trail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.packkit.ui.gear.Gear
import com.example.packkit.ui.gear.GearItemData
import java.time.format.DateTimeFormatter


@Composable
fun TrailInfoScreen(trip: TripData) {
    val trip = trip

    Column {
        Header(trip)
        Body(trip)
    }
}

@Composable
fun Header(trip: TripData) {
    Column(modifier = Modifier
        .background(color = MaterialTheme.colorScheme.primaryContainer)
        .padding(20.dp)
    ) {
        Text(
            text = "Trail Info: ${trip.trip}",
            modifier = Modifier
                .fillMaxWidth(),
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
        Text(
            text = trip.date
                .format(DateTimeFormatter.ofPattern("MMMM dd , yyyy")),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}

@Composable
fun Body(trip: TripData) {
    val titleList = listOf("Distance", "Elevation Gain", "Reports", "Notes", "Gear")
    val scrollState = rememberLazyListState()
    LazyColumn(
        state = scrollState,
        modifier = Modifier
    ) {
        items(titleList) { title ->
            BodyCard(title, trip)
        }
    }
}

@Composable
fun BodyCard(title: String, trip: TripData) {
    Column(
        modifier = Modifier
            .padding(20.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge
        )


        val tripData = Gear.sampleTripData
        var gearWeight = 0.0

        Text(
            text = when (title) {
                "Distance" -> "${trip.distance}mi"
                "Elevation Gain" -> "${trip.eleGain}ft"
                "Reports" -> trip.report
                "Notes" -> trip.notes
                "Gear" -> {
                    for (index in tripData) {
                        if (index.trip.trip == trip.trip) {
                            val tripGear = index.items
                            for (items in tripGear) {
                                GearCard(index = items)
                                gearWeight += items.weight
                            }
                        }
                    }
                    "Total Weight: %.2f lbs".format(gearWeight)
                }
                else -> "No Value Found"
            },
            modifier = Modifier.padding(horizontal = 10.dp),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun GearCard(index: GearItemData) {
    // Item Name
    Text(
        text = index.item,
        modifier = Modifier
            .padding(top = 10.dp, start = 10.dp, end = 10.dp),
        style = MaterialTheme.typography.titleMedium
    )

    // Item Weight
    Text(
        text = "%.2f lbs".format(index.weight),
        modifier = Modifier
            .padding(start = 20.dp, end = 10.dp),
        )

//    Row(
//        modifier = Modifier
//            .padding(bottom = 10.dp, start = 20.dp, end = 10.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        // Item Carried Button
//        Text("Carried")
//        RadioButton(index.isCarry, onClick = { })
//
//        // Item Consumable Button
//        Text("Consumable")
//        RadioButton(index.isConsume, onClick = { })
//    }

}