package com.ibm.dst.frame.ssm.common.base.model;

import java.io.Serializable;
import java.text.DecimalFormat;

public class BaseModel implements Serializable {

	private static final long serialVersionUID = -8086024662674323940L;
	
	public String formatDouble(String originStr,String formatStr) {
		String rStr = "";
		if(null == originStr || "".equals(originStr)) {
			rStr = "";
		} else {
			rStr = new DecimalFormat(formatStr).format(Double.parseDouble(originStr));
		}
		return rStr;
	}

}
