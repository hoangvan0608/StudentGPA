package ITSOL.StudentGPA;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class GenericReadFromFile<T>{
    public T t;

    public void docFile()
    {
        Scanner scanner = new Scanner(System.in);
        T local;
        System.out.println("Nhập vào đường dẫn cần đọc file: ");
        String str = scanner.nextLine().trim();
        File file = new File(str);
        try {
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);
            int i = 0;
            while (true)
            {
                Object oj = ois.readObject();
                if(oj ==null)
                    break;
                else{
                    local = (T) oj;
                    System.out.println(local.toString());
                }
            }
            ois.close();
            is.close();
        }
        catch (Exception e)
        {

        }
    }


    public static void main(String[] args) {
        while (true)
        {
            GenericReadFromFile<Object> sub = new GenericReadFromFile<>();
            sub.docFile();
        }

        //Subject : C:\Users\TAV\IdeaProjects\BackEnd__T3H\src\ITSOL\StudentGPA\Subject.txt
        //Student : C:\Users\TAV\IdeaProjects\BackEnd__T3H\src\ITSOL\StudentGPA\Student.txt
        //MarkSheet : C:\Users\TAV\IdeaProjects\BackEnd__T3H\src\ITSOL\StudentGPA\MarkSheet.txt


    }
}
