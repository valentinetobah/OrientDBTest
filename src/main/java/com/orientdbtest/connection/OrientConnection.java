/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orientdbtest.connection;

import com.tinkerpop.blueprints.impls.orient.OrientGraph;
import com.tinkerpop.blueprints.impls.orient.OrientGraphFactory;


/**
 *
 * @author tobah
 */
public class OrientConnection {

    private static OrientConnection orientConnection;
    private static boolean hasObject = false;

    private OrientConnection() {

    }

    public static OrientConnection getInstance() {
        if (hasObject) {
            return orientConnection;
        } else {
            hasObject = true;
            orientConnection = new OrientConnection();
            return orientConnection;
        }

    }

    public OrientGraph getConnectionRemote() {
        OrientGraphFactory ogf = new OrientGraphFactory(
                "remote:localhost/test", "root", "root");
        OrientGraph og = ogf.getTx();

        try {
            //System.out.println("Remote Features = " + og.getFeatures());
        } catch (Exception e) {
            System.out.println("Connection Exception " + e);
            og.shutdown();
        }
        return og;
    }

    public OrientGraph getConnectionLocal() {
        OrientGraphFactory ogf = new OrientGraphFactory(
                "plocal:/home/tobah/orientdb-2.1.3/databases/test");
        OrientGraph og = ogf.getTx();

        try {
            //System.out.println("Local Features = " + og.getFeatures());
        } catch (Exception e) {
            System.out.println("Connection Exception " + e);
            og.shutdown();
        }
        return og;
    }
}