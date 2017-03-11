package com.example.android.touristguide;

import android.app.LauncherActivity;
import android.content.Intent;
import android.graphics.Camera;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.OnMapReadyCallback;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback{

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //setUpMapIfNeeded();
    }
    protected void onPause(){
        super.onPause();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    /*private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }*/

    @Override
    public void onMapReady(GoogleMap googleMap) throws NullPointerException{
        mMap = googleMap;
        int i, j, k;
        j = 0;
        int max = 10;
        Geocoder geocoder = new Geocoder(this);
        List<Address> addressList;
        addressList = null;
        Address address = null;
        String dummy;
        LatLng latLng, ll = null;
        if (getIntent().getStringExtra("activity").toString().compareTo("interest") == 0) {
            mMap.clear();
            int inMax,size;
            size=0;
            inMax = getIntent().getIntExtra("MAX", 10);
            String Selection[] = getIntent().getStringArrayExtra("Locations");
            for (i = 0; i < inMax; i++) {
                try {
                    dummy= Selection[i]+", India";
                    addressList = geocoder.getFromLocationName(dummy, max);
                    size = addressList.size();
                } catch (IOException e) {
                    e.printStackTrace();
                }catch (NullPointerException ne){
                    ne.printStackTrace();
                }
                if (size != 0) {
                    for (j = 0; j < size; j++) {
                        if (addressList.get(j) == null) {
                            break;
                        }
                        address = addressList.get(j);
                        latLng = new LatLng(address.getLatitude(), address.getLongitude());
                        mMap.addMarker(new MarkerOptions().position(latLng).title(Selection[i]));
                    }
                }//else{
                  //  Toast.makeText(this, "No result found!", Toast.LENGTH_LONG).show();
                    //Intent intent = new Intent(this, HomePage.class);
                   // startActivity(intent);
                //}
        }
       } else {
            mMap.clear();
            mMap.setMyLocationEnabled(true);
            Location myLocation;
            myLocation = mMap.getMyLocation();
            double lat, lng;
            lat = 0;
            lng =0;
            try {
                lat = myLocation.getLatitude();
                lng = myLocation.getLongitude();
            }catch (NullPointerException npe){
                npe.printStackTrace();
            }
            List<Address> adL= null;
            String my_Location= null;
            try {
                adL = geocoder.getFromLocation(lat, lng, 1);
                my_Location = adL.get(0).getLocality().toString();
            }catch(IOException ioe){
                ioe.printStackTrace();
            }catch (NullPointerException npe){
                npe.printStackTrace();
            }
            try {
                my_Location = myLocation.toString();
            }catch (NullPointerException npe){
                npe.printStackTrace();
            }
            try {
                addressList = geocoder.getFromLocationName("tourist places, interesting near "+my_Location , 20);
            } catch (IOException e) {
                e.printStackTrace();
            }
            int size=0;
            try {
                size = addressList.size();
            }catch (NullPointerException npe){
                npe.printStackTrace();
            }
            if(size!=0){
            for (i=0;i<size;i++) {
                if (addressList.get(i) == null) {
                    break;
                }
                address = addressList.get(i);
                ll = new LatLng(address.getLatitude(), address.getLongitude());
                mMap.addMarker(new MarkerOptions().position(ll).title("Visit me!"));
            }
            }
            //else {
             //   Toast.makeText(this,"No result found!",Toast.LENGTH_LONG);
               // Intent intent = new Intent(this, HomePage.class);
                //startActivity(intent);
            //s}

        }



        /*
        // Add a marker in Sydney, Australia, and move the camera.
        LatLng sydney = new LatLng(-34, 151);




        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));


        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() throws NullPointerException{
        int i, j, k;
        j = 0;
        int max = 10;
        Geocoder geocoder = new Geocoder(this);
        List<Address> addressList;
        addressList = null;
        Address address = null;
        LatLng latLng[] = new LatLng[max];
        //if (getIntent().getStringExtra("activity").toString().compareTo("interest") == 0) {
            mMap.clear();
            int inMax;
            inMax = getIntent().getIntExtra("MAX", 10);
            String Selection[] = getIntent().getStringArrayExtra("Locations");
            for (i = 0; i < inMax; i++) {
                try {
                    addressList = geocoder.getFromLocationName(Selection[i] + ", India", max);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                for (j = 0; j < max; j++) {
                    if (addressList.get(j) == null) {
                        break;
                    }
                    address = addressList.get(j);
                    latLng[j] = new LatLng(address.getLatitude(), address.getLongitude());
                    mMap.addMarker(new MarkerOptions().position(latLng[j]).title(Selection[j]));
                }
            }
        /*} else {
            mMap.clear();
            String search = getIntent().getStringExtra("search");
            try {
                addressList = geocoder.getFromLocationName(search, 20);
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (i=0;i<20;i++) {
                if (addressList.get(i) == null) {
                    break;
                }
                address = addressList.get(i);
                LatLng ll = new LatLng(address.getLatitude(), address.getLongitude());
                mMap.addMarker(new MarkerOptions().position(ll).title(search));
            }
          //  mMap.moveCamera(CameraUpdateFactory.newLatLng(ll));
        }*/
    }
}
