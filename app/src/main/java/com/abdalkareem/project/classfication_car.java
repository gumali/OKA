package com.abdalkareem.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ListView;

public class classfication_car  extends AppCompatActivity {

    private ListView carTypeListView;
    private String[] carTypes = {"Economic", "Sport", "Luxury", "SUV", "MiniVan", "Convertible","Pick Up","Electric"};
    private int[] carImages = {
            R.drawable.economic, // Replace with your actual image resources
            R.drawable.sport,
            R.drawable.luxury,
            R.drawable.suv,
            R.drawable.minivan,
            R.drawable.convertible,
            R.drawable.pickup,
            R.drawable.electric
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classfication_car);

        //carTypeListView = findViewById(R.id.aa);
         carTypeListView=findViewById(R.id.s);
        ListViewAdapter adapter = new ListViewAdapter(this, carTypes, carImages);

        carTypeListView.setAdapter(adapter);

        carTypeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(classfication_car.this, BrandActivity.class);
                startActivity(intent);
            }
        });
    }
}
