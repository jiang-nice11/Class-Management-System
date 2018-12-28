package bean;
//学生信息类
public class Student {
	private String name;
	private String password;
	private String sex;
	private int sno;
	private String grade;
	private String smajor;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getSmajor() {
		return smajor;
	}
	public void setSmajor(String smajor) {
		this.smajor = smajor;
	}
	
	public Student(){
	
	}
	
	public Student(String name,String password,int sno,String sex,String smajor) {
		super();
		this.name=name;
		this.password=password;
		this.sno=sno;
		this.sex=sex;
		this.smajor=smajor;
	}
}
