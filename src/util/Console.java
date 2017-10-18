/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author _Adrián_Prendas_
 */
public class Console {
    public static void log(String str){
        System.out.println(str);
    }
    public static String stringIn(){
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        return str;
    }
    public static int integerIn(){
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        try{
            int n = Integer.parseInt(str);
            return n;
        }catch(Exception e){
            log("type is not Integer");
            log("try again");
            return integerIn();
        }
    }
    public static int nextIntRandom(int min, int max){
        Random rad = new Random();
        int n = rad.nextInt(max+1);
        if(n<min)return nextIntRandom(min,max);
        return n;
    }
    
    public static void main(String[]args){
        Set set = new HashSet<String>();
        set.add("Adrian");
        set.add("Tori");
        set.add("Zene");
        for(int i=0;i<20;i++){
            set.add("Adrian");
            set.add("Tori");
            set.add("Zene");
            
        }
        System.out.println(set);
    }
    
}
