package ivan.bermejo.presentation.ui

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate

@Composable
fun ExpandableCardIcon(
    expanded: Boolean,
    onIconClick: () -> Unit,
    modifier: Modifier
) {
    IconButton(onClick = onIconClick, modifier = modifier) {
        Icon(
            Icons.Filled.KeyboardArrowDown,
            "Icono para expandir tarjeta",
            Modifier.rotate(
                if (expanded)
                    180f
                else
                    360f
            )
        )
    }
}