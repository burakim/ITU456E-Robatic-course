package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by BurakMac on 22/12/15.
 */
public class ProcessManager {
    private ProcessBuilder processBuilder;

    public ProcessManager()
    {
        processBuilder = new ProcessBuilder("./raci.sh");


    }

    public void startProcess() throws IOException
    {
        Process process = processBuilder.start();
        String line;
        BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
        while ((line = input.readLine()) != null) {
            System.out.println(line);
        }
        input.close();
    }
}
