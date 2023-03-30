package com.setjy.automationbusinesstask.ui.screen.store

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.setjy.automationbusinesstask.R
import com.setjy.automationbusinesstask.ui.model.StoreUI
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun YandexMap(storeInfo: StoreUI, onBackToStoreListClicked: () -> Unit) {

    val mapView = rememberMapViewWithLifecycle()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        AndroidView(factory = { mapView }, modifier = Modifier.align(Alignment.Center)) { mapView ->
            CoroutineScope(Dispatchers.Main).launch {
                mapView.map.apply {
                    isZoomGesturesEnabled = true
                    move(
                        CameraPosition(Point(storeInfo.latitude, storeInfo.longitude), 16f, 0f, 0f),
                        Animation(Animation.Type.SMOOTH, 0f), null
                    )
                }
            }
        }
    }
    Button(onClick = onBackToStoreListClicked) {
        Text(text = "Назад к списку", style = MaterialTheme.typography.body2)
    }
}

@Composable
fun rememberMapViewWithLifecycle(): MapView {

    val context = LocalContext.current

    val mapView = remember {
        MapView(context).apply {
            id = R.id.map_view
        }
    }
    val lifecycleObserver = rememberMapLifecycleObserver(mapView, context)

    val lifecycle = LocalLifecycleOwner.current.lifecycle

    DisposableEffect(lifecycle) {
        lifecycle.addObserver(lifecycleObserver)
        onDispose {
            lifecycle.removeObserver(lifecycleObserver)
        }
    }
    return mapView
}

@Composable
fun rememberMapLifecycleObserver(mapView: MapView, context: Context): LifecycleEventObserver =
    remember(mapView) {
        LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_CREATE -> MapKitFactory.initialize(context)
                Lifecycle.Event.ON_START -> MapKitFactory.getInstance().onStart()
                Lifecycle.Event.ON_RESUME -> {}
                Lifecycle.Event.ON_PAUSE -> {}
                Lifecycle.Event.ON_STOP -> MapKitFactory.getInstance().onStop()
                Lifecycle.Event.ON_DESTROY -> {}
                else -> throw IllegalStateException()
            }
        }
    }