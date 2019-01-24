package DatabasePractice;

import static org.hamcrest.CoreMatchers.nullValue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WorkersDAO {
	private static final Logger logger = LoggerFactory.getLogger(WorkersDAO.class);

	public boolean addWorkers(Worker worker) {
		Connection connection = null;
		connection = Database.getInstance().getConnection();
		try {
			connection.setAutoCommit(false);
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO WORKERS (name,department,location, salary) VALUES(?, ?, ?, ?)");
			preparedStatement.setString(1, worker.getName());
			preparedStatement.setString(2, worker.getDepartment());
			preparedStatement.setString(3, worker.getLocation());
			preparedStatement.setInt(4, worker.getSalary());
			preparedStatement.addBatch();
			preparedStatement.executeBatch();
			connection.commit();
			connection.setAutoCommit(true);
			return true;
		} catch (SQLException e) {
			logger.error("Worker data insert failed " + e.toString());
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleWorkers(int employeeId) {
		Connection connection = null;
		connection = Database.getInstance().getConnection();
		try {
			connection.setAutoCommit(false);
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM WORKERS WHERE EMPLOYEEID=?");
			preparedStatement.setInt(1, employeeId);
			preparedStatement.addBatch();
			preparedStatement.executeBatch();
			connection.commit();
			connection.setAutoCommit(true);
			return true;
		} catch (SQLException e) {
			logger.error("Worker data delete failed " + e.toString());
			e.printStackTrace();
		}
		return false;
	}

	public boolean updaWorkers(Worker worker) {
		Connection connection = null;
		connection = Database.getInstance().getConnection();
		try {
			connection.setAutoCommit(false);
			PreparedStatement preparedStatement = connection.prepareStatement(
					"UPDATE WORKERS SET name=? ,department=? ,location=? , salary=? WHERE employeeid=?");
			preparedStatement.setString(1, worker.getName());
			preparedStatement.setString(2, worker.getDepartment());
			preparedStatement.setString(3, worker.getLocation());
			preparedStatement.setInt(4, worker.getSalary());
			preparedStatement.setInt(5, worker.getEmployeeid());
			preparedStatement.addBatch();
			preparedStatement.executeBatch();
			connection.commit();
			connection.setAutoCommit(true);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}

		return false;
	}

	public Worker findWorker(int id) {
	
		Connection connection = Database.getInstance().getConnection();
		try {
			Worker worker=null;
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM WORKERS WHERE EMPLOYEEID=?");
			preparedStatement.setInt(1,id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				worker.setDepartment(resultSet.getString("department"));
				worker.setEmployeeid(resultSet.getInt("employeeid"));
				worker.setLocation(resultSet.getString("location"));
				worker.setName(resultSet.getString("name"));
				worker.setSalary(resultSet.getInt("salary"));
				logger.debug(worker.toString());
				//return worker;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;

		
//		String sqlString = "SELECT * FROM WORKERS WHERE EMPLOYEEID="+id;
//		Connection connection = Database.getInstance().getConnection();
//		Statement statement = null;
//		try {
//			Worker worker=new Worker();
//			ResultSet resultSet =null;
//			statement= connection.createStatement();
//			resultSet = statement.executeQuery(sqlString);
//			
//			while (resultSet.next()) {
//				worker.setDepartment(resultSet.getString("department"));
//				worker.setEmployeeid(resultSet.getInt("employeeid"));
//				worker.setLocation(resultSet.getString("location"));
//				worker.setName(resultSet.getString("name"));
//				worker.setSalary(resultSet.getInt("salary"));
//				logger.debug(worker.toString());
//				return worker;
//			}
//				
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//			logger.error(e1.toString());
//		}
//		return null;
	}

	public boolean addWorkersUsingEmployeeId(Worker worker) {
		Connection connection = null;
		connection = Database.getInstance().getConnection();
		try {
			connection.setAutoCommit(false);
			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO WORKERS (name,department,location, salary,employeeid) VALUES(?, ?, ?, ?, ?)");
			preparedStatement.setString(1, worker.getName());
			preparedStatement.setString(2, worker.getDepartment());
			preparedStatement.setString(3, worker.getLocation());
			preparedStatement.setInt(4, worker.getSalary());
			preparedStatement.setInt(5, worker.getEmployeeid());
			preparedStatement.addBatch();
			preparedStatement.executeBatch();
			connection.commit();
			connection.setAutoCommit(true);
			return true;
		} catch (SQLException e) {
			logger.error("Worker data insert failed " + e.toString());
			e.printStackTrace();
		}
		return false;
	}

}
