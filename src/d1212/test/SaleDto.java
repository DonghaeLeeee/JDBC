package d1212.test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class SaleDto {
	int custno;
	String custname;
	String agarede;
	int psum;
}
