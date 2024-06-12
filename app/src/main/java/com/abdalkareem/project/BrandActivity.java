package com.abdalkareem.project;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BrandActivity extends AppCompatActivity {
    private List<Brand> items = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerAdapt;
    private static final String Base_URL = "http://192.168.56.1/rest/get_item.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_brand);

        recyclerView=findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        loadItems();
    }
    private void loadItems(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Base_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject object = array.getJSONObject(i);
                        int id = object.getInt("ID");
                        String image = object.getString("image");
                        int clas = object.getInt("classification_ID");
                        Brand brand = new Brand(id, image, clas);
                        items.add(brand);
                    }
                } catch (Exception e) {
                    e.printStackTrace(); // Added for debugging
                }
                recyclerAdapt = new BrandAdapter(BrandActivity.this, items);
                recyclerView.setAdapter(recyclerAdapt);
            }
        } ,new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(BrandActivity.this, error.toString(), Toast.LENGTH_LONG).show();
            }
        });
        Volley.newRequestQueue(BrandActivity.this).add(stringRequest);
    }
}