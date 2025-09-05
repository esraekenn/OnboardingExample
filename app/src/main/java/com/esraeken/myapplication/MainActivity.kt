package com.esraeken.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.esraeken.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                OnboardingPage1()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Composable
fun OnboardingPage1() {
    Column {

        Box(modifier = Modifier.fillMaxSize()) {

            OnboardingAnimation()

            val screenWidth =
                LocalConfiguration.current.screenWidthDp.dp
            val screenHeight =
                LocalConfiguration.current.screenHeightDp.dp
            Image(
                painter = painterResource(id = R.drawable.bg_onboarding_blue_circle),
                contentDescription = "Background",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .offset(y = screenHeight * 0.3f)

            )

            Image(
                painter = painterResource(id = R.drawable.ic_qrispy_onboarding_logo),
                contentDescription = "Vector Blur",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .wrapContentSize()
                    .blur(
                        radius = 10.dp,
                        edgeTreatment = BlurredEdgeTreatment.Unbounded
                    )
                    .align(Alignment.BottomCenter)
                    .alpha(0.2f)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.6f)
                    .align(Alignment.BottomCenter)
            ) {


                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    // Q Icon - sol üstte
                    Image(
                        painter = painterResource(R.drawable.ic_launcher_foreground),
                        contentDescription = "Bonus Icon"
                    )

                    // Ana başlık - sol hizalı
                    Text(
                        text = "One eSIM for Internet Everywhere",
                        style = MaterialTheme.typography.headlineLarge,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.padding(vertical = 16.dp)
                    )

                    Text(
                        text = "Install once and connect in over 190 countries.",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        color = Color.White,
                        textAlign = TextAlign.Start
                    )

                    Spacer(
                        modifier = Modifier.height(
                            16.dp
                        )
                    )

                    // Get Started butonu - ortalanmış

                    Spacer(
                        modifier = Modifier.height(
                            16.dp
                        )
                    )

                    // Already have account link - ortalanmış
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        TextButton(
                            onClick = { /* TODO: Navigate to sign in */ }) {
                            Text(
                                text = "Already have an account",
                                fontSize = 16.sp,
                                color = Color.White.copy(
                                    alpha = 0.8f
                                )
                            )
                        }
                    }
                }
            }
        }

    }

}

data class CarouselItem(
    val title: String, val icon: String, val backgroundColor: Color, val accentColor: Color
)

@Composable
fun OnboardingAnimation() {
    val items = listOf(
        CarouselItem("Pay", "💳", Color(0xFF00D4FF), Color(0xFF00D4FF)),
        CarouselItem("Save", "💎", Color(0xFF00D4FF), Color(0xFF00D4FF)),
        CarouselItem("Earn", "📈", Color(0xFF00D4FF), Color(0xFF00D4FF))
    )

    var currentIndex by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        while (true) {
            items.indices.forEach { index ->
                currentIndex = index
                delay(2000) // Her text 2 saniye focus kalır
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(40.dp)
            .fillMaxHeight(0.4f),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        items.forEachIndexed { index, item ->
            FuseTextItem(
                item = item, isActive = index == currentIndex
            )
            Spacer(modifier = Modifier.height(16.dp))

        }
    }

}

@Composable
fun FuseTextItem(
    item: CarouselItem, isActive: Boolean
) {
    val alpha by animateFloatAsState(
        targetValue = if (isActive) 1f else 0.3f,
        animationSpec = tween(durationMillis = 600, easing = FastOutSlowInEasing),
        label = "alpha"
    )

    val scale by animateFloatAsState(
        targetValue = if (isActive) 1f else 0.9f,
        animationSpec = tween(durationMillis = 600, easing = FastOutSlowInEasing),
        label = "scale"
    )

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier.graphicsLayer {
            this.alpha = alpha
            scaleX = scale
            scaleY = scale
        }) {
        // Icon - sadece aktif olanda göster
        if (isActive) {
            Text(
                text = item.icon, fontSize = 24.sp, modifier = Modifier.padding(end = 12.dp)
            )
        } else {
            // Boş alan bırak ki hizalama bozulmasın
            Spacer(modifier = Modifier.width(36.dp))
        }

        Text(
            text = item.title,
            fontSize = if (isActive) 48.sp else 36.sp,
            fontWeight = FontWeight.Bold,
            color = if (isActive) Color.Black else Color.Gray,
            style = MaterialTheme.typography.headlineLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        OnboardingPage1()
    }
}