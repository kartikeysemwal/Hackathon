package com.example.myapplication;

public class EmployementFirebase {
    private String company;
    private String salary;
    private String requirements;
    private String join;

    public EmployementFirebase() {
    }

    public EmployementFirebase(String company, String salary, String requirements, String join) {
        this.company = company;
        this.salary = salary;
        this.requirements = requirements;
        this.join = join;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getJoin() {
        return join;
    }

    public void setJoin(String join) {
        this.join = join;
    }

}
