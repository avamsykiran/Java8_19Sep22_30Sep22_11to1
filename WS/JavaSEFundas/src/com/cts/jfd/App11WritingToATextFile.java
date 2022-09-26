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

public class App11WritingToATextFile {

	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(System.in);
		List<String> lines = new ArrayList<String>();
		
		System.out.println("Type in the file content ('***' to stop): ");
		
		String line="";
		while(!"***".equals(line)) {
			line = scan.nextLine();
			if(!"***".equals(line)) {
				lines.add(line);
			}
		}
				
		Path filePath = Paths.get("./data.txt");
		
		if(Files.notExists(filePath)) {
			Files.createFile(filePath);
		}
		
		Files.write(filePath, lines, StandardOpenOption.APPEND);
		System.out.println("File saved!");
		scan.close();
	}
}
