package entity;

import ui.ScannerFactory;

public class Fresher extends Employee implements EmployeeSalary { // lớp Fresher kế thừa từ lớp Employee
    private String graduationDate;
    private String graduationRank;
    private String universityName;

    public Fresher() {
    }

    public Fresher(String graduationDate, String graduationRank, String universityName) {
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.universityName = universityName;
    }

    public Fresher(String id, String fullName, String birthday, String phone, String email,
            double workingHours, String graduationDate, String graduationRank, String universityName) {
        super(id, fullName, birthday, phone, email, workingHours);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.universityName = universityName;
    }

    @Override
    public void showInfo() {
        System.out.format("|%-3s|", id);
        System.out.format("%-20s|", fullName);
        System.out.format("%-10s|", birthday);
        System.out.format("%.10s|", phone);
        System.out.format("%-20s|", email);
        System.out.format("%-6s|", Double.toString(Math.round(workingHours * 100.0) / 100.0));
        System.out.format("%-10s |", graduationDate);
        System.out.format("  %-2s   |", graduationRank);
        System.out.format("%-7s|", universityName);
        System.out.format("%-7s|", Double.toString(Math.round(salary() * 100.0) / 100.0));
        System.out.format("%-7s|", Double.toString(Math.round(bonusTimeSalary() * 100.0) / 100.0));
        System.out.format("%-7s|", Double.toString(Math.round(totalSalary() * 100.0) / 100.0));
        System.out.println(" ");
    }

    // ==================== GET,SET ====================//

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return universityName;
    }

    public void setEducation(String education) {
        this.universityName = education;
    }

    // ===================================================//

    @Override
    public double salary() {
        double factor = 1;
        if (graduationRank.equals("A") || graduationRank.equals("a")) {
            factor = 1;
        } else if (graduationRank.equals("B") || graduationRank.equals("b")) {
            factor = 0.8;
        } else if (graduationRank.equals("C") || graduationRank.equals("c")) {
            factor = 0.6;
        } else if (graduationRank.equals("D") || graduationRank.equals("d")) {
            factor = 0.4;
        } else
            factor = 0.2;

        return basicSalary * factor;
    }

    // Tính lương thưởng thêm theo giờ làm
    @Override
    public double bonusTimeSalary() {
        int allTime = 140; // số giờ làm quy định đối với Fresher là 140h
        double salaryPerHour = salary() / allTime;
        if (workingHours > allTime) {
            return (workingHours - allTime) * (salaryPerHour);
        } else if (workingHours < allTime) {
            return -(allTime - workingHours) * (salaryPerHour);
        }
        return 0;
    }

    @Override
    // Tính tổng lương
    public double totalSalary() {
        return salary() + bonusTimeSalary();
    }

    @Override
    // Cập nhật lại thông tin nhân viên Fresher
    public void updateInfoOfStaff() {
        var scanner = ScannerFactory.getScanner();
        System.out.print("Graduation Date: ");
        String graduationDate = scanner.nextLine();
        System.out.print("Graduation Rank: ");
        String graduationRank = scanner.nextLine();
        System.out.print("University Name: ");
        String universityName = scanner.nextLine();

        setGraduationDate(graduationDate);
        setGraduationRank(graduationRank);
        setEducation(universityName);
    }
}
