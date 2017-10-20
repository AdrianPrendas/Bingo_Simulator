package test;

import java.util.ArrayList;
import model.Game;
import java.util.Scanner;
import util.Console;

/**
 *
 * @author _Adrián_Prendas_
 */
public class test {
    
    public static void main(String [] args){
        String type;
        int gamers;
        int grids;
        Game g;
        
        Console.log("ingrese el numero de personas:");
        gamers = Console.integerIn();
        
        Console.log("numero de cartones maximo por persona:");
        grids = Console.integerIn();
        
        Console.log("tipo de juego: [X,L,C,U,O,FULL,ROW,COLL]");
        
        type = Console.typeGameIn();
        g = new Game(gamers,grids,type);
        
Console.log(g.toString());
        g.play();
        
        try{
            Process myProcess = new ProcessBuilder(
                    "\"C:\\\\Program Files (x86)\\\\Google\\\\Chrome\\\\Application\\\\chrome.exe\"",
                    "data\\simulacion.html").start();
        }catch(Exception e){e.printStackTrace();}
       
    }
}
