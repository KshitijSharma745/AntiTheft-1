package com.nsit.antitheft;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.nsit.antitheft.Calls.RegisterCarCall;

import java.util.ArrayList;

public class RegisterAVehicle extends AppCompatActivity {
    Spinner spinner1;
    Spinner spinner2;

    ArrayList<String> type;
    ArrayList<String> color;

    private Button submitButton;
    private ArrayAdapter<String> adapter1;
    private ArrayAdapter<String> adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_avehicle);

        spinner1 = findViewById(R.id.type_spinner);
        spinner2 = findViewById(R.id.color_spinner);
        submitButton = findViewById(R.id.submitButton);

        type = new ArrayList<>();
        color = new ArrayList<>();

        type.add("Select type of vehicle");
        type.add("Car");
        type.add("Bike");
        type.add("Truck");
        type.add("Bus");

        color.add("Red");
        color.add("Blue");
        color.add("Yellow");
        color.add("Green");
        color.add("White");
        color.add("Black");
        color.add("Silver");

        adapter1 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,type);
        adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner1.setAdapter(adapter1);

        adapter2 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,color);
        adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner2.setAdapter(adapter2);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegisterCarCall registerCarCall= new RegisterCarCall(RegisterAVehicle.this);
                registerCarCall.execute();
            }
        });

    }
}
