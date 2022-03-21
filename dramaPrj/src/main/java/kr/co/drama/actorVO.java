package kr.co.drama;

public class actorVO {
	private String actname;
    private int actnum;
    private int dnum;
    
	public actorVO(String actname, int actnum, int dnum) {
		super();
		this.actname = actname;
		this.actnum = actnum;
		this.dnum = dnum;
	}

	public String getActname() {
		return actname;
	}

	public void setActname(String actname) {
		this.actname = actname;
	}

	public int getActnum() {
		return actnum;
	}

	public void setActnum(int actnum) {
		this.actnum = actnum;
	}

	public int getDnum() {
		return dnum;
	}

	public void setDnum(int dnum) {
		this.dnum = dnum;
	}

	@Override
	public String toString() {
		return "actorVO [actname=" + actname + ", actnum=" + actnum + ", dnum=" + dnum + "]";
	}
    
    
}
