package dev.rmarcos.currencyxchange.mainscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.rmarcos.currencyxchange.controller.getLastCurrency
import dev.rmarcos.currencyxchange.model.CurrencyData
import dev.rmarcos.currencyxchange.R
import dev.rmarcos.currencyxchange.controller.getCurrencyList
import java.util.Currency

@Composable
fun CurrencySelector(
    modifier: Modifier = Modifier,
    currencyList: List<CurrencyData>,
    onSelect: (CurrencyData) -> Unit,
){
    Box(
        modifier = modifier
            .wrapContentSize()
            .padding(4.dp),
        contentAlignment = Alignment.Center,
    ){
        var isExpanded by remember {mutableStateOf(false)}
        var actualCurrency by remember {mutableStateOf(getLastCurrency())}
        val trailingIcon = if (isExpanded) Icons.Filled.KeyboardArrowUp
                            else Icons.Filled.KeyboardArrowDown
        var input by remember {mutableStateOf(actualCurrency.toString())}
        //var filteredCurrencyList by remember {mutableStateOf(currencyList)}
        TextField(
            value = input,
            onValueChange = {
                input = it
                /*filteredCurrencyList = currencyList.filter{
                    it.name.contains(input) || it.code.contains(input)
                }*/
            },
            label = {Text(stringResource(R.string.select_currency))},
            maxLines = 1,
            readOnly = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            trailingIcon = {
                Icon(
                    imageVector = trailingIcon,
                    contentDescription = null,
                    modifier = Modifier.clickable{
                        isExpanded = !isExpanded
                    }
                )
            }
        )
        DropdownMenu(
            expanded = isExpanded,
            onDismissRequest = {isExpanded = false}
        ) {
            currencyList.forEach{
                DropdownMenuItem(
                    text = { Text(it.toString()) },
                    onClick = {
                        actualCurrency = it
                        input = it.toString()
                        onSelect(it)
                        isExpanded = !isExpanded
                    }
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CurrencySelectorPreview(){
    CurrencySelector(
        currencyList = getCurrencyList()
    ){

    }
}