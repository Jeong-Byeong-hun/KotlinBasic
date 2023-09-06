package com.example.myapplication.ui.button

import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

class PrimaryButton {

    @Composable
    fun PrimaryButton(
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        enable: Boolean,
        text: String
    ) {
        Button(modifier = modifier,
            onClick = { /*TODO*/ }) {

        }
    }
}