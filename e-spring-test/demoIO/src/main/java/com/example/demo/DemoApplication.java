package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);

        readURL();
    }

    public static void readURL() {
        URL bbc = null;
        try {
            bbc = new URL("https://www.oracle.com/index.html");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try (BufferedReader in = new BufferedReader(new InputStreamReader(bbc.openStream()))) {
            System.out.println("Loading html....");
            String inputLine = "";
            int counter = 0;

            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
                if (counter++ >= 4) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void connectWithURLConnectionObj() {
        URL myURL = null;
        try {
            myURL = new URL("https://www.bbc.com/");
            // Operations that depend on being connected, like getInputStream, getOutputStream, etc,
            // will implicitly perform the connection, if necessary.
            URLConnection myURLConnection = myURL.openConnection();
            myURLConnection.connect();
            // Now that you've successfully connected to your URL, you can use the URLConnection object to perform
            // actions such as reading from or writing to the connection

			// Reading from a URLConnection instead of reading directly from a URL might be more useful.
			// This is because you can use the URLConnection object for other tasks (like writing to the URL) at the same time.
            URLConnection yc = myURL.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            int counter = 0;

            String inputLine;
            while ((inputLine = in.readLine()) != null){
				System.out.println(inputLine);
				if (counter++ >= 4) {
					break;
				}
			}
            in.close();
        } catch (MalformedURLException e) {
            // new URL() failed
            e.printStackTrace();
        } catch (IOException e) {
            // openConnection() failed
            e.printStackTrace();
        }


    }

}
