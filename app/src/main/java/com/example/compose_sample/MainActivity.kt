package com.example.compose_sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose_sample.route.Screen
import com.example.compose_sample.ui.FlowRowSimpleUsageExample
import com.example.compose_sample.ui.Greeting
import com.example.compose_sample.ui.LazyStaggeredGridSnippetFixed
import com.example.compose_sample.ui.LinearDeterminateIndicator
import com.example.compose_sample.ui.MediumTopAppBarExample
import com.example.compose_sample.ui.theme.Compose_sampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_sampleTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()

                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    // Define the NavHost
                    NavHost(navController = navController, startDestination = Screen.DashboardScreen.route) {
                        composable(Screen.DashboardScreen.route) {
                            Greeting("Android", navController = navController)
                        }
                        composable(Screen.ScreenTwo.route) {
                            // Replace with your detail screen composable
                            MediumTopAppBarExample(navController)
                        }
                        composable(Screen.ScreenThree.route) {
                            // Replace with your detail screen composable
                            LinearDeterminateIndicator(navController)
                        }
                        composable(Screen.ScreenFour.route) {
                            // Replace with your detail screen composable
                            LazyStaggeredGridSnippetFixed(navController)
                        }
                        composable(Screen.ScreenFive.route) {
                            // Replace with your detail screen composable
                            FlowRowSimpleUsageExample()
                        }
                    }
                }
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    Compose_sampleTheme {
//        Greeting("Android")
//    }
//}