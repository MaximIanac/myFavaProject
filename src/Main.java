import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Formatter;

public class Main {
    public static void main(String[] args) {
        Student[] students = new Student[50];

        try {
            FileReader fileReader = new FileReader("C:\\Users\\Макс\\Desktop\\Учеба\\4 семестр\\ASDC\\Lab1\\lab1\\src\\list.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            for(int i = 0; i < students.length; i++) {
                students[i] = new Student();
                students[i].readingFile(bufferedReader);
            }

            Formatter form = new Formatter(System.out);
            for(int i = 0; i < students.length; i++) {
                students[i].writeTable(form);
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}