/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author AWANG, Irham, 
 */
public class Decrypt {
    private String plaintext = "";
    private String ciphertext;
    private String key;
    
    public Decrypt(String text, String key) {
        this.key = key;
        this.ciphertext = text;
    }
    
    public String decryptText()  {
        
        String[] character = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X/Y","Z"};
        String[][] digitTable = new String[key.length()][character.length];

        DigitTable table = new DigitTable(key,character,digitTable);

        table.fillTable();

        table.showTable();

        // replace space
        ciphertext = ciphertext.replaceAll("\\s+","");
        
        List<String> ciphertextList = new ArrayList<String>();
        
        int len = ciphertext.length();
        
        // put the series of 2-digits from ciphertext into a list
        // each 2-digits now represent one element in the list
        for(int i=0;i<len;i+=2){
             ciphertextList.add(ciphertext.substring(i, (i+2)));
        }

        int loop = ciphertextList.size();
        int count = 0;
        String word;

        // while loop will traverse the list to find matching digits from the digitTable
        while(count<loop){
            
            word = ciphertextList.get(count);
            
            //find digits from digitTable that match the element
            for(int i=0;i<key.length();i++){

                for(int j=0;j<character.length;j++){
                    
                    if(digitTable[i][j].equals(word)){
                        
                        plaintext = plaintext + character[j];
                    
                    }

                }
            }
            
            count++;
        }
        
        return plaintext;
  
    }
    
    public static void main(String[] args){
        
        //get input plaintext and key        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter plaintext:");
        String plaintext = input.nextLine();
        
        System.out.print("Enter key:");
        String key = input.nextLine();
        
        Decrypt dec = new Decrypt(plaintext, key);
        System.out.println(dec.decryptText());
        
    }
}
