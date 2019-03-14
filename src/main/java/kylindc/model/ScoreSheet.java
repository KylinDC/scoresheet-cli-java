package main.java.kylindc.model;

import main.java.kylindc.model.subject.Subject;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ScoreSheet {
    private Set<Student> students = new HashSet();
    private Klass klass = null;

    public ScoreSheet(Student[] students, Klass klass) {
        this.klass = klass;
        for (Student student : students) {
            this.students.add(student);
        }
    }

    public ScoreSheet(String[] studentIds, Klass klass) {
        this.klass = klass;
        for (String studentId : studentIds) {
            students.add(klass.getStudentById(studentId));
        }
    }

    public String genScoreSheet() {
        return "成绩单\n姓名|数学|语文|英语|编程|平均分|总分\n========================\n"
                + genStuScoresDetails()
                + "\n========================\n全班总分平均数："
                + klass.getClassScoresSumAverage()
                + "\n全班总分中位数："
                + klass.getClassScoresSumMedian();
    }

    private String genStuScoresDetails() {
        String stuScoresDetails = "";
        for (Student student : students) {
            stuScoresDetails = stuScoresDetails + genStuScoresDetail(student) + "\n";
        }
        return stuScoresDetails.trim();
    }

    private String genStuScoresDetail(Student student) {
        Map<String, Subject> subjects = student.getSubjects();
        return student.getName()
                + "|"
                + subjects.get("math").getScore()
                + "|"
                + subjects.get("chinese").getScore()
                + "|"
                + subjects.get("english").getScore()
                + "|"
                + subjects.get("programing").getScore()
                + "|"
                + student.getScoresAverage()
                + "|"
                + student.getScoresSum();
    }
}
