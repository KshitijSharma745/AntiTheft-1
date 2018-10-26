package com.nsit.antitheft;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nsit.antitheft.Adapters.RegisteredVehiclesRecyclerViewAdapter;

public class MyRegisteredVehicles extends AppCompatActivity {

    private RecyclerView reyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_registered_vehicles);

        reyclerView = findViewById(R.id.reyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RegisteredVehiclesRecyclerViewAdapter adapter = new RegisteredVehiclesRecyclerViewAdapter(10);

        reyclerView.setLayoutManager(layoutManager);
        reyclerView.setAdapter(adapter);

    }
}
