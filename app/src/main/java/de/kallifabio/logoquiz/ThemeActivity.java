package de.kallifabio.logoquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ThemeActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnThemeAuto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);

        btnThemeAuto = findViewById(R.id.btnThemeAuto);
        btnThemeAuto.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnThemeAuto:
                Intent intent = new Intent(ThemeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}