import java.io.BufferedReader;
import java.io.IOException;
import java.util.Formatter;

public class Student {
    private String name;
    private String surname;
    private String faculty;
    private int birth;
    private int entering;
    private int ID;

    public Student() {
        name = "None";
        surname = "None";
        faculty = "None";
        birth = 0;
        entering = 0;
        ID = 0;
    }

    public Student(Student other) {
        name = other.name;
        surname = other.surname;
        faculty = other.faculty;
        birth = other.birth;
        entering = other.entering;
        ID = other.ID;
    }

    public Student clone() {
        return new Student(this);
    }

    public boolean equal(Student other) {
        return (name.equals(other.name) &&
                surname.equals(other.surname) &&
                faculty.equals(other.faculty) &&
                birth == other.birth &&
                entering == other.entering &&
                ID == other.ID);
    }

    public void readingFile(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        String[] fields = line.split(", ");

        name = fields[0];
        surname = fields[1];
        faculty = fields[2];
        birth = Integer.parseInt(fields[3]);
        entering = Integer.parseInt(fields[4]);
        ID = Integer.parseInt(fields[5]);
    }

    public void writeElement() {
        System.out.println(name + ", " +
                           surname + ", " +
                           faculty + ", " +
                           birth + ", " +
                           entering + ", " +
                           ID);
    }

    public void writeTable(Formatter formatter) {
        formatter.format("%-15s %-15s %-15s %-10d %-10d %-4d\n", name, surname, faculty, birth, entering, ID);
    }
}
