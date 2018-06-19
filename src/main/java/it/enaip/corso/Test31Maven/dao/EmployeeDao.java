package it.enaip.corso.Test31Maven.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import it.enaip.corso.Test31Maven.db.ConnectionFactory;
import it.enaip.corso.Test31Maven.dto.Employee;

public class EmployeeDao {
	
	private static EmployeeDao dao;
	
	private EmployeeDao() {
		super();
	}
	
	public static EmployeeDao getInstance() {
		if(dao == null) {
			dao = new EmployeeDao();
		}
		return dao;
	}
	
	public List<Employee> getAll() {
		List<Employee> employees = new ArrayList<>();
		String query = "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, HIRE_DATE FROM EMPLOYEES";
		try(Connection con = ConnectionFactory.getNewConnection();
				PreparedStatement stmt = con.prepareStatement(query)){
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				long idemployee = rs.getLong("EMPLOYEE_ID");
				String name = rs.getString("FIRST_NAME");
				String surname = rs.getString("LAST_NAME");
				LocalDate date = rs.getDate("HIRE_DATE").toLocalDate();
				Employee employee = new Employee(idemployee, name, surname, date);
				employees.add(employee);
			}
			rs.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} 
		return employees;
	}
	
	public Employee getByPk(long id) {
		Employee employee = null;
		String query = "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, HIRE_DATE FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
		try(Connection con = ConnectionFactory.getNewConnection();
				PreparedStatement stmt = con.prepareStatement(query)){
			
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				long idemployee = rs.getLong("EMPLOYEE_ID");
				String name = rs.getString("FIRST_NAME");
				String surname = rs.getString("LAST_NAME");
				LocalDate date = rs.getDate("HIRE_DATE").toLocalDate();
				employee = new Employee(idemployee, name, surname, date);
			}
			rs.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} 
		return employee;
	}

}
