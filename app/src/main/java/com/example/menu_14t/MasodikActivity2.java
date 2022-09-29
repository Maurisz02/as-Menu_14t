package com.example.menu_14t;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MasodikActivity2 extends AppCompatActivity {

    private TextView textViewResult;
    private Button buttonResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masodik2);
        init();

        String seged = getSharedPreferenceData();
        textViewResult.setText(seged);

        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //felugro ablak
                Toast.makeText(MasodikActivity2.this, "Viszlát!", Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(MasodikActivity2.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private String getSharedPreferenceData() {
        SharedPreferences sp = getSharedPreferences("Data", Context.MODE_PRIVATE);
        String result = sp.getString("editTextErteke","Nincs ilyen érték");
        return result;
    }

    private void init(){
        textViewResult = findViewById(R.id.textViewResult);
        buttonResult = findViewById(R.id.buttonBack);
    }
}