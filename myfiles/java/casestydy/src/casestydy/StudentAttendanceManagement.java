package casestydy;

import java.util.Scanner;

public class StudentAttendanceManagement {

    static String[] studentNames = new String[100];
    static String[] studentClasses = new String[100];
    static int[] daysAttended = new int[100];
    static int[] totalDays = new int[100];
    static int studentCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Student Attendance Management System ---");
            System.out.println("1. Add New Student Attendance Record");
            System.out.println("2. Update Attendance Record");
            System.out.println("3. Generate Attendance Report");
            System.out.println("4. Generate Promotion Eligibility Report");
            System.out.println("5. Find Student");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addNewStudentRecord(scanner);
                    break;
                case 2:
                    updateAttendanceRecord(scanner);
                    break;
                case 3:
                    generateAttendanceReport();
                    break;
                case 4:
                    generatePromotionReport();
                    break;
                case 5:
                    findAndDisplayStudent(scanner);
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
        scanner.close();
    }

    // add a new student
    public static void addNewStudentRecord(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter class name: ");
        String className = scanner.nextLine();
        System.out.print("Enter number of days attended: ");
        int attended = scanner.nextInt();
        System.out.print("Enter total number of class days: ");
        int total = scanner.nextInt();

        studentNames[studentCount] = name;
        studentClasses[studentCount] = className;
        daysAttended[studentCount] = attended;
        totalDays[studentCount] = total;
        studentCount++;

        System.out.println("Student record added: " + name + " (" + className + ")");
    }

    // update attendance record
    public static void updateAttendanceRecord(Scanner scanner) {
        System.out.print("Enter student name to update: ");
        String name = scanner.nextLine();

        int index = findStudent(name);
        if (index != -1) {
            System.out.print("Enter new number of days attended: ");
            int newAttended = scanner.nextInt();
            daysAttended[index] = newAttended;
            System.out.println("Attendance updated for: " + name);
        } else {
            System.out.println("Student not found.");
        }
    }

    // generate attendance report for all students
    public static void generateAttendanceReport() {
        System.out.println("\n--- Attendance Report ---");
        for (int i = 0; i < studentCount; i++) {
            System.out.println("Student: " + studentNames[i] + " | Class: " + studentClasses[i]);
            System.out.println("Days Attended: " + daysAttended[i] + "/" + totalDays[i]);
            double percentage = calculateAttendancePercentage(i);
            System.out.printf("Attendance Percentage: %.2f%%\n", percentage);
            if (percentage < 75) {
                System.out.println("  *Does Not Meet Attendance Criteria*");
            }
        }
    }

    // generate promotion eligibility report
    public static void generatePromotionReport() {
        System.out.println("\n--- Promotion Eligibility Report (75% Attendance Required) ---");
        for (int i = 0; i < studentCount; i++) {
            double percentage = calculateAttendancePercentage(i);
            if (percentage >= 75) {
                System.out.println("Student: " + studentNames[i] + " | Class: " + studentClasses[i]);
                System.out.printf("Attendance Percentage: %.2f%% - Eligible for Promotion\n", percentage);
            } else {
                System.out.println("Student: " + studentNames[i] + " | Class: " + studentClasses[i]);
                System.out.printf("Attendance Percentage: %.2f%% - Not Eligible for Promotion\n", percentage);
            }
        }
    }

    // New method to find and display student details
    public static void findAndDisplayStudent(Scanner scanner) {
        System.out.print("Enter student name to search: ");
        String name = scanner.nextLine();

        int index = findStudent(name);
        if (index != -1) {
            System.out.println("Student found!");
            System.out.println("Name: " + studentNames[index]);
            System.out.println("Class: " + studentClasses[index]);
            System.out.println("Days Attended: " + daysAttended[index]);
            System.out.println("Total Class Days: " + totalDays[index]);
            double percentage = calculateAttendancePercentage(index);
            System.out.printf("Attendance Percentage: %.2f%%\n", percentage);
        } else {
            System.out.println("Student not found.");
        }
    }

    // calculate attendance percentage
    public static double calculateAttendancePercentage(int index) {
        return ((double) daysAttended[index] / totalDays[index]) * 100;
    }


    public static int findStudent(String name) {
        for (int i = 0; i < studentCount; i++) {
            if (studentNames[i].equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }
}