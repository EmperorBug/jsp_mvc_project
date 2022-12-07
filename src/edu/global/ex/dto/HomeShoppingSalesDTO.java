package edu.global.ex.dto;

public class HomeShoppingSalesDTO {
	private int 	custno;
	private String 	custname;
	private String	grade;
	private Long	sales;
	
	
	public HomeShoppingSalesDTO() {
	}

	public HomeShoppingSalesDTO(int custno, String custname, String grade, Long sales) {
		super();
		this.custno = custno;
		this.custname = custname;
		this.grade = grade;
		this.sales = sales;
	}

	public int getCustno() {
		return custno;
	}

	public String getCustname() {
		return custname;
	}

	public String getGrade() {
		return grade;
	}

	public Long getSales() {
		return sales;
	}

	
}
