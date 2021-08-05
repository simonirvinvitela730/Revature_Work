package libs;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImp implements EmployeeDAO {

    private static Statement statement = null;
    Connection connection = null;

    public EmployeeDAOImp()  {
        try {
            this.connection = ConnectionFactory.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void addEmployee(Employee employee) throws SQLException {
        String sql = "insert into employee (name, email) values (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, employee.getName());
        preparedStatement.setString(2, employee.getEmail());
        int count = preparedStatement.executeUpdate();
        if(count > 0)
            System.out.println("employee saved");
        else
            System.out.println("Oops! something went wrong");
    }

    @Override
    public void updateEmployee(Employee employee) throws SQLException {
        String sql = "update employee set name = ?, email = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, employee.getName());
        preparedStatement.setString(2, employee.getEmail());
        preparedStatement.setInt(3, employee.getId());
        int count = preparedStatement.executeUpdate();
        if(count > 0)
            System.out.println("employee updated");
        else
            System.out.println("Oops! something went wrong");
    }

    @Override
    public void deleteEmployee(int id) throws SQLException {
        String sql = "delete from employee where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int count = preparedStatement.executeUpdate();
        if(count > 0)
            System.out.println("employee delete");
        else
            System.out.println("Oops! something went wrong");
    }
    
    @Override
    public List<Employee> getEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "select * from employee";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String email = resultSet.getString(3);
            Employee employee = new Employee(id, name, email);
            employees.add(employee);
            
        }
        for (Employee e: employees) {
        	System.out.println("Id: "+e.getId()+" Name: "+e.getName()+" Email: "+ e.getEmail());
        }
        return employees;
    }


    @Override
    public Employee employeeById(int id) throws SQLException {
    	Employee employee = new Employee();
    	String sql = "select * from employee where id ="+id;
    	
    	statement = connection.createStatement();
    	ResultSet resultSet = statement.executeQuery(sql);
    	while(resultSet.next()) {
           	int newid = resultSet.getInt(1);
           	String name = resultSet.getString(2);
           	String email = resultSet.getString(3);
           	
           	employee.setId(newid);
           	employee.setName(name);
           	employee.setEmail(email);
           	
           	System.out.println("Id: "+employee.getId()+" Name: "+employee.getName()+" Email: "+employee.getEmail());
    	}return employee;
    }
}
