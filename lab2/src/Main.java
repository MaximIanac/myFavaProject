import java.io.IOException;
import java.util.Formatter;

public class Main {
    public static void main(String[] args) throws IOException {
        Student[] studentsSorted;
        Student[] studentsUnSorted;

        studentsSorted = OptionsSorted.readingFIle();
        studentsUnSorted = OptionsUnSorted.readingFIle();

        System.out.println("\nSequential Search (UN_SORTED): ");
        System.out.println(OptionsUnSorted.sequentialSearch(studentsUnSorted, 5));

        System.out.println("\nBinary Search (SORTED): ");
        System.out.println(OptionsSorted.binarySearch(studentsSorted, 5));
        System.out.println("\nInterpolation Search (SORTED): ");
        System.out.println(OptionsSorted.interpolationSearch(studentsSorted, 5));
        System.out.println("\nFibonacci Search (SORTED): ");
        System.out.println(OptionsSorted.fibonacciSearch(studentsSorted, 5));

        Tree tree = new Tree();
        for (Student stud: studentsSorted) {
            tree.insertNode(stud);
        }
        System.out.println("\nBinary tree search:");
        System.out.println(tree.findNodeByID(5));
    }
}