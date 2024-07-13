package org.example.alifx.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EnvReader {
    private final Map<String, String> envMap = new HashMap<>();

    public EnvReader(String filePath) {
        loadEnvFile(filePath);
    }

    private void loadEnvFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] keyValue = line.split("=", 2);
                if (keyValue.length == 2) {
                    envMap.put(keyValue[0].trim(), keyValue[1].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String get(String key) {
        return envMap.get(key);
    }
}

