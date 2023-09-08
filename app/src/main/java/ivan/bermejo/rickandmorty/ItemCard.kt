package ivan.bermejo.rickandmorty

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ivan.bermejo.core.data.model.Character

@Composable
fun ItemCard(
    character: Character
) {
    var expanded by remember { mutableStateOf(false) }
    Card {
        Column(modifier = Modifier.animateContentSize()) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column {
                    Text(text = character.name, style = MaterialTheme.typography.h6)
                    Text(
                        text = "${character.species} , ${character.gender}, ${character.origin.name}, ${character.location.name}",
                        style = MaterialTheme.typography.body1
                    )
                }

                ExpandableCardIcon(
                    expanded = expanded,
                    onIconClick = { expanded = !expanded },
                    modifier = Modifier.align(
                        Alignment.CenterEnd
                    )
                )
            }

            if (expanded)
                Divider(thickness = Dp.Hairline, modifier = Modifier.padding(horizontal = 16.dp))

            AsyncImage(
                model = character.image,
                contentDescription = character.name,
                modifier = Modifier
                    .height(if (expanded) 300.dp else 0.dp)
                    .padding(16.dp)
            )
        }
    }

}