package com.example.bingoapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bingoapp.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
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
        mMap = googleMap

        val latitude: Double = intent.getDoubleExtra("latitude",-34.0)
        val longitude: Double = intent.getDoubleExtra("longitude",151.0)
        val address: String? = intent.getStringExtra("address");

        // Add a marker in Sydney and move the camera
        val bingo = LatLng(latitude, longitude)
        mMap.addMarker(MarkerOptions().position(bingo).title(address))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bingo))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bingo, 17f))

    }
}
