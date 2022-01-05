package entity;

import ui.ScannerFactory;

public class Intern extends Employee implements EmployeeSalary { // lớp Intern kế thừa từ lớp Employee
    private String major;
    private int semester;
    private String universityName;

    public Intern() {
    }

    public Intern(String major, int semester, String universityName) {
        this.major = major;
        this.semester = semester;
        this.universityName = universityName;
    }

    public Intern(String id, String fullName, String birthday, String phone, String email,
            double workingHours, String major, int semester,
            String universityName) {
        super(id, fullName, birthday, phone, email, workingHours);
        this.major = major;
        this.semester = semester;
        this.universityName = universityName;
    }

    // In ra thông tin của nhân viên Intern
    @Override
    public void showInfo() {

        System.out.format("|%-3s|", id);
        System.out.format("%-20s|", fullName);
        System.out.format("%-10s|", birthday);
        System.out.format("%.10s|", phone);
        System.out.format("%-20s|", email);
        System.out.format("%-6s|", Double.toString(Math.round(workingHours * 100.0) / 100.0)); // làm tròn số thập phân
                                                                                               // và chuyển sang kiểu dữ
                                                                                               // liệu String
        System.out.format("%-10s|", major);
        System.out.format("%-3d|", semester);
        System.out.format("%-7s|", universityName);
        System.out.format("%-7s|", Double.toString(Math.round(salary() * 100.0) / 100.0)); // làm tròn số thập phân
                                                                                           // (dùng Math.round ra được
                                                                                           // số int, sau đó chia cho
                                                                                           // 100 để lấy được 2 số thập
                                                                                           // phân phia sau) và chuyển
                                                                                           // sang kiểu dữ liệu String
        System.out.format("%-7s|", Double.toString(Math.round(bonusTimeSalary() * 100.0) / 100.0)); // làm tròn số thập
                                                                                                    // phân và chuyển
                                                                                                    // sang kiểu dữ liệu
                                                                                                    // String
        System.out.format("%-8s|", Double.toString(Math.round(totalSalary() * 100.0) / 100.0)); // làm tròn số thập phân
                                                                                                // và chuyển sang kiểu
                                                                                                // dữ liệu String
        System.out.println(" ");
    }

    // ==================== GET,SET ====================//

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    // ===================================================//

    // Tính lương ban đầu
    @Override
    public double salary() {
        double factor = 1; // hệ số lương cơ bản là 1
        if (semester == 1) { // nếu làm trong 1 học kì
            factor = 0.1; // hệ số lương cơ bản là 0.1
        } else if (semester == 2) {// nếu làm trong 2 học kì
            factor = 0.2;// hệ số lương cơ bản là 0.2
        } else if (semester == 3) {// nếu làm trong 3 học kì
            factor = 0.3;// hệ số lương cơ bản là 0.3
        } else if (semester == 4) {// nếu làm trong 4 học kì
            factor = 0.4;// hệ số lương cơ bản là 0.4
        } else if (semester == 5) {// nếu làm trong 5 học kì
            factor = 0.5;// hệ số lương cơ bản là 0.5
        }
        return basicSalary * factor;// trả về lương cơ bản * hệ số lương
    }

    @Override
    // Tính lương thưởng thêm theo giờ làm
    public double bonusTimeSalary() {
        int allTime = 80; // số giờ làm quy định đối với Intern là 80
        double salaryPerHour = salary() / allTime; // lương mỗi giờ = lương ban đầu chia cho số giờ làm quy định
        if (workingHours > allTime) { // nếu làm nhiều hơn số giờ quy định
            return (workingHours - allTime) * (salaryPerHour); // trả về lương thưởng thêm = số giờ dư * lương mỗi giờ
        } else if (workingHours < allTime) { // nếu làm ít hơn số giờ quy định
            // trả về lương thưởng thêm = - (số giờ dư * lương mỗi giờ)
            return -(allTime - workingHours) * (salaryPerHour);
        }
        return 0;
    }

    @Override
    // Tính tổng lương
    public double totalSalary() {
        return salary() + bonusTimeSalary(); // tổng lương ban đầu + lương thưởng thêm
    }

    @Override
    // Cập nhật lại thông tin của nhân viên Intern
    public void updateInfoOfStaff() {
        var scanner = ScannerFactory.getScanner();
        System.out.print("Major: ");
        String major = scanner.nextLine();
        System.out.print("Semester: ");
        int semester = Integer.parseInt(scanner.nextLine());
        System.out.print("University Name: ");
        String universityName = scanner.nextLine();
        // Set Values
        setMajor(major);
        setSemester(semester);
        setUniversityName(universityName);
    }
}
