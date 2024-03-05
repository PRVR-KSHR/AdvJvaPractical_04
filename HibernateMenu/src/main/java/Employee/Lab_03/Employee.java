package Employee.Lab_03;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private long phone;
    private String addr;

    public Employee() {
        super();
    }

    public Employee(int id, String name, double salary, long phone, String addr) {
        super();
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.phone = phone;
        this.addr = addr;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", phone=" + phone + ", addr=" + addr
                + "]";
    }
}
