package com.cts.jfd;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App12ReadingATextFile {

	public static void main(String[] args) throws IOException {
				
		Path filePath = Paths.get("./data.txt");
		
		if(Files.notExists(filePath)) {
			System.out.println("No such file to read!");
			System.exit(1);
		}
		
		if(Files.isDirectory(filePath)) {
			System.out.println("It appears to be a folder!");
			System.exit(1);
		}
		
		List<String> lines = Files.readAllLines(filePath);
		
		if(lines.isEmpty()) {
			System.out.println("File is empty");
		}else{
			lines.stream().forEach(System.out::println);
		}
	}
}
