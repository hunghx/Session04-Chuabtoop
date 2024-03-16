package ra.entity;

import ra.config.InputMethods;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Lớp nhân viên
public class Employee {
    // fields
    // biến instance - thể hiện
    private int id;
    private String fullName;
    private Date birthday;
    private String address;
    private String phone;
    private float salary;
    private float rate;

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    // Constructor methods - dùng để khởi tạo đối tượng - dùng từ khóa new để goi
    public Employee() {
    }

    public Employee(int id, String fullName, Date birthday, String address, String phone, float salary, float rate) {
        this.id = id;
        this.fullName = fullName;
        this.birthday = birthday;
        this.address = address;
        this.phone = phone;
        this.salary = salary;
        this.rate = rate;
    }

    // các phương thức khác
    // tính bao đong , cac phương thức  getter / setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }


    public void displayData() {
        System.out.printf("Mã NV : %-3s | Tên NV : %-10s | Ngày sinh : %-10s | Địa chỉ : %-10s | SDT : %-11s | Lương CB : %-10s | Hệ số : %-3s \n"
                , id, fullName,sdf.format(birthday),address,phone, salary, rate);
    }

    // các phương thức tự định nghĩa
    // tính lương
    public float calActualSalary(){
        return salary*rate;
    }
    // nhập dữ liệu
    public void inputData(boolean isAdd) throws ParseException { // né lỗi
        // chuyen doi tu String <-> Date sử dụng SimpleDateFormat
        // nhập id
        if (isAdd) {
            System.out.println("Nhập mã nhân viên");
            this.id = InputMethods.getInteger();
        }
        System.out.println("Nhập tên nhân viên");
        this.fullName = InputMethods.getString();
        System.out.println("Nhập ngày sinh nhân viên");
        this.birthday = sdf.parse(InputMethods.getString());
        System.out.println("Nhập địa chỉ nhân viên");
        this.address = InputMethods.getString();
        System.out.println("Nhập sdt nhân viên");
        this.phone = InputMethods.getString();
        System.out.println("Nhập luong cơ bản nhân viên");
        this.salary = InputMethods.getFloat();
        System.out.println("Nhập hệ só lương nhân viên");
        this.rate = InputMethods.getFloat();
    }

}
