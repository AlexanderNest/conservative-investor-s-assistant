package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        Bonds b = new Bonds("RU000A101HU5");
        Map<String, String> info = b.getMainInfo();

        ArrayList <String[]> payments = b.getPaymentsInfo();

        System.out.println(info.toString());
        for (var i : payments){
            System.out.println(Arrays.toString(i));
        }

    }
}
