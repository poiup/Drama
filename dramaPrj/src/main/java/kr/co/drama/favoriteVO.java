package kr.co.drama;

import java.sql.Date;

public class favoriteVO {
	private int unum;
	private int dnum; 
	private int favnum; 
	private Date favdate;
	
	public favoriteVO(int unum, int dnum, int favnum, Date favdate) {
		super();
		this.unum = unum;
		this.dnum = dnum;
		this.favnum = favnum;
		this.favdate = favdate;
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

	public int getFavnum() {
		return favnum;
	}

	public void setFavnum(int favnum) {
		this.favnum = favnum;
	}

	public Date getFavdate() {
		return favdate;
	}

	public void setFavdate(Date favdate) {
		this.favdate = favdate;
	}

	@Override
	public String toString() {
		return "favoriteVO [unum=" + unum + ", dnum=" + dnum + ", favnum=" + favnum + ", favdate=" + favdate + "]";
	}
	
	
}
