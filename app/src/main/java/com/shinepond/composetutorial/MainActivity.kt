package com.shinepond.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shinepond.composetutorial.ui.theme.ComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    drawProfileCard(Message("shinepond","android developer"))
                }
            }
        }
    }
}

@Composable
fun drawProfileCard(msg: Message) {
    Row (
        modifier = Modifier.padding(4.dp)
    ){
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "profile image",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column (
            //horizontalAlignment = Alignment.CenterHorizontally
        verticalArrangement = Arrangement.Center
                ) {
            Text(text = msg.author)
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = msg.body)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTutorialTheme {
        drawProfileCard(Message("shinepond","android developer"))
    }
}

class Message(
    val author : String,
    val body : String
) {

}