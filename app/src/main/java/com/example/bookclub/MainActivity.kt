package com.example.bookclub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bookclub.ui.theme.BookClubTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookClubTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    Column(
                        modifier = Modifier.padding(top = 32.dp)
                    ) {
                        Header(
                            modifier = Modifier.fillMaxWidth()
                        )
                        BookCard(
                            msg = Book("Crime & Punishment", "Fyodor Dostoevsky")
                        )
                    }

                }
            }
        }
    }
}

data class Book(val title: String, val author: String)

@Composable
fun BookCard(msg:Book, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.padding(all = 21.dp),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = R.drawable.crimeandpunishment),
            contentDescription = "Marc's big ass",
            modifier = Modifier
                .size(200.dp)
                .padding(bottom = 4.dp)
        )
        Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp) {
            Text(
                text = msg.title,
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.padding(all = 4.dp)
            )
        }
        Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 2.dp) {
            Text(
                text = "By " + msg.author,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.padding(all = 4.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBookCard(){
    Surface {
        BookCard(
            msg = Book("Crime", "Droid")
        )
    }
}

@Composable
fun Header(modifier: Modifier = Modifier){
    Text(
        text= "Your Books",
        textAlign = TextAlign.Center,
        fontSize = 24.sp,
        modifier = modifier
    )

}