
package util;


import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author _Adrián_Prendas_
 */
public class Console {
    public static void log(String str){
        System.out.println(str);
    }
    public static String typeGameIn(){
        Scanner scan = new Scanner(System.in);
        
        try{
            String str = scan.next();
            str = str.toUpperCase();
            switch(str){
                case "X":
                case "L":
                case "C":
                case "U":
                case "O":
                case "FULL":
                case "ROW":
                case"COL":return str;
                default:throw new Exception();
            }
        }catch(Exception e){
            log("no existe esa opcion");
            log("intentelo de nuevo");
            return typeGameIn();
        }
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
            log("el tipo no entero");
            log("intentelo de nuevo");
            return integerIn();
        }
    }
    public static int nextIntRandom(int min, int max){
        Random rad = new Random();
        int n = rad.nextInt(max+1);
        if(n<min)return nextIntRandom(min,max);
        return n;
    }    
}
