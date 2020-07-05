package cn.jsu.ww.vo;

import java.util.Date;

public class Goods {
private Integer id;
private Integer ghs_id;
private Integer kf_id;
private Integer number;
private Date in_date;
private String type;
private String name;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Integer getGhs_id() {
	return ghs_id;
}
public void setGhs_id(Integer ghs_id) {
	this.ghs_id = ghs_id;
}
public Integer getKf_id() {
	return kf_id;
}
public void setKf_id(Integer kf_id) {
	this.kf_id = kf_id;
}
public Integer getNumber() {
	return number;
}
public void setNumber(Integer number) {
	this.number = number;
}
public Date getIn_date() {
	return in_date;
}
public void setIn_date(Date in_date) {
	this.in_date = in_date;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

}
