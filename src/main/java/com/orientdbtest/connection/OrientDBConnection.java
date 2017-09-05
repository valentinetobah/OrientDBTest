/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orientdbtest.connection;

import com.orientechnologies.orient.core.db.OrientDB;
import com.orientechnologies.orient.core.db.OrientDBConfig;
import com.orientechnologies.orient.core.db.document.ODatabaseDocument;

/**
 *
 * @author tobah
 */
public class OrientDBConnection {

    public static ODatabaseDocument getConnection() {
        ODatabaseDocument db = null;
        try {
            OrientDB orientDB = new OrientDB("remote:localhost", "root", "root",
                    OrientDBConfig.defaultConfig());
            db = orientDB.open("test", "root", "root");

        } catch (Exception e) {
            System.out.println("e");
        }
        return db;
    }
//    
//     public static ODatabaseSession getConnection1() {
//        ODatabaseSession db = null;
//        try {
//            OrientDB orientDB = new OrientDB("remote:localhost", "root", "root",
//                    OrientDBConfig.defaultConfig());
//            db = orientDB.open("test", "root", "root");
//
//        } catch (Exception e) {
//            System.out.println("e");
//        }
//        return db;
//    }

}
