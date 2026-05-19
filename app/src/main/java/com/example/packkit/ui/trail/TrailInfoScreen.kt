package com.example.packkit.ui.trail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.time.format.DateTimeFormatter


@Composable
fun TrailInfoScreen(navController: NavController, trip: TripData, modifier: Modifier) {
    val trip = trip

    Column(modifier = modifier) {
        Header(trip)
        Body(trip)
    }
}

@Composable
fun Header(trip: TripData) {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            "Trail Info: ${trip.trip}",
            modifier = Modifier

                .fillMaxWidth()
        )
        Text(trip.date.format(DateTimeFormatter.ofPattern("dd MMM, yyyy")))
    }
}

@Composable
fun Body(trip: TripData) {
    // TODO: Can use function to replace these
    // Distance and Elevation Gain
    Row(modifier = Modifier) {
        Text(
            "Distance ${trip.distance}mi",
            modifier = Modifier.weight(1f)
        )
        Text(
            "Elevation Gain: ${trip.eleGain}ft",
            modifier = Modifier.weight(1f)
        )
    }

    // Permits Required
    // TODO: Set state for selected
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Permits")
        RadioButton(
            selected = false,
            // TODO("Change state of selected")
            onClick = { }
        )
    }
    var isExReport by remember { mutableStateOf(false) }

    // Reports
    Column {
        Text("Reports")
        Text(
            trip.report,
            modifier = Modifier
                .clickable(
                    onClick = { isExReport = !isExReport }
                ),
            maxLines = if (isExReport) Int.MAX_VALUE else 1
        )
    }

    // User Notes
    var isExNotes by remember { mutableStateOf(false)}
    Column {
        Text("Notes")
        Text(
            trip.notes,
            modifier = Modifier
                .clickable(
                    onClick = { isExNotes = !isExNotes }
                ),
            maxLines = if (isExNotes) Int.MAX_VALUE else 1
        )
    }
}