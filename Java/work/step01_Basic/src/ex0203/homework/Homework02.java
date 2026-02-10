package ex0203.homework;

public class Homework02 {

	public static void main(String[] args) {
		int pencils = 534;
		int students = 30;
		
		int pencilsPerStudent = pencils/students;
		System.out.println(pencilsPerStudent);
		
		int pencilsLeft = pencils - pencilsPerStudent * students;//pencils%students
		System.out.println(pencilsLeft);

	}

}
