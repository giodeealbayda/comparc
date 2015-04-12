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
public class EX {
    private String IR;
    private String ALUOUTPUT;
    private String B;
    private int COND=0;
    
    public EX(String IR, String ALU, String B, int COND) {
        this.IR = IR.toUpperCase();
        this.ALUOUTPUT = ALU.toUpperCase();
        this.B = B.toUpperCase();
        this.COND = COND;
    }

    public String getIR() {
        return IR;
    }

    public void setIR(String IR) {
        this.IR = IR;
    }

    public String getALUOUTPUT() {
        return ALUOUTPUT;
    }

    public void setALUOUTPUT(String ALUOUTPUT) {
        this.ALUOUTPUT = ALUOUTPUT;
    }

    public String getB() {
        return B;
    }

    public void setB(String B) {
        this.B = B;
    }

    public int getCOND() {
        return COND;
    }

    public void setCOND(int COND) {
        this.COND = COND;
    }
}
