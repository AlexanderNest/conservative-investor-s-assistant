package com.company;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bonds {
    String URL = "https://smart-lab.ru/q/bonds/"; // надо прикреплять номер облигации

    Bonds(String name){
        URL += name;
    }

    public static void main() throws IOException {

        //System.out.println(tables.get(0));

        /*Document d = Jsoup.parse(h1.toString());
        System.out.println(d.get(0));
        System.out.println(d.select(""));*/

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


    public  Map<String, String> getMainInfo(){
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

    public  ArrayList<String[]> getPaymentsInfo(){
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
