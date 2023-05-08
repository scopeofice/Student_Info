package com.test;

import static utils.StudentCollectionUtils.populateList;
import static utils.StudentCollectionUtils.populateMap;

import java.util.Map;
import java.util.OptionalDouble;
import java.util.Scanner;

import com.app.core.Student;
import com.app.core.Subject;

public class TestStudentMap {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Map<String,Student> studentMap=populateMap(populateList());
		System.out.println("Stundent Map :");
		studentMap.forEach((k,v)->System.out.println(k+" "+v));
		System.out.println("After sorting");
		
		studentMap.values().stream().sorted((k,v)->((Double)k.getGpa()).compareTo(v.getGpa())).forEach(s->System.out.println(s));
		System.out.println("Dec");
		studentMap.values().stream().sorted((k,v)->((Double)v.getGpa()).compareTo(k.getGpa())).forEach(s->System.out.println(s));
		
		System.out.println("Enter subject : ");	 
		 String sub=sc.next().toUpperCase();
		 Subject newSub=Subject.valueOf(sub);
		 OptionalDouble avg=studentMap.values().stream().filter(s->s.getSubject()==newSub)
		 .mapToDouble(s->s.getGpa()).average();
		
		 if(avg.isPresent()) {
			 System.out.println(avg);
		 }
		 
		 System.out.println("Topper : Harshal");
		OptionalDouble max= studentMap.values().stream().mapToDouble(s->s.getGpa()).max();
		
		studentMap.values().stream().filter(s->s.getGpa()==max.getAsDouble()).forEach(s->System.out.println(s.getName()+" "+max.getAsDouble()));
		
		if(max.isPresent() ) {
			System.out.println(max.getAsDouble());
		}
		System.out.println();
		
		System.out.println("--------------");
		studentMap.values().stream().filter(s->s.getGpa()<7.0).forEach(s->System.out.println(s.getName()));
		
		System.out.println("------------");
		System.out.println("Enter city...");
		
		String city=sc.next();
		
		studentMap.values().stream().filter(s->s.getAddress().getCity().equalsIgnoreCase(city))
		.forEach(s->System.out.println(s.getName()));
		
		
		
		
		
		
		
		 
	}

}
