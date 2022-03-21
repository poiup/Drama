package kr.co.drama;
import java.sql.Date;

public class dramainfoVO {
	private String dname;
	private int dprice; 
    private String dgenre; 
    private Date ddate;
    private int dage; 
    private int dnum;
    private String dthumb; 
    private String dvideo;
    private String dtext;
    
	public dramainfoVO(String dname, int dprice, String dgenre, Date ddate, int dage, int dnum, String dthumb,
			String dvideo, String dtext) {
		super();
		this.dname = dname;
		this.dprice = dprice;
		this.dgenre = dgenre;
		this.ddate = ddate;
		this.dage = dage;
		this.dnum = dnum;
		this.dthumb = dthumb;
		this.dvideo = dvideo;
		this.dtext = dtext;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public int getdprice() {
		return dprice;
	}

	public void setdprice(int dprice) {
		this.dprice = dprice;
	}

	public String getDgenre() {
		return dgenre;
	}

	public void setDgenre(String dgenre) {
		this.dgenre = dgenre;
	}

	public Date getDdate() {
		return ddate;
	}

	public void setDdate(Date ddate) {
		this.ddate = ddate;
	}

	public int getDage() {
		return dage;
	}

	public void setDage(int dage) {
		this.dage = dage;
	}

	public int getDnum() {
		return dnum;
	}

	public void setDnum(int dnum) {
		this.dnum = dnum;
	}

	public String getDthumb() {
		return dthumb;
	}

	public void setDthumb(String dthumb) {
		this.dthumb = dthumb;
	}

	public String getDvideo() {
		return dvideo;
	}

	public void setDvideo(String dvideo) {
		this.dvideo = dvideo;
	}

	public String getDtext() {
		return dtext;
	}

	public void setDtext(String dtext) {
		this.dtext = dtext;
	}

	@Override
	public String toString() {
		return "dramainfoVO [dname=" + dname + ", dprice=" + dprice + ", dgenre=" + dgenre + ", ddate=" + ddate
				+ ", dage=" + dage + ", dnum=" + dnum + ", dthumb=" + dthumb + ", dvideo=" + dvideo + ", dtext=" + dtext
				+ "]";
	}
    
    
}
