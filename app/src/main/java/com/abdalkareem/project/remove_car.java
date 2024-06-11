package com.abdalkareem.project;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class remove_car extends Activity {

    private EditText carIdEditText;
    private Button removeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_car);

        carIdEditText = findViewById(R.id.carId);
        removeButton = findViewById(R.id.removeCarButton);

        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement remove car logic
            }
        });
    }
}
