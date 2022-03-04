package kr.co.drama;

public class userinfoVO {
	private String uid;
	private String upw;
	private String uname;
	private int uage;
	private int unum;
    private String ucredit;
    private String uadress;
    private String unick;
    private int upoint;
    
	public userinfoVO(String uid, String upw, String uname, int uage, int unum, String ucredit, String uadress,
			String unick, int upoint) {
		super();
		this.uid = uid;
		this.upw = upw;
		this.uname = uname;
		this.uage = uage;
		this.unum = unum;
		this.ucredit = ucredit;
		this.uadress = uadress;
		this.unick = unick;
		this.upoint = upoint;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUpw() {
		return upw;
	}

	public void setUpw(String upw) {
		this.upw = upw;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public int getUage() {
		return uage;
	}

	public void setUage(int uage) {
		this.uage = uage;
	}

	public int getUnum() {
		return unum;
	}

	public void setUnum(int unum) {
		this.unum = unum;
	}

	public String getUcredit() {
		return ucredit;
	}

	public void setUcredit(String ucredit) {
		this.ucredit = ucredit;
	}

	public String getUadress() {
		return uadress;
	}

	public void setUadress(String uadress) {
		this.uadress = uadress;
	}

	public String getUnick() {
		return unick;
	}

	public void setUnick(String unick) {
		this.unick = unick;
	}

	public int getUpoint() {
		return upoint;
	}

	public void setUpoint(int upoint) {
		this.upoint = upoint;
	}

	@Override
	public String toString() {
		return "userinfoVO [uid=" + uid + ", upw=" + upw + ", uname=" + uname + ", uage=" + uage + ", unum=" + unum
				+ ", ucredit=" + ucredit + ", uadress=" + uadress + ", unick=" + unick + ", upoint=" + upoint + "]";
	}	
	
}
