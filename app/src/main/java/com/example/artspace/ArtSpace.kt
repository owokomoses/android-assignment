package com.example.artspace



import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment

class ArtPiece(
    val imageRes: Int,
    val title: String,
    val artist: String,
    val date: String
)

@Composable
fun ArtSpace(modifier: Modifier = Modifier) {

    val artPieces = listOf(
        ArtPiece(R.drawable.mercedes, "Mercedes", "Moses", "Published in 2024"),
        ArtPiece(R.drawable.bmw, "BMW", "Andrew Miles", "Published in 2024"),
        ArtPiece(R.drawable.ferrari, "Ferrari", "John Doe", "Published in 2024"),
        ArtPiece(R.drawable.r35, "Nissan GTR", "Mary Doe", "Published in 2024"),
        ArtPiece(R.drawable.porsche, "Porsche 911 GT3RS", "Mike Daniel", "Published in 2024")
    )

    var currentIndex by remember { mutableIntStateOf(0) }

    Column(
        modifier = modifier
            .padding(top = 50.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = artPieces[currentIndex].imageRes),
            contentDescription = null,
            modifier = Modifier
                .size(400.dp)
                .padding(bottom = 16.dp)
        )

        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(0.8f)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(text = artPieces[currentIndex].title)
                Text(text = "Photo by ${artPieces[currentIndex].artist}")
                Text(text = artPieces[currentIndex].date)
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Button(
                onClick = {
                    if (currentIndex > 0) currentIndex--
                },
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(text = "Previous")
            }

            Button(
                onClick = {
                    if (currentIndex < artPieces.size - 1) currentIndex++
                },
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(text = "Next")
            }
        }
    }
}
