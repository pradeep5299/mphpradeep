package com.mphasis.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.mphasis.dao.EmployeeDao;
import com.mphasis.model.Employee;
import com.mphasis.model.Salary;

public class EmployeeController implements EmployeeInterface {
	Employee emp;
	Salary sal;
	List<Employee> emplist = new ArrayList<Employee>();
	EmployeeDao empdao = new EmployeeDao();
	
	public List addEmployee()
	{
		emp = new Employee();
		Scanner  sc = new Scanner(System.in);
		System.out.println("Enter the Eid");
		int eno = sc.nextInt();
		emp.setEid(eno);
		System.out.println("Enter the Ename ");
		String enam = sc.next();
		emp.setEname(enam);
		
		sal= new Salary();
		
		System.out.println("Enter basic Salary");
		int basic = sc.nextInt();
		sal.setBasic(basic);
		System.out.println("Enter DA");
		int da = sc.nextInt();
		sal.setDa(da);
		System.out.println("Enter HRA");
		int hra = sc.nextInt();
		sal.setHra(hra);
		System.out.println("Enter PF");
		int pf= sc.nextInt();
		sal.setPf(pf);
		
		sal.setGross(basic, da, hra);
		sal.setNet(sal.getGross(),pf);
		emp.setSalary(sal);
		
		//emplist.add(emp);
		empdao.insertEmp(emp);
		
		//System.out.println(emp.getEid() + " " + emp.getEname());	
		System.out.println("Employee "  + eno + "Succesfully added");
		return emplist;
	}
	
	public void viewEmployee(List elist)
	{
		/*Iterator i= elist.iterator();

		while(i.hasNext())
		{
			System.out.println(i.next());
		}*/
		
		empdao.viewEmp();
		
	}
	
	public void insertUsingProc()
	{
		Employee e = new Employee();
		Scanner  sc = new Scanner(System.in);
		System.out.println("Enter the Eid");
		int eno = sc.nextInt();
		e.setEid(eno);
		System.out.println("Enter the Ename ");
		String enam = sc.next();
		e.setEname(enam);
		
		empdao.insertUsingProcedure(e);
	}
	public void rsmd()
	{
		empdao.rsmd();
	}

	@Override
	public void type_forward_only_rs() {
		empdao.type_forward_only_rs();
		
	}

	@Override
	public void type_scroll_insensitive_rs() {
		empdao.type_scroll_insensitive_rs();
		
	}

	@Override
	public void type_scroll_sensitive_rs_insert() {
		empdao.type_scroll_sensitive_rs_insert();
		
	}
	@Override
	public void type_scroll_sensitive_rs_update() {
		empdao.type_scroll_sensitive_rs_update();
		
	}
	@Override
	public void batchUpdate() {
			empdao.batchUpdate();
	}
	
	
}