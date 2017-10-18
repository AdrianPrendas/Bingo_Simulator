package test;

import model.Game;
import java.util.Scanner;
import util.Console;

/**
 *
 * @author _Adrián_Prendas_
 */
public class test {
    
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        String str;
        Console.log("ingrese el numero de personas:");
        str = scan.next();
        int gamers = Integer.parseInt(str);
        Console.log("numero de cartones maximo por persona:");
        str = scan.next();
        int grids = Integer.parseInt(str);
        Console.log("tipo de juego: [X,L,C,U,O,FULL,ROW,COLL]");
        str = scan.next();
        Game g = new Game(gamers,grids,str);
Console.log(g.toString());
        g.play();
        
    }
}
