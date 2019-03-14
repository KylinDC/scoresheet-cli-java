package test.java.kylindc.subject;

import main.java.kylindc.model.Student;
import main.java.kylindc.service.Parser;

import java.util.Optional;

public class ParserTest {
    public static void main(String[] args) {
        String testStuStr = "ni,kkk, Math: 90,English:80";
        Optional<Student> testStu = Parser.parseStudentInfo(testStuStr);
        System.out.println(testStu.get().getSubjects());
    }
}
