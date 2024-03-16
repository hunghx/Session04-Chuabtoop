package ra.run;

import ra.config.InputMethods;
import ra.entity.Employee;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class EmployeeManagement {
    private static Employee[] employees = new Employee[0];

    static {
        employees = new Employee[3];
        try {
            employees[0] = new Employee(1, "Nam", Employee.sdf.parse("1/1/1996"), "HN", "0989476743", 1000000, 2.1f);
            employees[1] = new Employee(2, "Lan", Employee.sdf.parse("11/1/1996"), "HN", "0999384357", 1000000, 2.1f);
            employees[2] = new Employee(3, "Hoàng", Employee.sdf.parse("15/1/1996"), "HN", "0938766373", 1000000, 2.1f);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

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
                    findEmployeeById();
                    break;
                case 4:
                    updateEmployee();
                    break;
                case 5:
                    deleteEmployee();
                    break;
                case 6:
                    searchEmployeeByName();
                    break;
                case 7:
                    sortEmployee();
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
        Employee[] newEmployee = new Employee[employees.length + count];
        // sao chép mảng cũ sang mảng mới
        for (int i = 0; i < employees.length; i++) {
            newEmployee[i] = employees[i];
        }
        // duyệt và thêm phần tử từ vị trí length cũ đến length mới - 1
        for (int i = 0; i < count; i++) {
            System.out.println("Nhập nhân viên thứ " + (i + 1));
            // tạo nhân viên mới
            Employee newEm = new Employee();
            // nhập dữ liệu
            newEm.inputData(true);
            // lưu vào vị trí của mảng
            newEmployee[employees.length + i] = newEm;
        }
        System.out.println("Bạn đã nhập mới " + count + " nhân viên");
        // cập nhật lại mảng
        employees = newEmployee;
    }

    // hiển thi
    protected static void displayEmployee() { // dùng chung vùng nhớ tĩnh
        // kiểm tra xem có phân tử hay không
        if (employees.length == 0) {
            System.err.println("danh sách trống");
            return; // dừng ầm
        }
        System.out.println("Danh sách nhân viên");
        for (Employee e : employees) { // foreach
            e.displayData();
        }
    }

    //     tim kiếm theo mã nhân viên
    protected static void findEmployeeById() { // dùng chung vùng nhớ tĩnh
        System.out.println("Nhập mã nhân viên cần kiểm tra");
        int id = InputMethods.getInteger();
        int index = indexOf(id);
        if (index == -1) {
            // ko timm thay
            System.err.println("Khong tim thay nhan vien phu hơp");
        } else {
            System.out.println("Thông tin nhan vien có id = " + id + " là");
            employees[index].displayData();
        }
    }

    private static int indexOf(int id) { // tìm kiếm vị trí cua nhan viên theo id
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    // cạp nhật
    protected static void updateEmployee() throws ParseException { // dùng chung vùng nhớ tĩnh
//
        System.out.println("Nhập mã nhân viên cần cập nhật");
        int id = InputMethods.getInteger();
        int index = indexOf(id);
        if (index == -1) {
            // ko timm thay
            System.err.println("Khong tim thay nhan vien phu hơp");
        } else {
            System.out.println("Thông tin cũ nhan vien có id = " + id + " là");
            employees[index].displayData();
            System.out.println("Nhập thông tin mới cho nhân viên");
            employees[index].inputData(false);
            System.out.println("cập nhat thanh cong");
        }
    }

    // xóa
    protected static void deleteEmployee() { // dùng chung vùng nhớ tĩnh
        System.out.println("Nhập mã nhân viên cần xóa");
        int id = InputMethods.getInteger();
        int index = indexOf(id);
        if (index == -1) {
            // ko timm thay
            System.err.println("Khong tim thay nhan vien phu hơp");
        } else {
            Employee[] newEmployee = new Employee[employees.length - 1];
//            int indexNew = 0;
//            for (int i = 0; i < employees.length; i++) {
//                if (i!=index){
//                    newEmployee[indexNew++] = employees[i];
//                }
//            }
//            employees  = newEmployee;
            // dich các phan tư sang trâi

            for (int i = index; i < employees.length - 1; i++) {
                employees[i] = employees[i + 1];
            }
            // sao chép mảng sang mảng mới
            for (int i = 0; i < newEmployee.length; i++) {
                newEmployee[i] = employees[i];
            }
            employees = newEmployee;
            System.out.println("đã xóa thanh cong");
        }

    }

    // tìm kiếm tương đối
    protected static void searchEmployeeByName() { // dùng chung vùng nhớ tĩnh
        System.out.println("Nhập tên nhân viên cần tim");
        String name = InputMethods.getString();
        boolean check = false;
        for (Employee e : employees) {
            if (e.getFullName().contains(name)) {
                // hiêển thị
                e.displayData();
                check = true;
            }
        }
        if (!check) {
            System.err.println("khong tim thay ket qua phu hop");
        }
    }

    // sắp xếp
    protected static void sortEmployee() { // dùng chung vùng nhớ tĩnh
//        Employee temp;
//        int i, j;
//
//        boolean swapped = false;
//
//        // lap qua tat ca cac so
//        for (i = 0; i < employees.length - 1; i++) {
//            swapped = false;
//
//            // vong lap thu hai
//            for (j = 0; j < employees.length - 1 - i; j++) {
//
//                // kiem xa xem so ke tiep co nho hon so hien tai hay khong
//                // trao doi cac so.
//                // (Muc dich: lam noi bot (bubble) so lon nhat)
//                if (employees[j].getFullName().compareTo(employees[j + 1].getFullName()) > 0) {
//                    temp = employees[j];
//                    employees[j] = employees[j + 1];
//                    employees[j + 1] = temp;
//
//                    swapped = true;
//
//                }
//            }
//
//            // neu khong can trao doi nua, tuc la
//            // mang da duoc sap xep va thoat khoi vong lap.
//            if (!swapped) {
//                break;
//            }
//
//        }
//        Arrays.sort(employees,(o1, o2) -> o2.getFullName().compareTo(o1.getFullName()));

        // tuổi tăng dần
        Arrays.sort(employees,(o1, o2) ->o2.getBirthday().compareTo(o1.getBirthday()));
        System.out.println("Đa săp xếp xong");
    }
}