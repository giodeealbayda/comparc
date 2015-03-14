/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparc;

import java.util.Arrays;

public class COMPARC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here        
        MainFrame mf = new MainFrame();
        mf.setVisible(true);

        String instruction = "DSUBU";
        String rdString = "R1";
        String rsString = "R2";
        String rtString = "R3";

        int rd = Integer.valueOf(rdString.substring(1, rdString.length()));
        int rt = Integer.valueOf(rtString.substring(1, rsString.length()));
        int rs = Integer.valueOf(rsString.substring(1, rsString.length()));

        int opcode;
        int imm;
        byte[] instructionByte = new byte[32];

        System.out.println(instruction + " " + rd + ", " + rs + ", " + rt);
        switch (instruction) {

            case "DSUBU":
                opcode = 0;
                imm = 47;
                int j;

                // for opcode (6)
                for (j = 5; j >= 0; j--) {
                    instructionByte[j] = 0;
                }
                // for rs (5)
                for (j = 10; j >= 6; j--) {
                    if (rs != 0) {
                        if (rs % 2 == 1) {
                            instructionByte[j] = 1;
                        } else {
                            instructionByte[j] = 0;
                        }
                        rs /= 2;
                    } else {
                        instructionByte[j] = 0;
                    }
                }

                // for rt (5)
                for (j = 15; j >= 11; j--) {
                    if (rt != 0) {
                        if (rt % 2 == 1) {
                            instructionByte[j] = 1;
                        } else {
                            instructionByte[j] = 0;
                        }
                        rt /= 2;
                    } else {
                        instructionByte[j] = 0;
                    }
                }

                // for rd
                for (j = 20; j >= 16; j--) {
                    if (rd != 0) {
                        if (rd % 2 == 1) {
                            instructionByte[j] = 1;
                        } else {
                            instructionByte[j] = 0;
                        }
                        rd /= 2;
                    } else {
                        instructionByte[j] = 0;
                    }
                }

                // another 5 (5)
                for (j = 25; j >= 21; j--) {
                    instructionByte[j] = 0;
                }

                // func (6)
                for (j = 31; j >= 26; j--) {
                    if (imm != 0) {
                        if (imm % 2 == 1) {
                            instructionByte[j] = 1;
                        } else {
                            instructionByte[j] = 0;
                        }
                        imm /= 2;
                    } else {
                        instructionByte[j] = 0;
                    }
                }
                break;

            default:
                System.out.println("ERROR");
                break;
        }
        System.out.println(Arrays.toString(instructionByte));
    }

}
