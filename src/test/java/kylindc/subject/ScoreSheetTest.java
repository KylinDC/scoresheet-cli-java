package test.java.kylindc.subject;

import main.java.kylindc.model.Klass;
import main.java.kylindc.model.ScoreSheet;
import main.java.kylindc.model.Student;
import main.java.kylindc.model.subject.Chinese;
import main.java.kylindc.model.subject.English;
import main.java.kylindc.model.subject.Math;
import main.java.kylindc.model.subject.Programing;
import main.java.kylindc.service.Parser;

public class ScoreSheetTest {
    public static void main(String[] args) {
        Student zhang = new Student("01", "张三");
        zhang.addSubject(new English(90));
        zhang.addSubject(new Chinese(90));
        zhang.addSubject(new Programing(80));
        zhang.addSubject(new Math(85));
        Student li = new Student("02", "李四");
        li.addSubject(new English(90));
        li.addSubject(new Chinese(80));
        li.addSubject(new Programing(75));
        li.addSubject(new Math(85));
        String[] studentIds = {"01", "02"};
        Klass klass = new Klass("01");
        klass.addStudent(zhang);
        klass.addStudent(li);
        ScoreSheet scoreSheet = new ScoreSheet(studentIds, klass);
        System.out.println(scoreSheet.genScoreSheet());
        System.out.println(klass.getStudentsByIds(studentIds));
        System.out.println(Parser.genStudentsByIds("01,02", klass));
    }
}
