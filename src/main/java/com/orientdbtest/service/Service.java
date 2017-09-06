package com.orientdbtest.service;

import com.google.gson.Gson;
import com.orientdbtest.dao.OrientDao;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("service")
public class Service {

    @GET
    @Path("student")
    @Produces(MediaType.APPLICATION_JSON)
    public String getStudent(@QueryParam("rid") String rid) {
        
        String json;
        String rid1 = "#" + rid;
        
        if (rid1 == null) {
            
            json = new Gson().toJson(OrientDao.getAllStudents());
            
            return json;
            
        } else {
            
            json = new Gson().toJson(OrientDao.getStudent(rid1));
            
            return json;
        }
    }

    @GET
    @Path("subject")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSubject(@QueryParam("rid") String rid) {
        
        String json;
        String rid1 = "#" + rid;
        
        if (rid1 == null) {
            
            json = new Gson().toJson(OrientDao.getAllSubjects());
            
        return json;
        
        } else {
            
            json = new Gson().toJson(OrientDao.getSubject(rid1));
            
            return json;
        }
    }

    @POST
    @Path("addsubject")
    @Produces(MediaType.APPLICATION_JSON)
    public String addSubject(@QueryParam("title") String title,
            @QueryParam("percentageScore") int percentageScore) {
        
        String json = new Gson()
                .toJson(OrientDao.addSubject(title, percentageScore));
        
        if (json != null) {
            
            return json;
        }
        
        return "No record was added";

    }

    @POST
    @Path("addstudent")
    @Produces(MediaType.APPLICATION_JSON)
    public String addStudent(@QueryParam("name") String name,
            @QueryParam("surname") String surname) {
        
        String json = new Gson().toJson(OrientDao.addStudent(name, surname));
        
        if (json != null) {
            
            return json;
        }
        
        return "No record was added";
    }

    @PUT
    @Path("updatestudent")
    @Produces(MediaType.APPLICATION_JSON)
    public String updateStudent(@QueryParam("rid") String rid,
            @QueryParam("name") String name, @QueryParam("surname") String surname) {
        
        String rid1 = "#" + rid;
        
        if (rid1 != null) {
            
            if (name != null) {
                
                String json = new Gson()
                        .toJson(OrientDao.updateStudentName(rid1, name));
                
                return json;
            }
            if (surname != null) {
                
                String json = new Gson()
                        .toJson(OrientDao.updateStudentSurname(rid1, surname));
                
                return json;
            }
        }

        return null;
    }

    @PUT
    @Path("updatesubject")
    @Produces(MediaType.APPLICATION_JSON)
    public String updateSubject(@QueryParam("rid") String rid,
            @QueryParam("title") String title,
            @QueryParam("score") String score) {
        
        String rid1 = "#" + rid;
        
        if (rid1 != null) {
            
            if (title != null) {
                
                String json = new Gson()
                        .toJson(OrientDao.updateSubjectTitle(rid1, title));
                
                return json;
            }
            if (score != null) {
                
                int score1 = Integer.parseInt(score);
                
                String json = new Gson()
                        .toJson(OrientDao.updateSubjectScore(rid1, score1));
                
                return json;
            }
        }

        return null;
    }

    @DELETE
    @Path("deletesubject")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteSubject(@QueryParam("rid") String rid) {

        return OrientDao.deleteSubjectById("#" + rid);
    }

    @DELETE
    @Path("deletestudent")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteStudent(@QueryParam("rid") String rid) {

        return OrientDao.deleteStudentById("#" + rid);
    }
}
