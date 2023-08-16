package com.meelickorganicfarm.app.compose.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.meelickorganicfarm.app.R
import com.meelickorganicfarm.app.utils.getDate

@Composable
fun WelcomeScreen(
    message: String = stringResource(id = R.string.app_name),
    onEnterClick: () -> Unit
) {
    val welcomeFontSize = dimensionResource(id = R.dimen.welcome_font_size).value.sp
    val welcomeSpacerSize = dimensionResource(id = R.dimen.welcome_spacer_size).value.dp

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Logo()
        Text(text = message, fontSize = welcomeFontSize)
        Text(text = getDate(), fontSize = welcomeFontSize)
        Spacer(Modifier.size(welcomeSpacerSize))
        EnterButton(onEnterClick)
    }
}

@Composable
fun Logo() {
    Image(
        painter = painterResource(id = R.drawable.willow_tree),
        contentDescription = stringResource(id = R.string.logo_content_description)
    )
}

@Composable
fun EnterButton(onEnterClick: () -> Unit) {
    TextButton(onClick = onEnterClick) {
        Text(
            text = "Enter farm shop",
            fontSize = dimensionResource(id = R.dimen.welcome_font_size).value.sp,
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WelcomeScreenPreview(message: String = stringResource(id = R.string.app_name)) {
    val welcomeFontSize = dimensionResource(id = R.dimen.welcome_font_size).value.sp
    val welcomeSpacerSize = dimensionResource(id = R.dimen.welcome_spacer_size).value.dp

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Logo()
        Text(text = message, fontSize = welcomeFontSize)
        Text(text = getDate(), fontSize = welcomeFontSize)
        Spacer(Modifier.size(welcomeSpacerSize))
        EnterButton(onEnterClick = {})
    }
}