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
public class Instruction {
    
    private String label;
    private String opcode;
    private String pc;
    private String inst;
    private String dependency; //registers to wait
    private String answer;
    private IF ifinst;
    private ID idinst;
    private EX exinst;
    private MEM meminst;
    private WB wbinst;

    public void setIF(String IR, String NPC, String PC) {
        ifinst = new IF(IR, NPC, PC);
    }

    public void setID(String A, String B, String IMM, String IR) {
        idinst = new ID(A, B, IMM, IR);
    }

    public void setEX(String IR, String ALUOUTPUT, String B, int COND) {
        exinst = new EX(IR, ALUOUTPUT, B, COND);
    }

    public void setMEM(String IR, String ALUOUTPUT, String LMD, String MEMALU) {
        meminst = new MEM(IR, ALUOUTPUT, LMD, MEMALU);
    }

    public void setWB(String REG, String value, String hi, String lo) {
        wbinst = new WB(REG, value, hi, lo);
    }

    public IF getIF() {
        return ifinst;
    }

    public ID getID() {
        return idinst;
    }

    public EX getEX() {
        return exinst;
    }

    public MEM getMEM() {
        return meminst;
    }
    
    public WB getWB() {
        return wbinst;
    }
    
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getOpcode() {
        return opcode;
    }
    
    public void setOpcode(String opcode) {
        this.opcode = opcode;
    }

    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public String getInst() {
        return inst;
    }

    public void setInst(String inst) {
        this.inst = inst;
    }
    
    public String getDependency() {
        return dependency;
    }
    
    public void setDependency(String dependency) {
        this.dependency = dependency;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
