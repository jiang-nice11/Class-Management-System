package bean;

public class Teacher {
	private String tname;
	private String tpassword;
	private String tno;
	
	public Teacher() {
		
	}
	public Teacher(String tname,String tpassword,String tno ) {
		super();
		this.tname=tname;
		this.tpassword=tpassword;
		this.tno=tno;	
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTpassword() {
		return tpassword;
	}
	public void setTpassword(String tpassword) {
		this.tpassword = tpassword;
	}
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}

}
