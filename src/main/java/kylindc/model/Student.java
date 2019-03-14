package main.java.kylindc.model;

import main.java.kylindc.model.subject.Subject;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Student {
    private String id;
    private String name;
    private Map<String, Subject> subjects = new HashMap<>();

    public Student(String id) {
        this.id = id;
    }

    public Student(String id, String name) {
        this(id);
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Subject> getSubjects() {
        return this.subjects;
    }

    public void setSubjects(Map<String, Subject> subjects) {
        this.subjects = subjects;
    }

    public boolean addSubject(Subject subject) {
        subjects.put(subject.getName(), subject);
        return true;
    }

    public boolean addSubjects(Map<String, Subject> subjects) {
        this.subjects.putAll(subjects);
        return true;
    }

    public boolean addSubjects(Collection<Subject> subjects) {
        subjects.stream().forEach(e -> addSubject(e));
        return true;
    }

    public boolean addSubjects(Subject[] subjects) {
        Arrays.stream(subjects).forEach(e -> addSubject(e));
        return true;
    }

    public double getScoresSum() {
        return subjects.values().stream().mapToDouble(e -> e.getScore()).sum();
    }

    public double getScoresAverage() {
        return getScoresSum() / subjects.size();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            if (this.id.equals(((Student) obj).id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return id + ": " + name;
    }
}
