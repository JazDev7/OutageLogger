package com.jazdev.outagelogger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author JazDev
 */
public class Logger {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  

        final InetAddress host = InetAddress.getByName("google.com");
        while(true) {
            // Check for internet connection every 5 seconds (by pinging host)
            // Log if host cannot be reached
            if(!host.isReachable(5000)) {
                System.out.println("Connection down!");
                BufferedWriter  out = new BufferedWriter (new FileWriter(new File("log.txt"), true), 32768);
                out.write("Outtage noted at: " + formatter.format(new Date()) + "\n");
                out.close();
            } else {
                //System.out.println("Connection up.");
            }
            Thread.sleep(10000);
        }  
    }
}
