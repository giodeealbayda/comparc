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
public class IF {
    private String IR;
    private String NPC;
    private String PC;
    
    public IF(String IR, String NPC, String PC) {
        this.IR = IR.toUpperCase();
        this.NPC = NPC.toUpperCase();
        this.PC = PC.toUpperCase();
    }

    public String getIR() {
        return IR;
    }

    public void setIR(String IR) {
        this.IR = IR.toUpperCase();
    }

    public String getNPC() {
        return NPC;
    }

    public void setNPC(String NPC) {
        this.NPC = NPC.toUpperCase();
    }

    public String getPC() {
        return PC;
    }

    public void setPC(String PC) {
        this.PC = PC.toUpperCase();
    }
}
