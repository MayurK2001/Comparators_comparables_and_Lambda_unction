package com.spsoftwares;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Mayur", 164, 87));
        students.add(new Student("Aayush", 68, 87));
        students.add(new Student("Aadesh",70,69));
        students.add(new Student("eknath", 89, 67));
        students.add(new Student("Aayush", 150, 60));
        students.sort(new sortByNameThenMarks());
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
               if(o1.getName().equalsIgnoreCase(o2.getName())) {
                    return Integer.compare(o1.getMarks(), o2.getMarks());
                }
               return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
       //  Using Lambda function:
        students.sort((o1, o2) -> {
            if (o1.getName().equalsIgnoreCase(o2.getName())) {
                return Integer.compare(o1.getMarks(), o2.getMarks());
            }
            return o1.getName().compareToIgnoreCase(o2.getName());
        });
        Collections.sort(students);
        students.forEach(System.out::println);
    }
}
class Student implements Comparable<Student>
{
    private final String name;
    private final int rollNo;
    private final int marks;
    public Student(String name, int rollNo, int marks){
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public int getMarks() {
        return marks;
    }

   @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNo=" + rollNo +
                ", marks=" + marks +
                '}';
    }
    @Override
    public int compareTo(Student obj) {
//       if(this.marks > obj.marks){
//           return 1;
//       }
//       else if(this.marks < obj.marks){
//           return -1;
//       }
//       else return 0;
        int c = Integer.compare(obj.marks , this.marks);
        if(c != 0){
            return c;
        }
        return -Integer.compare(obj.rollNo, this.rollNo);
    }
}
class sortByNameThenMarks implements Comparator<Student>{
    public int compare(Student a, Student b){
        if(a.getName().equalsIgnoreCase(b.getName())){
            return Integer.compare(a.getMarks(),b.getMarks());
        }
        return a.getName().compareToIgnoreCase(b.getName());
    }
}