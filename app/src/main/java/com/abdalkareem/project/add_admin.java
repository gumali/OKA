package com.abdalkareem.project;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class add_admin extends Activity {

    private EditText adminEmailEditText, adminPasswordEditText;
    private Button addAdminButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_admin);

        adminEmailEditText = findViewById(R.id.adminEmailEditText);
        adminPasswordEditText = findViewById(R.id.adminPasswordEditText);
        addAdminButton = findViewById(R.id.addAdminButton);

        addAdminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement add admin logic
            }
        });
    }
}
