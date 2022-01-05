package entity;

import ui.ScannerFactory;

public class Experience extends Employee implements EmployeeSalary { // lớp Experience kế thừa từ lớp Employee
    private int yearOfExperience;
    private String proSkill;

    public Experience() {
    }

    public Experience(int yearOfExperience, String proSkill) {
        this.yearOfExperience = yearOfExperience;
        this.proSkill = proSkill;
    }

    public Experience(String id, String fullName, String birthday, String phone, String email,
            double workingHours, int yearOfExperience, String proSkill) {
        super(id, fullName, birthday, phone, email, workingHours);
        this.yearOfExperience = yearOfExperience;
        this.proSkill = proSkill;
    }

    @Override
    public void showInfo() {
        System.out.format("|%-3s|", id);
        System.out.format("%-20s|", fullName);
        System.out.format("%-10s|", birthday);
        System.out.format("%.10s|", phone);
        System.out.format("%-20s|", email);
        System.out.format("%-6s|", Double.toString(Math.round(workingHours * 100.0) / 100.0));
        System.out.format("%-2s |", yearOfExperience);
        System.out.format("%-10s|", proSkill);
        System.out.format("%-7s|", Double.toString(Math.round(salary() * 100.0) / 100.0));
        System.out.format("%-8s|", Double.toString(Math.round(bonusTimeSalary() * 100.0) / 100.0));
        System.out.format("%-8s|", Double.toString(Math.round(totalSalary() * 100.0) / 100.0));
        System.out.println(" ");
    }

    // ==================== GET,SET ====================//
    public int getYearOfExperience() {
        return yearOfExperience;
    }

    public void setYearOfExperience(int yearOfExperience) {
        this.yearOfExperience = yearOfExperience;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    // ===================================================//
    @Override
    // Tính lương ban đầu cho nhân viên
    public double salary() {
        double factor = 1;
        if (yearOfExperience >= 1 & yearOfExperience < 2) { // Có 1 năm kinh nghiệm
            factor = 1;
        } else if (yearOfExperience >= 2 & yearOfExperience < 4) { // Có từ 2 đến 3 năm kinh nghiệm
            factor = 1.5;
        } else if (yearOfExperience >= 4 & yearOfExperience < 6) {// Có từ 4 đến 5 năm kinh nghiệm
            factor = 2;
        } else if (yearOfExperience >= 6 & yearOfExperience < 8) { // Có từ 6 đến 7 năm kinh nghiệm
            factor = 2.5;
        } else if (yearOfExperience >= 8 & yearOfExperience < 10) { // Có từ 8 đến 9 năm kinh nghiệm
            factor = 3.5;
        } else if (yearOfExperience >= 10 & yearOfExperience < 12) { // Có từ 10 đến 11 năm kinh nghiệm
            factor = 4;
        } else if (yearOfExperience >= 12 & yearOfExperience < 14) { // Có từ 12 đến 13 năm kinh nghiệm
            factor = 4.5;
        } else if (yearOfExperience >= 14) { // Có từ 14 năm kinh nghiệm trở lên
            factor = 5;
        } else {
            factor = 0.5;
        }

        if (proSkill.equals("A") || proSkill.equals("a")) { // Có kĩ năng là A
            factor += 2.5;
        } else if (proSkill.equals("B") || proSkill.equals("b")) { // Có kĩ năng là B
            factor += 2;
        } else if (proSkill.equals("C") || proSkill.equals("c")) { // Có kĩ năng là C
            factor += 1.5;
        } else if (proSkill.equals("D") || proSkill.equals("d")) { // Có kĩ năng là D
            factor += 1;
        } else
            factor += 0.5;

        return basicSalary * factor;
    }

    @Override
    // Tính thêm lương thưởng cho nhân viên làm thêm giờ
    public double bonusTimeSalary() {
        int allTime = 140; // Giờ làm quy định của nhân viên Experience là 140h
        double salaryPerHour = salary() / allTime;

        if (workingHours > allTime) { // Trường hợp nhân viên làm nhiều hơn 140h sẽ được thưởng thêm lương
            return (workingHours - allTime) * (salaryPerHour);
        } else if (workingHours < allTime) { // Trường hợp nhân viên làm ít hơn 140h sẽ bị trừ lương
            return -(allTime - workingHours) * (salaryPerHour);
        }
        return 0;
    }

    @Override
    // Tính tổng lương nhân viên
    public double totalSalary() {
        return salary() + bonusTimeSalary(); // Tổng lương = lương ban đầu + lương thưởng
    }

    @Override
    // Cập nhật lại thông tin của nhân viên Experience
    public void updateInfoOfStaff() {
        var scanner = ScannerFactory.getScanner();
        System.out.print("Year Of Experience: ");
        int yearOfExperience = Integer.parseInt(scanner.nextLine());
        System.out.print("Pro Skill: ");
        String proSkill = scanner.nextLine();

        setYearOfExperience(yearOfExperience);
        setProSkill(proSkill);
    }
}
