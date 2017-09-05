/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orientdbtest.dao;

import com.orientechnologies.orient.core.db.document.ODatabaseDocument;
import com.orientechnologies.orient.core.sql.executor.OResult;
import com.orientechnologies.orient.core.sql.executor.OResultSet;

import java.util.ArrayList;
import java.util.List;
import com.orientdbtest.connection.OrientDBConnection;
import com.orientdbtest.pojo.Student;
import com.orientdbtest.pojo.Subject;

/**
 *
 * @author tobah
 */
public class OrientDao {   

    public static List<Student> getAllStudents() {
        
        List<Student> studentList = new ArrayList<Student>();
        
        String select = "select * from student";
        
        try (ODatabaseDocument db = OrientDBConnection.getConnection()) {
            try (OResultSet rs = db.query(select)) {

                while (rs.hasNext()) {

                    OResult row = rs.next();

                    Student student = new Student();
                    
                    student.setRid((row.getProperty("@rid")).toString());
                    student.setName((String) row.getProperty("name"));
                    student.setSurname((String) row.getProperty("surname"));

                    System.out.println("\nRID: " + student.getRid().toString());
                    System.out.println("Name: " + student.getName());
                    System.out.println("Surname: " + student.getSurname());

                    studentList.add(student);

                }
                System.out.println("\nStudent List: " + studentList.size());
            }
        }

        return studentList;
    }

    public static List<Subject> getAllSubjects() {
        
        List<Subject> subjectList = new ArrayList<Subject>();

        String select = "select * from subject";

        try (ODatabaseDocument db = OrientDBConnection.getConnection()) {
            try (OResultSet rs = db.query(select)) {

                while (rs.hasNext()) {

                    OResult row = rs.next();

                    Subject subject = new Subject();

                    subject.setRid(row.getProperty("@rid").toString());
                    subject.setTitle((String) row.getProperty("title"));
                    subject.setPercentageScore((int) row.getProperty("percentageScore"));

                    System.out.println("\nRID: " + subject.getRid());
                    System.out.println("Title: " + subject.getTitle());
                    System.out.println("Percentage Score: " + subject.getPercentageScore());

                    subjectList.add(subject);

                }
                System.out.println("\nSubject List: " + subjectList.size());
            }
        }

        return subjectList;
    }
    
    public static Subject getSubject(String id){
        List<Subject> subject = getAllSubjects();
        for(Subject sub : subject){
            if(sub.getRid().equalsIgnoreCase(id)){
                return sub;
            }
        }
        
        return null;
    }
    
    public static Student getStudent(String id){
        List<Student> student = getAllStudents();
        for(Student stud : student){
            if(stud.getRid().equalsIgnoreCase(id)){
                return stud;
            }
        }
        
        return null;
    }
    
    public static String addStudent(String name, String surname){
        
        String sql 
                = "insert into Student content { name: ?, surname: ? }";
        
        OrientDBConnection.getConnection().query(sql, name, surname);
        
        System.out.println("New Student record added");
        
        return "You have Successfully added a new Student record";
    }
    
    public static String addSubject(String title, int percentageScore){
        String sql 
                = "insert into Subject content { name: ?, surname: ? }";
        
        OrientDBConnection.getConnection().query(sql, title, percentageScore);
        
        System.out.println("New Subject record added");
        
        return "You have Successfully added a new Subject ecord";
    }


}
