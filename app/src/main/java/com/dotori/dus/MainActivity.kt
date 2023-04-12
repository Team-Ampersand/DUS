package com.dotori.dus

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dotori.dotori_components.components.toggle.DotoriThemeSwitchButton
import com.dotori.dotori_components.theme.DotoriColor

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            // 시스템 설정에 따라 앱의 테마를 설정합니다.
            val checkDarkMode = if (isSystemInDarkTheme())  // 현재 디바이스가 어두운 테마인지 확인합니다.
                AppCompatDelegate.MODE_NIGHT_YES
            else AppCompatDelegate.MODE_NIGHT_NO
            AppCompatDelegate.setDefaultNightMode(checkDarkMode)


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(DotoriColor.BackGround)
            ) {
                DotoriThemeSwitchButton(
                    switchPadding = 5.dp,
                    buttonWidth = 70.dp,
                    buttonHeight = 40.dp,
                    onSwitchClick = {

                    }
                )
            }
        }
    }
}