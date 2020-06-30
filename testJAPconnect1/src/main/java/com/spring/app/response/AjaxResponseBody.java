/**
 * 
 */
package com.spring.app.response;

/**
 * @author SRT
 *
 */
public class AjaxResponseBody {
	private String msg;
	private String error;
	private String status;
	private Object obj;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
    
    
}
