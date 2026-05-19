package com.example.packkit.ui.gear

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.packkit.R
import com.example.packkit.ui.trail.TripData
import java.math.BigDecimal
import java.math.RoundingMode
import java.time.format.DateTimeFormatter
import kotlin.math.abs


@Composable
fun GearInfoScreen(modifier: Modifier) {
    val trip = Gear.sampleTripData[0].trip
    val gear = Gear.sampleTripData[0].items

    Column(modifier = modifier) {
        Header(trip)
        Body(gear)
    }
}

@Composable
fun Header(trip: TripData) {
    Column(modifier = Modifier) {
        Text(
            "Gear for \"${trip.trip}\" Trip",
            modifier = Modifier
                .fillMaxWidth()
        )
        Text(trip.date.format(DateTimeFormatter.ofPattern("dd MMM, yyyy")))
    }
}

@Composable
fun Body(gear: List<GearItemData>) {

    // Gear breakdown
    LazyColumn (
        modifier = Modifier
    ) {
        // Weight Breakdown and Pies
        item {
            // Weight of all gear
            var weightAll = 0.0
            // Add weight of all items
            gear.forEach { item ->
                weightAll += item.weight
            }
            // Round to 2 decimal places
            weightAll = BigDecimal(weightAll).setScale(2, RoundingMode.HALF_UP).toDouble()

            // Weight of carried gear
            var weightCarry = 0.0
            // Add weight of carried items
            gear.filter { it.isCarry }.forEach { item ->
                weightCarry += item.weight
            }
            weightCarry = BigDecimal(weightCarry).setScale(2, RoundingMode.HALF_UP).toDouble()

            val weightGoal = 6.25
            val weightOver = BigDecimal(weightCarry - weightGoal).setScale(2, RoundingMode.HALF_UP).toDouble()

            // Weights breakdown
            Row(modifier = Modifier.padding(20.dp)) {
                // Total Weight + Goal Weight
                Column {
//                    PieWeight(name = "Total Weight", gear = gear, weightAll, weightGoal)

                    Text("Total Weight: $weightAll lbs")
                    Text("Goal Weight: $weightGoal lbs")
                }
                // Carried Weight + Over/Under Weight
                Column {
//                    PieWeight(name = "Carried Weight", gear = gear, weightCarry, weightOver)

                    Text("Carried Weight: $weightCarry lbs")

                    if (weightOver >= 0) {
                        Text("Over Weight: $weightOver lbs")
                    } else (
                            Text("Under Weight: ${abs(weightOver)} lbs")
                            )
                }
            }
        }

        // Essentials
        val gearEssentials = gear.filter { it.section == "Essentials" }
        item { GearSection("Essentials") }
        items(gearEssentials) { index ->
            GearCard(index)
        }

        // Consumables
        val gearConsumables = gear.filter { it.section == "Consumables" }
        item { GearSection("Consumables") }
        items(gearConsumables) { index ->
            GearCard(index)
        }

        // Luxury
        item { GearSection("Luxury") }
        val gearLuxury = gear.filter {  it.section == "Luxury" }
        items(gearLuxury) { index ->
            GearCard(index)
        }
    }
}

@Composable
fun GearSection(title: String) {
    Text(
        title,
        modifier = Modifier.padding(20.dp)
    )
}

@Composable
fun GearCard(index: GearItemData) {
    Row {
        // Delete Button
        DeleteGear(
            item = index,
            modifier = Modifier.weight(1f)
        )

        // Item info
        LazyRow(
            modifier = Modifier.weight(3f),
            verticalAlignment = Alignment.Bottom
        ) {
            // Item Name
            item {
                Text(index.item)
            }

            // Item Weight
            item {
                Text("%.2f lbs".format(index.weight))
            }

            // Item Carried Button
            item {
                Text("Carried")
                RadioButton(index.isCarry, onClick = { })
            }

            // Item Consumable Button
            item {
                Text("Consumable")
                RadioButton(index.isConsume, onClick = { })
            }
        }
    }
}

@Composable
fun DeleteGear(item: GearItemData, modifier: Modifier) {
    // delete trip button
    ElevatedButton (
        modifier = modifier,
        onClick = { /* TODO: Add Delete Function */ println("Click Me $item") }
    ) {
        // displays icon and description in a column
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.ic_delete),
                contentDescription = "Trash",
                modifier = Modifier
            )
            Text("Trash")
        }
    }
}
