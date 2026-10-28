package com.example.quadrantscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.Text
import androidx.compose.ui.res.stringResource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.foundation.background

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.quadrantscreen.ui.theme.QuadrantScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuadrantScreenTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    QuadrantScreen()
                }
            }
        }
    }
}

@Composable
fun QuadrantScreen() {
    Column(Modifier.fillMaxSize()) { // s wali column ne or fillMaxSize ne
        Row(Modifier.weight(1f)) { // Is wali row ne
            // jo ye ComposableInfoCard bne hai inka kaam
            ComposableInfoCard(
                title = stringResource(R.string.first_title),// ye first wale box ke main heading hai ise hmneyha likh ke string.xml me likha same aise hi charo ke lie
                description = stringResource(R.string.first_description),// ye heading ke niche aane wala paragraph type hai jise string.xml ke andr likha ek dum first title ke niche hi same aise hi charo k lie
                backgroundColor = Color.DarkGray, //agr white nhi lena to () ke andr color ki value ya name likh do bss
                modifier = Modifier.weight(1f)// isne weight(1f) ne ye kaam kia ki r weight ka kaam hai  khaali jgah ho baatna hisso me or andr iski vale hai 1f kre or ye column or row ke andr hi use hota hai vaise nhi modifier ka use krke uske andr
            )
            ComposableInfoCard(
                title = stringResource(R.string.second_title),
                description = stringResource(R.string.second_description),
                backgroundColor = Color.Gray,
                modifier = Modifier.weight(1f)
            )
        }
            Row(Modifier.weight(1f)) { // is wali ROw function ne ye
                ComposableInfoCard(
                    title = stringResource(R.string.third_title),
                    description = stringResource(R.string.third_description),
                    backgroundColor = Color.LightGray,
                    modifier = Modifier.weight(1f)
                )
                ComposableInfoCard(
                    title = stringResource(R.string.fourth_title),
                    description = stringResource(R.string.fourth_description),
                    backgroundColor = Color.White,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }

    @Composable
    fun ComposableInfoCard(
        title: String,
        description: String,
        backgroundColor: Color,
        modifier: Modifier = Modifier
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(backgroundColor)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                modifier = Modifier.padding(bottom = 16.dp),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = description,
                textAlign = TextAlign.Justify
            )
        }
    }
    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun QuadrantsScreenPreview() {
        QuadrantScreenTheme {
            QuadrantScreen()
        }
    }
