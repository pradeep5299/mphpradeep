package com.mphasis.sorteg;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserial {
	 public static void main(String[] args) {
		Student st = null;
	
			try (FileInputStream fis = new FileInputStream("myfile.txt");
					ObjectInputStream ois = new ObjectInputStream(fis)) {
				st =(Student)ois.readObject();
				fis.close();
				ois.close();
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(st.getSid());
		System.out.println(st.getSname());
		System.out.println(st.getAge());
		System.out.println(st.getMarks());
		
	}
}