import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Student s = new Student("Xiao Ming", 12, 89);
        s.getsco();
    }
}

class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Student extends Person {
    protected int sco;

    public Student(String name, int age, int score) {
    	super(name, age); 
        this.sco = score;
    }
    
    public void getsco(){
    	System.out.println(sco);
    }
}
