package de.kallifabio.logoquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class StartscreenActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startscreen);

        btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnStart:
                Intent intent = new Intent(StartscreenActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
