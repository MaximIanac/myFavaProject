import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OptionsUnSorted {

    public static Student[] readingFIle() throws IOException {
        Student[] students = new Student[50];


        try {
            FileReader fileReader = new FileReader("C:\\Users\\Макс\\Desktop\\Учеба\\4 семестр\\ASDC\\lab2\\src\\fileUnsorted.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            for(int i = 0; i < students.length; i++) {
                students[i] = new Student();
                students[i].readingFile(bufferedReader);
            }

        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }

        return students;
    }

    public static String sequentialSearch(Student[] students, int target) {
        long startTime = System.nanoTime();
        long endTime;
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getID() == target) {
                endTime = System.nanoTime();
                System.out.println("Time of execution: " + (endTime - startTime)+ " Nano Seconds");
                return students[i].toString();
            }
        }
        endTime = System.nanoTime();
        System.out.println("Time of execution: " + (endTime - startTime)+ " Nano Seconds");
        return "Error"; // если элемент не найден
    }
}