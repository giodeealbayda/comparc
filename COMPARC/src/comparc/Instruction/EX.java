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
    private String COND;
    
    public EX(String IR, String ALUOUPUT, String B, String COND) {
        this.IR = IR;
        this.ALUOUTPUT = ALUOUTPUT;
        this.B = B;
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

    public String getCOND() {
        return COND;
    }

    public void setCOND(String COND) {
        this.COND = COND;
    }
}
