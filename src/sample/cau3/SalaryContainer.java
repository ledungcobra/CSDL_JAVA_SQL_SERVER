package sample.cau3;

public class SalaryContainer{
    private int id;
    private int year;
    private float salary;

    public SalaryContainer(int id, int year, float salary) {
        this.id = id;
        this.year = year;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}