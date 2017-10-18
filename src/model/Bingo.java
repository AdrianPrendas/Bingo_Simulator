package model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author _Adrián_Prendas_
 */
public class Bingo extends LinkedHashMap<Character, List> {
    public Bingo initial;
    public Bingo(List B,List I, List N, List G, List O){   
       super();
       this.put('B',B);
       this.put('I',I);
       this.put('N',N);
       this.put('G',G);
       this.put('O',O);
       this.initial = new Bingo(this);
    }
    public Bingo(Bingo b){
        super();//copy arraysList
        this.put('B',new ArrayList<Integer>(b.get('B')));
        this.put('I',new ArrayList<Integer>(b.get('I')));
        this.put('N',new ArrayList<Integer>(b.get('N')));
        this.put('G',new ArrayList<Integer>(b.get('G')));
        this.put('O',new ArrayList<Integer>(b.get('O')));
    }
    
    public boolean completeAndCheck(Bingo checker,String number, StringBuilder html){
        Character letra = number.charAt(0);
        int n = Integer.parseInt(number.substring(1));
        if(this.get(letra).contains(n)){
            int index = this.get(letra).indexOf(n);
            for(int i=0;i<5;i++){
                if((Integer)checker.get(letra).get(i)==0 && i == index){
                    this.get(letra).set(index, 0);
                    
                    System.out.println(this);
                    html.append("<div class=\"box\">");
                    html.append(this.toTags());
                    html.append("</div>");
                    return completed(checker);
                }
            }
            
        }
        return false;
    }
    
    public boolean completed(Bingo checker){
        
        for(int i=0;i<5;i++){
            if((Integer)checker.get('B').get(i)==0 && (Integer)this.get('B').get(i)!=0)
                return false;
            if((Integer)checker.get('I').get(i)==0 && (Integer)this.get('I').get(i)!=0)
                return false;
            if((Integer)checker.get('N').get(i)==0 && (Integer)this.get('N').get(i)!=0)
                return false;
            if((Integer)checker.get('G').get(i)==0 && (Integer)this.get('G').get(i)!=0)
                return false;
            if((Integer)checker.get('O').get(i)==0 && (Integer)this.get('O').get(i)!=0)
                return false;
        }
        return true;
    }
    
    public String toString(){
        String str = "________________\n";
              str += "|B |I |N |G |O |\n";
               str+= "----------------\n";
        for(int j=0;j<5;j++){
            int b = (int)this.get('B').get(j);
            int i = (int)this.get('I').get(j);
            int n = (int)this.get('N').get(j);
            int g = (int)this.get('G').get(j);
            int o = (int)this.get('O').get(j);
            str+= "|";
            str+= ((b==0)?"X |":((b/10<1)?b+" |":b+"|"));
            str+= ((i==0)?"X |":((i/10<1)?i+" |":i+"|"));
            str+= ((n==0)?"X |":((n/10<1)?n+" |":n+"|"));
            str+= ((g==0)?"X |":((g/10<1)?g+" |":g+"|"));
            str+= ((o==0)?"X |":((o/10<1)?o+" |":o+"|"));
            str+= "\n";
        }
        str+= "****************\n";
        return str;
    }
    
    public String toTags(){
        String str =
"<table border=\"2\" >\n" +
"	<thead bgcolor=\"lime\">\n" +
"		<tr>\n" +
"			<td>B</td>\n" +
"			<td>I</td>\n" +
"			<td>N</td>\n" +
"			<td>G</td>\n" +
"			<td>O</td>\n" +
"		</tr>\n" +
"	</thead>\n" +
"	<tbody>";
        for(int j=0;j<5;j++){
            str+="<tr>\n";
            
            int b = (int)this.get('B').get(j);
            int i = (int)this.get('I').get(j);
            int n = (int)this.get('N').get(j);
            int g = (int)this.get('G').get(j);
            int o = (int)this.get('O').get(j);
            str+= ((b==0)?"<td class=\"X\">":"<td>");
            str+= ((b==0)?"X":b);
            str+= "</td>\n";
            str+= ((i==0)?"<td class=\"X\">":"<td>");
            str+= ((i==0)?"X":i);
            str+= "</td>\n";
            str+= ((n==0)?"<td class=\"X\">":"<td>");
            str+= ((n==0)?"X":n);
            str+= "</td>\n";
            str+= ((g==0)?"<td class=\"X\">":"<td>");
            str+= ((g==0)?"X":g);
            str+= "</td>\n";
            str+= ((o==0)?"<td class=\"X\">":"<td>");
            str+= ((o==0)?"X":o);
            str+= "</td>\n";
            
            str+= "</tr>";
        }
        str+=
"	</tbody>\n" +
"</table>";
        return str;
    }
}
