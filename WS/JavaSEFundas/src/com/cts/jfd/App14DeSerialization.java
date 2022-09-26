package com.cts.jfd;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import com.cts.jfd.model.Employee;

public class App14DeSerialization {

	public static void main(String[] args) {

		File file = new File("./data.binary");
		try (FileInputStream fin = new FileInputStream(file); ObjectInputStream oin = new ObjectInputStream(fin)) {
			List<Employee> emps = (List<Employee>) oin.readObject();
			emps.stream().forEach(System.out::println);
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}
}
