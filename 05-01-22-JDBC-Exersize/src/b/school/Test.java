package b.school;

public class Test {

	public static void main(String[] args) {

		SchoolDao schoolDao = new SchoolDao();
		schoolDao.create();
		StudentDao studentDao = new StudentDao();
		studentDao.create();
		
		for (int i = 1; i <= 3; i++) {
			School school = new School(0, "School"+i, "Jerusalem");
			schoolDao.save(school);
			for (int j = 1; j <= 10; j++) {
				Student student = new Student(0, i, "Student"+i+j, "student"+i+j+"@mail.com");
//				school.setStudents.[i-1](null);
				studentDao.save(student);
			}
		}
		
		for (int i = 1; i <= 3; i++) {
			School school = schoolDao.get(i);
			System.out.println(school);
			if(i==1) {
				for (int j = 1; j <= 10; j++) {
				Student student = studentDao.get(j);
				System.out.println(student);
				}
			}else if(i==2) {
				for (int j = 11; j <= 20; j++) {
					Student student = studentDao.get(j);
					System.out.println(student);
				}
			}else if(i==3) {
				for (int j = 21; j <= 30; j++) {
					Student student = studentDao.get(j);
					System.out.println(student);
				}
				
			}
			
			
		}
	}

}
