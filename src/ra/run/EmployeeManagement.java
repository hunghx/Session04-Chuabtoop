package ra.run;

import ra.config.InputMethods;
import ra.entity.Employee;

import java.text.ParseException;
import java.util.Scanner;

public class EmployeeManagement {
    private static Employee[] employees = new Employee[0];
//    private static int size = 0;// số luong nhân vien ban dau = 0
//    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws ParseException {
        while (true) {
            // hiển thị menu
            System.out.println("\n" +
                    "*********************MENU********************** \n" +
                    "1.\tThêm mới 1 nhân viên \n" +
                    "2.\tHiển thị danh sách thông tin nhân viên \n" +
                    "3.\tXem thông tin nhân viên theo mã nhân viên\n" +
                    "4.\tCập nhật thông tin nhân viên\n" +
                    "5.\tXóa nhân viên\n" +
                    "6.\tTìm kiếm nhân viên theo tên (tương đối)\n" +
                    "7.\tSắp xếp và hiển thị danh sách nhân viên theo tên từ a - z\n" +
                    "8.\tThoát\n");
            // yêu ầu nhập vào
            System.out.println("nhạp chưc năng");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    addNewEmployee();
                    break;
                case 2:
                    displayEmployee();
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:
                    System.out.println("Thoat chuong trinh");
                    return; // dừng hàm main
                default:
                    System.err.println("nhap khong hop le, nhap lai");
            }
        }

    }
    // thêm mới
    protected static void addNewEmployee() throws ParseException { // dùng chung vùng nhớ tĩnh
        //nhap so luong muon them
        System.out.println("nhap so luong nhan vien muốn thêm");
        int count = InputMethods.getInteger();
        // nới rộng mảng thêm count phần tử
        Employee[] newEmployee = new Employee[employees.length+count];
        // sao chép mảng cũ sang mảng mới
        for (int i = 0; i < employees.length; i++) {
            newEmployee[i] = employees[i];
        }
        // duyệt và thêm phần tử từ vị trí length cũ đến length mới - 1
        for (int i = 0; i < count ; i++) {
            System.out.println("Nhập nhân viên thứ "+(i+1));
            // tạo nhân viên mới
            Employee newEm = new Employee();
            // nhập dữ liệu
            newEm.inputData();
            // lưu vào vị trí của mảng
            newEmployee[employees.length+i] = newEm;
        }
        System.out.println("Bạn đã nhập mới "+count+ " nhân viên");
        // cập nhật lại mảng
        employees = newEmployee;
    }
    // hiển thi
    protected static void displayEmployee(){ // dùng chung vùng nhớ tĩnh
        // kiểm tra xem có phân tử hay không
        if (employees.length==0){
            System.err.println("danh sách trống");
            return; // dừng ầm
        }
        System.out.println("Danh sách nhân viên");
        for (Employee e : employees) { // foreach
            e.displayData();
        }
    }
    // tim kiếm theo mã nhân viên
//    protected static void addNewEmployee(){ // dùng chung vùng nhớ tĩnh
//
//    }
//    // cạp nhật
//    protected static void addNewEmployee(){ // dùng chung vùng nhớ tĩnh
//
//    }
//    // xóa
//    protected static void addNewEmployee(){ // dùng chung vùng nhớ tĩnh
//
//
//    }
//    // tìm kiếm tương đối
//    protected static void addNewEmployee(){ // dùng chung vùng nhớ tĩnh
//
//    }
//    // sắp xếp
//    protected static void addNewEmployee(){ // dùng chung vùng nhớ tĩnh
//
//    }
}
