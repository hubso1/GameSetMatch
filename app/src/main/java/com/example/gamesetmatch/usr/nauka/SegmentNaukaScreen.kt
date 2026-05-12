package com.example.gamesetmatch.usr.nauka

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.gamesetmatch.R
import androidx.core.net.toUri
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView


@OptIn(ExperimentalMaterial3Api::class)
@androidx.annotation.OptIn(UnstableApi::class)
@Composable
fun SegmentScreen(
    onNavigateBack: () -> Unit,
    viewModel: SegmentViewmodel,
    name: String
){
    val context = LocalContext.current
    val segment = viewModel.segment

    val photos = when (segment){
        SegmetType.Forehand -> viewModel.listforehand
        SegmetType.Backhand -> viewModel.listbackhand
        SegmetType.Serwis -> viewModel.listservis
    }

    val url = when(segment){
        SegmetType.Serwis -> R.raw.serwis
        SegmetType.Backhand -> R.raw.backhand
        SegmetType.Forehand -> R.raw.forehand
    }

    val VideoUrl = remember(url) {
        "android.resource://${context.packageName}/$url".toUri()
    }


    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            setMediaItem(MediaItem.fromUri(VideoUrl))
            prepare()
            playWhenReady = false
        }
    }

    var vid by remember { mutableStateOf(true) }
    BackHandler(enabled = vid) {
        vid = false
        exoPlayer.stop()
        onNavigateBack()
    }

    Column(modifier = Modifier.fillMaxSize()) {
        ListItem(
            colors = ListItemDefaults.colors(Color.Transparent),
            headlineContent = {
                Text(
                    text = name,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            },
            leadingContent = {
                IconButton(onClick = {
                    vid = false
                    exoPlayer.stop()
                    onNavigateBack() }) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back")
                }
            }
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            if (vid) {
                AndroidView(
                    factory = {
                        PlayerView(context).apply {
                            player = exoPlayer
                            useController = true
                            controllerAutoShow = false
                            controllerHideOnTouch = true
                            hideController()
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
            }
            else{
                Spacer(Modifier
                    .fillMaxWidth()
                    .height(200.dp))
            }
            Text(text = stringResource(R.string.obejrzyj_wideo),
                fontSize = 20.sp,
                fontWeight = FontWeight.Black,
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 20.dp))

            when (segment){
                SegmetType.Forehand -> Text(stringResource(R.string.podstawa_uderze),fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,)
                SegmetType.Backhand -> Text(stringResource(R.string.jednor_czny_lub_obur_czny),fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,)
                SegmetType.Serwis -> Text(stringResource(R.string.najwa_niejsze_uderzenie),fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,)
            }

            Text(text = stringResource(R.string.galeria_ruchu),
                fontSize = 20.sp,
                fontWeight = FontWeight.Black,
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 10.dp))



            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(16.dp)
            ) {
                items(photos) { resId ->
                    Card(
                        modifier = Modifier
                            .width(250.dp)
                            .height(350.dp),
                        shape = MaterialTheme.shapes.medium
                    ) {
                        Image(
                            painter = painterResource(id = resId),
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }
    }
}

