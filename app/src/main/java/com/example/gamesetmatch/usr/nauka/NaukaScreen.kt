package com.example.gamesetmatch.usr.nauka

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowCircleRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.gamesetmatch.R
import com.example.gamesetmatch.usr.nav.NavItem

//Ui dla ekranu Nauka
@Composable
fun NaukaScreen(
    viewModel: NaukaViewModel = viewModel(),
    onNavigatetoForehand: () -> Unit,
    onNavigatetoBackhand: () -> Unit,
    onNavigatetoSerwis: () -> Unit

) {

    val modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)


    ){

        ListItem(
            headlineContent = {
                Text(
                    text = stringResource(R.string.nauka_techniki),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            },

            colors = ListItemDefaults.colors(
                containerColor = Color.Transparent,
                headlineColor = MaterialTheme.colorScheme.scrim,
            )
        )

        Card(modifier = modifier,
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.tertiary)
            ) {
            Spacer(modifier = Modifier.height(80.dp))
            ListItem(
                headlineContent = {
                    Text(
                        text = stringResource(R.string.forehand),
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                trailingContent = {
                    IconButton(
                        onClick = onNavigatetoForehand,
                        Modifier.size(45.dp)
                    ) {
                        Icon(
                            Icons.Outlined.ArrowCircleRight,
                            contentDescription = null,
                            Modifier.size(45.dp)
                        )
                    }
                },

                colors = ListItemDefaults.colors(
                    containerColor = Color.Transparent,
                    headlineColor = MaterialTheme.colorScheme.onPrimary,
                    trailingIconColor = MaterialTheme.colorScheme.secondary
                )
            )
        }

        Card(modifier = modifier,
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.tertiary)
        ) {
            Spacer(modifier = Modifier.height(80.dp))
            ListItem(
                headlineContent = {
                    Text(
                        text = stringResource(R.string.backhand),
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                trailingContent = {
                    IconButton(
                        onClick = onNavigatetoBackhand,
                        Modifier.size(45.dp)
                    ) {
                        Icon(
                            Icons.Outlined.ArrowCircleRight,
                            contentDescription = null,
                            Modifier.size(45.dp)
                        )
                    }
                },

                colors = ListItemDefaults.colors(
                    containerColor = Color.Transparent,
                    headlineColor = MaterialTheme.colorScheme.onPrimary,
                    trailingIconColor = MaterialTheme.colorScheme.secondary
                )
            )
        }

        Card(modifier = modifier,
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.tertiary)
        ) {
            Spacer(modifier = Modifier.height(80.dp))
            ListItem(
                headlineContent = {
                    Text(
                        text = stringResource(R.string.serwis),
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                trailingContent = {
                    IconButton(
                        onClick = onNavigatetoSerwis,
                        Modifier.size(45.dp)
                    ) {
                        Icon(
                            Icons.Outlined.ArrowCircleRight,
                            contentDescription = null,
                            Modifier.size(45.dp)
                        )
                    }
                },

                colors = ListItemDefaults.colors(
                    containerColor = Color.Transparent,
                    headlineColor = MaterialTheme.colorScheme.onPrimary,
                    trailingIconColor = MaterialTheme.colorScheme.secondary
                )
            )
        }


    }
}

@Preview(showBackground = true )
@Composable
fun Compose_test(){
    val navController = rememberNavController()
    NaukaScreen(onNavigatetoForehand = {},
    onNavigatetoBackhand = {},
    onNavigatetoSerwis = {})
}

