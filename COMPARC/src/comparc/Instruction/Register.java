/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparc.Instruction;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Danica
 */
public class Register {
    private List<String> register;
    private String hi;
    private String lo;
    
    public Register(Register register) {
        this.register = new ArrayList<String>(register.getRegister());
        this.hi = register.getHi();
        this.lo = register.getLo();
    }
    
    public Register() {
        
    }

    public List<String> getRegister() {
        return register;
    }
    
    public String getRegister(int reg) {
        return register.get(reg);
    }

    public void setRegister(List<String> register) {
        this.register = register;
    }
    
    public void setRegister(int reg, String value) {
        register.set(reg, value);
    }

    public String getHi() {
        return hi;
    }

    public void setHi(String hi) {
        this.hi = hi;
    }

    public String getLo() {
        return lo;
    }

    public void setLo(String lo) {
        this.lo = lo;
    }
}
