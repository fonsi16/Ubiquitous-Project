package com.example.project_ubi.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.project_ubi.R;

public class MainActivity extends AppCompatActivity {

    Button btn_sign_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_sign_up=findViewById(R.id.btn_sign_up);

        btn_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                try {
                startActivity(intent);
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this,"Error to sign up",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}