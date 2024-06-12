package com.abdalkareem.project;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

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
        String adminemail=adminEmailEditText.getText().toString();
                String admpass=adminPasswordEditText.getText().toString();
            if(adminemail.isEmpty()){
                adminEmailEditText.setError("cannot be empty");
            return;
            }
                if(admpass.isEmpty()){
                    adminPasswordEditText.setError("cannot be empty");
                return;
                }
                addtodb(adminemail,admpass);



            }

            private void addtodb(String adminemail, String admpass) {
                HashMap<String,Object> datahashmap=new HashMap<>();
                datahashmap.put("name",adminemail);
                datahashmap.put("password",admpass);

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference nameref = database.getReference("account");

        // String key=  "admin";
                //datahashmap.put("admin",key);
                nameref.child("new admin").setValue(datahashmap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(add_admin.this, "addedd", Toast.LENGTH_SHORT).show();
                    adminEmailEditText.getText().clear();
                    adminPasswordEditText.getText().clear();

                    }
                });


            }
        });
    }
}
