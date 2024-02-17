import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gallery.ui.theme.GalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GalleryTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingWithButtons()
                }
            }
        }
    }
}

@Composable
fun GreetingWithButtons() {
    var currentArtistIndex by remember { mutableStateOf(0) }
    val artists = listOf("Mariya", "John", "Anna", "David", "Linda", "Michael", "Emma", "Daniel", "Olivia", "James")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hi, my name is artist ${artists[currentArtistIndex]}!",
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {
                currentArtistIndex = (currentArtistIndex - 1 + artists.size) % artists.size
            }) {
                Text(text = "Попередній")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = {
                currentArtistIndex = (currentArtistIndex + 1) % artists.size
            }) {
                Text(text = "Наступний")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingWithButtonsPreview() {
    GalleryTheme {
        GreetingWithButtons()
    }
}
