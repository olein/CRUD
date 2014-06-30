package fahim;

import java.sql.*;
import java.util.Map;


import com.opensymphony.xwork2.ActionContext;

public class Account {

	private String name;
	private String password;
	private String passwordConfirm;
	private String NewName;
	private String Newpassword;
	private String Result = " ";

	public String Login() {
		System.out.println("MySQL Connect Example.");
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "USER";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password1 = "";
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + dbName, userName,
					password1);
			System.out.println("Connected to the database");

			Statement stm = conn.createStatement();
			ResultSet rs0 = stm
					.executeQuery("SELECT * FROM ACCOUNT WHERE name='" + name
							+ "' AND password='" + password + "';");

			if (rs0.next() == true) {
				conn.close();
				System.out.println("Disconnected from database");
				return "success";
			} else {
				return "failure";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("failed\n");
		}

		return "success";
	}
	
	public String Logout()
	{
		  Map session = ActionContext.getContext().getSession();
		  session.remove("logged-in"); 
		  return "success";
	}

	public String Create() {
		if (password.equals(passwordConfirm)) {

			System.out.println("MySQL Connect Example.");
			Connection conn = null;
			String url = "jdbc:mysql://localhost:3306/";
			String dbName = "USER";
			String driver = "com.mysql.jdbc.Driver";
			String userName = "root";
			String password1 = "";
			try {
				Class.forName(driver).newInstance();
				conn = DriverManager.getConnection(url + dbName, userName,
						password1);
				System.out.println("Connected to the database");

				Statement stm = conn.createStatement();
				ResultSet rs0 = stm
						.executeQuery("SELECT * FROM ACCOUNT WHERE name='"
								+ name + "' AND password='" + password + "';");

				if (rs0.next() == true) {
					conn.close();
					System.out.println("Disconnected from database");
					Result = "Sorry!!! User name or Password is already taken";
					setResult(Result);
					return "failure";
				} else {
					String sql = "INSERT INTO ACCOUNT(name,password) "
							+ "VALUES ('" + name + "', '" + password + "');";
					stm.executeUpdate(sql);

					conn.close();
					Result = "Your account is created successfully";
					setResult(Result);
					return "success";
				}

			} catch (Exception e) {
				e.printStackTrace();
				System.out.print("failed\n");
			}

		}

		return "success";
	}
	
	public String Update() {
	
			if(NewName.length()==0)
			{
				NewName = name;
			}
			if(Newpassword.length()==0)
			{
				Newpassword = password;
			}
			System.out.println("MySQL Connect Example.");
			Connection conn = null;
			String url = "jdbc:mysql://localhost:3306/";
			String dbName = "USER";
			String driver = "com.mysql.jdbc.Driver";
			String userName = "root";
			String password1 = "";
			try {
				Class.forName(driver).newInstance();
				conn = DriverManager.getConnection(url + dbName, userName,
						password1);
				System.out.println("Connected to the database");

				Statement stm = conn.createStatement();
				ResultSet rs0 = stm
						.executeQuery("SELECT * FROM ACCOUNT WHERE name='"
								+ name + "' AND password='" + password + "';");

				if (rs0.next() == true) {
					
					String sql = "UPDATE ACCOUNT SET name='"+NewName+"',password='"+Newpassword+"' WHERE name='"+name+"' AND password='"+password+"';";
							
					stm.executeUpdate(sql);
					
					conn.close();
					System.out.println("Disconnected from database");
					Result = "Account Updated";
					setResult(Result);
					return "success";
				} else {
					
					conn.close();
					Result = "Update Failed";
					setResult(Result);
					return "failure";
				}

			} catch (Exception e) {
				e.printStackTrace();
				System.out.print("failed\n");
			}

		

		return "success";
	}

	public String Delete() {
		
		if(name.equals(null))
		{
			return "failure";
		}
		if(password.equals(null))
		{
			return "failure";
		}
		System.out.println("MySQL Connect Example.");
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "USER";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password1 = "";
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + dbName, userName,
					password1);
			System.out.println("Connected to the database");

			Statement stm = conn.createStatement();
			ResultSet rs0 = stm
					.executeQuery("SELECT * FROM ACCOUNT WHERE name='"
							+ name + "' AND password='" + password + "';");

			if (rs0.next() == true) {
				
				String sql = "DELETE FROM ACCOUNT WHERE name='"+name+"' AND password='"+password+"';";
						
				stm.executeUpdate(sql);
				
				conn.close();
				System.out.println("Disconnected from database");
				return "success";
			} else {
				
				conn.close();
				Result = "Account delete action failed!!";
				setResult(Result);
				return "failure";
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("failed\n");
		}

	

	return "success";
}
	
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNewName() {
		return NewName;
	}

	public void setNewName(String newName) {
		NewName = newName;
	}

	public String getNewpassword() {
		return Newpassword;
	}

	public void setNewpassword(String newpassword) {
		Newpassword = newpassword;
	}

	public String getResult() {
		return Result;
	}

	public void setResult(String result) {
		Result = result;
	}
}
