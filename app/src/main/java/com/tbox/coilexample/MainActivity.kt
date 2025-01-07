package com.tbox.coilexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import coil.compose.AsyncImage
import com.tbox.coilexample.ui.theme.CoilExampleTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.imageLoader
import coil.memory.MemoryCache

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Url'ler tanımlanıyor
        val imageUrl = "https://miro.medium.com/v2/resize:fit:640/format:webp/1*Je7aKKEi63p-3jHHs7CTXA.png"
        val imageUrl2 = "https://miro.medium.com/v2/resize:fit:640/format:webp/1*Je7aKKEi63p-3jHHs7CTXA.png"


        enableEdgeToEdge()

        //UI bileşeni
        setContent {
            CoilExampleTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {

                    //İlk resmi SubcomposeAsyncImage ile yükleme
                    SubcomposeAsyncImage(
                        model = imageUrl,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1280f/847f) //Oran
                    )

                    //İkinci resmi AsyncImage ile yükleme
                    AsyncImage(
                        model = imageUrl2,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1280f/692f)
                    )
                    Spacer(Modifier.height(16.dp))

                    //Önbelleği temizleyen buton
                    Button(
                        onClick = {

                            // Disk önbelleğinden belirtilen URL'yi temizler
                            imageLoader.diskCache?.remove(imageUrl)

                            //Bellek önbelleğinden belirtilen URL'yi temizler
                            imageLoader.memoryCache?.remove(MemoryCache.Key(imageUrl))
                        }
                    ) {
                        Text("Clear cache")
                    }
                }



            }
        }
    }
}



