package com.dojinyou.javajungsuk.operator;

import java.util.Objects;

public class Student {
    String name;
    String number;
    int birthYear;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return Objects.equals(number, student.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "홍길동";
        s1.number = "1234";
        s1.birthYear = 1995;

        Student s2 = new Student();
        s2.name = "홍길동";
        s2.number = "1234";
        s2.birthYear = 1995;

        if(s1.equals(s2)) {
            System.out.print("s1 == s2");
        } else {
            System.out.print("s1 != s2");
        }

    }
}
