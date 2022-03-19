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

	public int getUnum() {
		return unum;
	}

	public void setUnum(int unum) {
		this.unum = unum;
	}

	public int getDnum() {
		return dnum;
	}

	public void setDnum(int dnum) {
		this.dnum = dnum;
	}

	public String getComtcont() {
		return comtcont;
	}

	public void setComtcont(String comtcont) {
		this.comtcont = comtcont;
	}

	public Date getComtdate() {
		return comtdate;
	}

	public void setComtdate(Date comtdate) {
		this.comtdate = comtdate;
	}

	public int getComtrate() {
		return comtrate;
	}

	public void setComtrate(int comtrate) {
		this.comtrate = comtrate;
	}

	public int getComtnum() {
		return comtnum;
	}

	public void setComtnum(int comtnum) {
		this.comtnum = comtnum;
	}

	@Override
	public String toString() {
		return "drama_commentVO [unum=" + unum + ", dnum=" + dnum + ", comtcont=" + comtcont + ", comtdate=" + comtdate
				+ ", comtrate=" + comtrate + ", comtnum=" + comtnum + "]";
	}
	
	
	
}
