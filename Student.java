package ITSOL.StudentGPA;

import java.io.Serializable;
import java.util.Scanner;

public class Student implements Serializable {
    static int idTemp = 10000;
    private int iD;
    private String fullName;
    private String address;
    private String phoneNumber;
    private String clasString;

    public Student nhap(Scanner scanner)
    {
        System.out.println("Ho ten:");
        this.setFullName(scanner.nextLine());
        System.out.println("Dia chi:");
        this.setAddress(scanner.nextLine());
        System.out.println("So dien thoai:");
        this.setPhoneNumber(scanner.nextLine());
        System.out.println("Lop:");
        this.setClasString(scanner.nextLine());
        System.out.println("------");
        return this;
    }

    public Student(int iD, String fullName, String address, String phoneNumber, String clasString) {
        this.iD = iD;
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.clasString = clasString;
    }

    @Override
    public String toString() {
        return "Student{" +
                "iD=" + iD +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", clasString='" + clasString + '\'' +
                '}';
    }

    public Student() {
        this.iD = ++idTemp;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getClasString() {
        return clasString;
    }

    public void setClasString(String clasString) {
        this.clasString = clasString;
    }
}
