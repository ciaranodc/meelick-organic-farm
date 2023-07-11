package com.meelickorganicfarm.app

import android.os.Bundle
import android.text.format.DateFormat
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.meelickorganicfarm.app.ui.theme.MeelickOrganicFarmTheme
import java.util.Date

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeelickOrganicFarmTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Welcome()
                }
            }
        }
    }
}

@Composable
fun Welcome(message: String = stringResource(id = R.string.app_name)) {
    fun getDate(): String {
        return "${DateFormat.format("dd-MMM-yyyy", Date().time)}"
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Logo()
        Text(text = message, fontSize = 18.sp)
        Text(text = getDate(), fontSize = 18.sp)
    }
}

@Composable
fun Logo() {
    Image(
        painter = painterResource(id = R.drawable.willow_tree),
        contentDescription = stringResource(id = R.string.logo_content_description)
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WelcomePreview() {
    MeelickOrganicFarmTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Welcome()
        }
    }
}