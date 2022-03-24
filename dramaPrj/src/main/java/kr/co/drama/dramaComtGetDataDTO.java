package kr.co.drama;

import java.sql.Date;

public class dramaComtGetDataDTO {
	private int unum; 
	private String unick; 
	private int comtnum; 
	private int dnum;
	private String comtcont; 
	private Date comtdate; 
	private int comtrate;
	
	public dramaComtGetDataDTO(int unum,String unick,int comtnum,int dnum,String comtcont,Date comtdate,int comtrate) {
		this.unick = unick;
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
	public String getUnick() {
		return unick;
	}
	public void setUnick(String unick) {
		this.unick = unick;
	}
	public int getComtnum() {
		return comtnum;
	}
	public void setComtnum(int comtnum) {
		this.comtnum = comtnum;
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
	
	@Override
	public String toString() {
		return "dramaComtGetDataDTO [unum=" + unum + ", unick=" + unick + ", comtnum=" + comtnum + ", dnum=" + dnum
				+ ", comtcont=" + comtcont + ", comtdate=" + comtdate + ", comtrate=" + comtrate + "]";
	}
	
	

	
}
