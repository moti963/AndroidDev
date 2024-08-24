package com.motiky.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.motiky.artspace.Models.ArtWork
import com.motiky.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArtSpaceLayout(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun ArtSpaceLayout(
    modifier: Modifier = Modifier
) {
    val artworks = listOf(
        ArtWork(
            imageResId = R.drawable.art1,
            titleResId = R.string.artwork_1_title,
            authorResId = R.string.artwork_1_author,
            yearResId = R.string.artwork_1_year,
            typeResId = R.string.artwork_1_type,
            descriptionResId = R.string.artwork_1_description
        ),ArtWork(
            imageResId = R.drawable.art2,
            titleResId = R.string.artwork_2_title,
            authorResId = R.string.artwork_2_author,
            yearResId = R.string.artwork_2_year,
            typeResId = R.string.artwork_2_type,
            descriptionResId = R.string.artwork_2_description
        ),ArtWork(
            imageResId = R.drawable.art3,
            titleResId = R.string.artwork_3_title,
            authorResId = R.string.artwork_3_author,
            yearResId = R.string.artwork_3_year,
            typeResId = R.string.artwork_3_type,
            descriptionResId = R.string.artwork_3_description
        ),ArtWork(
            imageResId = R.drawable.art4,
            titleResId = R.string.artwork_4_title,
            authorResId = R.string.artwork_4_author,
            yearResId = R.string.artwork_4_year,
            typeResId = R.string.artwork_4_type,
            descriptionResId = R.string.artwork_4_description
        ),ArtWork(
            imageResId = R.drawable.art5,
            titleResId = R.string.artwork_5_title,
            authorResId = R.string.artwork_5_author,
            yearResId = R.string.artwork_5_year,
            typeResId = R.string.artwork_5_type,
            descriptionResId = R.string.artwork_5_description
        )
    )

    var indexVal by remember {
        mutableStateOf(0)
    }
    val currWork = artworks[indexVal]

    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ElevatedCardView(
            imgId = currWork.imageResId,
            titleId = currWork.titleResId,
            authorId = currWork.authorResId,
            yearId = currWork.yearResId,
            workTypeId = currWork.typeResId,
            descId = currWork.descriptionResId
        )
        Spacer(modifier = modifier.height(32.dp))
        Row{
            Button(
                onClick = { indexVal = if (indexVal > 0) indexVal - 1 else artworks.size - 1 },
                modifier = modifier
                    .padding(2.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.btn_prev)
                )
            }
            Button(
                onClick = { indexVal = (indexVal + 1) % 5 },
                modifier = modifier
                    .padding(2.dp)
                ) {
                Text(text = stringResource(id = R.string.btn_next))
            }
        }
    }
}

@Composable
fun ElevatedCardView(
    imgId: Int,
    titleId: Int,
    authorId: Int,
    yearId: Int,
    workTypeId: Int,
    descId: Int,
    modifier: Modifier = Modifier
) {
    ElevatedCard (
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(450.dp)
    ){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = imgId),
                contentDescription = stringResource(id = titleId),
                modifier = modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            )
            Text(
                text = stringResource(id = titleId),
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                fontSize = 18.sp
            )
            Text(
                text = "***--- ${stringResource(id = workTypeId)} ---***",
                fontStyle = FontStyle.Italic
            )
            Text(
                text = stringResource(id = authorId),
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace
            )
            Text(
                text = "(${stringResource(id = yearId)})",
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = stringResource(id = descId),
                modifier = modifier.padding(8.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ArtSpaceLayoutPreview(){
    ArtSpaceTheme {
        ArtSpaceLayout()
    }
}