package com.motiky.appnavigation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.motiky.appnavigation.R
import com.motiky.appnavigation.data.OrderUiState
import com.motiky.appnavigation.ui.components.FormattedPriceLable
import com.motiky.appnavigation.ui.theme.AppNavigationTheme

@Composable
fun OrderSummaryScreen(
    orderUiState: OrderUiState,
    onCancelButtonClicked: () -> Unit = {},
    onSendButtonClicked: (String, String) -> Unit,
    modifier: Modifier = Modifier
) {

    val resources = LocalContext.current.resources

    val numberOfCupcakes = resources.getQuantityString(
        R.plurals.cupcakes,
        orderUiState.quantity,
        orderUiState.quantity
    )

    val orderSummary = stringResource(
        R.string.order_details,
        numberOfCupcakes,
        orderUiState.flavor,
        orderUiState.date,
        orderUiState.quantity
    )

    val newOrder = stringResource(id = R.string.new_cupcake_order)

    val items = listOf(
        Pair(stringResource(id = R.string.quantity), numberOfCupcakes),
        Pair(stringResource(id = R.string.flavor), orderUiState.flavor),
        Pair(stringResource(id = R.string.pickup_date), orderUiState.date),
    )

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
        ) {
            items.forEach { item->
                Text(
                    text = item.first.uppercase()
                )
                Text(
                    text = item.second,
                    fontWeight = FontWeight.Bold
                )
                Divider(thickness = dimensionResource(id = R.dimen.thickness_divider))
            }
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
            FormattedPriceLable(
                subtotal = orderUiState.price,
                modifier = Modifier.align(Alignment.End)
            )
        }

        Row(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))
        ){
            Column(
                verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        onSendButtonClicked(
                            newOrder,
                            orderSummary
                        )
                    }
                ) {
                    Text(
                        text = stringResource(id = R.string.send)
                    )
                }
                OutlinedButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onCancelButtonClicked
                ) {
                    Text(
                        text = stringResource(id = R.string.cancel)
                    )
                }
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun OrderSummaryScreenPreview() {
    AppNavigationTheme {
        OrderSummaryScreen(
            orderUiState = OrderUiState(0, "Test", "Test", "$300.00"),
            onCancelButtonClicked = {},
            onSendButtonClicked = { subject: String, summary: String -> },
            modifier = Modifier
                .fillMaxHeight()
        )
    }
}


