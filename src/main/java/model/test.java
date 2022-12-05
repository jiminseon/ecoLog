package lab4;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CompanyTest {

	private static CompanyDao compDao = new CompanyDao();
	
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("부서명을 입력하시오: ");
		String deptName = scanner.next();
		
		Department dept = compDao.findDeptInfo(deptName);	
		
		if (dept != null) {
			System.out.println("<부서정보>");
		System.out.println("부서번호: " + dept.getDeptNo());
		System.out.println("부서명: " + dept.getDName());
		System.out.println("관리자사번: " + dept.getManager());
		System.out.println("사원수: " + dept.getEmpNums());
		System.out.println();
		}
		else {
			System.out.println("부서를 찾지 못했음");
		}
	     List<Employee> empList = compDao.findEmployeesInDept(dept.getDeptNo());  
	     Iterator<Employee> eList = empList.iterator();

		System.out.println("사번	  이름  	    직무	       급여	     수당	  ");
		System.out.println("---------------------------------------");
	     while(eList.hasNext()) {
	    	 	Employee emp  =eList.next();
	    	 	int empno = emp.getEmpNo();
				String ename = emp.getEname();
				String job = emp.getJob();
			    double sal = emp.getSal();
			    double comm = emp.getComm();
				
				System.out.printf("%d %10s %10s %10.2f %10.2f \n", empno, ename, job, sal, comm);
	     }
	     System.out.println();
		System.out.print("새 관리자 사번과 관리자 보직수당을 입력하시오: ");
		int managerNo  = scanner.nextInt();
		double commission = scanner.nextDouble();
		
		compDao.replaceManagerOfDept(dept.getDeptNo(), managerNo, commission); 
	    
	    Employee manager = compDao.findEmpInfo(managerNo);   
	    String ename = manager.getEname();
		String job =manager.getJob();
	    double sal = manager.getSal();
	    double comm = manager.getComm();
		String dname = manager.getDname();
		System.out.println("새 관리자 정보:");
		System.out.printf("%s %10s %10.2f %10.2f %10s \n", ename, job, sal, comm, dname);
		
		scanner.close();
	}
}