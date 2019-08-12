package day19;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Test07_foreach {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(2017002, "김씨", "마케팅부"));
		list.add(new Employee(2017003, "박씨", "기술부"));
		list.add(new Employee(2018003, "박씨", "전산실"));
		list.add(new Employee(2017017, "고씨", "기술부"));
		list.add(new Employee(2019003, "홍길동", "영업부"));

		System.out.println("*** iterator 기반 목록 출력 ***");
		Iterator<Employee> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println();

		System.out.println("*** foreach 기반 목록 출력 ***");
		list.forEach(new Consumer<Employee>() {

			@Override
			public void accept(Employee t) {
				// TODO Auto-generated method stub
				System.out.println(t);
			}
		});
		System.out.println();

		System.out.println("*** foreach 람다로 1 목록 출력 ***");
		list.forEach((Employee t) -> {
			System.out.println(t);
		});
		System.out.println();

		System.out.println("*** foreach 람다로 2 목록 출력 ***");
		list.forEach(t -> System.out.println(t));
		System.out.println();

		System.out.println("*** foreach 람다로 3 목록 출력 ***");
		list.forEach(System.out::println);

	}

}
