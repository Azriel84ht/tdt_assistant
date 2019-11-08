package tdt;

import java.sql.Connection;
import java.sql.DriverManager;

public class TDTSystem {
	
	private String TDTip, TDTname;
	private int AMPs;
	private Connection TDTcon = null;
	private Exception ex;
	
	public TDTSystem(String TDTname, String TDTip) {
		this.TDTip = TDTip;
		this.TDTname = TDTname;
	}
	
	public int openCON(String TDTuser,String TDTpass) {
		String url = "jdbc:teradata://"+this.TDTip+"/TMODE=ANSI,CHARSET=UTF8";
		try {
			Class.forName("com.teradata.jdbc.TeraDriver");
			this.TDTcon = DriverManager.getConnection(url,TDTuser,TDTpass);
			return 0;
		}catch (Exception error) {
			this.ex = error;
			return 1;
		}
	}
}
