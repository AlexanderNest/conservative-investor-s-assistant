package com.nestapps.conservative_investor_s_assistant.utils;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bonds extends AsyncTask<String, Void, String> {
    String URL = "https://smart-lab.ru/q/bonds/"; // надо прикреплять номер облигации

    @Override
    protected String doInBackground(String... strings) {
        // на первое время хочу просто увидеть название облигации
        String isin = strings[0];
        URL += isin; // готовый адрес облигации

        Map<String, String> info = null;
        ArrayList <String[]> payments = null;

        try {
            info = getMainInfo();
            payments = getPaymentsInfo();
        } catch (Exception e) {
            return null;
        }

        //ArrayList <String[]> payments = getPaymentsInfo(); //тут платежи купонов

        String date = info.get("Дата размещения");
        /*for (var i : payments){
            System.out.println(Arrays.toString(i));
        }*/
        return date;
    }







    private Elements getPureTables(){

        Document document = null;
        try {
            document = Jsoup.connect(URL).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document.select("table");
    }


    private Map<String, String> getMainInfo(){
        Elements tables = getPureTables();
        String g = tables.get(0).toString();

        Document doc = Jsoup.parse(g);

        Map<String, String> pairs = new HashMap<>();
        byte i = 0;
        String key = "", value = "";
        for (Element line : doc.getElementsByTag("td")){
            if (i == 0){
                key = line.text();
                i++;
            }
            else if (i == 1){
                value = line.text();
                i++;
            }
            else{
                pairs.put(key, value);
                i = 0;
            }
        }

        return pairs;
    }

    private ArrayList<String[]> getPaymentsInfo(){
        Elements tables = getPureTables();
        String g = tables.get(1).toString();

        Document doc = Jsoup.parse(g);

        Map<String, String> pairs = new HashMap<>();

        byte i = 0;
        String []lines = new String[6];

        ArrayList<String[]> table = new ArrayList<>();
        for (Element line : doc.getElementsByTag("td")){
            if (i == 6){
                i = 0;
                table.add(lines.clone());
                lines = new String[6];
            }
            lines[i] = line.text();
            i++;
        }

        return table;
    }


}
