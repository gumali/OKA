package com.abdalkareem.project;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class FormActivity extends AppCompatActivity {

    private EditText ssnEditText;
    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText bankAccountEditText;
    private EditText phoneNumberEditText;
    private DatePicker dateRentPicker;
    private DatePicker dateReturnPicker;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        // Initialize views
        ssnEditText = findViewById(R.id.ssn);
        firstNameEditText = findViewById(R.id.first_name);
        lastNameEditText = findViewById(R.id.last_name);
        bankAccountEditText = findViewById(R.id.bank_account_number);
        phoneNumberEditText = findViewById(R.id.phone_number);
        dateRentPicker = findViewById(R.id.date_rent);
        dateReturnPicker = findViewById(R.id.date_return);
        submitButton = findViewById(R.id.submit_button);

        // Set date pickers to current date
        setDateToCurrent(dateRentPicker);
        setDateToCurrent(dateReturnPicker);

        // Set submit button click listener
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });
    }

    private void setDateToCurrent(DatePicker datePicker) {
        Calendar calendar = Calendar.getInstance();
        datePicker.updateDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
    }

    private void submitForm() {
        // Get user input
        String ssn = ssnEditText.getText().toString().trim();
        String firstName = firstNameEditText.getText().toString().trim();
        String lastName = lastNameEditText.getText().toString().trim();
        String bankAccount = bankAccountEditText.getText().toString().trim();
        String phoneNumber = phoneNumberEditText.getText().toString().trim();
        int rentDay = dateRentPicker.getDayOfMonth();
        int rentMonth = dateRentPicker.getMonth();
        int rentYear = dateRentPicker.getYear();
        int returnDay = dateReturnPicker.getDayOfMonth();
        int returnMonth = dateReturnPicker.getMonth();
        int returnYear = dateReturnPicker.getYear();

        // Validate input (basic validation example)
        if (ssn.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || bankAccount.isEmpty() || phoneNumber.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Process the input data (e.g., send to server or save locally)
        // For now, just display the data in a Toast message
        String rentDate = rentDay + "/" + (rentMonth + 1) + "/" + rentYear;
        String returnDate = returnDay + "/" + (returnMonth + 1) + "/" + returnYear;
        String message = "SSN: " + ssn + "\nFirst Name: " + firstName + "\nLast Name: " + lastName +
                "\nBank Account: " + bankAccount + "\nPhone Number: " + phoneNumber +
                "\nRent Date: " + rentDate + "\nReturn Date: " + returnDate;

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

        // Further processing can be done here...
    }
}
