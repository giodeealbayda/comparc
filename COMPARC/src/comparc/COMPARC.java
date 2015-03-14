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

        String instruction = "AND";
        String rdString = "R1";
        String rsString = "R2";
        String rtString = "R3";

        int rd;
        int rt;
        int rs;
        int imm;
        int opcode;
        byte[] instructionByte = new byte[32];
        int j;

        switch (instruction) {

            case "DSUBU":
                rd = Integer.valueOf(rdString.substring(1, rdString.length()));
                rt = Integer.valueOf(rtString.substring(1, rtString.length()));
                rs = Integer.valueOf(rsString.substring(1, rsString.length()));
                opcode = 0;
                imm = 47;

                // opcode 0...5
                for (j = 5; j >= 0; j--) {
                    instructionByte[j] = 0;
                }
                // for rs (5) 6...10
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

                // for rt (5) 11...15
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

                // for rd 16...20
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

                // another 5 (5) 21...25
                for (j = 25; j >= 21; j--) {
                    instructionByte[j] = 0;
                }

                // func (6) 26...31
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

            case "DDIV":
                opcode = 0;
                rd = 0;
                rt = Integer.valueOf(rtString.substring(1, rtString.length()));
                rs = Integer.valueOf(rsString.substring(1, rsString.length()));
                imm = 30;

                // opcode 0...5
                for (j = 5; j >= 0; j--) {
                    instructionByte[j] = 0;
                }
                // for rs (5) 6...10
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

                // for rt (5) 11...15
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

                // for rd 16...20
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

                // another 5 (5) 21...25
                for (j = 25; j >= 21; j--) {
                    instructionByte[j] = 0;
                }

                // func (6) 26...31
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

            case "AND":
                opcode = 0;
                rs = Integer.valueOf(rsString.substring(1, rsString.length()));
                rt = Integer.valueOf(rtString.substring(1, rtString.length()));
                rd = Integer.valueOf(rdString.substring(1, rdString.length()));
                imm = 36;

                // opcode 0...5
                for (j = 5; j >= 0; j--) {
                    instructionByte[j] = 0;
                }
                // for rs (5) 6...10
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

                // for rt (5) 11...15
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

                // for rd 16...20
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

                // another 5 (5) 21...25
                for (j = 25; j >= 21; j--) {
                    instructionByte[j] = 0;
                }

                // func (6) 26...31
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

            case "DSRLV":
                break;

            case "SLT":
                break;

            case "BEQ":
                break;

            case "LW":
                break;

            case "LWU":
                break;

            case "SW":
                break;

            case "DADDIU":
                break;

            case "J":
                break;
            default:
                System.out.println("ERROR");
                break;
        }
        System.out.println(Arrays.toString(instructionByte));
    }

}
