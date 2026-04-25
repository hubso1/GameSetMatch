package com.example.gamesetmatch.usr.nauka

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.room.util.TableInfo
import com.example.gamesetmatch.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppSegment(
    onNavigateBack: () -> Unit,
    nauka: String){
    CenterAlignedTopAppBar(colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent),
        title = {
            Text(
                text = nauka,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        },
        navigationIcon = {

            IconButton(onClick = onNavigateBack) {

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back")

            }
        }


    )
}
@Composable
fun SegmentScreen(
    onNavigateBack: () -> Unit,
    viewModel: SegmentViewmodel
){
    val segment = viewModel.segment

    val photos = when (segment){
        SegmetType.Forehand -> viewModel.listforehand
        SegmetType.Backhand -> viewModel.listbackhand
        SegmetType.Serwis -> viewModel.listservis
    }







    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(300.dp))
        when (segment){
            SegmetType.Forehand -> Text(stringResource(R.string.podstawa_uderze))
            SegmetType.Backhand -> Text(stringResource(R.string.jednor_czny_lub_obur_czny))
            SegmetType.Serwis -> Text(stringResource(R.string.najwa_niejsze_uderzenie))
        }



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


