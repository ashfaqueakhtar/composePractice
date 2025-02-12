package com.example.firstcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(heightDp = 200)
@Composable
fun ItemUsersPreview() {
    //remember te last state of scroll
    //modifier = Modifier.verticalScroll(state = rememberScrollState())
    //Disadvantage it renders everything
    /*Column (modifier = Modifier.verticalScroll(state = rememberScrollState())){
        getCategoryList().map {
            ItemUsers(img = it.img, title = it.title, subTitle = it.subtitle)
        }
    }*/

    //rememberSavable helps in Screen configuration change
    //rememberSavable -> if custom objects saved then it should be parcelable
    //remember helps in composition save only
    //StateHosting

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        content = {
            items(getCategoryList()){
                ItemUsers(img = it.img, title = it.title, subTitle = it.subtitle)
            }
        })
}

@Composable
fun ItemUsers(img: Int, title: String, subTitle: String) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(img),
                contentDescription = "",
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(48.dp)
                    .clip(
                        CircleShape
                    )
            )
            Column {
                Text(title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text(subTitle, fontSize = 14.sp, fontWeight = FontWeight.Light)
            }
        }
    }
}

data class Users(val img: Int, val title: String, val subtitle: String)

fun getCategoryList(): List<Users> {
    val list = mutableListOf<Users>()
    list.add(Users(img = R.drawable.profile2, title = "Shyam Singh", subtitle = "HR"))
    list.add(Users(img = R.drawable.profile2, title = "Priyanka", subtitle = "Manager"))
    list.add(
        Users(
            img = R.drawable.profile2,
            title = "Rohit Sehezpal",
            subtitle = "Software Engineer"
        )
    )
    list.add(
        Users(
            img = R.drawable.profile2,
            title = "Rohan Gupta",
            subtitle = "Software Engineer"
        )
    )
    list.add(
        Users(
            img = R.drawable.profile2,
            title = "Shiv Thakur",
            subtitle = "Senior Software Engineer"
        )
    )
    list.add(
        Users(
            img = R.drawable.profile2,
            title = "Ashfaque Akhtar",
            subtitle = "Senior Software Engineer"
        )
    )
    list.add(Users(img = R.drawable.profile2, title = "Digvijay Singh", subtitle = "Module Lead"))
    list.add(
        Users(
            img = R.drawable.profile2,
            title = "Harsh Rana",
            subtitle = "Assiciate Software Engineer"
        )
    )

    return list;
}