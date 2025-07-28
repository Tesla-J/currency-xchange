package dev.rmarcos.currencyxchange.mainscreen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ValueParser(
    modifier: Modifier = Modifier,
    onParse: (Float) -> Unit
){
    var input by remember { mutableStateOf("1.00") }
    OutlinedTextField(
        modifier = modifier,
        value = input,
        maxLines = 1,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Decimal
        ),
        onValueChange = {
            input = it
            onParse(if (input.isBlank()) 0f else input.toFloat())
        }
    )
}

@Composable
@Preview(showBackground = true)
fun ValueParserPreview(){
    ValueParser(){

    }
}