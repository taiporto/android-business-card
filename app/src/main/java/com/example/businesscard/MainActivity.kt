package com.example.businesscard

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard("Tai Porto", title = "Front-end Software Developer", phoneNumber = "+55 21 0000-0000", twitterHandle = "@moonkoala_", email="tai.dporto@gmail.com")
                }
            }
        }
    }
}

@Composable
fun BusinessCard(fullName: String, title: String, phoneNumber: String, twitterHandle:String, email: String, modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier= modifier.fillMaxSize()) {
        PersonalInfo(fullName = fullName, title = title)
        ContactInfo(phoneNumber, twitterHandle, email)
    };
}

@Composable
fun PersonalInfo(fullName: String, title: String, modifier: Modifier = Modifier) {
    Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier= modifier
        .fillMaxWidth()
        .padding(bottom = 32.dp)) {
        Image(
            modifier = modifier.size(160.dp),
            alignment = Alignment.Center,
            painter = painterResource(id = R.drawable.me),
            contentDescription = stringResource(R.string.personal_photo_description)
        )
        Text(
            text = fullName,
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = title,
        )
    }
}

@Composable
fun PurpleIcon(icon: ImageVector, contentDescription: String) {
    Icon(icon, contentDescription, tint = Color(0XFF691E9B))
}

@Composable
fun ContactInfo(phoneNumber: String, twitterHandle:String, email: String, modifier: Modifier = Modifier) {
    Column {
        Row {
            PurpleIcon(Icons.Rounded.Phone, contentDescription = stringResource(R.string.phone_icon_description))
            Spacer(modifier = modifier.size(8.dp))
            Text(
                text = phoneNumber
            )
        }
        Row {
            PurpleIcon(Icons.Rounded.Share, contentDescription = stringResource(R.string.social_media_description))
            Spacer(modifier = modifier.size(8.dp))
            Text(
                text = twitterHandle
            )
        }
        Row {
            PurpleIcon(Icons.Rounded.Email, contentDescription = stringResource(R.string.email_icon_description))
            Spacer(modifier = modifier.size(8.dp))
            Text(
                text = email
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard("Tai Porto", title = "Front-end Software Developer", phoneNumber = "+55 21 0000-0000", twitterHandle = "@moonkoala_", email="tai.dporto@gmail.com")
    }
}