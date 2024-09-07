package com.example.assignment_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    ImageView ivSky;
    TextView tvWelcome;
    boolean isSky1 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextText);
        ivSky = findViewById(R.id.imageView3);
        tvWelcome = findViewById(R.id.textViewWelcome);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void start(View view) {
        if (isSky1) {
            ivSky.setImageResource(R.drawable.sky2);
        } else {
            ivSky.setImageResource(R.drawable.sky1);
        }
        isSky1 = !isSky1;
    }


    public void showWelcome(View view) {
        String name = etName.getText().toString().trim();
        if (!name.isEmpty()) {
            tvWelcome.setText("Welcome " + name);
            tvWelcome.setVisibility(View.VISIBLE);
        } else {
            etName.setError("Please enter your name");
        }
    }
}