package com.nestapps.conservative_investor_s_assistant;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.nestapps.conservative_investor_s_assistant.utils.Bonds;

import org.w3c.dom.Text;

import java.util.concurrent.ExecutionException;

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
                TextView et = findViewById(R.id.nameoblig);
                String text = getName();
                if (text != null){
                    et.setText(text);
                }else {
                    et.setText("Не найдено");
                }

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
        //рабочая облигация "RU000A101HU5"
        Bonds bondTask = new Bonds();
        EditText et = findViewById(R.id.searching_textbox);
        bondTask.execute(et.getText().toString());
        String result = "";
        try {
           result = bondTask.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
}
