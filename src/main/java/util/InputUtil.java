/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Scanner;

/**
 *
 * @author rashid.khitilov
 */
public class InputUtil {
    public static String requireText(String title){
        Scanner sc= new Scanner(System.in);
        System.out.println(title);
        String answer=sc.nextLine();
        return answer;
    }
}
