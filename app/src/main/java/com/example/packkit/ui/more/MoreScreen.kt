package com.example.packkit.ui.more

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun MoreScreen(modifier: Modifier) {
    val tabs = listOf(
        Tabs("Notifications"),
        Tabs("Preferences"),
        Tabs("App Tutorial"),
        Tabs("Experience Survey"),
    )

    LazyColumn(
        modifier = modifier
            .padding(20.dp)
    ) {
        items(tabs.size) { index ->
            MoreTab(
                title = tabs[index].title
            )
        }
    }
}


@Composable
fun MoreTab(title: String) {
    var isExpanded by remember { mutableStateOf(false) }

    val functionalMsg = "Currently Unavailable!"

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { isExpanded = !isExpanded}
    ) {
        Text(
            text = title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            style = MaterialTheme.typography.titleLarge
        )
        if (isExpanded) {
            Text(
                text = functionalMsg,
                modifier = Modifier.padding(bottom = 20.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

data class Tabs(
    val title: String,
)