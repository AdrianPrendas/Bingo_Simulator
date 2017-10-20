
package model;

import eif203.util.IOServices;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import util.Console;


/**
 *
 * @author _Adrián_Prendas_
 */
public class Game  extends Hashtable<String,List>{
    public Bingo checker;
    public Set balls;
    public StringBuilder html = new StringBuilder();
    public int gamers;
    public int maxGamesPerGames;
    public String typeGame;
    public Game(int gamers, int maxGamesPerGamer, String typeGame){
        super();
        this.gamers=gamers;
        this.maxGamesPerGames=maxGamesPerGamer;
        this.typeGame=typeGame;
        Generator  generator = new Generator();
        for(int i=0;i<gamers;){
            int n = Console.nextIntRandom(1, maxGamesPerGamer);
            LinkedList gamesPerPerson = new LinkedList();
            for(int j=0;j<n;j++)
                gamesPerPerson.add(generator.generateBingo());
            
            Console.log("nombre:");
            String name = Console.stringIn();
            if(this.get(name)==null){
                this.put(name, gamesPerPerson);
                i++;
            }
        }
        this.checker = generator.generateChecker(typeGame);
    }

    public void play(){
        this.balls = new HashSet<String>();
        char[] letras ={'B','I','N','G','O'};
        int c=0, n=0, i=1;
        String number="";
        String ball ="";
        for(;;){
            
           c = Console.nextIntRandom(0, 4);
           if(c == 0)
               n = Console.nextIntRandom(1, 15);
           else if(c==1)
                   n = Console.nextIntRandom(16, 30);
           else if(c==2)
                   n = Console.nextIntRandom(31, 45);
           else if(c==3)
                   n = Console.nextIntRandom(46, 60);
           else if(c==4)
                   n = Console.nextIntRandom(61, 75);
            //[B1-B15],[I16,I30],[N31,N45],[G46,G60],[O61,O75]//randoms
            ball = letras[c]+String.valueOf(n);
            
            if(this.balls.contains(ball))
                continue;
            else 
                this.balls.add(ball);
            
            System.out.format("Bola numero %d: %s %n", i, ball);
            
this.html.append("<div class=\"container\">");
this.html.append(String.format("Bola numero %d: <b>%s</b> <br>%n", i++, ball));
            if(winner(ball))break;       
this.html.append("</div>");            
        }
        
        Console.log("hay un ganador");
        Console.log(getWinner());
this.html.append("<div class=\"after-box\">");
this.html.append(this.getWinnerTag());
this.html.append("</div>");
this.writeHTML();
    }
    
    public boolean winner(String number){
        for(String name: this.keySet()){
            this.html.append("<div class=\"after-box\">");
            this.html.append("<h5 class=\"text-uppercase text-center\">"+name+"</h5>");
            Iterator<Bingo> it = this.get(name).iterator();
            for(;it.hasNext();){    
                Bingo bingo = it.next();
                if(bingo.completeAndCheck(this.checker, number, this.html)){    
                    this.html.append("</div>");
                    return true;
                }
            }
            this.html.append("</div>");
        }
        
        return false;
    }
    public String getWinner(){
        String str = "";
        for(String name: this.keySet()){
            Iterator<Bingo> it = this.get(name).iterator();
            for(;it.hasNext();){
                Bingo bingo = it.next();
                if(bingo.completed(this.checker)){
                    str += name+"\n";
                    str += bingo.toString();
                    str += "inicial\n";
                    str += bingo.initial.toString();
                    return str;
                }
                    
            }
        }
        return "nadie";
    }
    public String getWinnerTag(){
        String str = "";
        str += "<h2>Hay un ganador</h2>\n";
        for(String name: this.keySet()){
            Iterator<Bingo> it = this.get(name).iterator();
            for(;it.hasNext();){
                Bingo bingo = it.next();
                if(bingo.completed(this.checker)){
                    str += "<div class=\"box\">";
                    str += "<h3>"+name+"</h3>\n";
                    str += bingo.toTags();
                    str += "</div>";
                    str += "<div class=\"box\">";
                    str += "<h3>inicial</h3>\n";
                    str += bingo.initial.toTags();
                    str += "</div>";
                    return str;
                }
            }
        }
        return "nadie";
    }
     public String toString(){
        String str="";
        for(String name:this.keySet()){
            str += name+"\n";
            
            Iterator<Bingo> it = this.get(name).iterator();
            for(;it.hasNext();){
                str += it.next().toString();
            }
        }
        str+="------------->>>";
        str+="checker";
        str+="<<<-------------\n";
        str+=this.checker.toString();
        return str;
    }
     
    public String toTags(){
        String str="<div class='container'>\n";
        for(String name:this.keySet()){
            str += "<h3>"+ name +"</h3>\n";
            
            Iterator<Bingo> it = this.get(name).iterator();
            for(;it.hasNext();){
                str += it.next().toTags();
            }
        }
        str += "<h3>checker</h3>\n";
        
        str+=this.checker.toTags();
        str+="</div>";
        return str;
        
    }
    
    public void writeHTML(){
        String html = new String();
        try{
        List list = IOServices.readTextFileAsList("data/", "base.html");
        Iterator<String> it = list.iterator();
        String htmlBase ="";
        for(;it.hasNext();) htmlBase += it.next() +"\n";
        
        htmlBase+= this.initialParams();
        
        
        String htmlClose =
"</body>\n"+
"</html>";
        
        html = htmlBase+this.html.toString()+htmlClose;
        IOServices.writeText("data/", "simulacion.html",html);
        }catch(Exception e){e.printStackTrace();}
        System.out.println(html);
    }
    
    public String initialParams(){

        StringBuilder string = new StringBuilder();
        for(String name: this.keySet()){
            string.append("<div class=\"after-box\">");
            string.append("<h5 class=\"text-uppercase text-center\">"+name+"</h5>");
            Iterator<Bingo> it = this.get(name).iterator();
            for(;it.hasNext();){    
                Bingo bingo = it.next();
                string.append("<div class=\"box\">");
                    string.append(bingo.initial.toTags());
                    string.append("</div>");
            }
            string.append("</div>");       
        }
        string.append("<div class=\"after-box\">");
        string.append("<h5 class=\"text-uppercase text-center\">checker</h5>");
        string.append(this.checker.toTags());       
        string.append("</div>");       
        
        StringBuilder str = new StringBuilder();
        str.append(String.format(
"<ol>%n" +
"		<li>Cantidad de usuarios: %d</li>%n" +
"		<li>cantidad de cartones por usuario: %d</li>%n" +
"		<li>tipo de juego: %s</li>%n" +
"	</ol>%n" +
"%s%n</div>%n",this.gamers,this.maxGamesPerGames,this.typeGame,string.toString()));
        return str.toString();
    }
    
}
