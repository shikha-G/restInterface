package test.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

public class MyModel {
	private String name;
	
	@NotEmpty
	private Long guid;
	
	public Long getGuid() {
		return guid;
	}

	public void setGuid(Long guid) {
		this.guid = guid;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}

	public boolean isBool() {
		return bool;
	}

	public void setBool(boolean bool) {
		this.bool = bool;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	private LocalDateTime datetime;
	
	private boolean bool;
	
	private List<String> list;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
