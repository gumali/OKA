package com.abdalkareem.project;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class update_car extends Activity {

    private EditText carIdEditText, carNameEditText, carTypeEditText, carModelEditText, carPriceEditText;
    private Button updateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_car);

        carIdEditText = findViewById(R.id.carIdEditText);
        carNameEditText = findViewById(R.id.carNameEditText);
        carTypeEditText = findViewById(R.id.carTypeEditText);
        carModelEditText = findViewById(R.id.carModelEditText);
        carPriceEditText = findViewById(R.id.carPriceEditText);
        updateButton = findViewById(R.id.updateButton);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement update car logic
            }
        });
    }
}
