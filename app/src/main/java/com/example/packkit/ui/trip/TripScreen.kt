package com.example.packkit.ui.trip

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.packkit.R
import com.example.packkit.ui.trail.Trip
import com.example.packkit.ui.trail.TripData
import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * Displays all trips in a LazyColumn. Each segment of trips is separated by headers.
 *
 * @param modifier
 */
@Composable
fun TripScreen(navController: NavController, modifier: Modifier) {
    val allTrips = Trip.sampleTrips.sortedBy { it.date }    // Load all trips into an array

    val today = LocalDate.now()     // Used to sort trips
    val nextTrip = allTrips.filter { it.date >= today }.minByOrNull { it.date }     // Find the soonest upcoming trip

    val scrollState = rememberLazyListState()
    LazyColumn(
        state = scrollState,
        modifier = modifier
    ) {
        // Next Trip
        item {
            TripSection("Next Trip")
            TripCard(nextTrip, navController = navController)
        }

        // Upcoming Trip(s)
        item {
            TripSection("Upcoming Trips")
        }
        val upcomingTrips = allTrips.filter { it.date > (nextTrip?.date ?: today)}      // Filter out nextTrip and past trips
        items(upcomingTrips) { trip ->      // prints upcoming trips to the screen
            TripCard(trip, navController = navController)
        }

        // Past Trip(s)
        item {
            TripSection("Past Trips")
        }

        val pastTrips = allTrips.sortedByDescending { it.date }.filter { it.date < today }      // Filter out upcoming trips
        items(pastTrips) { trip ->          // prints past trips to the screen
            TripCard(trip, navController = navController)
        }
    }
}



/**
 * Creates a navigational button to link to a trip.
 */
@Composable
fun TripCard(trip: TripData?, navController: NavController) {
    Button (
        modifier = Modifier.padding(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
        onClick = { navController.navigate("trip/${trip?.trip}") }

    ) {
        // displays the trip and delete button in a row
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // displays the name and date of the trip in a column
            Column(
                modifier = Modifier
                    .weight(2f),
                horizontalAlignment = Alignment.Start,
            ) {
                Text(
                    text = trip?.trip ?: "No Trip Available",
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = trip?.date
                        ?.format(
                            DateTimeFormatter.ofPattern("dd MMM, yyyy")
                        )
                        ?: "null Date",
                    style = MaterialTheme.typography.titleMedium
                )
            }
            // delete trip button
//            ElevatedButton (
//                modifier = Modifier
//                    .weight(1f),
//                onClick = { /* TODO: Add Delete Function */
//                    Trip.sampleTrips.remove(trip)
//                }
//            ) {
//                // displays icon and description in a column
//                Column(
//                    modifier = Modifier,
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    Image(
//                        painter = painterResource(R.drawable.ic_delete),
//                        contentDescription = "Trash",
//                        modifier = Modifier,
//                        colorFilter = if (isSystemInDarkTheme()) {
//                            ColorFilter.tint(Color.LightGray)
//                        } else {
//                            null
//                        }
//                    )
//                    Text(
//                        text = "Trash",
//                        style = MaterialTheme.typography.titleSmall
//                    )
//                }
//            }
        }
    }
}

/**
 * Used to display the trip section.
 *
 * @param title The section to be displayed
 */
@Composable
fun TripSection(title: String) {
    Text(
        text = title,
        color = MaterialTheme.colorScheme.onBackground,
        style = MaterialTheme.typography.headlineLarge,
        modifier = Modifier.padding(20.dp)
    )
}