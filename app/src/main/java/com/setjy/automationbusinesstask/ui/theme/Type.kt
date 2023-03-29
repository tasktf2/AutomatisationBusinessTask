package com.setjy.automationbusinesstask.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.setjy.automationbusinesstask.R

val MontserratFontFamily = FontFamily(
    Font(R.font.montserrat_extra_light, FontWeight.ExtraLight, FontStyle.Normal),
    Font(R.font.montserrat_extra_light_italic, FontWeight.ExtraLight, FontStyle.Italic),
    Font(R.font.montserrat_light, FontWeight.Light, FontStyle.Normal),
    Font(R.font.montserrat_light_italic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.montserrat_thin, FontWeight.Thin, FontStyle.Normal),
    Font(R.font.montserrat_thin_italic, FontWeight.Thin, FontStyle.Italic),
    Font(R.font.montserrat_medium, FontWeight.Medium, FontStyle.Normal),
    Font(R.font.montserrat_medium_italic, FontWeight.Medium, FontStyle.Italic),
    Font(R.font.montserrat_regular, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.montserrat_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.montserrat_semi_bold, FontWeight.SemiBold, FontStyle.Normal),
    Font(R.font.montserrat_semi_bold_italic, FontWeight.SemiBold, FontStyle.Italic),
    Font(R.font.montserrat_bold, FontWeight.Bold, FontStyle.Normal),
    Font(R.font.montserrat_bold_italic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.montserrat_extra_bold, FontWeight.ExtraBold, FontStyle.Normal),
    Font(R.font.montserrat_extra_bold_italic, FontWeight.ExtraBold, FontStyle.Italic),
    Font(R.font.montserrat_black, FontWeight.Black, FontStyle.Normal),
    Font(R.font.montserrat_black_italic, FontWeight.Black, FontStyle.Italic)
)

val Typography = Typography(
    //header
    h1 = TextStyle(
        fontFamily = MontserratFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 26.sp
    ),
    //store name
    body1 = TextStyle(
        fontFamily = MontserratFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
    ),
    //product
    body2 = TextStyle(
        fontFamily = MontserratFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
    ),
    //store address
    caption = TextStyle(
        fontFamily = MontserratFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    )
)