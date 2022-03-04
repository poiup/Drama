package kr.co.drama;

import java.sql.Date;

public class drama_commentVO {
	private int unum;
	private int dnum;
	private String comtcont; 
	private Date comtdate; 
	private int comtrate;
	private int comtnum;
	
	public drama_commentVO(int unum, int dnum, String comtcont, Date comtdate, int comtrate, int comtnum) {
		super();
		this.unum = unum;
		this.dnum = dnum;
		this.comtcont = comtcont;
		this.comtdate = comtdate;
		this.comtrate = comtrate;
		this.comtnum = comtnum;
	}

	@Override
	public String toString() {
		return "drama_commentVO [unum=" + unum + ", dnum=" + dnum + ", comtcont=" + comtcont + ", comtdate=" + comtdate
				+ ", comtrate=" + comtrate + ", comtnum=" + comtnum + "]";
	}
	
	
	
}
