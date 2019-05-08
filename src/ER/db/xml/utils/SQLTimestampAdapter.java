package ER.db.xml.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.sql.Timestamp;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class SQLTimestampAdapter extends XmlAdapter<String, Timestamp> {
	
	
	
	@Override
	public String marshal(Timestamp ts) throws Exception {
		   
		    
			return ts.toString();
			//hay que devolver string*/
		
	}

	@Override
	public Timestamp unmarshal(String string) throws Exception {
    
            DateTimeFormatter formatterWithTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");	
	        LocalDateTime localDateTime = LocalDateTime.parse(string, formatterWithTime);		
	        Timestamp arrivalTime = Timestamp.valueOf(localDateTime);
	        return arrivalTime;
	        //hay que devolver timestamp
	}

}