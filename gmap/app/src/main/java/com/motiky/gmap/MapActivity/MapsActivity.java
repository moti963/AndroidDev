package com.motiky.gmap.MapActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.motiky.gmap.R;
import com.motiky.gmap.databinding.ActivityMapsBinding;

import java.io.IOException;
import java.util.ArrayList;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback{

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        if (supportMapFragment != null) {
            supportMapFragment.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        LatLng latLng = new LatLng(26.2389, 73.0243);
        MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("Jodhpur");
        mMap.addMarker(markerOptions);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16f));
        // Overlay Circle
        /*mMap.addCircle(new CircleOptions()
                .center(latLng)
                .radius(1000)
                .fillColor(Color.GREEN)
                .strokeColor(Color.RED));*/

        // Overlay Polygon
/*        mMap.addPolygon(new PolygonOptions()
                .add(
                        new LatLng(26.2389,73.0243),
                        new LatLng(26.2389,74.0243),
                        new LatLng(27.2389,74.0243),
                        new LatLng(27.2389,73.0243),
                        new LatLng(26.2389,73.0243)
                )
                .fillColor(Color.YELLOW)
                .strokeColor(Color.BLUE)
        );*/
        // Add overlay image
      /*  mMap.addGroundOverlay(new GroundOverlayOptions()
                .position(latLng, 1000f, 1000f)
                .image(BitmapDescriptorFactory.fromResource(R.drawable.myprofile))
                .clickable(true)
        );*/

        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(@NonNull LatLng latLng) {
                mMap.addMarker(new MarkerOptions().position(latLng).title("Curr Location"));
                Toast.makeText(MapsActivity.this, "Latitude : " +  latLng.latitude + " Longitude : " + latLng.longitude, Toast.LENGTH_SHORT).show();
                pinPointTheLatLong(latLng);
            }
        });
    }

    public void pinPointTheLatLong(LatLng latLng) {
        Geocoder geocoder = new Geocoder(this);
        try {
            ArrayList<Address> addressArrayList = (ArrayList<Address>) geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
            Log.d("Address", addressArrayList.get(0).getAddressLine(0));
            Toast.makeText(this, addressArrayList.get(0).getAddressLine(0), Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            //throw new RuntimeException(e);
            //Log.d("Error", e.getMessage());
            e.printStackTrace();
        }
    }
}