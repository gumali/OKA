package com.abdalkareem.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class admin_login extends AppCompatActivity {

    private EditText ename;
    private EditText epass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_login);
        ename=findViewById(R.id.ed_admin);
        epass=findViewById(R.id.ed_pass);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public boolean validadminname(){
        String val=ename.getText().toString();
    if(val.isEmpty()){
        ename.setError("admin email cannot be empty");
        return false;
    }
    else{
        ename.setError(null);
        return true;
    }


    }
    public boolean validadminpass(){
        String val=epass.getText().toString();
        if(val.isEmpty()){
            epass.setError("admin password cannot be empty");
            return false;
        }
        else{
            epass.setError(null);
            return true;
        }


    }
    public void checkadmin() {
        String adminname = ename.getText().toString().trim();
        String admipassword = epass.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("account");
        Query checkadminnameDatabase = reference.orderByChild("name").equalTo(adminname);

        checkadminnameDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    ename.setError(null);
                    boolean isPasswordCorrect = false;

                    for (DataSnapshot adminSnapshot : snapshot.getChildren()) {
                        String passwordfromDB = adminSnapshot.child("password").getValue(String.class);

                        if (Objects.equals(passwordfromDB, admipassword)) {
                            isPasswordCorrect = true;
                            Intent intent = new Intent(admin_login.this, FirstAdminactivity.class);
                            startActivity(intent);
                            break;
                        }
                    }

                    if (!isPasswordCorrect) {
                        epass.setError("invalid password");
                        epass.requestFocus();
                    }
                } else {
                    ename.setError("admin does not exist");
                    ename.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(admin_login.this, "Database error: " + error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }


    public void log_in(View view) {

        if(!validadminname()||!validadminpass()){

        }else{
            checkadmin();

        }
    }
}