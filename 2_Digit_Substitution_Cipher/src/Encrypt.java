/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author irham
 */
public class Encrypt {

    /**
     * @param args the command line arguments
     */
    
    private String plaintext;
    private String ciphertext = "";
    private String key;
        
    public Encrypt(String text, String key) {
        this.key = key;
        this.plaintext = text;
    }

    public String encryptText() {
        // TODO code application logic here
        
        String[] character = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X/Y","Z"};
        String[][] digitTable = new String[key.length()][character.length];
        
        DigitTable table = new DigitTable(key,character,digitTable);
        
        table.fillTable();
        
        //table.showTable();
      
        //converting to ciphertext      
        ArrayList<String> match = new ArrayList<String>();
        
        for(int i=0;i<plaintext.length();i++){
            

            char CHAR = plaintext.charAt(i);
            match.add(Character.toString(CHAR));
            int count = 0;
            
            for(int j=0;j<match.size();j++){
                if(match.get(j).equals(Character.toString(CHAR))){
                    count++;
                }
            }
            
            // if the same letter repaets more than 4 times, start back at first row
            if(count > 4){
                count = 1;
            }
            
            for(int j=0;j<character.length;j++){
                if(character[j].contains(Character.toString(CHAR))){
                    ciphertext = ciphertext + table.getDigitTable()[count-1][j] + " ";
                }
            }
        }
        
        //System.out.println();
        //output ciphertext
        return ciphertext;
    }
    
    public static void main(String[] args){
        
        //get input plaintext and key
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter plaintext:");
        
        String plaintext = input.nextLine();

        System.out.print("Enter key:");
        String key = input.nextLine();
        
        Encrypt enc = new Encrypt(plaintext, key);
        System.out.println(enc.encryptText());
        
    }
    
}
