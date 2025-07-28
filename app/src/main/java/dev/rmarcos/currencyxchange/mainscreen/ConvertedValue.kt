package dev.rmarcos.currencyxchange.mainscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.rmarcos.currencyxchange.R
import dev.rmarcos.currencyxchange.model.CurrencyData
import java.util.Currency

@Composable
fun ConvertedValue(
    modifier: Modifier = Modifier,
    value: Float,
    currencyData: CurrencyData,
    onClick: (String) -> Unit,
) {
    val convertedValue = "%5.2f ${currencyData.symbol}".format(value)
    Row(
        modifier = modifier
            .padding(8.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = convertedValue, //TODO check for locale
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(
            Modifier.padding(8.dp)
        )
        Icon(
            painter = painterResource(R.drawable.baseline_content_copy_24),
            contentDescription = stringResource(R.string.copy_value),
            modifier = Modifier.clickable(
                enabled = true,
                onClick = {
                    onClick(convertedValue)
                }
            )
        )
    }
}

@Composable
@Preview(showBackground = true)
fun ConvertedValuePreview() {
    ConvertedValue(
        value = 50f,
        currencyData = CurrencyData("kWANZA", "AOA", Currency.getInstance("AOA").symbol)
    ){}
}