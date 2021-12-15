package Lab2;

public class SalaryRaiser {

	public static void main(String[] args) {
		int salary = (int) (Math.random() * 1001) + 5000;
		int newSalary = 0;
		System.out.println(salary);
		if ((int)(salary * 1.1) <= 6000) {
			newSalary = (int)(salary * 1.1);
		}else {
			newSalary = (int)(salary * 1.05);
		}
		System.out.println(newSalary);
	}

}
