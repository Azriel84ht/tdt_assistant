
import tdt.TDTSystem;

public class Pruebas {

	public static void main(String[] args) {
		TDTSystem TESAsys = new TDTSystem("TESA","10.51.80.49");
		int conresult = TESAsys.openCON("t724147","offspring");

		System.out.println("Ha habido errores al conectar");
	}
/*
	
	public static int getTDTinfo(TDTConnection TESAcon, TDTSystem TESAsys) {
		int retorno = 0;
		retorno = TESAcon.TDTExecute("SELECT HASHAMP()+1 AS AMPS;");
		if (retorno == 0) {
			ResultSet rs = TESAcon.getResult();
			try {
				rs.next();
				TESAsys.setAMPsnum(rs.getInt("AMPS"));
				return 0;
			}catch(SQLException ex) {
				System.out.println("Algo fue mal");
				ex.printStackTrace();
				return 1;
			}
		}else {
			return 1;
		}
	}*/
}
