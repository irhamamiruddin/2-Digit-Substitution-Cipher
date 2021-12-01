/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author IRHAM
 */
public class DigitTable {
    
    private String key;
    private String[] character;
    private String[][] digitTable;

    public DigitTable(String key, String[] character, String[][] digitTable) {
        
        this.key = key;
        this.character = character;
        this.digitTable = digitTable;
    
    }

    public String[][] getDigitTable() {
        return digitTable;
    }
    
    
    public String[][] fillTable(){
        
        //fill the table
        int digit = 0;
        for(int i=0;i<key.length();i++){
            
            int diff = 0;
            
            char keyLetter = key.charAt(i);
            
            for(int j=0;j<character.length;j++){
                
                if(character[j].contains(Character.toString(keyLetter))||
                        character[j].compareTo(Character.toString(keyLetter))>0){
                    
                    digitTable[i][j] = String.format("%02d", digit);
                    digit++;
                    diff++;
                
                }
            }
            
            for(int j=0;j<character.length-diff;j++){
                
                digitTable[i][j] = String.format("%02d", digit);
                digit++;
                    
            }
            
        }
        
        return digitTable;
    }
     
    public void showTable(){
        
        //show table
        for(int i=0;i<key.length();i++){
            for(int j=0;j<character.length;j++){
                System.out.print(digitTable[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}
