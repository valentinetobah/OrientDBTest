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
import com.orientechnologies.orient.core.id.ORecordId;

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

                    studentList.add(student);

                }
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

                    subjectList.add(subject);

                }
            }
        }

        return subjectList;
    }

    public static Subject getSubject(String rid) {
        
        List<Subject> subject = getAllSubjects();
        
        for (Subject sub : subject) {
            
            if (sub.getRid().equalsIgnoreCase(rid)) {
                
                return sub;
            }
        }

        return null;
    }

    public static Student getStudent(String rid) {
        
        List<Student> student = getAllStudents();
        
        for (Student stud : student) {
            
            if (stud.getRid().equalsIgnoreCase(rid)) {
                
                return stud;
            }
        }

        return null;
    }

    public static Student addStudent(String name, String surname) {

        String sql
                = "insert into Student content { name: ?, surname: ? }";

        try (ODatabaseDocument db = OrientDBConnection.getConnection()) {

            try (OResultSet rs = db.query(sql, name, surname)) {

                while (rs.hasNext()) {

                    OResult row = rs.next();

                    Student student = new Student();

                    student.setRid((row.getProperty("@rid")).toString());
                    student.setName((String) row.getProperty("name"));
                    student.setSurname((String) row.getProperty("surname"));

                    return student;

                }
            }
        }

        return null;
    }

    public static Subject addSubject(String title, int percentageScore) {
        String sql
                = "insert into Subject content { title: ?, percentageScore: ? }";

        try (ODatabaseDocument db = OrientDBConnection.getConnection()) {

            try (OResultSet rs = db.query(sql, title, percentageScore)) {

                while (rs.hasNext()) {

                    OResult row = rs.next();

                    Subject subject = new Subject();

                    subject.setRid(row.getProperty("@rid").toString());
                    subject.setTitle((String) row.getProperty("title"));
                    subject.setPercentageScore((int) row.getProperty("percentageScore"));

                    return subject;
                }
            }
        }

        return null;
    }

    public static Student updateStudentName(String rid, String name) {

        String sql = "select from Student where @rid = ?";

        ORecordId orid = new ORecordId(rid);

        try (ODatabaseDocument db = OrientDBConnection.getConnection()) {

            try (OResultSet rs = db.query(sql, orid)) {

                while (rs.hasNext()) {

                    OResult row = rs.next();

                    row.getVertex().ifPresent(x -> {
                        x.setProperty("name", name);
                        x.save();
                    });
                    
                    Student student = new Student();

                    student.setRid((row.getProperty("@rid")).toString());
                    student.setName((String) row.getProperty("name"));
                    student.setSurname((String) row.getProperty("surname"));

                    return student;

                }
            }

        }
        return null;
    }

    public static Student updateStudentSurname(String rid, String surname) {

        String sql = "select from Student where @rid = ?";

        ORecordId orid = new ORecordId(rid);

        try (ODatabaseDocument db = OrientDBConnection.getConnection()) {

            try (OResultSet rs = db.query(sql, orid)) {

                while (rs.hasNext()) {

                    OResult row = rs.next();
                    
                    row.getVertex().ifPresent(x -> {
                        x.setProperty("surname", surname);
                        x.save();
                    });

                    Student student = new Student();

                    student.setRid((row.getProperty("@rid")).toString());
                    student.setName((String) row.getProperty("name"));
                    student.setSurname((String) row.getProperty("surname"));

                    return student;

                }
            }

        }
        return null;
    }

    public static Subject updateSubjectTitle(String rid, String title) {

        String sql = "select from Subject where @rid = ?";

        ORecordId orid = new ORecordId(rid);

        try (ODatabaseDocument db = OrientDBConnection.getConnection()) {

            try (OResultSet rs = db.query(sql, orid)) {

                while (rs.hasNext()) {

                    OResult row = rs.next();
                    
                    row.getVertex().ifPresent(x -> {
                        x.setProperty("title", title);
                        x.save();
                    });

                    Subject subject = new Subject();

                    subject.setRid(row.getProperty("@rid").toString());
                    subject.setTitle((String) row.getProperty("title"));
                    subject.setPercentageScore((int) row.getProperty("percentageScore"));

                    return subject;
                }
            }
        }

        return null;
    }

    public static Subject updateSubjectScore(String rid, int score) {

        String sql = "select from Subject where @rid = ?";

        ORecordId orid = new ORecordId(rid);

        try (ODatabaseDocument db = OrientDBConnection.getConnection()) {

            try (OResultSet rs = db.query(sql, orid)) {

                while (rs.hasNext()) {

                    OResult row = rs.next();
                    
                    row.getVertex().ifPresent(x -> {
                        x.setProperty("percentageScore", score);
                        x.save();
                    });

                    Subject subject = new Subject();

                    subject.setRid(row.getProperty("@rid").toString());
                    subject.setTitle((String) row.getProperty("title"));
                    subject.setPercentageScore((int) row.getProperty("percentageScore"));

                    return subject;
                }
            }
        }

        return null;
    }

    public static String deleteStudentById(String rid) {

        String sql = "delete vertex Student where @rid = ?";

        ORecordId orid = new ORecordId(rid);

        try (ODatabaseDocument db = OrientDBConnection.getConnection()) {
            
            db.query(sql, orid);

            System.out.println("Student record successfully deleted");

            return "Student record with RID = " + rid + " has been successfully deleted";
        }

    }

    public static String deleteSubjectById(String rid) {

        String sql = "delete vertex Subject where @rid = ?";

        ORecordId orid = new ORecordId(rid);

        try (ODatabaseDocument db = OrientDBConnection.getConnection()) {
            
            db.query(sql, orid);

            System.out.println("Subject record successfully deleted");

            return "Subject record with RID = " + rid + " has been successfully deleted";
        }

    }

}
