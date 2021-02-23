package de.kallifabio.logoquiz;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final static String prefNameFirstStart = "firstAppStart";
    final static String databaseName = "level.db";
    final static String tableName = "level";
    final static String prefLevel = "currentLevel";
    final int maxLevel = 24; // Bei weiteren Leveln erhöhen, so viel wie in Datenbank (id) eingetragen
    Button btnHint, btnSkip, btnCheck;
    ImageView ivLogo;
    EditText etLogoName;
    TextView tvHint;
    LottieAnimationView av_correct;
    int currentLevel;
    String companyName;
    String imageName;

    // <editor-fold defaultstate="collapsed" desc="getPrefNameFirstStart">
    public static String getPrefNameFirstStart() {
        return prefNameFirstStart;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="loadLevel">
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

            int imageID = getResources().getIdentifier(imageName, "drawable", getPackageName());
            ivLogo.setImageResource(imageID);
        }

        ivLogo.setVisibility(View.VISIBLE);
        etLogoName.setVisibility(View.VISIBLE);
        btnSkip.setVisibility(View.VISIBLE);
        btnHint.setVisibility(View.VISIBLE);
        btnCheck.setVisibility(View.VISIBLE);

        av_correct.setVisibility(View.INVISIBLE);

        etLogoName.setText("");
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="safeLevel">
    public void safeLevel() {
        SharedPreferences preferencesLevel = getSharedPreferences(prefLevel, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencesLevel.edit();
        editor.putInt(prefLevel, currentLevel);
        editor.apply();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="animateLevelComplete">
    public void animateLevelComplete() {
        ivLogo.setVisibility(View.INVISIBLE);
        etLogoName.setVisibility(View.INVISIBLE);
        btnSkip.setVisibility(View.INVISIBLE);
        btnHint.setVisibility(View.INVISIBLE);
        btnCheck.setVisibility(View.INVISIBLE);
        tvHint.setVisibility(View.INVISIBLE);

        av_correct.setVisibility(View.VISIBLE);
        av_correct.playAnimation();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadLevel();
            }
        }, 2900);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="firstAppStart">
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
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="getDatabaseName">
    public static String getDatabaseName() {
        return databaseName;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="getTableName">
    public static String getTableName() {
        return tableName;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="getMaxLevel">
    public int getMaxLevel() {
        return maxLevel;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="getPrefLevel">
    public static String getPrefLevel() {
        return prefLevel;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="onCreate">
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        av_correct = findViewById(R.id.av_correct);

        ivLogo = findViewById(R.id.ivLogo);
        etLogoName = findViewById(R.id.etLogoName);
        btnHint = findViewById(R.id.btnHint);
        btnSkip = findViewById(R.id.btnSkip);
        btnCheck = findViewById(R.id.btnCheck);
        tvHint = findViewById(R.id.tvHint);

        btnSkip.setOnClickListener(this);
        btnCheck.setOnClickListener(this);
        btnHint.setOnClickListener(this);

        if (firstAppStart()) {
            createDatabase();
        }

        loadLevel();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="createDatabase">
    // Bei Bedarf ändern, Daten in Datenbank eintragen
    public void createDatabase() {
        SQLiteDatabase database = openOrCreateDatabase(databaseName, MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE " + tableName + " (id INTEGER, company TEXT, imageName TEXT)");
        database.execSQL("INSERT INTO " + tableName + " VALUES('1', 'Nasa', 'nasa')");
        database.execSQL("INSERT INTO " + tableName + " VALUES('2', 'YouTube', 'youtube')");
        database.execSQL("INSERT INTO " + tableName + " VALUES('3', 'Instagram', 'instagram')");
        database.execSQL("INSERT INTO " + tableName + " VALUES('4', 'Ford', 'ford')");
        database.execSQL("INSERT INTO " + tableName + " VALUES('5', 'Audi', 'audi')");
        database.execSQL("INSERT INTO " + tableName + " VALUES('6', 'Apple', 'apple')");
        database.execSQL("INSERT INTO " + tableName + " VALUES('7', 'Elgato', 'elgato')");
        database.execSQL("INSERT INTO " + tableName + " VALUES('8', 'FaceBook', 'facebook')");
        database.execSQL("INSERT INTO " + tableName + " VALUES('9', 'GitHub', 'github')");
        database.execSQL("INSERT INTO " + tableName + " VALUES('10', 'IKEA', 'ikea')");
        database.execSQL("INSERT INTO " + tableName + " VALUES('11', 'Intel', 'intel')");
        database.execSQL("INSERT INTO " + tableName + " VALUES('12', 'Java', 'java')");
        database.execSQL("INSERT INTO " + tableName + " VALUES('13', 'LG', 'lg')");
        database.execSQL("INSERT INTO " + tableName + " VALUES('14', 'Logitech', 'logitech')");
        database.execSQL("INSERT INTO " + tableName + " VALUES('15', 'PlayStation', 'playstation')");
        database.execSQL("INSERT INTO " + tableName + " VALUES('16', 'Razer', 'razer')");
        database.execSQL("INSERT INTO " + tableName + " VALUES('17', 'Roccat', 'roccat')");
        database.execSQL("INSERT INTO " + tableName + " VALUES('18', 'Samsung', 'samsung')");
        database.execSQL("INSERT INTO " + tableName + " VALUES('19', 'Seat', 'seat')");
        database.execSQL("INSERT INTO " + tableName + " VALUES('20', 'Snapchat', 'snapchat')");
        database.execSQL("INSERT INTO " + tableName + " VALUES('21', 'TikTok', 'tiktok')");
        database.execSQL("INSERT INTO " + tableName + " VALUES('22', 'Twitch', 'twitch')");
        database.execSQL("INSERT INTO " + tableName + " VALUES('23', 'Twitter', 'twitter')");
        database.execSQL("INSERT INTO " + tableName + " VALUES('24', 'Xbox', 'xbox')");
        database.close();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="onClick">
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCheck:
                if (etLogoName.getText().toString().equalsIgnoreCase(companyName)) {
                    currentLevel++;
                    safeLevel();
                    animateLevelComplete();
                } else {
                    Toast.makeText(getApplicationContext(), "Leider falsch", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btnHint:
                tvHint.setText("Erster Buchstabe: " + companyName.substring(0, 1));
                tvHint.setVisibility(View.VISIBLE);
                break;
            case R.id.btnSkip:
                currentLevel++;
                safeLevel();
                Toast.makeText(getApplicationContext(), "Lösung: " + companyName, Toast.LENGTH_LONG).show();
                animateLevelComplete();
                break;
        }
    }
    // </editor-fold>

}