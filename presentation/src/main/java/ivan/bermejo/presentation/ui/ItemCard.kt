package ivan.bermejo.presentation.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ivan.bermejo.domain.model.ViewData

@Composable
fun ItemCard(
    viewData: ViewData,
    onClick: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    Card(modifier = Modifier.clickable(onClick = onClick)) {
        Column(modifier = Modifier.animateContentSize()) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                if (viewData.favorite) {
                    Box {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = viewData.name,
                            modifier = Modifier.padding(horizontal = 16.dp),
                            tint = Color.Red
                        )
                    }
                }
                Box {
                    Text(text =  viewData.name, style = MaterialTheme.typography.h6)
                }
                Box(
                    Modifier
                        .fillMaxWidth()
                ){
                    ExpandableCardIcon(
                        expanded = expanded,
                        onIconClick = { expanded = !expanded },
                        modifier = Modifier.align(Alignment.CenterEnd)
                    )
                }
            }
            Divider(thickness = Dp.Hairline, modifier = Modifier.padding(horizontal = 16.dp))

            AsyncImage(
                model = viewData.image,
                contentDescription = viewData.name,
                modifier = Modifier
                    .height(if (expanded) 300.dp else 0.dp)
                    .padding(16.dp)
            )
        }
    }

}