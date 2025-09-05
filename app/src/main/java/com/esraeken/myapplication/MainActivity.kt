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
import androidx.compose.material3.Button
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
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
@Composable
fun OnboardingPage1() {
    _root_ide_package_.androidx.compose.foundation.layout.Column() {

        _root_ide_package_.androidx.compose.foundation.layout.Box(modifier = Modifier.fillMaxSize()) {

            OnboardingAnimation()

            val screenWidth =
                _root_ide_package_.androidx.compose.ui.platform.LocalConfiguration.current.screenWidthDp.dp
            val screenHeight =
                _root_ide_package_.androidx.compose.ui.platform.LocalConfiguration.current.screenHeightDp.dp
            _root_ide_package_.androidx.compose.foundation.Image(
                painter = _root_ide_package_.androidx.compose.ui.res.painterResource(id = R.drawable.bg_onboarding_blue_circle),
                contentDescription = "Background",
                contentScale = _root_ide_package_.androidx.compose.ui.layout.ContentScale.Crop,
                modifier = Modifier
                    .align(_root_ide_package_.androidx.compose.ui.Alignment.BottomCenter)
                    .offset(y = screenHeight * 0.3f)

            )

            _root_ide_package_.androidx.compose.foundation.Image(
                painter = _root_ide_package_.androidx.compose.ui.res.painterResource(id = R.drawable.ic_qrispy_onboarding_logo),
                contentDescription = "Vector Blur",
                contentScale = _root_ide_package_.androidx.compose.ui.layout.ContentScale.Crop,
                modifier = Modifier
                    .wrapContentSize()
                    .blur(
                        radius = 10.dp,
                        edgeTreatment = _root_ide_package_.androidx.compose.ui.draw.BlurredEdgeTreatment.Unbounded
                    )
                    .align(_root_ide_package_.androidx.compose.ui.Alignment.BottomCenter)
                    .alpha(0.2f)
            )
            _root_ide_package_.androidx.compose.foundation.layout.Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.6f)
                    .align(_root_ide_package_.androidx.compose.ui.Alignment.BottomCenter)
            ) {


                _root_ide_package_.androidx.compose.foundation.layout.Column(
                    modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
                    verticalArrangement = _root_ide_package_.androidx.compose.foundation.layout.Arrangement.Bottom
                ) {
                    // Q Icon - sol üstte
                    _root_ide_package_.androidx.compose.foundation.Image(
                        painter = _root_ide_package_.androidx.compose.ui.res.painterResource(R.drawable.ic_qrispy_onboarding_logo),
                        contentDescription = "Bonus Icon"
                    )

                    // Ana başlık - sol hizalı
                    Text(
                        text = "One eSIM for Internet Everywhere",
                        style = _root_ide_package_.androidx.compose.material3.MaterialTheme.typography.headlineLarge,
                        fontSize = 32.sp,
                        fontWeight = _root_ide_package_.androidx.compose.ui.text.font.FontWeight.Bold,
                        color = _root_ide_package_.androidx.compose.ui.graphics.Color.White,
                        textAlign = _root_ide_package_.androidx.compose.ui.text.style.TextAlign.Start,
                        modifier = Modifier.padding(vertical = 16.dp)
                    )

                    Text(
                        text = "Install once and connect in over 190 countries.",
                        style = _root_ide_package_.androidx.compose.material3.MaterialTheme.typography.headlineSmall,
                        fontWeight = _root_ide_package_.androidx.compose.ui.text.font.FontWeight.Normal,
                        fontSize = 14.sp,
                        color = _root_ide_package_.androidx.compose.ui.graphics.Color.White,
                        textAlign = _root_ide_package_.androidx.compose.ui.text.style.TextAlign.Start
                    )

                    _root_ide_package_.androidx.compose.foundation.layout.Spacer(
                        modifier = Modifier.height(
                            16.dp
                        )
                    )

                    // Get Started butonu - ortalanmış

                    _root_ide_package_.androidx.compose.foundation.layout.Spacer(
                        modifier = Modifier.height(
                            16.dp
                        )
                    )

                    // Already have account link - ortalanmış
                    _root_ide_package_.androidx.compose.foundation.layout.Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = _root_ide_package_.androidx.compose.ui.Alignment.Center
                    ) {
                        _root_ide_package_.androidx.compose.material3.TextButton(
                            onClick = { /* TODO: Navigate to sign in */ }) {
                            Text(
                                text = "Already have an account",
                                fontSize = 16.sp,
                                color = _root_ide_package_.androidx.compose.ui.graphics.Color.White.copy(
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
    val title: String,
    val icon: String,
    val backgroundColor: Color,
    val accentColor: Color
)
@Composable
fun OnboardingAnimation(){
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
            .fillMaxWidth().padding(40.dp)
            .fillMaxHeight(0.4f),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        items.forEachIndexed { index, item ->
            FuseTextItem(
                item = item,
                isActive = index == currentIndex
            )
            Spacer(modifier = Modifier.height(16.dp))

        }
    }

}
@Composable
fun FuseTextItem(
    item: CarouselItem,
    isActive: Boolean
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
        }
    ) {
        // Icon - sadece aktif olanda göster
        if (isActive) {
            Text(
                text = item.icon,
                fontSize = 24.sp,
                modifier = Modifier.padding(end = 12.dp)
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