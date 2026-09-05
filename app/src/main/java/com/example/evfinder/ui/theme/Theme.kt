package com.example.evfinder.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = EcoGreenPrimary,
    onPrimary = Color.Black,
    primaryContainer = EcoGreenDark,
    onPrimaryContainer = EcoGreenLight,
    secondary = EcoSecondary,
    secondaryContainer = EcoDarkSurfaceVariant,
    background = EcoDarkBackground,
    surface = EcoDarkSurface,
    onBackground = Color.White,
    onSurface = Color.White,
    surfaceVariant = EcoDarkSurfaceVariant
)

private val LightColorScheme = lightColorScheme(
    primary = EcoGreenDark,
    onPrimary = Color.White,
    primaryContainer = EcoGreenContainer,
    onPrimaryContainer = EcoGreenDark,
    secondary = EcoSecondary,
    secondaryContainer = EcoSecondaryContainer,
    background = EcoLightBackground,
    surface = EcoLightSurface,
    onBackground = Color(0xFF0F172A),
    onSurface = Color(0xFF0F172A),
    surfaceVariant = Color(0xFFE2E8F0)
)

@Composable
fun EvFinderTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // Set false to preserve our custom Eco-Green theme identity
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
