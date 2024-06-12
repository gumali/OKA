package com.abdalkareem.project;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class FirstAdminactivity extends Activity {

    private ImageButton addCarButton, removeCarButton, updateCarButton, displayCarButton, addAdminButton, logoutButton, rentedCarsButton, viewAsCustomerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_adminactivity);

        addCarButton = findViewById(R.id.addCarButton);
        removeCarButton = findViewById(R.id.removeCarButton);
        updateCarButton = findViewById(R.id.updateCarButton);
        displayCarButton = findViewById(R.id.displayCarButton);
        addAdminButton = findViewById(R.id.addAdminButton);
        logoutButton = findViewById(R.id.logoutButton);
        rentedCarsButton = findViewById(R.id.rentedCarsButton);
        viewAsCustomerButton = findViewById(R.id.viewAsCustomerButton);

        addCarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstAdminactivity.this, add_car.class));
            }
        });

        removeCarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstAdminactivity.this, remove_car.class));
            }
        });

        updateCarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstAdminactivity.this, update_car.class));
            }
        });

        displayCarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstAdminactivity.this, display_car.class));
            }
        });

        addAdminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstAdminactivity.this, add_admin.class));
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        rentedCarsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstAdminactivity.this, rented_cars.class));
            }
        });

        viewAsCustomerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstAdminactivity.this, classfication_car.class));
            }
        });
    }


}
