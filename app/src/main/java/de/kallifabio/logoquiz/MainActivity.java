package de.kallifabio.logoquiz;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final static String prefNameFirstStart = "firstAppStart";
    final static String databaseName = "level.db";
    final static String tableName = "level";
    final static String prefLevel = "currentLevel";
    final int maxLevel = 4;
    Button btnHint, btnSkip, btnCheck;
    ImageView ivLogo;
    EditText etLogoName;
    TextView tvHint;
    int currentLevel;
    String companyName;
    String imageName;

    public static String getPrefNameFirstStart() {
        return prefNameFirstStart;
    }

    public static String getDatabaseName() {
        return databaseName;
    }

    public static String getTableName() {
        return tableName;
    }

    public static String getPrefLevel() {
        return prefLevel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivLogo = findViewById(R.id.ivLogo);
        etLogoName = findViewById(R.id.etLogoName);
        btnHint = findViewById(R.id.btnHint);
        btnSkip = findViewById(R.id.btnSkip);
        btnCheck = findViewById(R.id.btnCheck);
        tvHint = findViewById(R.id.tvHint);

        btnSkip.setOnClickListener(this);
        btnCheck.setOnClickListener(this);
        btnHint.setOnClickListener(this);
    }

    public void loadLevel() {
        SharedPreferences preferencesLoad = getSharedPreferences(prefLevel, MODE_PRIVATE);
        currentLevel = preferencesLoad.getInt(prefLevel, 1);

        if (currentLevel <= maxLevel) {
            SQLiteDatabase database = openOrCreateDatabase(databaseName, MODE_PRIVATE, null);
            Cursor cursor = database.rawQuery("SELECT * FROM " + tableName + " WHERE id = '" + currentLevel + "'", null);
            cursor.moveToFirst();
            if (cursor.getCount() == 1) {
                companyName = cursor.getString(1);
                imageName = cursor.getString(2);
                cursor.close();
                database.close();
            }
        }
    }

    public void safeLevel() {
        SharedPreferences preferencesLevel = getSharedPreferences(prefLevel, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencesLevel.edit();
        editor.putInt(prefLevel, currentLevel);
        editor.apply();
    }

    public void animateLevelComplete() {

    }

    public boolean firstAppStart() {
        SharedPreferences preferences = getSharedPreferences(prefNameFirstStart, MODE_PRIVATE);
        if (preferences.getBoolean(prefNameFirstStart, true)) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean(prefNameFirstStart, false);
            editor.apply();
            return true;
        } else {
            return false;
        }
    }

    public void createDatabase() {
        SQLiteDatabase database = openOrCreateDatabase(databaseName, MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE " + tableName + " (id INTEGER, company TEXT, imageName TEXT)");
        database.execSQL("INSERT INTO " + tableName + " VALUES('1', 'Nasa', 'nasa')");
        database.execSQL("INSERT INTO " + tableName + " VALUES('2', 'YouTube', 'youtube')");
        database.execSQL("INSERT INTO " + tableName + " VALUES('3', 'Instagram', 'instagram')");
        database.execSQL("INSERT INTO " + tableName + " VALUES('4', 'Ford', 'ford')");
        database.close();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCheck:
                break;
            case R.id.btnHint:
                break;
            case R.id.btnSkip:
                break;
        }
    }

    public int getMaxLevel() {
        return maxLevel;
    }
}