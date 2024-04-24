package com.example.fusionfit


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Checkbox
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fusionfit.ui.theme.TextColor
import com.example.fusionfit.ui.theme.GrayColor
import com.example.fusionfit.ui.theme.Primary
import com.example.fusionfit.ui.theme.Secondary
import com.example.fusionfit.ui.theme.TextColor
import kotlin.math.min

@Composable
fun NormalTextComponent(value:String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = TextColor,
        textAlign = TextAlign.Center
    )
}

@Composable
fun HeadingTextComponent(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        color = TextColor,
        textAlign = TextAlign.Center
    )
}

@Composable
fun MyTextField (labelValue:String,painterResource: Painter,
                 onTextSelected: (String) -> Unit,
                 errorStatus :Boolean=false){

    val textValue = remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label = { Text (text = labelValue) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        singleLine = true,
        maxLines = 1,
        value = textValue.value,
        onValueChange = {
            textValue.value = it
            onTextSelected(it)

        },
        leadingIcon = {
            Icon(painter = painterResource,contentDescription = "")
        },
        isError = !errorStatus

    )
}


@Composable
fun PasswordTextField (labelValue:String,painterResource: Painter,
                       onTextSelected: (String) -> Unit,
                       errorStatus :Boolean=false){

    val localFocusManager = LocalFocusManager.current
    val password = remember {
        mutableStateOf("")
    }

    val passwordVisible = remember{
        mutableStateOf(false)
    }
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label = { Text (text = labelValue) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done),
        singleLine = true,
        keyboardActions = KeyboardActions{
            localFocusManager.clearFocus()

        },
        maxLines = 1,
        value = password.value,
        onValueChange = {
            password.value = it
            onTextSelected(it)

        },
        leadingIcon = {
             Icon(painterResource,contentDescription = "")
         },
        trailingIcon = {
            val iconImage = if(passwordVisible.value) {
                Icons.Filled.Visibility
            } else{
               Icons.Filled.VisibilityOff
            }

            var description = if(passwordVisible.value){
                "Hide password"
            }
            else{
              "Show password"
            }
            IconButton(onClick = {passwordVisible.value = !passwordVisible.value}) {
                Icon(imageVector = iconImage,contentDescription =description)

            }
        },
        visualTransformation = if(passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        isError = !errorStatus

    )
}


@Composable
fun ButtonComponent(value: String,onButtonClicked : () -> Unit,isEnabled :Boolean = false){
    Button(onClick = { onButtonClicked.invoke() },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 48.dp),
        contentPadding = PaddingValues(),
        colors = androidx.compose.material3.ButtonDefaults.outlinedButtonColors(
            contentColor = Color.Transparent
        ),
        enabled = isEnabled
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp)
            .background(
                brush = Brush.horizontalGradient(listOf(Secondary, Primary)),
                shape = RoundedCornerShape(50.dp)
            ),
            contentAlignment = Alignment.Center
        ){
            Text(text = value,
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold)

        }

    }
}

@Composable
fun DividerTextComponent(){
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically) {

        Divider(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            color = GrayColor,
            thickness = 1.dp
        )
        Text(modifier = Modifier.padding(8.dp),
            text = "OR", fontSize = 18.sp, color = TextColor)
        Divider(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            color = GrayColor,
            thickness = 1.dp
        )

    }
}

@Composable
fun ClickableLoginTextComponent (tryingToLogin :Boolean= true,onTextSelected: (String) -> Unit){
    val initialText = if (tryingToLogin)"Already have an account?" else "Don't have an account yet? "
    val loginText = if (tryingToLogin)"Login" else "Register"
    
    val annotatedString = buildAnnotatedString { 
        append(initialText)
        withStyle(style = SpanStyle(color = Primary)){
            pushStringAnnotation(tag = loginText, annotation = loginText)
            append(loginText)
        }
    }
    ClickableText(  modifier = Modifier
        .fillMaxWidth()
        .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 21.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
        ),
        text = annotatedString, onClick = { offset ->


        annotatedString.getStringAnnotations(offset, offset)
            .firstOrNull()?.also { span ->

            Log.d("ClickableTextComponent","{${span.item}}")

            if (span.item == loginText) {

                onTextSelected(span.item)
            }
        }
    })


}

