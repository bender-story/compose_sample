package com.example.compose_sample.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlowRowSimpleUsageExample() {
    FlowRow(
        modifier = Modifier.padding(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        maxItemsInEachRow = 2
    ) {
        val itemModifier = Modifier
            .padding(4.dp)
            .height(80.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.Blue)
        repeat(6) { item ->
            // if the item is the third item, don't use weight modifier, but rather fillMaxWidth
            if ((item + 1) % 3 == 0) {
                Spacer(modifier = itemModifier.fillMaxWidth())
            } else {
                Spacer(modifier = itemModifier.weight(0.5f))
            }
        }
    }
}



