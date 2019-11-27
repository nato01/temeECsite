package com.internousdev.radish.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware{
	private Map<String, Object> session;

	public String execute() {
		String userId = String.valueOf(session.get("userId"));
		boolean keepUserId = Boolean.valueOf(String.valueOf(session.get("keepUserId")));   /*保存IDチックにチックを入れている場合sessionにいれてID保持　ValueOfを使う理由は保存IDチックを入れていなくてもエラー起こさないため*/
		session.clear();
		if(keepUserId){
			session.put("keepUserId", keepUserId);  /*保存IDチックを入れているかどうかをsessionに入れている*/
			session.put("userId", userId);
		}
		return SUCCESS;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
