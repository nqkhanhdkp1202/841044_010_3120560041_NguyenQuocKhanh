
import ui.ScannerFactory;
import ui.UIManager;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        UIManager uiManager = new UIManager();
        Scanner scanner = ScannerFactory.getScanner();
        uiManager.addDatabase();
        while (true) {
            System.out.println("");
            System.out.println("+-----------Employee Management Program------------+");
            System.out.println("|Enter 1: Insert New Employee                      |");
            System.out.println("|Enter 2: Search Employee                          |");
            System.out.println("|Enter 3: Delete Employee                          |");
            System.out.println("|Enter 4: Edit Employee Information                |");
            System.out.println("|Enter 5: Display Employee                         |");
            System.out.println("|Enter 6: Report Manager                           |");
            System.out.println("|Enter 0: Exit                                     |");
            System.out.println("+--------------------------------------------------+");
            System.out.print("Please choose: ");
            String ch = scanner.nextLine();
            switch (ch) {
                case "1": {
                    System.out.print("Enter Type of Employee(0: Experience | 1: Fresher | 2: Intern): ");
                    int type = Integer.parseInt(scanner.nextLine());
                    if (type < 0 && type > 2) {
                        System.out.print("Syntax error!");
                        break;
                    }
                    uiManager.insert(type);
                    break;
                }
                case "2": {
                    System.out.print("Enter ID of Employee want to search: ");
                    String id = ScannerFactory.getScanner().nextLine();
                    uiManager.showByID(id);
                    break;
                }
                case "3": {
                    System.out.print("Enter ID of Employee want to remove:  ");
                    String id = ScannerFactory.getScanner().nextLine();
                    uiManager.delete(id);
                    break;
                }
                case "4": {
                    System.out.print("Enter ID of Employee you want to edit: ");
                    String id = ScannerFactory.getScanner().nextLine();
                    uiManager.update(id);
                    break;
                }
                case "5": {
                    System.out.println("+--------Display Employee---------+");
                    System.out.println("|Enter 1: Display By Experience   |");
                    System.out.println("|Enter 2: Display By Fresher      |");
                    System.out.println("|Enter 3: Display By Intern       |");
                    System.out.println("|Enter 4: Display All Employees   |");
                    System.out.println("|Enter 0: Exit                    |");
                    System.out.println("+---------------------------------+");
                    System.out.print("Please choose: ");
                    String a = scanner.nextLine();
                    switch (a) {
                        case "1": {
                            System.out.println(
                                    "+----------------------------------------------Display All Experience-----------------------------------------------+");
                            System.out.println(
                                    "|id |        Name        | Birthday |  Phone   |       Email        |W.Hour|YOE|ProSkill  |Salary |Bonus   |Total   |");
                            System.out.println(
                                    "+-------------------------------------------------------------------------------------------------------------------+");
                            uiManager.showExperienceEmployee();
                            System.out.println(
                                    "+-------------------------------------------------------------------------------------------------------------------+");
                            break;
                        }
                        case "2": {
                            System.out.println(
                                    "+---------------------------------------------Display All Fresher--------------------------------------------------------------+");
                            System.out.println(
                                    "|id |        Name        | Birthday |  Phone   |       Email        |W.Hour|  GraDate  |GraRank|UniName|Salary | Bonus |Total  |");
                            System.out.println(
                                    "+------------------------------------------------------------------------------------------------------------------------------+");
                            uiManager.showFresherEmployee();
                            System.out.println(
                                    "+------------------------------------------------------------------------------------------------------------------------------+");
                            break;
                        }
                        case "3": {
                            System.out.println(
                                    "+----------------------------------------------Display All Intern----------------------------------------------------------+");
                            System.out.println(
                                    "|id |        Name        | Birthday |  Phone   |       Email        |W.Hour|Major     |Sem|UniName|Salary | Bonus |Total   |");
                            System.out.println(
                                    "+--------------------------------------------------------------------------------------------------------------------------+");
                            uiManager.showInternEmployee();
                            System.out.println(
                                    "+--------------------------------------------------------------------------------------------------------------------------+");
                            break;
                        }
                        case "4": {
                            System.out.println(
                                    "+---------------------------------------------Display All Employees----------------------------------------------------------+");
                            uiManager.showAllEmployee();
                            System.out.println(
                                    "+----------------------------------------------------------------------------------------------------------------------------+");
                            break;
                        }
                        case "0": {
                            break;
                        }
                        default: {
                            System.out.println("Syntax error! Please re-enter!");
                            continue;
                        }
                    }
                    break;
                }
                case "6": {
                    System.out.println("+---------Report Manager--------+");
                    System.out.println("|Enter 1: Report By Increase    |");
                    System.out.println("|Enter 2: Report By Decrease    |");
                    System.out.println("|Enter 3: Report By Id Increase |");
                    System.out.println("|Enter 4: Report By Id Decrease |");
                    System.out.println("|Enter 0: Exit                  |");
                    System.out.println("+-------------------------------+");
                    System.out.print("Please choose: ");
                    String a = scanner.nextLine();
                    switch (a) {
                        case "1": {
                            System.out.println(
                                    "+---------------------------------------------Display All Employees----------------------------------------------------------+");
                            uiManager.SortEmployeeByTotalSalary_MinDownMax();
                            uiManager.showAllEmployee();
                            System.out.println(
                                    "+----------------------------------------------------------------------------------------------------------------------------+");
                            break;
                        }
                        case "2": {
                            System.out.println(
                                    "+---------------------------------------------Display All Employees----------------------------------------------------------+");
                            uiManager.SortEmployeeByTotalSalary_MaxDownMin();
                            uiManager.showAllEmployee();
                            System.out.println(
                                    "+----------------------------------------------------------------------------------------------------------------------------+");
                            break;
                        }
                        case "3": {
                            System.out.println(
                                    "+---------------------------------------------Display All Employees----------------------------------------------------------+");
                            uiManager.SortEmployeeByID_MinDownMax();
                            uiManager.showAllEmployee();
                            System.out.println(
                                    "+----------------------------------------------------------------------------------------------------------------------------+");
                            break;
                        }
                        case "4": {
                            System.out.println(
                                    "+---------------------------------------------Display All Employees----------------------------------------------------------+");
                            uiManager.SortEmployeeByID_MaxDownMin();
                            uiManager.showAllEmployee();
                            System.out.println(
                                    "+----------------------------------------------------------------------------------------------------------------------------+");
                            break;
                        }
                        case "0": {
                            break;
                        }
                        default: {
                            System.out.println("Syntax error! Please re-enter!");
                            continue;
                        }
                    }
                    break;
                }
                case "0": {
                    return;
                }
                default: {
                    System.out.println("Syntax error! Please re-enter!");
                    continue;
                }
            }
        }
    }
}