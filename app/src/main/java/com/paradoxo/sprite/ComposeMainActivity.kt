package com.paradoxo.sprite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.paradoxo.sprite.ui.theme.SpriteTheme

class ComposeMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpriteTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppScreen()
                }
            }
        }
    }
}

@Composable
fun AppScreen() {
    var moveCard by remember { mutableStateOf(true) }

    val heightDp = LocalConfiguration.current.screenHeightDp

    val animatedOffset by animateDpAsState(
        targetValue = if (moveCard) 0.dp else (heightDp / 2).dp,
        label = ""
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(15, 15, 68))
            .clickable {
                moveCard = !moveCard
            }
    ) {
        Box(modifier = Modifier.offset(y = animatedOffset)) {
            CardScreenImageView(
                image = R.drawable.luffy,
                text = stringResource(id = R.string.bounce),
                textColor = R.color.purple_200,
            )
        }

    }
}

@Composable
fun CardScreenImageView(
    image: Int,
    text: String,
    textColor: Int
) {
    var changeCorner by remember { mutableStateOf(true) }

    val cornerAnimation by animateDpAsState(
        targetValue = if (changeCorner) 50.dp else 10.dp,
        label = ""
    )

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        ElevatedCard(
            shape = RoundedCornerShape(cornerAnimation),
            modifier = Modifier.clickable {
                changeCorner = !changeCorner
            }
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "imagem personagem luffy"
            )
        }

        Text(
            text = text,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            textAlign = TextAlign.Center,
            color = colorResource(id = textColor)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun AppScreenPreview() {
    AppScreen()
}