/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparc;

/**
 *
 * @author Danica
 */
public class Sample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //System.out.println(Integer.parseInt("FFFF", 2));
        
        //AND
        String tempA="11010", tempB="11100", ans="";
        String charA, charB;
        
        for(int i=0; i<5; i++) {
            charA = Character.toString(tempA.charAt(i));
            charB = Character.toString(tempB.charAt(i));
            System.out.println(charA + " " + charB);
            if(charA.matches("1") && charB.matches("1")) {
                ans = ans + '1';
            } else {
                ans = ans + '0';
            }
        }
        System.out.println(ans);
        
        System.out.println(Integer.toBinaryString(-1));
        
        int x=8, y=10, z=0;
        z = x-y;
        System.out.println(Integer.toHexString(z));
    }
    
}
