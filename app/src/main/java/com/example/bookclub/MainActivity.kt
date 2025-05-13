package com.example.bookclub

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bookclub.ui.theme.BookClubTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*setContent {
            BookClubTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    BookImage(
                        "jork",
                        "gerf",
                        modifier = Modifier.padding(24.dp)
                        )
                }
            }
        }*/
        val addBookButton: Button =findViewById(R.id.addBookButton)
        addBookButton.setOnClickListener{
            Toast.makeText(this, "weiner dog", Toast.LENGTH_SHORT).show()
        }
    }
}

@Composable
fun BookText(title: String, author: String, modifier: Modifier = Modifier) {
    //Make column so texts don't overlap
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = title,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 24.dp)
        )
        Text(
            text = author,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(top = 16.dp)
                .padding(end = 16.dp)
        )
    }
}

@Composable
fun BookImage(title: String, author: String, modifier: Modifier = Modifier){
    //Make box to overlap images & text
    Box(modifier) {
        Image(
            painter = painterResource(id = R.drawable.marcboomin),
            contentDescription = null,
            //contentScale = ContentScale.Crop,
        )
        BookText(
            title = title,
            author = author,
            modifier = Modifier
                .fillMaxSize()
        )
    }
}
