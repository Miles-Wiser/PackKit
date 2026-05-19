package com.example.packkit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.packkit.ui.gear.GearInfoScreen
import com.example.packkit.ui.more.MoreScreen
import com.example.packkit.ui.theme.PackKitTheme
import com.example.packkit.ui.trail.TrailInfoScreen
import com.example.packkit.ui.trail.Trip
import com.example.packkit.ui.trip.TripScreen


class PackKitActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PackKitApp()
        }
    }
}

@Composable
fun PackKitApp() {
    PackKitTheme {
        val navController = rememberNavController()

        Scaffold(
            bottomBar = { Footer(navController) }
        ) { paddingValues ->
            NavHost(
                navController = navController,
                startDestination = "home"
            ) {
                composable(route = "home") {
                    TripScreen(
                        navController = navController,
                        modifier = Modifier.padding(paddingValues)
                        )
                }
                composable(route = "more") {
                    MoreScreen(
                        navController = navController,
                        modifier = Modifier.padding(paddingValues)
                    )
                }
                composable(route = "trip/{tripId}") { backStackEntry ->

                    val tripId = backStackEntry.arguments?.getString("tripId")

                    // Find the trip that was selected
                    for (trip in Trip.sampleTrips) {
                        if (tripId == trip.trip) {
                            Column(modifier = Modifier.padding(paddingValues)) {
                                TrailInfoScreen(
                                    navController = navController,
                                    trip = trip,
                                    modifier = Modifier.padding(paddingValues)
                                )
                            }
                            break
                        }
                    }
                }
                composable(route = "gear") {
                    GearInfoScreen(
                        modifier = Modifier.padding(paddingValues)
                    )
                }
            }
        }
    }
}

/**
 * Displays the bottom bar and navigational buttons.
 */
@Composable
fun Footer(navController: NavController) {
    Row(
        modifier = Modifier
//            TODO: Figure out how to apply colors correctly
            .background(Color.DarkGray)
            .padding(bottom = 20.dp)
            .height(120.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
//        FooterIcon(R.drawable.ic_add, "Add")
        FooterIcon(R.drawable.ic_home, "Home", navController = navController)
        FooterIcon(R.drawable.ic_more, "More", navController = navController)
    }
}

/**
 * Displays a navigational button for the bottom bar.
 *
 * @param imgId The reference id for the button's image.
 * @param description The description for the button.
 */
@Composable
fun FooterIcon(imgId: Int, description: String, navController: NavController) {
    Button(
        onClick = { navController.navigate(description) }
    ) {
        Column(
            modifier = Modifier
                .widthIn(min = 50.dp, max = 70.dp)
                .padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(imgId),
                contentDescription = description,
                modifier = Modifier
            )
            Text(description)
        }
    }
}