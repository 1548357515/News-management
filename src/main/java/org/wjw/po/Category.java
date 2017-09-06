package org.wjw.po;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
public class Category implements Serializable{
/**
	 * 
	 */
private static final long serialVersionUID = -3064336136393015800L;
private Integer id;
private String categoryName;
private Set<News> newser=new HashSet<News>();
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getCategoryName() {
	return categoryName;
}
public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}
public Set<News> getNewser() {
	return newser;
}
public void setNewser(Set<News> newser) {
	this.newser = newser;
}
}
