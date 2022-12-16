package d1208.test;

import java.sql.Date;

public class Money {
	private int custno;
	private int saleno;
	private int pcost;
	private int amount;
	private int price;
	private String pcode;
	private Date sdate;
	
	//생성자
	public Money(int custno, int saleno, int pcost, int amount, int price, String pcode, Date sdate) {
		super();
		this.custno = custno;
		this.saleno = saleno;
		this.pcost = pcost;
		this.amount = amount;
		this.price = price;
		this.pcode = pcode;
		this.sdate = sdate;
	}

	@Override
	public String toString() {
		return "Money [custno=" + custno + ", saleno=" + saleno + ", pcost=" + pcost + ", amount=" + amount + ", price="
				+ price + ", pcode=" + pcode + ", sdate=" + sdate + "]";
	}

	//getter
	public int getCustno() {
		return custno;
	}

	public int getSaleno() {
		return saleno;
	}

	public int getPcost() {
		return pcost;
	}

	public int getAmount() {
		return amount;
	}

	public int getPrice() {
		return price;
	}

	public String getPcode() {
		return pcode;
	}

	public Date getSdate() {
		return sdate;
	}
	
	
}
