package com.example.myapplication.ui.radio

import android.app.Notification.Action
import android.widget.RadioGroup
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.Modifier
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class RadioButtonCompose {

    @Composable
    fun RadioCompose(text: String, selected: Boolean, onClick: () -> Action) {
        Surface(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
            shape = MaterialTheme.shapes.small
        )
        {
            RadioButton(
                selected = false,
                onClick = {
                    // change selected here
                },
                modifier = Modifier.semantics { contentDescription = "Option 1" }
            )
        }

    }

}