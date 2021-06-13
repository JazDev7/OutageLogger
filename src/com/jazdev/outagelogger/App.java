package com.jazdev.outagelogger;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Program starts here
 * @author JazDev
 */
public class App {
    /**
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        OutageLogger oL = null;
        InetAddress host = null;
        
        // Try to ping a specific host, or 'google.com' if none specified
        System.out.println("Checking host...");
        try { 
            if(args.length == 0) {
                host = InetAddress.getByName("google.com");
            } else {
                host = InetAddress.getByName(args[0]);
            }
            oL = new OutageLogger(host);
            System.out.println(host.getHostName() + " host good!");
        } catch (UnknownHostException e) {
            System.err.println(e);
        }

        // Begin logging
        if(oL == null) {
            System.out.println("Failed to initialize OuttageLogger...");
            System.out.println("Program will now exit");
        } else {
            System.out.println("OuttageLogger now monitoring...");
            while(true) {
                oL.checkConnection();
            }
        }
        
    }
}
