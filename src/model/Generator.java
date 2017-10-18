
package model;

import model.Bingo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import util.Console;

/**
 *
 * @author _Adrián_Prendas_
 */
public class Generator extends Hashtable<String,List>{
    
    public Generator(){
        super();
    }
    private List generate5NumbersInRange(int minRange, int maxRange){//sin repetir
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<5;){//5 randoms sin repetir
            int n = Console.nextIntRandom(minRange,maxRange);
            if(!set.contains(n)){
                set.add(n);
                i++;
            }
        }
        List list = new ArrayList<Integer>(set);
        String hash = set.toString();
        if(this.get(hash)==null)
            this.put(hash, list);
        else//si ya existe la secuencia, vuelva a calcular
            return generate5NumbersInRange(minRange,maxRange);
        return list;
    }
    public Bingo generateBingo(){
        List B = this.generate5NumbersInRange(1, 15);
        List I = this.generate5NumbersInRange(16, 30);
        List N = this.generate5NumbersInRange(31, 45);
        List G = this.generate5NumbersInRange(46, 60);
        List O = this.generate5NumbersInRange(61, 75);
        return new Bingo(B,I,N,G,O);
    }
    public Bingo generateChecker(String shape){
        /*|B|I|N|G|O|
          -----------
          |1|1|1|1|1|
          |0|0|0|0|0|
          |2|2|2|2|2|
          |3|3|3|3|3|
          |4|4|4|4|4|
        */
        switch(shape){
            case "ROW":return  checkerROW();
            case "COL":return checkerCOL();
            case "FULL":return checkerFULL();
            case "C":return checkerC();
            case "L":return checkerL();
            case "O":return checkerO();
            case "U":return checkerU();
            case "X":return checkerX();
            
        }
        return null;
    }
    private Bingo checkerROW(){
       /*|B|I|N|G|O|
          -----------
          |0|0|0|0|0|
          |2|2|2|2|2|
          |3|3|3|3|3|
          |4|4|4|4|4|
          |5|5|5|5|5|
        */
        Integer [] b ={0,2,3,4,5};
        Integer [] i ={0,2,3,4,5};
        Integer [] n ={0,2,3,4,5};
        Integer [] g ={0,2,3,4,5};
        Integer [] o ={0,2,3,4,5};
        return checker(b,i,n,g,o);
    }
    private Bingo checkerCOL(){
       /*|B|I|N|G|O|
          -----------
          |0|2|3|4|5|
          |0|2|3|4|5|
          |0|2|3|4|5|
          |0|2|3|4|5|
          |0|2|3|4|5|
        */
        Integer [] b ={0,0,0,0,0};
        Integer [] i ={2,2,2,2,2};
        Integer [] n ={3,3,3,3,3};
        Integer [] g ={4,4,4,4,4};
        Integer [] o ={5,5,5,5,5};
        return checker(b,i,n,g,o);
    }
    private Bingo checkerFULL(){
       /*full
          |B|I|N|G|O|
          -----------
          |0|0|0|0|0|
          |0|0|0|0|0|
          |0|0|0|0|0|
          |0|0|0|0|0|
          |0|0|0|0|0|
        */
        Integer [] b ={0,0,0,0,0};
        Integer [] i ={0,0,0,0,0};
        Integer [] n ={0,0,0,0,0};
        Integer [] g ={0,0,0,0,0};
        Integer [] o ={0,0,0,0,0};
        return checker(b,i,n,g,o);
    }
    private Bingo checkerC(){
        /*C
          |B|I|N|G|O|
          -----------
          |0|0|0|0|0|
          |0|1|1|1|1|
          |0|1|1|1|1|
          |0|1|1|1|1|
          |0|0|0|0|0|
        */
        Integer [] b ={0,0,0,0,0};
        Integer [] i ={0,1,1,1,0};
        Integer [] n ={0,1,1,1,0};
        Integer [] g ={0,1,1,1,0};
        Integer [] o ={0,1,1,1,0};
        return checker(b,i,n,g,o);
    }
    private Bingo checkerL(){
        /*L
          |B|I|N|G|O|
          -----------
          |0|1|1|1|1|
          |0|1|1|1|1|
          |0|1|1|1|1|
          |0|1|1|1|1|
          |0|0|0|0|0|
        */
        Integer [] b ={0,0,0,0,0};
        Integer [] i ={1,1,1,1,0};
        Integer [] n ={1,1,1,1,0};
        Integer [] g ={1,1,1,1,0};
        Integer [] o ={1,1,1,1,0};
        return checker(b,i,n,g,o);
    }
    private Bingo checkerO(){
       /*O
          |B|I|N|G|O|
          -----------
          |0|0|0|0|0|
          |0|1|1|1|0|
          |0|1|1|1|0|
          |0|1|1|1|0|
          |0|0|0|0|0|
        */
        Integer [] b ={0,0,0,0,0};
        Integer [] i ={0,1,1,1,0};
        Integer [] n ={0,1,1,1,0};
        Integer [] g ={0,1,1,1,0};
        Integer [] o ={0,0,0,0,0};
        return checker(b,i,n,g,o);
    }
    private Bingo checkerU(){
       /*U
          |B|I|N|G|O|
          -----------
          |0|1|1|1|0|
          |0|1|1|1|0|
          |0|1|1|1|0|
          |0|1|1|1|0|
          |0|0|0|0|0|
        */
        Integer [] b ={0,0,0,0,0};
        Integer [] i ={1,1,1,1,0};
        Integer [] n ={1,1,1,1,0};
        Integer [] g ={1,1,1,1,0};
        Integer [] o ={0,0,0,0,0};
        return checker(b,i,n,g,o);
    }
    private Bingo checkerX(){
       /*X
          |B|I|N|G|O|
          -----------
          |0|1|1|1|0|
          |1|0|1|0|1|
          |1|1|0|1|1|
          |1|0|1|0|1|
          |0|1|1|1|0|
        */
        Integer [] b ={0,1,1,1,0};
        Integer [] i ={1,0,1,0,1};
        Integer [] n ={1,1,0,1,1};
        Integer [] g ={1,0,1,0,1};
        Integer [] o ={0,1,1,1,0};
        return checker(b,i,n,g,o);   
    }
    
    private Bingo checker(Integer[] b, Integer[] i, Integer[] n, Integer[] g, Integer[] o){
        List B = new ArrayList<Integer>(Arrays.asList(b));
        List I = new ArrayList<Integer>(Arrays.asList(i));
        List N = new ArrayList<Integer>(Arrays.asList(n));
        List G = new ArrayList<Integer>(Arrays.asList(g));
        List O = new ArrayList<Integer>(Arrays.asList(o));
        return new Bingo(B,I,N,G,O);
    }
}
