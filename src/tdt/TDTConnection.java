package tdt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TDTConnection {
	
	private TDTSystem TDT;
	private String Username;
	private String Password;
	private String url;
	private Connection myConnection = null;
	private Statement myStatement = null;
	private SQLException ex;
	private ResultSet rs;
	
	public TDTConnection (TDTSystem TDT, String Username, String Password) {
		this.TDT = TDT;
		this.Username = Username;
		this.Password = Password;
		this.url = "jdbc:teradata://"+TDT.getAddress()+"/TMODE=ANSI,CHARSET=UTF8";
	}
	public SQLException getTDTException() {
		return this.ex;
	}
	
	public int TDTConnect() {
		try {
			this.myConnection = DriverManager.getConnection(url,Username,Password);
			try {
				this.myStatement = this.myConnection.createStatement();
				return 0;
			}catch (SQLException ex){
				this.ex = ex;
				return 1;
			}
		}catch (SQLException ex) {
			this.ex = ex;
			return 1;
		}
	}
	public ResultSet getResult() {
		return this.rs;
	}
	public int close() {
		try {
			this.myStatement.close();
			this.myConnection.close();
			return 0;
		} catch (SQLException ex) {
			this.ex = ex;
			return 1;
		}
	}
	public int TDTExecute (String Query) {
		try {
			this.rs = this.myStatement.executeQuery(Query);
			return 0;
		}catch (SQLException ex) {
			this.ex = ex;
			return 1;
		}
	}
}
