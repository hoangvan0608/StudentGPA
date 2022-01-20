package ITSOL.StudentGPA;

import ITSOL.WeekOne.DaHinh_TruuTuong.GiangVien;

import java.io.*;
import java.util.Scanner;

public class Management implements Serializable {
    static Scanner scanner = new Scanner(System.in);
    Student[] sts;
    Subject[] sbs;
    MarkSheet[] msk;
    int[] mark;
    Student[] fileStudent = new Student[10];
    public void inputStudents()
    {
        int quantity = 0;

        try {
            System.out.print("Nhap so sinh vien: ");
            quantity = Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException n)
        {
            try {
                System.out.println("Vui lòng nhập vào số nguyên dương!");
                System.out.print("Nhap so sinh vien: ");
                quantity = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(e);
                System.out.println("Vẫn nhập sai kiểu dữ liệu! Thoát!");
                return;
            }
        }
        sts = new Student[quantity];
        fileStudent = new Student[quantity];
        for (int i = 0; i < quantity; i++) {
            sts[i] = new Student();
            sts[i] = sts[i].nhap(scanner);
        }


    }
    public void showStudents()
    {
        if(sts == null)
            return;
        for (int i = 0; i < sts.length; i++) {
            System.out.println(sts[i].toString());
        }


    }

    public void inputSubjects()
    {
        int quantity = 0;

        try {
            System.out.print("Nhap so mon hoc: ");
            quantity = Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException n)
        {
            try {
                System.out.println("Vui lòng nhập vào số nguyên dương!");
                System.out.print("Nhap so mon hoc: ");
                quantity = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(e);
                System.out.println("Vẫn nhập sai kiểu dữ liệu! Thoát!");
                return;
            }
        }
        sbs = new Subject[quantity];
        for (int i = 0; i < quantity; i++) {
            sbs[i] = new Subject();
            sbs[i] = sbs[i].nhap(scanner);
        }
    }
    public void showSubject()
    {
        if(sbs ==null)
            return;
        for (int i = 0; i < sbs.length; i++) {
            System.out.println(sbs[i].toString());
        }
    }

    public void inputMarks(Student[] students, Subject[] subjects)
    {
        int countStudent = -1, countSubject = -1;
        countStudent = students.length;
        countSubject = subjects.length;
        if(countStudent == 0 || countSubject == 0)
        {
            System.out.println("Nhap thong tin sinh vien va mon hoc truoc!");
        }
        else {
            msk = new MarkSheet[countStudent];
            for (int i = 0; i < countStudent; i++) {
                boolean check = false;
                Student localStudent = students[i];
                System.out.print("Nhap so mon hoc cho sinh vien "+localStudent.getiD()+": ");
                int slMonHoc;
                do {
                    slMonHoc = scanner.nextInt();
                    if (slMonHoc > countSubject) {
                        System.out.print("Nhap qua so luong mon hoc!");
                        check = true;
                    } else if (slMonHoc < 1) {
                        System.out.println("Nhap it nhat mot mon hoc");
                        check = true;
                    } else
                        check = false;
                } while (check);
                Subject localSub[] = new Subject[slMonHoc];
                mark = new int[slMonHoc];
                Subject[] subTemps = new Subject[slMonHoc];
                boolean check1 = true;
                for (int j = 0; j < slMonHoc; j++) {
                    Subject checksub;
                    System.out.println("Nhap ID mon hoc: ");
                    do {
                        int id = scanner.nextInt();
                        checksub = searchForSubject(subjects,id);
                        if(checksub != null)
                        {
                            subTemps[j] = checksub;
                            if(countSubjects(subTemps,id) >1)
                            {
                                System.out.println("Môn học "+id+" đã có! Nhập môn khác!");
                                check1 = true;
                            }
                            else
                            {
                                check1 = false;
                            }
                        }
                        else {
                            System.out.print("Nhap lai id: ");
                            check1 = true;
                        }
                    }while (check1);
                    System.out.println("Nhap diem:");
                    int diem = -1;
                    do {
                        diem = scanner.nextInt();
                        if(diem < 0 || diem > 10)
                            System.out.println("Vui long nhap diem trong doan [0,10] !");
                    }while (diem < 0 || diem > 10);
                    localSub[j] = checksub;
                    System.out.println("===========");
                    mark[j] = diem;

                }
                msk[i] = new MarkSheet(localStudent,localSub,mark);
                msk[i].diemTongKet();
            }
            showMarks();
        }
    }
    public Subject searchForSubject(Subject[] subjects,int name)
    {
        for (int i = 0; i < subjects.length; i++) {
            if(subjects[i].getId() == name)
                return subjects[i];
        }
        return null;
    }
    public int countSubjects(Subject[] subjects,int id)
    {
        int count = 0;
        for (int i = 0; i < subjects.length; i++) {
            if(subjects[i] != null)
            {
                if(subjects[i].getId() == id)
                    count++;
            }

        }
        return count;
    }

    public void showMarks()
    {
        for (int i = 0; i < msk.length; i++) {
            System.out.println(msk[i].toString());
        }
    }
    public void showDiemTongKet()
    {
        for (int i = 0; i < msk.length; i++) {
            String name =msk[i].getStudent().getFullName();
            float diem = msk[i].getDiemTongKet();
            System.out.println(String.format("Sinh viên %s có điểm tổng kết : %f",name,diem));
        }
    }
    public void sortByNameStudent()
    {
        for (int i = 0; i < msk.length -1; i++) {
            for (int j = i+1; j < msk.length; j++) {
                if(msk[i].getStudent().getFullName().compareTo(msk[j].getStudent().getFullName()) > 0)
                {
                    MarkSheet tem = msk[i];
                    msk[i] = msk[j];
                    msk[j] = tem;
                }
            }
        }
        showMarks();
    }
    public void sortBySubName()
    {
        for (int i = 0; i < msk.length; i++) {
            for (int j = 0; j < msk[i].getSubjects().length -1; j++) {
                for (int k = j+1   ; k < msk[i].getSubjects().length; k++) {
                    if(msk[i].getSubjects()[j].getSubName().compareTo(msk[i].getSubjects()[k].getSubName()) > 0)
                    {
                        Subject tem = msk[i].getSubjects()[j];
                        msk[i].getSubjects()[j] = msk[i].getSubjects()[k];
                        msk[i].getSubjects()[k] = tem;
                    }
                }
            }
        }
        showMarks();
    }



    /*
    =========================================
     */

    public void writeStudentToFile()
    {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {

            fos = new FileOutputStream("C:\\Users\\TAV\\IdeaProjects\\BackEnd__T3H\\src\\ITSOL\\StudentGPA\\Student.txt");
            oos = new ObjectOutputStream(fos);
            if(sts == null)
                return;
            for (int i = 0; i < sts.length; i++) {
                oos.writeObject(sts[i]);
            }
            oos.flush();
            System.out.println("Xong!");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void writeSubjectToFile()
    {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {


            fos = new FileOutputStream("C:\\Users\\TAV\\IdeaProjects\\BackEnd__T3H\\src\\ITSOL\\StudentGPA\\Subject.txt");
            oos = new ObjectOutputStream(fos);
            if(sts == null)
                return;
            for (int i = 0; i < sbs.length; i++) {
                oos.writeObject(sbs[i]);
            }
            oos.flush();
            System.out.println("Xong!");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void writeMarkSheetToFile()
    {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {

            fos = new FileOutputStream("C:\\Users\\TAV\\IdeaProjects\\BackEnd__T3H\\src\\ITSOL\\StudentGPA\\MarkSheet.txt");
            oos = new ObjectOutputStream(fos);
            if(sts == null)
                return;
            for (int i = 0; i < msk.length; i++) {
                oos.writeObject(msk[i]);
            }
            oos.flush();
            System.out.println("Xong!");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void readStudentFromFile()
    {
        FileInputStream fi = null;
        ObjectInputStream ois = null;
        try {
            fi = new FileInputStream("..\\Student.txt");
            ois = new  ObjectInputStream(fi);
            int i =0;
            Student stTemp;
            while (true)
            {
                Object oj = ois.readObject();
                if(oj == null)
                    break;
                if(oj != null)
                {
                    stTemp = (Student) oj;
                    stTemp.toString();
                }
            }
            ois.close();
            fi.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /*
    =========================================
     */
    public Student[] getSts() {
        return sts;
    }

    public void setSts(Student[] sts) {
        this.sts = sts;
    }

    public Subject[] getSbs() {
        return sbs;
    }

    public void setSbs(Subject[] sbs) {
        this.sbs = sbs;
    }

    public MarkSheet[] getMsk() {
        return msk;
    }

    public void setMsk(MarkSheet[] msk) {
        this.msk = msk;
    }
}
