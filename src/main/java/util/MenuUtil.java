/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import config.Config;

/**
 *
 * @author rashid.khitilov
 */
public class MenuUtil {

    public static void processMenu() {
        String lang = MenuUtil.getExamLanguage();
        if (lang.equals(Config.langEn)) {
            handleMap("key", lang);
        } else if (lang.equals(Config.langAz)) {
            handleMap("value", lang);
        }
    }

    public static String getExamLanguage() {
        return InputUtil.requireText("Sual ingilisce sorushulsun yoxsa Azerbaycan dilinde? Please select az or en");
    }

    public static String getQuestion(String word, String lang) {
        String question = word;
        if (lang.equals(Config.langEn)) {
            question = InputUtil.requireText("what is the main of " + word + " in Azerbaijani");
        } else if (lang.equals(Config.langAz)) {
            question = InputUtil.requireText("Ingilisce  " + word + " nedir?");
        }
        return question;
    }

    public static void showMessageIfAllFalse(String word,String lang) {
        if (lang.equals(Config.langEn)) {
            System.out.println("You didn't find this word's answer!!! , answer is: " + word);
        } else if (lang.equals(Config.langAz)) {
            System.out.println("Siz sualin cavabini tapa bilmediz!!! , cavab: " + word);
        }
    }
    public static void showSuccessMessage(String lang) {
        if (lang.equals(Config.langEn)) {
            System.out.println("Congratulations, You are right!");
        } else if (lang.equals(Config.langAz)) {
            System.out.println("Tebrikler!!! , dogru cavab!");
        }
    }
    public static void showSuccessMessageIfAllTrue(String lang) {
        if (lang.equals(Config.langEn)) {
            System.out.println("Congratulations, All are right!");
        } else if (lang.equals(Config.langAz)) {
            System.out.println("Tebrikler!!! , Hamsi dogrudur!");
        }
    }

    public static void showErrorMessage(String lang) {
        if (lang.equals(Config.langEn)) {
            System.out.println("Wrong Entry, Please try again!");
        } else if (lang.equals(Config.langAz)) {
            System.out.println("Sefdir, yeniden yoxlayin");
        }
    }

    public static void handleMap(String keyOrValue, String language) {
        try {
            List<Map.Entry<String, String>> list = Config.generateShuffledList("words.txt");
            int count = 0;
            for (Map.Entry<String, String> entry : list) {
                String entryPointKey ;
                String entryPointValue;
                if(keyOrValue.equals("key")) {
                    entryPointKey = entry.getKey();
                    entryPointValue= entry.getValue();
                }else{
                    entryPointKey = entry.getValue();
                    entryPointValue= entry.getKey();
                }
                String answer = MenuUtil.getQuestion(entryPointValue, language);
                if (!answer.equals(entryPointKey)) {
                    MenuUtil.showErrorMessage(language);
                    int count2 = 1;
                    for (int i = 0; i < 2; i++) {
                        answer = MenuUtil.getQuestion(entryPointValue, language);
                        if (!answer.equals(entryPointKey)) {
                            count2++;
                            if (count2 < 3) {
                                MenuUtil.showErrorMessage(language);
                            }
                        } else {
                            MenuUtil.showSuccessMessage(language);
                            break;
                        }
                        if (count2 == 3) {
                            showMessageIfAllFalse(entryPointValue, language);
                            System.exit(0);
                        }
                    }
                } else {
                    MenuUtil.showSuccessMessage(language);
                }
                count++;
            }
            if (count > 2) {
                showSuccessMessageIfAllTrue(language);
                System.exit(0);
            }
        } catch (Exception ex) {
            Logger.getLogger(MenuUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
