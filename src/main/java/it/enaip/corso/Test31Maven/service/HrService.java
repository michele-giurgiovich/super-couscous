package it.enaip.corso.Test31Maven.service;

import java.util.List;

import it.enaip.corso.Test31Maven.dao.EmployeeDao;
import it.enaip.corso.Test31Maven.dto.Employee;

public class HrService {
	
	private static HrService facade;
	
	private EmployeeDao employeeDao;
	
	private HrService() {
		super();
		this.employeeDao = EmployeeDao.getInstance();
	}
	
	public static HrService getInstance() {
		if(facade == null) {
			facade = new HrService();
		}
		return facade;
	}
	
	public List<Employee> getAllEmployee(){
		List<Employee> employees = this.employeeDao.getAll();
		return employees;
	}
	
	public Employee getEmployee(long id) {
		Employee employee = this.employeeDao.getByPk(id);
		return employee;
	}

}
