package com.test;

import java.util.List;

import com.app.core.Student;
import static utils.StudentCollectionUtils.populateList;

public class TestStudent {

	public static void main(String[] args) {
		
		List<Student> studentList=populateList();
		System.out.println("Student list : ");
		studentList.forEach(s->System.out.println(s));
	}

}
