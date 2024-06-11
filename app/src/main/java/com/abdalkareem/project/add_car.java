package com.abdalkareem.project;



import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class add_car extends Activity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private EditText carNameEditText, carTypeEditText, carModelEditText, carPriceEditText;
    private ImageView carImageView;
    private Button uploadImageButton, addButton;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        carNameEditText = findViewById(R.id.carName);
        carTypeEditText = findViewById(R.id.carType);
        carModelEditText = findViewById(R.id.carModel);
        carPriceEditText = findViewById(R.id.carPrice);
        carImageView = findViewById(R.id.emptyImageView);
        uploadImageButton = findViewById(R.id.uploadImageButton);
        addButton = findViewById(R.id.addCarButton);

        uploadImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImageChooser();
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCar();
            }
        });
    }

    private void openImageChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imageUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                carImageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void addCar() {
        String carName = carNameEditText.getText().toString().trim();
        String carType = carTypeEditText.getText().toString().trim();
        String carModel = carModelEditText.getText().toString().trim();
        String carPrice = carPriceEditText.getText().toString().trim();

        if (carName.isEmpty() || carType.isEmpty() || carModel.isEmpty() || carPrice.isEmpty() || imageUri == null) {
            Toast.makeText(this, "Please fill in all fields and upload an image", Toast.LENGTH_SHORT).show();
            return;
        }

        // Here you can implement the logic to add the car to the database or server
        // For demonstration, we'll just show a Toast message

        Toast.makeText(this, "Car added successfully", Toast.LENGTH_SHORT).show();

        // Clear inputs
        carNameEditText.setText("");
        carTypeEditText.setText("");
        carModelEditText.setText("");
        carPriceEditText.setText("");
        carImageView.setImageResource(android.R.color.transparent);
    }
}
