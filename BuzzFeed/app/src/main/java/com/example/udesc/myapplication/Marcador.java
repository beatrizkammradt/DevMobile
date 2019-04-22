package com.example.udesc.myapplication;

import java.util.ArrayList;
import java.util.Collections;

public class Marcador {
    private ArrayList<Integer> teachers;

    public Marcador() {
        teachers = new ArrayList();
        teachers.add(0);
        teachers.add(0);
        teachers.add(0);
        teachers.add(0);
    }

    public void addPoint(int teacher) {
        this.teachers.set(teacher, this.teachers.get(teacher) + 1);
    }

    public int findTeacher(){
        int max = Collections.max(teachers);

        return teachers.indexOf(max);
    }

    public ArrayList<Integer> getTeachers() {
        return teachers;
    }

    public void setList(ArrayList<Integer> lst){
        teachers = lst;
    }
}
