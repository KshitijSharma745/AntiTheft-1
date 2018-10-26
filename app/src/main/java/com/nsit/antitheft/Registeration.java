package com.nsit.antitheft;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Registeration extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText nameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText dobEditText;
    private EditText phoneNumberEditText;
    private CardView drivingLicenseCardView;
    private TextView drivingLicenseStatusTextView;
    private ImageView drivingLicenseImageView;
    private CardView adhaarCardView;
    private TextView adhaarCardStatusTextView;
    private ImageView adhaarCardImageView;
    private EditText houseNoEditText;
    private EditText localityEditText;
    private EditText cityEditText;
    private EditText stateEditText;
    private EditText pincodeEditText;
    private Button registerButton;
    private TextView loginTextView;
    private String licenseCardURL = null;
    private String adhaarCardURL = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);

        usernameEditText = findViewById(R.id.usernameEditText);
        nameEditText = findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        dobEditText = findViewById(R.id.dobEditText);
        phoneNumberEditText = findViewById(R.id.phoneNumberEditText);
        drivingLicenseCardView = findViewById(R.id.drivingLicenseCardView);
        drivingLicenseStatusTextView = findViewById(R.id.drivingLicenseStatusTextView);
        drivingLicenseImageView = findViewById(R.id.drivingLicenseImageView);
        adhaarCardView = findViewById(R.id.adhaarCardView);
        adhaarCardStatusTextView = findViewById(R.id.adhaarCardStatusTextView);
        adhaarCardImageView = findViewById(R.id.adhaarCardImageView);
        houseNoEditText = findViewById(R.id.houseNoEditText);
        localityEditText = findViewById(R.id.localityEditText);
        cityEditText = findViewById(R.id.cityEditText);
        stateEditText = findViewById(R.id.stateEditText);
        pincodeEditText = findViewById(R.id.pincodeEditText);
        registerButton = findViewById(R.id.registerButton);
        loginTextView = findViewById(R.id.loginTextView);



        drivingLicenseCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String fullName = nameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String dob = dobEditText.getText().toString();
                String phoneNumber = phoneNumberEditText.getText().toString();
                String houseNo = houseNoEditText.getText().toString();
                String locality = localityEditText.getText().toString();
                String city = cityEditText.getText().toString();
                String state = stateEditText.getText().toString();
                String pinCode = pincodeEditText.getText().toString();
                String completeAddress = houseNo + ", " + locality + ", " + city + ", " + state + ", " + pinCode;

                if (adhaarCardURL !=null && licenseCardURL !=null){
                    // Send post request to server for user registeration
                }
                else{
                    Toast.makeText(Registeration.this,"Adhaar or License missing!",Toast.LENGTH_LONG).show();
                }

//                drivingLicenseStatusTextView  drivingLicenseImageView
            }
        });

        adhaarCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                adhaarCardStatusTextView  adhaarCardImageView
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        loginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Registeration.this, Login.class);
                startActivity(intent);
            }
        });

    }
}
