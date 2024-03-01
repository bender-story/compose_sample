package com.example.compose_sample.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.compose_sample.route.Screen

val itemsList = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5","Item 1", "Item 2", "Item 3", "Item 4", "Item 5","Item 1", "Item 2", "Item 3", "Item 4", "Item 5","Item 1", "Item 2", "Item 3", "Item 4", "Item 5","Item 1", "Item 2", "Item 3", "Item 4", "Item 5")

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MediumTopAppBarExample(navController: NavController ) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    val openAlertDialog = remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            MediumTopAppBar(
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer, // Ensure this is onPrimaryContainer for better visibility
                ),
                title = { Text("Medium Top App Bar") },
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(Icons.Filled.ArrowBack, "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(Icons.Filled.Menu, "Menu")
                    }
                },
                scrollBehavior = scrollBehavior
            )
        },
        bottomBar = {

            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                ElevatedButton(onClick = {
                    openAlertDialog.value = true
                }) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = "Bottom app bar",
                    )
                }

            }
        }
    ) { innerPadding ->
        ScrollableListExample(innerPadding)
    }

    if(openAlertDialog.value){
        AlertDialogExample(
            onDismissRequest = { openAlertDialog.value = false },
            onConfirmation = {
                navController.navigate(Screen.ScreenThree.route)
                openAlertDialog.value = false
                println("Confirmation registered") // Add logic here to handle confirmation.
            },
            dialogTitle = "Alert dialog example",
            dialogText = "This is an example of an alert dialog with buttons.",
        )
    }
}

@Composable
fun ScrollableListExample(innerPadding: PaddingValues) {
    LazyColumn(modifier = Modifier.padding(innerPadding)) {
        items(itemsList) { item ->
            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp)) {
                Text(text = item, modifier = Modifier.padding(16.dp))
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogExample(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
) {
    AlertDialog(
        icon = {
            Icon(Icons.Filled.AccountBox, contentDescription = "Example Icon")
        },
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Text(text = dialogText)
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text("Dismiss")
            }
        }
    )
}
