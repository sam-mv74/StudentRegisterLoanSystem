package menu;


import dto.StudentRegistrationDTO;
import entity.University;
import utility.ApplicationContext;
import utility.SecurityContext;

import java.util.List;

public class EnrollMenu extends MainMenu {
    @Override
    public String getText() {
        return """
                1.SignUp
                2.SignIn
                3.Exit
                """;
    }
    public void chooseAnOption() {
        switch (scanner.nextInt()) {
            case 1 -> singUp();
            case 2 -> signIn();
            case 3 -> System.exit(-1);
            default -> System.out.println("Invalid Input");
        }
    }

    private void signIn() {
        LoginMenu loginMenu = ApplicationContext.getLoginMenu();
        boolean flg = true;
        while (flg) {
            System.out.println("Username:");
            String username = scanner.next();
            System.out.println("Password:");
            String password = scanner.next();
            if (studentService.login(username, password)) {
                flg = false;
                System.out.println("Successfully Logged In");
                System.out.println("----------------------");
                loginMenu.showMenu();
            } else {
                System.out.println("Invalid Username Or Password");
            }
        }
    }

    private void singUp() {
        boolean flg = true;
        while (flg) {
            System.out.println("Please Enter The Requested Information:");
            System.out.println("first name:");
            String firstName = scanner.next();
            System.out.println("last name:");
            String lastName = scanner.next();
            System.out.println("mother's name:");
            String motherName = scanner.next();
            System.out.println("father's name:");
            String fatherName = scanner.next();
            System.out.println("certificate number:");
            String certificateNumber = scanner.next();
            System.out.println("national code:");
            String nationalCode = scanner.next();
            System.out.println("birth date:(yyyy-mm-dd)");
            String birthDate = scanner.next();
            System.out.println("city");
            String cityName = scanner.next();
            System.out.println("married:(y/n)");
            String married = scanner.next();
            System.out.println("student number:");
            String studentNumber = scanner.next();
            System.out.println("university name:");
            String universityName = scanner.next();
            String universityType = getUniversityType();
            System.out.println("entry year:");
            String entryYear = scanner.next();
            String gradeLevel = getGradeLevel();
            System.out.println("inDorm:(y/n)");
            String inDorm = scanner.next();
            University university = new University();
            university.setName(universityName);
            StudentRegistrationDTO studentRegistrationDTO = new StudentRegistrationDTO(firstName, lastName, motherName, fatherName,
                    certificateNumber, nationalCode, birthDate, cityName, married, studentNumber,
                    universityName, universityType, entryYear, gradeLevel, inDorm);
            List<String> results = studentService.registerStudent(studentRegistrationDTO);
            if (results.isEmpty()) {
                System.out.println("Successfully Registered");
                System.out.println("Username: " + SecurityContext.getCurrentStudent().getUsername());
                System.out.println("Password:" + SecurityContext.getCurrentStudent().getPassword());
                System.out.println("----------------------");
                flg = false;
                this.showMenu();
            } else {
                System.out.println(results);
            }
        }
    }

    private String getGradeLevel() {
        String gradeLevel = "";
        boolean flag;
        do {
            flag = false;
            System.out.println("""
                    Grade Level:
                    1.ASSOCIATE
                    2.CONTINUOUS_BA
                    3.DISCONTINUOUS_BA
                    4.CONTINUOUS_MA
                    5.DISCONTINUOUS_MA
                    6.CONTINUOUS_DR
                    7.DISCONTINUOUS_DR
                    8.PROFESSIONAL_DR
                    """);
            int input = scanner.nextInt();
            switch (input) {
                case 1 -> gradeLevel = "ASSOCIATE";
                case 2 -> gradeLevel = "CONTINUOUS_BA";
                case 3 -> gradeLevel = "DISCONTINUOUS_BA";
                case 4 -> gradeLevel = "CONTINUOUS_MA";
                case 5 -> gradeLevel = "DISCONTINUOUS_MA";
                case 6 -> gradeLevel = "CONTINUOUS_DR";
                case 7 -> gradeLevel = "DISCONTINUOUS_DR";
                case 8 -> gradeLevel = "PROFESSIONAL_DR";
                default -> {
                    System.out.println("Invalid Input");
                    flag = true;
                }
            }
        } while (flag);
        return gradeLevel;
    }

    private String getUniversityType() {
        String universityType = "";
        boolean flag;
        do {
            flag = false;
            System.out.println("""
                    University Type:
                    1.DAY_TIME_PUBLIC
                    2.NIGHT_TIME_PUBLIC
                    3.AZAD
                    4.NON_PROFIT
                    5.CAMPUS
                    6.EXCESS_CAPACITY
                    7.PAYAM_NOOR
                    8.APPLIED_SCIENCES
                    """);
            int input = scanner.nextInt();
            switch (input) {
                case 1 -> universityType = "DAY_TIME_PUBLIC";
                case 2 -> universityType = "NIGHT_TIME_PUBLIC";
                case 3 -> universityType = "AZAD";
                case 4 -> universityType = "NON_PROFIT";
                case 5 -> universityType = "CAMPUS";
                case 6 -> universityType = "EXCESS_CAPACITY";
                case 7 -> universityType = "PAYAM_NOOR";
                case 8 -> universityType = "APPLIED_SCIENCES";
                default -> {
                    System.out.println("Invalid Input");
                    flag = true;
                }
            }
        } while (flag);
        return universityType;
    }
}
