/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jazdev.outagelogger;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Program starts here
 * @author JazDev
 */
public class App {
    /**
     * 
     * @param args command line arguments (unused)
     */
    public static void main(String[] args) {
        OuttageLogger oL = null;
        
        try {
            final InetAddress host = InetAddress.getByName("google.com");
            oL = new OuttageLogger(host);
        } catch (UnknownHostException e) {
            System.err.println(e);
        }
        
        while(oL != null) {
            oL.checkConnection();
        }
    }
}
