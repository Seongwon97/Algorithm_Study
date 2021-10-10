package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class User implements Comparable<User>{
	public String name;
	public int age;
	public int order;
	
	public User(String name, int age, int order) {
		this.name = name;
		this.age = age;
		this.order = order;
	}
	
	@Override
	public int compareTo(User o) {
		if (this.age > o.age) {
			return 1;
		}
		else if (this.age == o.age) {
			return this.order < o.order? -1:1;
		}
		return -1;
	}

}

public class B10814 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int num = Integer.parseInt(sc.nextLine());
		String userInfo;
		String[] ageName = new String[num];
		User user;
		
		ArrayList<User> userList = new ArrayList<>();
		
		for (int i=0; i<num; i++) {
			userInfo = sc.nextLine();
			ageName = userInfo.split(" ");
			user = new User(ageName[1], Integer.parseInt(ageName[0]), i);
			userList.add(user);
		}
		Collections.sort(userList);
		
		for (int i=0; i<num; i++) {
			System.out.println(userList.get(i).age+" "+ userList.get(i).name);
		}
		

	}

}
