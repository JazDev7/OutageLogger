package com.jazdev.outagelogger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class will check connection to a specified host, then log the current
 * time and date if said host cannot be reached
 * @author JazDev
 */
public class OuttageLogger {
    private InetAddress host;
    
    public OuttageLogger() {
        host = null;
    }
    
    public OuttageLogger(InetAddress host) {
        this.host = host;
    }
    
    /**
     * This method checks the connection to a given host.  If the host cannot
     * be reached, it will call the logOuttage() method.
     * @param host the internet host to check connection with
     */
    public void checkConnection() {    
        if(host != null) {
            // Check for internet connection every 5 seconds (by pinging host)
            // Log if host cannot be reached
            try {
                if(!host.isReachable(5000)) {
                    System.out.println("Connection down!");
                    logOuttage();

                } else {
                    System.out.println("Connection up.");
                }
                Thread.sleep(10000);
            } catch(InterruptedException | IOException e) {
                System.err.println(e);
            }
        }
    }
    
    /**
     * This method logs the current time and date to a file.
     */
    public void logOuttage() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
        BufferedWriter  out = new BufferedWriter (new FileWriter(new File("log.txt"), true), 32768);
        out.write("Outtage noted at: " + formatter.format(new Date()) + "\n");
        out.close();
    }
}
