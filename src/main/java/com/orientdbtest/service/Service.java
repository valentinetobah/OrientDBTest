package com.orientdbtest.service;

import com.google.gson.Gson;
import com.orientdbtest.dao.OrientDao;
import com.orientechnologies.orient.core.id.ORID;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("service")
public class Service {
 
   @GET
   @Path("students")
   @Produces(MediaType.APPLICATION_JSON)
   public String getStudents(){
       String  json = new Gson().toJson(OrientDao.getAllStudents());
       return json;
       
   }
   
   @GET
   @Path("subjects")
   @Produces(MediaType.APPLICATION_JSON)
   public String getSubjects(){
       String  json = new Gson().toJson(OrientDao.getAllSubjects());
       return json;
       
   }
   
   @GET
   @Path("students/{rid}")
   @Produces(MediaType.APPLICATION_JSON)
   public String getStudent(@PathParam("rid") String rid){
       String  json = new Gson().toJson(OrientDao.getStudent(rid));
       return json;
       
   }
   
   @GET
   @Path("subjects/{rid}")
   @Produces(MediaType.APPLICATION_JSON)
   public String getSubject(@PathParam("rid") String rid){
       String  json = new Gson().toJson(OrientDao.getSubject(rid));
       return json;
   }
       
   @POST
   @Path("addsubject/{title}/{percentageScore}")
   @Produces(MediaType.APPLICATION_JSON)
   public String addSubject(@PathParam("title") String title, 
           @PathParam("percentageScore") int percentageScore){
       return OrientDao.addSubject(title, percentageScore);
       
   }
   
   @POST
   @Path("addstudent/{name}/{surname}")
   @Produces(MediaType.APPLICATION_JSON)
   public String addStudent(@PathParam("name") String name, 
           @PathParam("percentageScore") String surname){
       return OrientDao.addStudent(name, surname);
   }
}
