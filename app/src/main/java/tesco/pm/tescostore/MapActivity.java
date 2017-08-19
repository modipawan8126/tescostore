package tesco.pm.tescostore;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import tesco.pm.tescostore.constant.Constants;

/**
 * Created by pmodi4 on 7/31/2017.
 */

public class MapActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_ACCESS = 1;

    GoogleMap googleMap;
    MapFragment mapFragment;

    double latitude;
    double longitude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Bundle bundle = getIntent().getExtras();
        latitude = (double) bundle.get(Constants.LATITUDE);
        longitude = (double) bundle.get(Constants.LONGITUDE);
        Log.d(this.getClass().getSimpleName(), latitude + "   " + longitude);

        mapFragment = ((MapFragment) getFragmentManager().findFragmentById(R.id.map));
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                myMapReady(googleMap);
            }
        });

    }

    //@Override
    public void myMapReady(GoogleMap gMap) {
        googleMap = gMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        try {
            googleMap.setMyLocationEnabled(true);
        } catch (SecurityException se) {

        }

        //Edit the following as per you needs
        googleMap.setTrafficEnabled(true);
        googleMap.setIndoorEnabled(true);
        googleMap.setBuildingsEnabled(true);
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        //

        //LatLng placeLocation = new LatLng(13.0225863, 77.6580978); //Make them global
        LatLng placeLocation = new LatLng(latitude, longitude); //Make them global
        MarkerOptions options = new MarkerOptions();
        options.position(placeLocation);
        options.title("Tesco");
        Marker placeMarker = googleMap.addMarker(options);
        showAddressOnMarker(placeMarker);
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(17.0f), 1000, null);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(placeLocation, 17.0f));
    }


    public boolean showAddressOnMarker(Marker marker) {
        Log.d(this.getClass().getSimpleName(), "Preparing Address for Marker");
        Geocoder geocoder = new Geocoder(MapActivity.this, Locale.getDefault());
        List<Address> addresses = null; // Here 1 represent max location result to returned, by documents it recommended 1 to 5
        try {
            addresses = geocoder.getFromLocation(latitude, longitude, 1);
            String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i <= addresses.get(0).getMaxAddressLineIndex(); i++) {
                Log.d(this.getClass().getSimpleName(), addresses.get(0).getAddressLine(i));
                sb.append(addresses.get(0).getAddressLine(i)).append(" ");
                if (i == 1) {
                    break;
                }
            }
            String city = addresses.get(0).getLocality();
            sb.append(city);
            Log.d(this.getClass().getSimpleName(), "Address - " + sb.toString());
            //marker.setTitle(address + " " + city);
            marker.setTitle(sb.toString());
            marker.showInfoWindow();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return true;
    }



    /*private void checkRequiredPermissions() {

        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(MapActivity.this,
                Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(MapActivity.this,
                    Manifest.permission.READ_PHONE_STATE)) {


            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(MapActivity.this,
                        new String[]{Manifest.permission.READ_PHONE_STATE, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},
                        MapActivity.MY_PERMISSIONS_REQUEST_ACCESS);

            }
        } else {

        }

    }*/

   /* @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_ACCESS: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {


                } else {

                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }*/
}
