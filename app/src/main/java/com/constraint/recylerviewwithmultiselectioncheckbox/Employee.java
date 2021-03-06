package com.constraint.recylerviewwithmultiselectioncheckbox;

/**
 * Created by S Soft on 04-Aug-17.
 */

import java.io.Serializable;
public class Employee implements Serializable{
    private String empName;
    private String empComp;
    private String number;
    private boolean isSelected;

    public Employee(String empName, String empComp, String number, boolean isSelected) {
        this.empName = empName;
        this.empComp = empComp;
        this.number = number;
        this.isSelected = isSelected;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpComp() {
        return empComp;
    }

    public void setEmpComp(String empComp) {
        this.empComp = empComp;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
