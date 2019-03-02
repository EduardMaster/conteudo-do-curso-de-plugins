package net.eduard.curso.java;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.UUID;

import net.eduard.api.lib.manager.DBManager;
import net.eduard.api.lib.modules.AutoBase;
import net.eduard.api.lib.modules.AutoBase.Info;

@Info(name = "tabela")
public class AutoBaseSimplesObjeto implements AutoBase<AutoBaseSimplesObjeto> {

	public static void main(String[] args) {
		DBManager db = new DBManager();
		db.openConnection();
		AutoBaseSimplesObjeto teste = new AutoBaseSimplesObjeto();

		teste.createTable(db.getConnection());
//		teste.insert(db.getConnection());
//		teste.id = 29;
		teste.updateCache(db.getConnection());
//		teste.duplo = 10;
		teste.updateTable(db.getConnection());
//		List<MeuObjeto> listaBolada = teste.getAll(db.getConnection(), "id", false);
//		teste.delete(db.getConnection());
		db.closeConnection();
	}

	@Info(primary = true)
	int id;
	@Info(secondary = true)
	String nome = "Boracha";
	UUID uuid = UUID.randomUUID();
	double duplo;
	float flutuante;
	char carro = 'A';
	long longo;
	byte bit;
	short shorte;
	Date dia = new Date(System.currentTimeMillis());
	Timestamp datetime = new Timestamp(System.currentTimeMillis());
	Time time = new Time(System.currentTimeMillis());
	Calendar calendario = Calendar.getInstance();
	java.util.Date diautil = Calendar.getInstance().getTime();

	@Override
	public String toString() {

		return "MeuObjeto [id=" + id + ", nome=" + nome + ", uuid=" + uuid + ", duplo=" + duplo + ", flutuante="
				+ flutuante + ", carro=" + carro + ", longo=" + longo + ", bit=" + bit + ", shorte=" + shorte + ", dia="
				+ dia + ", datetime=" + datetime + ", time=" + time + ", calendario=" + calendario + ", diautil="
				+ diautil + "]";
	}

}
