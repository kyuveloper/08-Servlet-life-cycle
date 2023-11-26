package com.ohgiraffers.mvc.employee.dto;

public class EmpDeleteDTO {
    /*private String empDelName;

    public EmpDeleteDTO() {
    }

    public EmpDeleteDTO(String empDeleName) {
        this.empDelName = empDeleName;
    }

    public String getEmpDelName() {
        return empDelName;
    }

    public void setEmpDelName(String empDelName) {
        this.empDelName = empDelName;
    }

    @Override
    public String toString() {
        return "EmpDeleteDTO{" +
                "empDelName='" + empDelName + '\'' +
                '}';
    }*/
    private String empDelName;
    private int empDelId;

    public EmpDeleteDTO() {
    }

    public EmpDeleteDTO(String empDelName, int empDelId) {
        this.empDelName = empDelName;
        this.empDelId = empDelId;
    }

    public String getEmpDelName() {
        return empDelName;
    }

    public void setEmpDelName(String empDelName) {
        this.empDelName = empDelName;
    }

    public int getEmpDelId() {
        return empDelId;
    }

    public void setEmpDelId(int empDelId) {
        this.empDelId = empDelId;
    }

    @Override
    public String toString() {
        return "EmpDeleteDTO{" +
                "empDelName='" + empDelName + '\'' +
                ", empDelId=" + empDelId +
                '}';
    }
}
