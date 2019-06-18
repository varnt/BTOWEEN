package controlller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Arquivo {

	public Arquivo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner diskScanner = null;
		try {
			diskScanner = new Scanner(new java.io.File("C:\\testanto.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(diskScanner.hasNextLine()) {
			System.out.println(diskScanner.nextLine());
			}
		}

}
