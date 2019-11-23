package util;

public class Assignment_DTO {
	private int no;
	private String id;
	private String name;
	private String occup;
	private String addr;
	private String password;
	
	public Assignment_DTO() {}
	
	public Assignment_DTO(int no, String id, String name, String occup, String addr) {
		super();
		this.no = no;
		this.id = id;
		this.name = name;
		this.occup = occup;
		this.addr = addr;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccup() {
		return occup;
	}

	public void setOccup(String occup) {
		this.occup = occup;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
