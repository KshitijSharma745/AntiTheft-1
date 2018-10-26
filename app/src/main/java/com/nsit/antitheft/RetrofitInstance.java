package com.nsit.antitheft;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    public static ApiInterface getRetrofitInstance(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://trafficai.grubx.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ApiInterface.class);
    }

}
