package dev.rmarcos.currencyxchange

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.gms.ads.MobileAds
import dev.rmarcos.currencyxchange.controller.getCurrencyList
import dev.rmarcos.currencyxchange.mainscreen.AdBanner
import dev.rmarcos.currencyxchange.mainscreen.ConvertedValue
import dev.rmarcos.currencyxchange.mainscreen.CurrencySelector
import dev.rmarcos.currencyxchange.mainscreen.ValueParser
import dev.rmarcos.currencyxchange.ui.theme.CurrencyXchangeTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CurrencyXchangeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        CoroutineScope(Dispatchers.IO).launch {
            MobileAds.initialize(this@MainActivity)
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        AdBanner(
            bannerId = stringResource(R.string.TOP_AD_BAR)
        )
        Spacer(
            Modifier.weight(1f)
        )
        ConvertedValue(
            value = 0f,
            currencySymbol = "TODO" // TODO
        ) {
            // TODO
        }
        ValueParser (
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(top = 16.dp, bottom = 16.dp)
        ){
            //TODO
        }
        Row {
            CurrencySelector(
                modifier = Modifier.weight(1f),
                currencyList = getCurrencyList()
            ) {
                //TODO
            }
            CurrencySelector(
                modifier = Modifier.weight(1f),
                currencyList = getCurrencyList()
            ) {
                //TODO
            }
        }
        Spacer(
            Modifier.weight(1f)
        )
        AdBanner(
            bannerId = stringResource(R.string.TOP_AD_BAR)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    CurrencyXchangeTheme {
        MainScreen()
    }
}