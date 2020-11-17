package com.nestapps.conservative_investor_s_assistant;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class AddAssetActivity extends AppCompatActivity {

    private int checked_layout_id = R.id.obligation_layout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStartSetting();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    private void setStartSetting(){
        //основные настройки при запуске интента
        setContentView(R.layout.add_asset_layout);

        //добавление нужных элементов в экшн бар
        ActionBar action = getSupportActionBar();
        action.setDisplayHomeAsUpEnabled(true);
        action.setTitle("Добавление актива");

        //добавление слушателя на edittext
        EditText et = findViewById(R.id.searching_textbox);
        et.addTextChangedListener(new TextWatcher() {


            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                return;
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                return;
            }

            @Override
            public void afterTextChanged(Editable editable) {
                getName();
            }
        });
    }

    public void onObligationLayoutClicked(View v){
        //меняю выбор на облигации, устанавливаю это в поле
        checked_layout_id = v.getId();
        View second = findViewById(R.id.stock_layout);
        second.setBackground(null);
        v.setBackground(getDrawable(R.drawable.checked_border));
    }

    public void onStockLayoutClicked(View v){
        //меняю выбор на облигации, устанавливаю это в поле
        checked_layout_id = v.getId();

        View second = findViewById(R.id.obligation_layout);
        second.setBackground(null);
        v.setBackground(getDrawable(R.drawable.checked_border));


        Toast toast = Toast.makeText(getApplicationContext(),
                "В разработке", Toast.LENGTH_SHORT);
        toast.show();
    }

    private String getName(){
        return null;
    }
}
