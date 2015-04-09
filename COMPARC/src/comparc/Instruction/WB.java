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

    public WB(String reg, String value) {
        this.REG = reg;
        this.value = value;
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

}
