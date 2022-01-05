package service;

import entity.Employee;
import entity.Experience;
import entity.Fresher;
import entity.Intern;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.Comparator;

public class EmployeeManager {

    private List<Employee> employees;

    public EmployeeManager() {
        this.employees = new ArrayList<>();
    }

    // Thêm nhân viên
    public void insert(Employee employee) {
        this.employees.add(employee);
    }

    // Tìm theo id
    public Employee findById(String id) {
        return this.employees.stream().filter(employee -> employee.getId().equals(id)).findFirst().orElse(null);
        // dùng stream().filter để tìm kiếm nhân viên theo id bằng biểu thức lambda
    }

    // Xoá theo id
    public boolean deleteById(String id) {
        Employee employee = this.findById(id);
        if (employee == null) {
            return false;
        }
        this.employees.remove(employee);
        return true;
    }

    /**
     * type = 0 => Experience
     * type = 1 => Fresher
     * type = 2 => Intern
     */

    // Tìm kiếm theo loại
    public List<Employee> findByType(int type) {
        return this.employees.stream()
                .filter(employee -> { // hàm tìm kiếm nhân viên duyệt theo list
                    if (type == 0) { // khi giá trị type = 0
                        return employee instanceof Experience; // trả về nhân viên loại Experience
                    } else if (type == 1) { // khi giá trị type = 1
                        return employee instanceof Fresher; // trả về nhân viên loại Fresher
                    } else if (type == 2) { // khi giá trị type = 2
                        return employee instanceof Intern; // trả về nhân viên loại Intern
                    } else
                        return false;
                })
                .collect(Collectors.toList()); // thu thập các giá trị đúng bằng phương thức collect() và lưu vào list
                                               // bằng phương thức tolist()
    }

    public List<Employee> findAll() {
        return this.employees;
    }

    public void sortByTotalSalaryMinDownMax() {
        Collections.sort(employees, new Comparator<Employee>() { // sử dụng thư viện interface có sẵn Collections để sắp
                                                                 // xếp, hàm sẽ sắp xếp khi giá trị trả về là 1
            @Override
            public int compare(Employee o1, Employee o2) { // sử dụng thư viện interface Comparator viết lại hàm so sánh
                return o1.totalSalary() > o2.totalSalary() ? 1 : -1; // nếu nv1 có lương lớn hơn nv2 thì trả về 1 nếu ko
                                                                     // thì trả về -1
            }
        });
    }

    public void sortByTotalSalaryMaxDownMin() {
        Collections.sort(employees, new Comparator<Employee>() { // sử dụng thư viện có sẵn Collections để sắp xếp, hàm
                                                                 // sẽ sắp xếp khi giá trị trả về là 1
            @Override
            public int compare(Employee o1, Employee o2) { // sử dụng thư viện Comparator viết lại hàm so sánh
                return o1.totalSalary() < o2.totalSalary() ? 1 : -1; // nếu nv1 có lương bé hơn nv2 thì trả về 1 nếu ko
                                                                     // thì trả về -1
            }
        });
    }

    public void sortByIDMinDownMax() {
        Collections.sort(employees, new Comparator<Employee>() { // sử dụng thư viện có sẵn Collections để sắp xếp, hàm
                                                                 // sẽ sắp xếp khi giá trị trả về là 1
            @Override
            public int compare(Employee s1, Employee s2) { // sử dụng thư viện Comparator viết lại hàm so sánh
                int id1 = Integer.valueOf(s1.id); // đổi kiểu dữ liệu
                int id2 = Integer.valueOf(s2.id); // đổi kiểu dữ liệu
                if (id1 == id2) // trường hợp trùng id trả về 0
                    return 0;
                else if (id1 > id2) // khi id1 lớn hơn id 2 thì trả về 1
                    return 1;
                else // các trường hợp còn lại trả về 0
                    return -1;
            }
        });
    }

    public void sortByIDMaxDownMin() {
        Collections.sort(employees, new Comparator<Employee>() { // sử dụng thư viện có sẵn Collections để sắp xếp, hàm
                                                                 // sẽ sắp xếp khi giá trị trả về là 1
            @Override
            public int compare(Employee s1, Employee s2) { // sử dụng thư viện Comparator viết lại hàm so sánh
                int id1 = Integer.valueOf(s1.id); // đổi kiểu dữ liệu
                int id2 = Integer.valueOf(s2.id); // đổi kiểu dữ liệu
                if (id1 == id2) // trường hợp trùng id trả về 0
                    return 0;
                else if (id1 < id2) // khi id1 nhỏ hơn id 2 thì trả về 1
                    return 1;
                else // các trường hợp còn lại trả về 0
                    return -1;
            }
        });
    }
}
