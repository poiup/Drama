package kr.co.drama;

import java.sql.Date;

public class buyinfoVO {
	private int unum;
	private int dnum; 
	private int buynum; 
	private Date buydate;
	
	public buyinfoVO(int unum, int dnum, int buynum, Date buydate) {
		super();
		this.unum = unum;
		this.dnum = dnum;
		this.buynum = buynum;
		this.buydate = buydate;
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

	public int getBuynum() {
		return buynum;
	}

	public void setBuynum(int buynum) {
		this.buynum = buynum;
	}

	public Date getBuydate() {
		return buydate;
	}

	public void setBuydate(Date buydate) {
		this.buydate = buydate;
	}

	@Override
	public String toString() {
		return "buyinfoVO [unum=" + unum + ", dnum=" + dnum + ", buynum=" + buynum + ", buydate=" + buydate + "]";
	}
	
}
