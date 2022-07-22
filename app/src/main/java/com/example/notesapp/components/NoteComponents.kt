package com.example.notesapp.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.ExposedDropdownMenuDefaults.textFieldColors
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.input.ImeAction

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun NoteInputText(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    maxLine: Int=1,
    onTextChange: (String) -> Unit,
    onImeAction: () -> Unit = {}
){
    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(
        value = text,
        onValueChange = onTextChange,
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent,
            cursorColor = Color(0xFFDADFE3),
            focusedIndicatorColor = Color(0xFFDADFE3),
            unfocusedIndicatorColor = Color(0xFFDADFE3),
            focusedLabelColor = Color(0xFFDADFE3),
            unfocusedLabelColor = Color(0xFFDADFE3),
            placeholderColor = Color(0xFFDADFE3)),
        maxLines = maxLine,
        label = { Text(text = label) },
        placeholder = { Text(text = "Type here") },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = {
            onImeAction()
            keyboardController?.hide()
        }),
        modifier = Modifier,

        )
}

@Composable
fun NoteButton(
    modifier: Modifier = Modifier,
    text:String,
    onClick: () -> Unit,
    enabled: Boolean = true
){
    Button(onClick = onClick,
        shape = CircleShape,
        enabled = enabled,
        modifier = modifier) {
        Text(text)
    }
}