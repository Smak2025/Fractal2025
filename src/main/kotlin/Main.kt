import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {
    MaterialTheme {
        Content(Modifier.fillMaxWidth())
    }
}

@Composable
fun Content(modifier: Modifier = Modifier) {
    Text("Hello, World!")
}

fun main(): Unit = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
