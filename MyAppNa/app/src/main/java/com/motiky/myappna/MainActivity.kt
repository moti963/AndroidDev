package com.motiky.myappna

import android.os.Bundle
import android.provider.MediaStore.Images
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.motiky.myappna.ui.theme.MyAppNaTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            // R-6
            MyAppNaTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                    ) {
                    QuadrantParentView(modifier=Modifier)
                }
            }

            // R-5
        /*MyAppNaTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BlogPage(
                        title = stringResource(id = R.string.blog_title),
                        desc1 = stringResource(id = R.string.blog_desc1),
                        desc2 = stringResource(id = R.string.blog_desc2)
                    )
                }
            }*/

            // R-4
         /*   MyAppNaTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard(
                        name = "Moti",
                        title = "Developer",
                        contact = "+91 9876543210",
                        social = "@github/moti9",
                        email = "moti@gmail.com"
                    )
                }
            }*/


            // R-3
            /* MyAppNaTheme {
                 Surface (
                     modifier = Modifier.fillMaxSize(),
                     color = MaterialTheme.colorScheme.background
                     ) {
                     GreetingImage(
                         message = "Happy Birthday Dear MNOPQRST",
                         from = "from ABCDEF",
                     )
                 }
             }*/

            // R-2
            /* MyAppNaTheme {
                 Surface (
                     modifier = Modifier.fillMaxSize(),
                     color = MaterialTheme.colorScheme.background
                     ) {
                     HappyBirthdayMessage(
                         message = "Happy Birthday Dear MNOPQRST",
                         from = "from ABCDEF",
                     )
                 }
             }*/

            // R-1
            /*MyAppNaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }*/

        }
    }
}

/****************************
 ** Ui Implementation Area **
 ****************************/

// U-6
@Composable
fun QuadrantParentView(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize().padding(top = 48.dp)
    ) {
        Row(modifier = Modifier.weight(1f)) {
            QuadrantCard(
                title = stringResource(id = R.string.card1_title),
                description = stringResource(id = R.string.card1_desc),
                modifier = Modifier.weight(1f).background(Color(0xFFEADDFF))
            )
            QuadrantCard(
                title = stringResource(id = R.string.card2_title),
                description = stringResource(id = R.string.card2_desc),
                modifier = Modifier.weight(1f).background(Color(0xFFD0BCFF))
            )
        }
        Row (
            modifier = Modifier.weight(1f)
        ) {
            QuadrantCard(
                title = stringResource(id = R.string.card3_title),
                description = stringResource(id = R.string.card3_desc),
                modifier = Modifier.weight(1f).background(Color(0xFFB69DF8))
            )
            QuadrantCard(
                title = stringResource(id = R.string.card4_title),
                description = stringResource(id = R.string.card4_desc),
                modifier = Modifier.weight(1f).background(Color(0xFFF6EDFF))
            )
        }
    }
}

@Composable
fun QuadrantCard(title: String, description: String, modifier: Modifier = Modifier) {
        Column(
            modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = description,
                textAlign = TextAlign.Justify
            )
        }
}


// U-5

/*@Composable
fun BlogPage(title: String, desc1: String, desc2: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.bg_compose_background);
    Column (
        modifier = Modifier.fillMaxSize()
    ){
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = desc1,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = desc2,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
    }
}*/

// U-4
/*
@Composable
fun BusinessCard(name: String, title: String, contact: String, social: String, email: String) {
    val img = painterResource(id = R.drawable.ic_launcher_foreground)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(Color.Magenta)
        ) {
            Image(
                painter = img,
                contentDescription = null,
                Modifier.background(Color.LightGray)
            )
            Text(
                text = name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = title,
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif
            )
        }

        Spacer(modifier = Modifier.padding(200.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row (
                modifier = Modifier.padding(2.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(Icons.Rounded.Phone, contentDescription = "Phone Icon")
                Text(text = contact)
            }

            Row (
                modifier = Modifier.padding(2.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    Icons.Rounded.Person,
                    contentDescription = "Linkedin"
                )
                Text(
                    text = social
                )
            }

            Row (
                modifier = Modifier.padding(2.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Icon(Icons.Rounded.Email, contentDescription = "Email")
                Text(
                    text = email
                )
            }
        }
    }
}
*/


// U-3
/*@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val img = painterResource(R.drawable.androidparty)
    Box(modifier) {
        Image(
            painter = img,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            alpha = 1.0F
        )
        HappyBirthdayMessage(message = message, from = from, modifier = Modifier
            .fillMaxSize()
            .padding(8.dp))
    }

}*/

// U-2
/*
@Composable
fun HappyBirthdayMessage(message: String, from: String, modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(8.dp)
                .align(alignment = Alignment.End)
        )
    }
}
*/

// U-1
/*@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}*/

/********************************
 * Preview Implementation Area **
 ********************************/

// P-6

@Preview(showBackground = true)
@Composable
fun QuadrantParentViewPreview(){
    QuadrantParentView()
}

// P-5
/*@Preview(showBackground = true)
@Composable
fun BlogPagePreview() {
    MyAppNaTheme {
        BlogPage(
            title = stringResource(id = R.string.blog_title),
            desc1 = stringResource(id = R.string.blog_desc1),
            desc2 = stringResource(id = R.string.blog_desc2)
        )
    }
}*/

// P-4

/*
@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    MyAppNaTheme {
        BusinessCard(name = "Moti Kumar", title = "Developer", contact = "+91 9876543210", social = "@linkedin/moti9", email = "moti@gmail.com")
    }
}
*/


// P-3
/*@Preview(showBackground = true)
@Composable()
fun GreetingImagePreview() {
    MyAppNaTheme {
        Surface (
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            GreetingImage(
                message = "Happy Birthday Dear MNOPQRST !",
                from = "- from ABCDEF",
            )
        }
    }
}*/

// P-2
/*
@Preview(showBackground = true)
@Composable
fun HappyBirthdayMessagePreviw() {
    MyAppNaTheme {
        HappyBirthdayMessage(message = "Happy Birthday Dear ABC", from = "from DEFGHI")
    }
}*/

// P-1
/*@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyAppNaTheme {
        Greeting("Android")
    }
}*/
