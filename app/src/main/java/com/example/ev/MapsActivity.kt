package com.example.ev

import android.app.Application
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global.getString
import android.util.Log
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.ev.databinding.ActivityMapsBinding
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.Marker
import java.util.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private var homeLatLng : LatLng? = null
    private val TAG = MapsActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setMapStyle(map)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        val latitude = 13.033103890162304
        val longitude = 80.2445541
        val zoomLevel = 15f

        homeLatLng = LatLng(latitude, longitude)
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(homeLatLng, zoomLevel))
        map.addMarker(MarkerOptions().position(homeLatLng))
        setMapLongClick(map)
        setPoiClick(map)

       /* // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        val chennai = LatLng(13.1, 80.0)
        val synd : Marker = map.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        val chen : Marker = map.addMarker(MarkerOptions().position(chennai).title("Marker in Chennai"))
        val zoomLevel = 10f*/

     /*   map.setOnMarkerClickListener {
            if (it == synd) {
                map.moveCamera(CameraUpdateFactory.newLatLng(sydney))
                Log.d("Chen","Synd")

            }
            else if(it == chen){
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(chennai, zoomLevel))
            map.moveCamera(CameraUpdateFactory.newLatLng(chennai))

                Toast.makeText(this@MapsActivity,"chennai city gangster",Toast.LENGTH_SHORT)
                Log.d("Chen","Chennai")
                }
            return@setOnMarkerClickListener true
        }*/
    }

}
private fun setMapLongClick(map: GoogleMap) {
    map.setOnMapLongClickListener { latLng ->
        // A Snippet is Additional text that's displayed below the title.
        val snippet = String.format(
            Locale.getDefault(),
            "Lat: %1$.5f, Long: %2$.5f",
            latLng.latitude,
            latLng.longitude
        )
        map.addMarker(
            MarkerOptions()
                .position(latLng)
                .title((R.string.homeLat.toString()))
                .snippet(snippet)

        )
    }
}
private fun setPoiClick(map: GoogleMap) {
    map.setOnPoiClickListener { poi ->
        val poiMarker = map.addMarker(
            MarkerOptions()
                .position(poi.latLng)
                .title(poi.name)
        )
        poiMarker.showInfoWindow()
    }
}
private fun setMapStyle(map: GoogleMap) {
    try {
        // Customize the styling of the base map using a JSON object defined
        // in a raw resource file.
        val success = map.setMapStyle(
            MapStyleOptions.loadRawResourceStyle(
                getResources().openRawResource(R.id.map),
                R.raw.map_style
            )
        )

        if (!success) {
            Log.e("yo", "Style parsing failed.")
        }
    } catch (e: Resources.NotFoundException) {
        Log.e("yo", "Can't find style. Error: ", e)
    }
}