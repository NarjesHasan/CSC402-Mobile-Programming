package sa.edu.iau.cshj.studyplanner.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = Teal80,
    secondary = TealGrey80,
    tertiary = Blue80
)

private val LightColorScheme = lightColorScheme(
    primary = Teal40,
    secondary = TealGrey40,
    tertiary = Blue40
)

@Composable
fun StudyPlannerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
