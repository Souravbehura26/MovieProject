package com.cg.mtba.exception;

import java.time.LocalDateTime;

public class ErrorInfo {
	
	LocalDateTime time;
	String errormsg;
	String url;
	
	public ErrorInfo() {
		super();
	}

	public ErrorInfo(LocalDateTime time, String errormsg, String url) {
		super();
		this.time = time;
		this.errormsg = errormsg;
		this.url = url;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "ErrorInfo [time=" + time + ", errormsg=" + errormsg + ", url=" + url + "]";
	}
	
	
}
