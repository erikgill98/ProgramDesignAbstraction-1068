import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.io.File;

public class Jaws2{
    
    public static void main(String[] args) throws FileNotFoundException{
            SouthernAcc();
    } 
    
    public static void SouthernAcc() throws FileNotFoundException {
        
        File text = new File("JawsScript.txt");
        Scanner scan = new Scanner(text);

    
        while(scan.hasNext()){
            String curline = scan.nextLine();
            String[] words = curline.split(" ");
         
            for(int i = 0; i < words.length; i++){
                String currentWord = words[i];
                System.out.print(i + currentWord + " ");
                currentWord = wicked(currentWord);
                currentWord = addR(currentWord);
                currentWord = rRule(currentWord);
  
            }
          //  System.out.println(scan.nextLine());
          
        //break;
          
        }
    }
    
    //wicked question
    public static String wicked(String s){
        //equalsIgnoreCase removes case senstivity ex: Very/very
        s = s.toLowerCase();
        s = s.replaceAll("very", "wicked");
        /*if(s.equalsIgnoreCase("very")){
            return "wicked";
        }else{ */
        return s;
    }
    
    
    //adding an R to a word that ends in A
    public static String addR(String s) {
        if(s.endsWith("a") && s.length() != 1){
            s += "r";
        }
    return s;
}

    public static String rRule(String s){
        s = s.toLowerCase();
        while(s.contains("ar")){
            s.replaceAll("ar", "ah");
            int i = s.indexOf("ar");
            s = s.substring(0,i) + "h" + s.substring(i + 1);
        }
   
       return s; 
    }
}
