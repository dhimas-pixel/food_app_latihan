import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mbuh.project_food_app.R

@Composable
@Preview
fun MyBottomBar() {
    val bottomMenuItemsList = prepareBottomMenu()
    val context = LocalContext.current
    val selectedItem by remember {
        mutableStateOf("Home")
    }

    BottomAppBar(
        backgroundColor = colorResource(id = R.color.white),
        elevation = 3.dp
    ) {
        bottomMenuItemsList.forEach { bottomMenuItem ->
            BottomNavigationItem(
                selected = (selectedItem==bottomMenuItem.label),
                onClick = { /*TODO*/ },
                icon = {
                    Icon(painter = bottomMenuItem.icon,
                        contentDescription = null,
                        modifier = Modifier.padding(top = 8.dp).size(20.dp)
                    )
                }
            )
        }
    }
}

data class BottomMenuItem(
    val label: String,
    val icon: Painter
)

@Composable
fun prepareBottomMenu(): List<BottomMenuItem> {
    val bottomMenuItemsList = arrayListOf<BottomMenuItem>()
    bottomMenuItemsList.add(
        BottomMenuItem(
            label = "Home",
            icon = painterResource(id = R.drawable.btn_1)
        )
    )
    bottomMenuItemsList.add(
        BottomMenuItem(
            label = "Cart",
            icon = painterResource(id = R.drawable.btn_2)
        )
    )
    bottomMenuItemsList.add(
        BottomMenuItem(
            label = "Favorite",
            icon = painterResource(id = R.drawable.btn_3)
        )
    )
    bottomMenuItemsList.add(
        BottomMenuItem(
            label = "Order",
            icon = painterResource(id = R.drawable.btn_4)
        )
    )
    bottomMenuItemsList.add(
        BottomMenuItem(
            label = "Profile",
            icon = painterResource(id = R.drawable.btn_5)
        )
    )

    return bottomMenuItemsList
}