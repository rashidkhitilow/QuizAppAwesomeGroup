/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author rashid.khitilov
 */
public class Main {

    public static void main(String[] args) throws IOException {
        String filePath = "words.txt";
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

        Scanner sc = new Scanner(System.in);
        System.out.println("Sual ingilisce sorushulsun yoxsa Azerbaycan dilinde? az or en");
        String lang = sc.nextLine();
        String langEn = "en";
        String langAz = "az";
        if (lang.equals(langEn)) {
            List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());
            Collections.shuffle(list);
            int count = 0;
            for (Map.Entry<String, String> entry : list) {
                Scanner sc1 = new Scanner(System.in);
                System.out.println("what is the main of " + entry.getKey() + " in Azerbaijani");
                String answer = sc1.nextLine();
                if (!answer.equals(entry.getValue())) {
                    System.out.println("Wrong entry.Please try again");
                    int count2 = 1;
                    for (int i = 0; i < 2; i++) {
                        Scanner sc2 = new Scanner(System.in);
                        System.out.println("what is the main of " + entry.getKey() + " in Azerbaijani");
                        answer = sc2.nextLine();
                        if (!answer.equals(entry.getValue())) {
                            count2++;
                            if (count2 < 3) {
                                System.out.println("Wrong entry.Please try again");
                            }
                        } else {
                            break;
                        }
                        if (count2 == 3) {
                            System.out.println("You are false ,true answer is " + entry.getValue());
                            System.exit(0);
                        }
                    }
                } else {
                    System.out.println("Congratulations, You are right!");
                }
                count++;
            }
            if (count > 2) {
                System.out.println("All are right");
                System.exit(0);
            }

        } else if (lang.equals(langAz)) {
            List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());
            Collections.shuffle(list);
            int count = 0;
            for (Map.Entry<String, String> entry : list) {
                Scanner sc1 = new Scanner(System.in);
                System.out.println("Ingilisce  " + entry.getValue() + " nedir?");
                String answer = sc1.nextLine();
                if (!answer.equals(entry.getKey())) {
                    System.out.println("Sefdir, yeniden yoxlayin");
                    int count2 = 1;
                    for (int i = 0; i < 2; i++) {
                        Scanner sc2 = new Scanner(System.in);
                        System.out.println("Ingilisce  " + entry.getValue() + " nedir?");
                        answer = sc2.nextLine();
                        if (!answer.equals(entry.getKey())) {
                            count2++;
                            if (count2 < 3) {
                                System.out.println("Sefdir, yeniden yoxlayin");
                            }
                        } else {
                            break;
                        }
                        if (count2 == 3) {
                            System.out.println("Siz sualin cavabini tapa bilmediz!!! , cavab: " + entry.getValue());
                            System.exit(0);
                        }
                    }
                } else {
                    System.out.println("Tebrikler!!! , dogru cavab!");
                }
                count++;
            }
            if (count > 2) {
                System.out.println("Hamsi Dogrudur!!!");
                System.exit(0);
            }

        }
    }
}
