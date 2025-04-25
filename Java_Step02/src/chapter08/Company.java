package chapter08;

public class Company {

	public static void main(String[] args) {

		Employee_09 emp = new Employee_09("김직원", 4000);
		emp.work();
		emp.getInfo();

		Manager mgr = new Manager("박관리자", 5000, "영업");
		mgr.work();
		mgr.getInfo();
		mgr.approveLeave("김직원");

		// 다형성
		Employee_09 emp2 = new Manager("최팀장", 5500, "개발");
		emp2.work();
		emp2.getInfo();
		// emp.approveLeave("김직원"); //컴파일 에러(객체가 Employee_09 타입이라거 Manager 고유 기능은 안됨)

	}

}
