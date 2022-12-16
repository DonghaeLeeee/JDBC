package d1213.book;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DelayDto {
	private String bcode;
	private String title;
	private Date rent_date;
	
	@Override
	public String toString() {
		return  bcode + "\t"
				+ title + "\t" 
				+ rent_date ;
	}

}