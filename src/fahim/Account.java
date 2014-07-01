package fahim;

import java.sql.*;
import java.util.Map;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionContext;

public class Account {

	private String name;
	private String password;
	private String passwordConfirm;
	private String NewName;
	private String Newpassword;
	private String Result = " ";

	public Connection DBconnection(Connection conn) {

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

		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("failed\n");
		}
		return conn;

	}

	public int Select(Connection conn, String name, String password) {
		int id = 0;
		try {
			PreparedStatement preparedStatement1 = conn
					.prepareStatement("select * from ACCOUNT where name=? and password=?");
			preparedStatement1.setString(1, name);
			preparedStatement1.setString(2, password);
			ResultSet rs = preparedStatement1.executeQuery();
			if(rs.next())
			{
				id = rs.getInt("id");
			}
			return id;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	public String Login() throws SQLException {
		System.out.println("MySQL Connect Example.");
		Connection conn = null;

		conn = DBconnection(conn);

		Statement stm = conn.createStatement();
		ResultSet rs0 = stm.executeQuery("SELECT * FROM ACCOUNT WHERE name='"
				+ name + "' AND password='" + password + "';");

		if (rs0.next() == true) {
			conn.close();
			System.out.println("Disconnected from database");
			return "success";
		} else {
			return "failure";
		}
	}

	public String Logout() {
		Map session = ActionContext.getContext().getSession();
		session.remove("logged-in");
		return "success";
	}

	public String Create() throws SQLException {
		if (password.equals(passwordConfirm)) {

			System.out.println("MySQL Connect Example.");
			Connection conn = null;
			conn = DBconnection(conn);

			try {
				PreparedStatement preparedStatement = conn
						.prepareStatement("insert into ACCOUNT(name,password) values (?, ? )");
				// Parameters start with 1
				preparedStatement.setString(1, name);
				preparedStatement.setString(2, password);

				preparedStatement.executeUpdate();
				conn.close();
				return "success";

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return "failure";
	}

	public String Update() throws SQLException {

		if (NewName.length() == 0) {
			NewName = name;
		}
		if (Newpassword.length() == 0) {
			Newpassword = password;
		}
		System.out.println("MySQL Connect Example.");
		Connection conn = null;
		conn = DBconnection(conn);
		int id = 0;
		try {

			id = Select(conn, name, password);

			PreparedStatement preparedStatement = conn
					.prepareStatement("update ACCOUNT set name=?, password=? where id=?");
			// Parameters start with 1
			preparedStatement.setString(1, NewName);
			preparedStatement.setString(2, Newpassword);
			preparedStatement.setInt(3, id);
			preparedStatement.executeUpdate();
			conn.close();
			return "success";

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "failure";

	}

	public String Delete() throws SQLException {

		if (name.length() == 0) {
			return "failure";
		}
		if (password.length() == 0) {
			return "failure";
		}
		System.out.println("MySQL Connect Example.");
		Connection conn = null;
		conn = DBconnection(conn);
		int id = 0;
		try {

			id = Select(conn, name, password);

			PreparedStatement preparedStatement = conn
					.prepareStatement("delete from ACCOUNT where id=?");
			// Parameters start with 1

			preparedStatement.setInt(1, id);

			preparedStatement.executeUpdate();
			conn.close();
			System.out.println("MySQL Disconnected");
			return "success";
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "failure";

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
