package com.nsit.antitheft;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;

import retrofit2.Call;

public class TraceVehicleOnMap extends AppCompatActivity {

    private static LatLng positionOfVehicle;
    private static String LicensePlate;
    private static String address;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trace_vehicle_on_map);

        new MyTask(this).execute();

    }

    private class MyTask extends AsyncTask<Void, Void, Void>{

        Context context;
        ProgressDialog progressDialog;
        JsonArray jsonArray;

        MyTask(Context context){
            this.context = context;
            progressDialog = new ProgressDialog(context);
            progressDialog.setMessage("Please wait while we get details about the given vehicle");
        }

        @Override
        protected void onPreExecute() {
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            ApiInterface instance = RetrofitInstance.getRetrofitInstance();
            Call<JsonArray> jsonArrayCall = instance.getTrackDetails("HR13JP310");
            try {
                jsonArray = jsonArrayCall.execute().body();
                System.out.println("JsonArray is :\n "+jsonArray);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            progressDialog.dismiss();
            JsonObject jsonObject = jsonArray.get(0).getAsJsonObject();
            Toast.makeText(context,jsonObject.get("address")+"\n"+jsonObject.get("lat")+"\n"+jsonObject.get("lon"),Toast.LENGTH_LONG).show();
            double latitude = jsonObject.get("lat").getAsDouble();
            double longitude = jsonObject.get("lon").getAsDouble();
            positionOfVehicle = new LatLng(latitude, longitude);
            LicensePlate = jsonObject.get("licensePlate").getAsString();
            address = jsonObject.get("address").getAsString();

            new ReadyMap(TraceVehicleOnMap.this);
        }
    }

    public class ReadyMap implements OnMapReadyCallback{

        Context context;
        private GoogleMap mMap;

        ReadyMap(Context context){
            this.context = context;
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        }

        @Override
        public void onMapReady(GoogleMap googleMap) {
            mMap = googleMap;
            mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

            System.out.println("LatLang : "+positionOfVehicle);
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.title("License Plate : "+LicensePlate+"\n"+address);
            mMap.addMarker(new MarkerOptions().position(positionOfVehicle).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(positionOfVehicle));
            CameraUpdate zoom=CameraUpdateFactory.zoomTo(18);
            mMap.animateCamera(zoom);
        }
    }

}