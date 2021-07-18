package br.com.systemsgs.config;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatesReports implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	public static String dataAtualReportName() {
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		
		return dateFormat.format(Calendar.getInstance().getTime());
	}
	
	public static String formatDateSql(Date data) {
		StringBuffer retornaData = new StringBuffer();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		retornaData.append("'");
		retornaData.append(dateFormat.format(data));
		retornaData.append("'");
		
		return retornaData.toString();
	}

}
