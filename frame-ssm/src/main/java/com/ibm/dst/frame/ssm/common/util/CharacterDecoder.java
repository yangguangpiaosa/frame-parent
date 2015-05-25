package com.ibm.dst.frame.ssm.common.util;

import java.io.UnsupportedEncodingException;

public class CharacterDecoder {
    
    public static final String decoder(String inString) 
    				throws UnsupportedEncodingException{
	
	return java.net.URLDecoder.decode(inString, "utf-8");
	
    }
}
