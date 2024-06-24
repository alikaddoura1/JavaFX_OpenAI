package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PythonRunner {
	
	public static BufferedReader output;
	
	public static void doIt(String name) {
		// Full path to your Python executable
        String pythonExecutablePath = "/usr/bin/python3";  // Adjust this path according to your system
        String pythonScriptPath = "/Users/alikaddoura/Documents/Script/test.py";
        
        

        // Create a ProcessBuilder to run the Python script
        ProcessBuilder processBuilder = new ProcessBuilder(pythonExecutablePath, pythonScriptPath);
        

        try {
            // Start the process
            Process process = processBuilder.start();
            
            // Write data to the script's standard input
            OutputStreamWriter writer = new OutputStreamWriter(process.getOutputStream());
            writer.write(name);
            writer.flush();
            writer.close();

            // Capture the script's standard output
            BufferedReader stdOutput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            output = stdOutput;
            // Capture the script's error output
            BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            // Print standard output
            String s;
            while ((s = stdOutput.readLine()) != null) {
                System.out.println(s);
            }

        

            // Wait for the process to complete and get the exit code
            int exitCode = process.waitFor();
            System.out.println("Python script exited with code " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
         
	}
	
	
	
	
   
}