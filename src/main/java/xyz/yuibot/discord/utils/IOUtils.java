package xyz.yuibot.discord.utils;

import java.io.*;
import java.util.stream.Collectors;

public class IOUtils {
    public static String readFile(String path) {
        try(FileReader file = new FileReader(path);
            BufferedReader reader = new BufferedReader(file)
        ) {
            return reader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            return null;
        }
    }

}