package org.example.CommonHelpers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EnvironmentHelper {
    public static String getCurrentGitBranch() {
        try {
            Process process = Runtime.getRuntime().exec("git rev-parse --abbrev-ref HEAD");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            return reader.readLine().trim();
        } catch (Exception e) {
            e.printStackTrace();
            return "development"; // default to dev if there's an issue
        }
    }
}
