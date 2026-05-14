package com.example.gamesetmatch.usr.glowna

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.ArrowCircleRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.gamesetmatch.R
import com.example.gamesetmatch.data.MeczEntity
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.offset
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.rotate
import androidx.compose.runtime.getValue

@Composable
fun GlownyScreen(viewModel: GlownaViewModel,
                 onNavigateToNauka: () -> Unit,
                 onNavigateToUStawienia: () -> Unit
                 ) {

    val match = viewModel.match

    // ANIMACJA 1 - strzałka
    val infiniteTransition = rememberInfiniteTransition()
    val offsetX = infiniteTransition.animateFloat(
        initialValue = 3f,
        targetValue = -3f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000),
            repeatMode = RepeatMode.Reverse
        ),
        label = "PulsingArrowAnimation"
    )

    // ANIMACJA 2 - zębatka
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val rotationAngle by animateFloatAsState(
        targetValue = if (isPressed) 180f else 0f,
        animationSpec = tween(durationMillis = 500),
        label = "GearRotation"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        ) {

        ListItem(
            headlineContent = {
                Text(
                    "${stringResource(R.string.cze)} \n${viewModel.name}",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )
            },
            supportingContent = {
                Text(
                    stringResource(R.string.gotowy_na_kort),
                    fontSize = 15.sp
                )
            },
            trailingContent = {
                IconButton(onClick = onNavigateToUStawienia, interactionSource = interactionSource) {
                    Icon(
                        Icons.Default.Settings,
                        contentDescription = "",
                        modifier = Modifier.size(30.dp).rotate(rotationAngle)
                    )
                }
            },
            colors = ListItemDefaults.colors(
                containerColor = Color.Transparent,
                headlineColor = MaterialTheme.colorScheme.scrim,
                supportingColor = MaterialTheme.colorScheme.scrim,
                trailingIconColor = MaterialTheme.colorScheme.scrim
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent
            ),

            shape = RoundedCornerShape(16.dp)
        ) {
            ListItem(
                headlineContent = {
                    Text(stringResource(R.string.rozpocznij_trening), fontSize = 20.sp, fontWeight = FontWeight.Bold ,modifier = Modifier.padding(5.dp))
                },

                trailingContent = {
                    IconButton(
                        onClick = onNavigateToNauka,
                        Modifier.size(45.dp)
                    ) {
                        Icon(
                            Icons.Outlined.ArrowCircleRight,
                            contentDescription = null,
                            Modifier.size(45.dp).offset(x = offsetX.value.dp)
                        )
                    }
                },
                colors = ListItemDefaults.colors(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    headlineColor = MaterialTheme.colorScheme.scrim,
                    trailingIconColor = MaterialTheme.colorScheme.scrim
                )
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        Text(stringResource(R.string.ostatni_mecz), fontSize = 20.sp, fontWeight = FontWeight.Bold,modifier = Modifier.padding(5.dp))
        if (match != null)
            lastmatchCard(match)


    }
}

@Composable
fun lastmatchCard(lastmach: MeczEntity){
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiary)
    ) {
        Box(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()) {
            Column {
                Text(
                    text = lastmach.data,
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.bodySmall
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "VS ${lastmach.przeciwnik.uppercase()}",
                        color = MaterialTheme.colorScheme.onPrimary
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Text(
                        text = lastmach.wynik,
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }

            // Kropka zwycięstwa po prawej stronie
            if (lastmach.czyWygrany) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .background(MaterialTheme.colorScheme.secondary, CircleShape)
                        .align(Alignment.CenterEnd)
                        .padding(end = 4.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true )
@Composable
fun Compose_test(){
    val vm: GlownaViewModel = hiltViewModel()
    GlownyScreen(viewModel = vm, onNavigateToNauka = {},
        onNavigateToUStawienia = {})

}