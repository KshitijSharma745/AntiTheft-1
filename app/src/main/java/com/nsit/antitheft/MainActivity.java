package com.nsit.antitheft;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private CardView registerOptionCardView;
    private CardView registeredCardView;
    private CardView traceMyVehicleCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerOptionCardView = findViewById(R.id.registerOptionCardView);
        registeredCardView = findViewById(R.id.registeredCardView);
        traceMyVehicleCardView = findViewById(R.id.traceMyVehicleCardView);

        registerOptionCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RegisterAVehicle.class);
                startActivity(intent);
            }
        });

        registeredCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        traceMyVehicleCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,TraceVehicleOnMap.class);
                startActivity(intent);
            }
        });

    }
}
