package com.nestapps.conservative_investor_s_assistant;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AddAssetActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_asset_layout);
    }

    public void onReturnButtonClicked(View view){
        finish();
    }

}
