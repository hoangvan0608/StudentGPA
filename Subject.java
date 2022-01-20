package ITSOL.StudentGPA;

import java.io.Serializable;
import java.util.Scanner;

public class Subject implements Serializable {
    private static int idTemp = 100;
    private int id;
    private String subName;
    private int subUnit;
    private String subType;

    public Subject nhap(Scanner scanner)
    {
        System.out.println("Nhap ten mon hoc:");
        this.setSubName(scanner.nextLine());
        System.out.println("So don vi hoc trinh");
        this.setSubUnit(scanner.nextInt());
        scanner.nextLine();
        int type = -1;
        try {
                System.out.println("Chon loai sach: ");
                System.out.println("1. Đại cương");
                System.out.println("2. Cơ sở ngành");
                System.out.println("3. Chuyên ngành");
                System.out.print("Lựa chọn: ");
                type = scanner.nextInt(); scanner.nextLine();
                switch (type)
                {
                    case 1:
                        this.setSubType(typeOfSubject(1));
                        break;
                    case 2:
                        this.setSubType(typeOfSubject(2));
                        break;
                    case 3:
                        this.setSubType(typeOfSubject(3));
                        break;
                    default:
                        System.out.println("Chọn sai!");
                        break;
                }

        } catch (Exception e)
        {
            System.out.println("Nhập số!");
        }
        return this;

    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", subName='" + subName + '\'' +
                ", subUnit=" + subUnit +
                ", subType='" + subType + '\'' +
                '}';
    }

    public String typeOfSubject(int n)
    {
        return n==1? "Đại cương" : (n==2? "Cơ sở ngành" : "Chuyên ngành");
    }

    public Subject() {
        this.id = ++idTemp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public int getSubUnit() {
        return subUnit;
    }

    public void setSubUnit(int subUnit) {
        this.subUnit = subUnit;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }
}
