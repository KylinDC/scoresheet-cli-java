package main.java.kylindc.model;

import java.util.*;
import java.util.stream.Collectors;

public class Klass {
    private String id;
    private Set<Student> students = new HashSet<>();

    public Klass(String id) {
        this.id = id;
    }

    public Klass(String id, Set<Student> students) {
        new Klass(id);
        this.students = students;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Student getStudentById(String id) {
        for (Student student : students) {
            if (id.equals(student.getId())) {
                return student;
            }
        }
        return null;
    }

    public Set<Student> getStudents() {
        return this.students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public int getStudentsNumber() {
        return students.size();
    }

    public Boolean addStudent(Student student) {
        students.add(student);
        return true;
    }

    public Boolean addStudent(Student[] students) {
        Arrays.stream(students).forEach(e -> addStudent(e));
        return true;
    }

    public Boolean addStudents(Collection<Student> students) {
        students.stream().forEach(e -> addStudent(e));
        return true;
    }

    public Double getClassScoresSum() {
        return students.stream().mapToDouble(e -> e.getScoresSum()).sum();
    }

    public Double getClassScoresSumAverage() {
        return getClassScoresSum() / students.size();
    }

    public Double getClassScoresSumMedian() {
        List<Double> scoresSumList =
                students.stream()
                        .mapToDouble(e -> e.getScoresSum())
                        .boxed()
                        .collect(Collectors.toList());
        Collections.sort(scoresSumList);
        int medianIndex = scoresSumList.size() / 2;
        if (scoresSumList.size() % 2 == 0) {
            return (scoresSumList.get(medianIndex) + scoresSumList.get(medianIndex - 1)) / 2;
        }
        return scoresSumList.get(medianIndex);
    }
}
