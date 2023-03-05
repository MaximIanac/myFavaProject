import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OptionsSorted {

    public static Student[] readingFIle() throws IOException {
        Student[] students = new Student[50];


        try {
            FileReader fileReader = new FileReader("C:\\Users\\Макс\\Desktop\\Учеба\\4 семестр\\ASDC\\lab2\\src\\fileSorted.txt");
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

    public static String binarySearch(Student[] students, int target) {
        long startTime = System.nanoTime();
        long endTime;

        int left = 0;
        int right = students.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (students[mid].getID() == target) {
                endTime = System.nanoTime();
                System.out.println("Time of execution: " + (endTime - startTime)+ " Nano Seconds");
                return students[mid].toString();
            } else if (students[mid].getID() < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        endTime = System.nanoTime();
        System.out.println("Time of execution: " + (endTime - startTime)+ " Nano Seconds");
        return "Error";
    }

    public static String interpolationSearch(Student[] students, int target) {
        long startTime = System.nanoTime();
        long endTime;

        int left = 0;
        int right = students.length - 1;
        while (left <= right && target >= students[left].getID() && target <= students[right].getID()) {
            int pos = left + ((target - students[left].getID()) * (right - left)) / (students[right].getID() - students[left].getID());
            if (students[pos].getID() == target) {
                endTime = System.nanoTime();
                System.out.println("Time of execution: " + (endTime - startTime) + " Nano Seconds");
                return students[pos].toString();
            } else if (students[pos].getID() < target) {
                left = pos + 1;
            } else {
                right = pos - 1;
            }
        }
        endTime = System.nanoTime();
        System.out.println("Time of execution: " + (endTime - startTime) + " Nano Seconds");
        return "Error";
    }

    public static String fibonacciSearch(Student[] students, int target) {
        long startTime = System.nanoTime();
        long endTime;

        int n = students.length;
        int fib2 = 0;
        int fib1 = 1;
        int fib = fib2 + fib1;
        while (fib < n) {
            fib2 = fib1;
            fib1 = fib;
            fib = fib2 + fib1;
        }
        int offset = -1;
        while (fib > 1) {
            int i = Math.min(offset + fib2, n - 1);
            if (students[i].getID() < target) {
                fib = fib1;
                fib1 = fib2;
                fib2 = fib - fib1;
                offset = i;
            } else if (students[i].getID() > target) {
                fib = fib2;
                fib1 = fib1 - fib2;
                fib2 = fib - fib1;
            } else {
                endTime = System.nanoTime();
                System.out.println("Time of execution: " + (endTime - startTime) + " Nano Seconds");
                return students[i].toString();
            }
        }
        if (fib1 == 1 && students[offset + 1].getID() == target) {
            endTime = System.nanoTime();
            System.out.println("Time of execution: " + (endTime - startTime) + " Nano Seconds");
            return students[offset + 1].getName() + " " + students[offset + 1].getSurname();
        }
        endTime = System.nanoTime();
        System.out.println("Time of execution: " + (endTime - startTime) + " Nano Seconds");
        return "Error";
    }
}
