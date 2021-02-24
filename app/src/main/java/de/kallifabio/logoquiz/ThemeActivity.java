package de.kallifabio.logoquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ThemeActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnThemeAuto, btnThemeSecret1, btnThemeSecret2, btnThemeSecret3, btnThemeSecret4,
            btnThemeSecret5, btnThemeSecret6, btnThemeSecret7, btnThemeSecret8, btnThemeSecret9,
            btnThemeSecret10, btnThemeSecret11, btnThemeSecret12, btnThemeSecret13, btnThemeSecret14,
            btnThemeSecret15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);

        btnThemeAuto = findViewById(R.id.btnThemeAuto);
        btnThemeSecret1 = findViewById(R.id.btnThemeSecret1);
        btnThemeSecret2 = findViewById(R.id.btnThemeSecret2);
        btnThemeSecret3 = findViewById(R.id.btnThemeSecret3);
        btnThemeSecret4 = findViewById(R.id.btnThemeSecret4);
        btnThemeSecret5 = findViewById(R.id.btnThemeSecret5);
        btnThemeSecret6 = findViewById(R.id.btnThemeSecret6);
        btnThemeSecret7 = findViewById(R.id.btnThemeSecret7);
        btnThemeSecret8 = findViewById(R.id.btnThemeSecret8);
        btnThemeSecret9 = findViewById(R.id.btnThemeSecret9);
        btnThemeSecret10 = findViewById(R.id.btnThemeSecret10);
        btnThemeSecret11 = findViewById(R.id.btnThemeSecret11);
        btnThemeSecret12 = findViewById(R.id.btnThemeSecret12);
        btnThemeSecret13 = findViewById(R.id.btnThemeSecret13);
        btnThemeSecret14 = findViewById(R.id.btnThemeSecret14);
        btnThemeSecret15 = findViewById(R.id.btnThemeSecret15);

        btnThemeAuto.setOnClickListener(this);
        btnThemeSecret1.setOnClickListener(this);
        btnThemeSecret2.setOnClickListener(this);
        btnThemeSecret3.setOnClickListener(this);
        btnThemeSecret4.setOnClickListener(this);
        btnThemeSecret5.setOnClickListener(this);
        btnThemeSecret6.setOnClickListener(this);
        btnThemeSecret7.setOnClickListener(this);
        btnThemeSecret8.setOnClickListener(this);
        btnThemeSecret9.setOnClickListener(this);
        btnThemeSecret10.setOnClickListener(this);
        btnThemeSecret11.setOnClickListener(this);
        btnThemeSecret12.setOnClickListener(this);
        btnThemeSecret13.setOnClickListener(this);
        btnThemeSecret14.setOnClickListener(this);
        btnThemeSecret15.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnThemeAuto:
                Intent intent = new Intent(ThemeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.btnThemeSecret1:
            case R.id.btnThemeSecret2:
            case R.id.btnThemeSecret3:
            case R.id.btnThemeSecret4:
            case R.id.btnThemeSecret5:
            case R.id.btnThemeSecret6:
            case R.id.btnThemeSecret7:
            case R.id.btnThemeSecret8:
            case R.id.btnThemeSecret9:
            case R.id.btnThemeSecret10:
            case R.id.btnThemeSecret11:
            case R.id.btnThemeSecret12:
            case R.id.btnThemeSecret13:
            case R.id.btnThemeSecret14:
            case R.id.btnThemeSecret15:
                Toast.makeText(getApplicationContext(), "Nicht verfügbar", Toast.LENGTH_LONG).show();
                break;
        }
    }
}