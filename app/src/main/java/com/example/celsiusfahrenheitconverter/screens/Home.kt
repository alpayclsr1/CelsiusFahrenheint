package com.example.celsiusfahrenheitconverter.screens

import android.media.Image
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.celsiusfahrenheitconverter.viewmodel.HomeViewModel
import com.example.celsiusfahrenheitconverter.R

@Composable
fun Home(homeViewModel: HomeViewModel){
    val context = LocalContext.current

    val tf1= remember {
        mutableStateOf("0")
    }
    val tf1Text= remember {
        mutableStateOf("Celsius")
    }
    val tf2= remember {
        mutableStateOf("0")
    }
    val tf2Text= remember {
        mutableStateOf("Fahrenheit")
    }
    val LText= remember {
        mutableStateOf("Celsius To Fahrenheit")
    }

    val celsius= remember {
        mutableStateOf(true)
    }
    val image1= remember {
        mutableStateOf(R.drawable.ctof)
    }

    val image2= remember {
        mutableStateOf(R.drawable.ftoc)
    }
    if (celsius.value!=true){
        LText.value="Fahrenheit to Celsius"
        image1.value=R.drawable.ftoc
    }else{
        LText.value="Celsius To Fahrenheit"
        image1.value=R.drawable.ctof
    }







    var contentMargin=14.dp


    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){


        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally  ) {

            Spacer(modifier = Modifier.padding(contentMargin))
            Spacer(modifier = Modifier.padding(contentMargin))
            androidx.compose.foundation.Image(painter = painterResource(image1.value), contentDescription ="", modifier = Modifier.size(350.dp,75.dp))

            Spacer(modifier = Modifier.padding(contentMargin))

            Spacer(modifier = Modifier.padding(contentMargin))
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly) {
                Spacer(modifier = Modifier.padding(contentMargin))
                Text(text = tf1Text.value +" :", fontSize = 32.sp, modifier = Modifier.size(200.dp,50.dp))
                Spacer(modifier = Modifier.padding(contentMargin))
                TextField(value = tf1.value, onValueChange ={tf1.value=it} , 
                    modifier = Modifier.size(100.dp,75.dp), 
                    textStyle = TextStyle(fontSize = 25.sp), 
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedLabelColor = colorResource(id = R.color.top), unfocusedLabelColor = colorResource(
                            id = R.color.top
                        ), focusedBorderColor = colorResource(id = R.color.top), unfocusedBorderColor = Color.Black
                        ), maxLines = 1
                 )
                Spacer(modifier = Modifier.padding(contentMargin))
            }
            Spacer(modifier = Modifier.padding(contentMargin))
            Spacer(modifier = Modifier.padding(contentMargin))
            Button(onClick = { if (celsius.value==true){
                celsius.value=false
            } else if (celsius.value==false){
                celsius.value=true
            }

            }, modifier = Modifier, shape = CircleShape
                , colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.top), contentColor = Color.White)) {
                Text(text = "l", fontSize = 32.sp)

            }
            Spacer(modifier = Modifier.padding(contentMargin))
            Spacer(modifier = Modifier.padding(contentMargin))
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly) {

                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly) {
                    Spacer(modifier = Modifier.padding(contentMargin))
                    Text(text = tf2Text.value +" :", fontSize = 32.sp, modifier = Modifier.size(200.dp,50.dp))
                    Spacer(modifier = Modifier.padding(contentMargin))
                    TextField(value = tf2.value, onValueChange ={tf2.value=it} , modifier = Modifier.size(100.dp,75.dp),textStyle = TextStyle(fontSize = 25.sp),colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedLabelColor = colorResource(id = R.color.top), unfocusedLabelColor = colorResource(
                            id = R.color.top
                        ), focusedBorderColor = colorResource(id = R.color.top), unfocusedBorderColor = Color.Black
                    ), maxLines = 1 )
                    Spacer(modifier = Modifier.padding(contentMargin))

                }
            }
            Spacer(modifier = Modifier.padding(contentMargin))
            Spacer(modifier = Modifier.padding(contentMargin))

            Row(modifier = Modifier.fillMaxHeight(), verticalAlignment = Alignment.CenterVertically,) {
                Button(onClick = {

                    /*if (tf2.value!=null){
                        homeViewModel.convertFaToCe(tf2.value)
                        tf1.value=homeViewModel.uiState.result
                    }else if(tf1.value!=null){
                        homeViewModel.convertCeToFa(tf1.value)
                        tf2.value=homeViewModel.uiState.result
                    }*/
                    if (tf1.value!=""  && tf2.value!=""){
                        if (celsius.value==true){
                            homeViewModel.convertCeToFa(tf1.value)
                            tf2.value=homeViewModel.uiState.result
                        }else{
                            homeViewModel.convertFaToCe(tf2.value)
                            tf1.value=homeViewModel.uiState.result
                        }


                    }else{

                        Toast.makeText(context," There is no value to calculate", Toast.LENGTH_SHORT).show()
                    }












                }, modifier = Modifier, shape = CircleShape
                    , colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.top), contentColor = Color.White)) {
                    Text(text = "Calculate", fontSize = 32.sp)

                }



            }




        }



    }


}




@Preview(showBackground = true)
@Composable
fun PrevHome(){



}