


package com.example.fusionfit

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fusionfit.ui.theme.FusionFitTheme

@Composable
fun AboutUs(){
    Column(Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Spacer(modifier = Modifier.height(60.dp))

        Text(text = "Meet Our Amazing Team !",
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 40.dp),
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic
            ),
            color = Color.Black,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(60.dp))

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Column {
                Image(painterResource(id =com.example.fusionfit.R.drawable.akhilesh),
                    contentDescription = null,
                    Modifier
                        .padding(10.dp)
                        .size(100.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.DarkGray, shape = CircleShape),
                    contentScale = ContentScale.Crop)
                Text(text = "Akhilesh Shinde",
                    modifier = Modifier
                        .heightIn(min = 40.dp),
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Italic
                    ),
                    color = Color.DarkGray,
                    textAlign = TextAlign.Center
                )

            }
            Spacer(modifier = Modifier.width(50.dp))
            Column {
                Image(painter = painterResource(id = com.example.fusionfit.R.drawable.shreyas),
                    contentDescription = null,
                    Modifier
                        .padding(10.dp)
                        .size(100.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.DarkGray, shape = CircleShape),
                    contentScale = ContentScale.Crop
                )
                Text(text = "  Shreyas Raut",
                    modifier = Modifier
                        .heightIn(min = 40.dp),
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Italic
                    ),
                    color = Color.DarkGray,
                    textAlign = TextAlign.Center
                )
            }


        }
        Spacer(modifier = Modifier.height(70.dp))
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Column {
                Image(painter = painterResource(id = com.example.fusionfit.R.drawable.vijay),
                    contentDescription = null,
                    Modifier
                        .padding(10.dp)
                        .size(100.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.DarkGray, shape = CircleShape),
                    contentScale = ContentScale.Crop)
                Text(text = "   Vijayraj Parve",
                    modifier = Modifier
                        .heightIn(min = 40.dp),
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Italic
                    ),
                    color = Color.DarkGray,
                    textAlign = TextAlign.Center
                )

            }
            Spacer(modifier = Modifier.width(50.dp))
            Column {
                Image(painter = painterResource(id = com.example.fusionfit.R.drawable.nitesh),
                    contentDescription = null,
                    Modifier
                        .padding(10.dp)
                        .size(100.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.DarkGray, shape = CircleShape),
                    contentScale = ContentScale.Crop
                )
                Text(text = " Nitesh Rajpurohit",
                    modifier = Modifier
                        .heightIn(min = 40.dp),
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Italic
                    ),
                    color = Color.DarkGray,
                    textAlign = TextAlign.Center
                )
            }


        }

    }
    /* Column(Modifier.fillMaxSize(),
         verticalArrangement = Arrangement.Center,
         horizontalAlignment = Alignment.CenterHorizontally){
         Spacer(modifier = Modifier.height(20.dp))
         Text(text = "Meet Our Amazing Team !",
             modifier = Modifier
                 .fillMaxWidth()
                 .heightIn(min = 40.dp),
             style = TextStyle(
                 fontSize = 30.sp,
                 fontWeight = FontWeight.Bold,
                 fontStyle = FontStyle.Italic
             ),
             color = Color.Black,
             textAlign = TextAlign.Center
         )

         Spacer(modifier = Modifier.height(20.dp))


         Image(painter = painterResource(id = com.example.aboutus.R.drawable.akhilesh),
             contentDescription = null,
             Modifier
                 .padding(10.dp)
                 .size(100.dp)
                 .clip(CircleShape)
                 .border(2.dp, Color.DarkGray, shape = CircleShape),
             contentScale = ContentScale.Crop
         )
         Text(text = "Akhilesh Shinde",
             modifier = Modifier
                 .fillMaxWidth()
                 .heightIn(min = 40.dp),
             style = TextStyle(
                 fontSize = 18.sp,
                 fontWeight = FontWeight.Normal,
                 fontStyle = FontStyle.Italic
             ),
             color = Color.DarkGray,
             textAlign = TextAlign.Center
         )

         Image(painter = painterResource(id = com.example.aboutus.R.drawable.shreyas),
             contentDescription = null,
             Modifier
                 .padding(10.dp)
                 .size(100.dp)
                 .clip(CircleShape)
                 .border(2.dp, Color.DarkGray, shape = CircleShape),
             contentScale = ContentScale.Crop
         )
         Text(text = "Shreyas Raut",
             modifier = Modifier
                 .fillMaxWidth()
                 .heightIn(min = 40.dp),
             style = TextStyle(
                 fontSize = 18.sp,
                 fontWeight = FontWeight.Normal,
                 fontStyle = FontStyle.Italic
             ),
             color = Color.DarkGray,
             textAlign = TextAlign.Center
         )

         Image(painter = painterResource(id = com.example.aboutus.R.drawable.vijay),
             contentDescription = null,
             Modifier
                 .padding(10.dp)
                 .size(100.dp)
                 .clip(CircleShape)
                 .border(2.dp, Color.DarkGray, shape = CircleShape),
             contentScale = ContentScale.Crop
         )
         Text(text = "Vijayraj Parve",
             modifier = Modifier
                 .fillMaxWidth()
                 .heightIn(min = 40.dp),
             style = TextStyle(
                 fontSize = 18.sp,
                 fontWeight = FontWeight.Normal,
                 fontStyle = FontStyle.Italic
             ),
             color = Color.DarkGray,
             textAlign = TextAlign.Center
         )

         Image(painter = painterResource(id = com.example.aboutus.R.drawable.nitesh),
             contentDescription = null,
             Modifier
                 .padding(10.dp)
                 .size(100.dp)
                 .clip(CircleShape)
                 .border(2.dp, Color.DarkGray, shape = CircleShape),
             contentScale = ContentScale.Crop
         )
         Text(text = "Nitesh Rajpurohit",
             modifier = Modifier
                 .fillMaxWidth()
                 .heightIn(min = 40.dp),
             style = TextStyle(
                 fontSize = 18.sp,
                 fontWeight = FontWeight.Normal,
                 fontStyle = FontStyle.Italic
             ),
             color = Color.DarkGray,
             textAlign = TextAlign.Center
         )


     }*/

}







//package com.example.fusionfit
//
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.sp
//import com.example.fusionfit.ui.theme.FusionFitTheme
//import com.example.fusionfit.ui.theme.headerColor
//
//@Composable
//fun AboutUs(){
//    Box(modifier = Modifier.fillMaxSize()){
//        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()) {
//            Text(text = "Settings", fontSize = 30.sp, color = headerColor)
//        }
//    }
//}
//
//
@Preview
@Composable
fun showPreviewSettings(){
    FusionFitTheme {
        AboutUs()
    }
}