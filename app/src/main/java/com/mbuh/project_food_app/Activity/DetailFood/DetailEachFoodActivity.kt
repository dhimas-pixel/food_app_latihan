package com.mbuh.project_food_app.Activity.DetailFood

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mbuh.project_food_app.Domain.FoodModel
import com.mbuh.project_food_app.Helper.previewFood
import com.mbuh.project_food_app.R
import com.uilover.project2142.Helper.ManagmentCart

class DetailEachFoodActivity : AppCompatActivity() {
    private lateinit var item: FoodModel
    private lateinit var managmentCart: ManagmentCart
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        item = intent.getSerializableExtra("object") as FoodModel
        item.numberInCart = 1
        managmentCart = ManagmentCart(this)

        setContent {
            DetailScreen(
                item = item,
                onBackClick = {
                    finish()
                },
                onAddToCartClick = {
                    managmentCart.insertItem(item)
                }
            )
        }

    }
}

@Composable
fun DetailScreen(item: FoodModel, onBackClick: () -> Unit, onAddToCartClick: () -> Unit) {
    var numberInCart by remember {
        mutableIntStateOf(item.numberInCart)
    }

    ConstraintLayout {
        val (footer, column) = createRefs()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.lightGrey))
                .verticalScroll(rememberScrollState())
                .constrainAs(column) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                }
                .padding(bottom = 100.dp)
        ) {
            HeaderSection(
                onBackClick = onBackClick,
                item = item,
            )
        }
    }
}
