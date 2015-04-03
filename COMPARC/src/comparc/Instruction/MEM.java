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
public class MEM {
    private String IR;
    private String ALUOUTPUT;
    private String LMD;
    private String MEMALU;
    
    public MEM(String IR, String ALUOUTPUT, String LMD, String MEMALU) {
        this.IR = IR;
        this.ALUOUTPUT = ALUOUTPUT;
        this.LMD = LMD;
        this.MEMALU = MEMALU;
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

    public String getLMD() {
        return LMD;
    }

    public void setLMD(String LMD) {
        this.LMD = LMD;
    }

    public String getMEMALU() {
        return MEMALU;
    }

    public void setMEMALU(String MEMALU) {
        this.MEMALU = MEMALU;
    }
    
}
