package ITSOL.StudentGPA;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Student[] students = new Student[100];
    static Subject[] subjects = new Subject[100];
    static MarkSheet[] markSheets = new MarkSheet[100];

    public static void main(String[] args) {
        Management man = new Management();

//        int a[];
//        int[] b = new int[10];
//        a = b;
//        System.out.println(a.length);

        int choose = -1;
        do {
            menu();
            try {
                System.out.println("Lựa chọn của bạn: ");
                choose = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Nhập đúng lựa chọn theo chỉ mục của chức năng!");
                choose = -1;
            }
            switch (choose)
            {
                case 1:
                    man.inputStudents();
                    break;
                case 2:
                    man.showStudents();
                    break;
                case 3:
                    man.inputSubjects();
                    break;
                case 4:
                    man.showSubject();
                    break;
                case 5:
                    students = man.getSts();
                    subjects = man.getSbs();
                    if(subjects != null && students != null)
                    {
                        man.inputMarks(students, subjects);
                        break;
                    }
                    else {
                        break;
                    }
                case 6:
                    students = man.getSts();
                    subjects = man.getSbs();
                    if(subjects != null && students != null)
                    {
                        man.sortByNameStudent();
                        break;
                    }
                    else {
                        break;
                    }
                case 7:
                    students = man.getSts();
                    subjects = man.getSbs();
                    if(subjects != null && students != null)
                    {
                        man.sortBySubName();
                        break;
                    }
                    else {
                        break;
                    }
                case 8:
                    man.writeStudentToFile();
                    man.writeMarkSheetToFile();
                    man.writeSubjectToFile();
                    break;
            }
        } while (choose != 0);
    }
    public static void menu()
    {
        System.out.println("Mời bạn chọn một trong số các chức năng sau");
        System.out.println("1. Nhập danh sách sinh viên mới");
        System.out.println("2. Hiển thị danh sách sinh viên");
        System.out.println("3. Nhập danh sách môn học mới");
        System.out.println("4. Hiển thị danh sách môn học");
        System.out.println("5. Nhập điểm cho mỗi sinh viên");
        System.out.println("6. Sắp xếp bảng điểm theo họ tên Sinh viên");
        System.out.println("7. Sắp xếp bảng điểm theo tên môn học");
        System.out.println("8. Ghi toàn bộ dữ liệu vào File");
        System.out.println("0. Thoát");
    }
}
