/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparc.Instruction;

/**
 *
 * @author Danica
 */
public class ID {
    private String A;
    private String B;
    private String IMM;
    private String IR;
    
    public ID(String A, String B, String IMM, String IR) {
        this.A = A.toUpperCase();
        this.B = B.toUpperCase();
        this.IMM = IMM.toUpperCase();
        this.IR = IR.toUpperCase();
    }

    public String getA() {
        return A;
    }

    public void setA(String A) {
        this.A = A;
    }

    public String getB() {
        return B;
    }

    public void setB(String B) {
        this.B = B;
    }

    public String getIMM() {
        return IMM;
    }

    public void setIMM(String IMM) {
        this.IMM = IMM;
    }

    public String getIR() {
        return IR;
    }

    public void setIR(String IR) {
        this.IR = IR;
    }
}
