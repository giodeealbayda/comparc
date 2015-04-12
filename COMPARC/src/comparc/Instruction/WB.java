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
public class WB {

    private String REG;
    private String value;
    private String HI;
    private String LO;
            

    public WB(String reg, String value, String hi, String lo) {
        this.REG = reg;
        this.value = value;
        this.HI = hi;
        this.LO = lo;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getHI() {
        return HI;
    }

    public void setHI(String HI) {
        this.HI = HI;
    }

    public String getLO() {
        return LO;
    }

    public void setLO(String LO) {
        this.LO = LO;
    }
}
