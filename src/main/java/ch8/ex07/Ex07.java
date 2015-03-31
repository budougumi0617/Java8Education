/**
 * @file
 * @par File Name:
 * Ex07.java
 * @author budougumi0617
 * @date Created on 2015/03/17
 */
package main.java.ch8.ex07;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author budougumi0617
 * @note Refer to README.md
 */
public class Ex07 {
	public static <T> Comparator<T> reverseOrderNullFirst() {
		@SuppressWarnings("unchecked")
		Comparator<T> nullsFirst = (Comparator<T>) Comparator.nullsFirst(Comparator
				.reverseOrder());
		return nullsFirst;
	}

	public static void main(String[] args) {
		People[] people = { new People("alice", ""), new People("bob", ""),
				new People("carly", ""), new People(null, ""), new People("david", "") };
		Arrays.stream(people).forEach(System.out::println);
		System.out.println("-----------");
		Arrays.sort(people,
				Comparator.comparing(People::getFirstName, reverseOrderNullFirst()));
		Arrays.stream(people).sequential().forEach(System.out::println);
	}
}

class People {

	String firstName;
	String lastName;

	public People(String first, String last) {
		firstName = first;
		lastName = last;
	}

	public String getFirstName() {
		return firstName;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
}