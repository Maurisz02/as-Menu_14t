package com.example.menu_14t;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button buttonSubmit;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //1. elmentjuk
                adatMentes();

            }
        });
    }

    private void adatMentes() {
        SharedPreferences sp = getSharedPreferences("Data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        String seged= editText.getText().toString();
        if(seged.equals(null)){
            editText.setError("Muszáj kitölteni");
        }else{
            editor.putString("editTextErteke",seged);
            //editor.commit();//return bool
            editor.apply();

            //2. atmegyunk masik activity be
            Intent intent = new Intent(MainActivity.this,MasodikActivity2.class);
            startActivity(intent);
            //backStack
            finish();
        }

    }

    private void init(){
        buttonSubmit = findViewById(R.id.buttonSubmit);
        editText = findViewById(R.id.editTextInput);
    }
}