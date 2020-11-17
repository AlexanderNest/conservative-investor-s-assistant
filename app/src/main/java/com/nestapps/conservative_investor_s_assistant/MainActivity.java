package com.nestapps.conservative_investor_s_assistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        startSettings();
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void startSettings(){
        getSupportActionBar().setTitle("Ваш портфель");
    }

    public void on_add_asset_button_clicked(View view){
        Intent intent = new Intent(MainActivity.this, AddAssetActivity.class);
        startActivity(intent);

        //снизу создание layout инстумента
        /*LayoutInflater ltInflater = getLayoutInflater();
        RelativeLayout assetlayout = (RelativeLayout)
                ltInflater.inflate(R.layout.asset_layout, null, false);
        LinearLayout assets = findViewById(R.id.assetslayout);
        assets.addView(assetlayout);*/
    }

    public boolean on_settings_button_clicked(MenuItem item) {
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intent);
        return true;
    }


    public void onRubleLayoutClicked(View view){
        View dollar_layout = findViewById(R.id.dollar_layout);
        dollar_layout.setBackground(null);
        view.setBackground(getDrawable(R.drawable.checked_border));
    }

    public void onDollarLayoutClicked(View view){
        View ruble_layout = findViewById(R.id.ruble_layout);
        ruble_layout.setBackground(null);
        view.setBackground(getDrawable(R.drawable.checked_border));
    }
}