package com.abdalkareem.project;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class display_car extends Activity {

    private ListView carListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_car);

        carListView = findViewById(R.id.carListView);

        // Implement logic to display car list
    }
}