package com.ibm.dst.frame.mongo.entity;

import java.util.List;
import java.util.Map;

public class Person {
	private String code = null;
	private String name = null;
	private Map<String, String> testMap = null;
	private String[] arr = null;
	private List<String> list = null;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, String> getTestMap() {
		return testMap;
	}
	public void setTestMap(Map<String, String> testMap) {
		this.testMap = testMap;
	}
	public String[] getArr() {
		return arr;
	}
	public void setArr(String[] arr) {
		this.arr = arr;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
}
