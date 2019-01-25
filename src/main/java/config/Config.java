/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author rashid.khitilov
 */
public class Config {
    public static String langEn = "en";
    public static String langAz = "az";
    public static List<Map.Entry<String, String>> generateShuffledList(String filePath) throws Exception{
        HashMap<String, String> map = new HashMap<String, String>();

        String line;
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",", 2);
            if (parts.length >= 2) {
                String key = parts[0];
                String value = parts[1];
                map.put(key, value);
            } else {
                System.out.println("ignoring line: " + line);
            }
        }
        reader.close();
        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());
        Collections.shuffle(list);
        return list;
    }
}
