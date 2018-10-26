package com.nsit.antitheft.Calls;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.nsit.antitheft.ApiInterface;
import com.nsit.antitheft.Login;
import com.nsit.antitheft.RetrofitInstance;

import java.io.IOException;

import retrofit2.Call;

public class RegisterCarCall extends AsyncTask<Void, Void, Void> {
    private Context context;
    private ProgressDialog progressDialog;

    public RegisterCarCall(Context context){
        this.context = context;
        progressDialog = new ProgressDialog(context);
    }

    @Override
    protected void onPreExecute() {
        progressDialog.setMessage("Please wait while we register your stolen car details!");
        progressDialog.show();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        ApiInterface apiInterface = RetrofitInstance.getRetrofitInstance();
        Call<JsonObject> addStolenVehicle = apiInterface.addStolenVehicle("sanjayk","+91-7678366446","DL10434","Xy-237859532");
        try {
            JsonObject jsonObject = addStolenVehicle.execute().body();
            System.out.println("addStolenVehicle is : "+jsonObject);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context,"Some error occurred : "+e.getMessage(),Toast.LENGTH_LONG).show();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        progressDialog.dismiss();
        Toast.makeText(context,"Your car has been registered with us, Once we get details about it we will inform you about it via sms!",Toast.LENGTH_LONG).show();
    }
}
