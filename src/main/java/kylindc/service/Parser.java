package main.java.kylindc.service;

import main.java.kylindc.model.Klass;
import main.java.kylindc.model.Student;
import main.java.kylindc.model.subject.Math;
import main.java.kylindc.model.subject.*;

import java.util.*;
import java.util.stream.Collectors;

public class Parser {
    public static Optional<Student> parseStudentInfo(String studentInfo) {
        Student student = null;
        if (isStudentInfoCurrent(studentInfo)) {
            String[] infos = studentInfo.split(",");
            for (String info : infos) {
                info.trim();
            }
            String name = infos[0];
            String id = infos[1];
            student = new Student(name, id);
            Set<Subject> subjects =
                    Arrays.stream(infos)
                            .skip(2)
                            .map(
                                    e -> {
                                        String subjectInfos[] = e.split(":");
                                        return genSubject(
                                                subjectInfos[0].trim(),
                                                Double.parseDouble(subjectInfos[1].trim()));
                                    })
                            .collect(Collectors.toSet());
            student.addSubjects(subjects);
        }
        Optional<Student> optionalStudent = Optional.ofNullable(student);
        return optionalStudent;
    }

    private static Boolean isStudentInfoCurrent(String studentInfo) {
        List<String> subjectNames =
                new ArrayList<>(Arrays.asList("Math", "English", "Chinese", "Programing"));
        return Arrays.stream(studentInfo.split(","))
                .map(e -> e.trim())
                .skip(2)
                .map(e -> e.split(":")[0].trim())
                .allMatch(e -> subjectNames.contains(e));
    }

    private static Subject genSubject(String name, Double score) {
        switch (name) {
            case "Math":
                return new Math(score);
            case "English":
                return new English(score);
            case "Chinese":
                return new Chinese(score);
            case "Programing":
                return new Programing(score);
            default:
                return null;
        }
    }

    public static Set<Student> genStudentsByIds(String ids, Klass klass) {
        String[] idArray = ids.split(",");
        for (String id : idArray) {
            id.trim();
        }
        return klass.getStudentsByIds(idArray);
    }
}
