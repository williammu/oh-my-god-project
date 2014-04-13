package com.projectK.common.action;

import java.lang.reflect.ParameterizedType;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

@SuppressWarnings("unchecked")
public class BaseAction<T extends Object> extends ActionSupport implements ModelDriven<T>, Preparable, SessionAware,
		ServletRequestAware, ServletResponseAware {
	private static final long serialVersionUID = 1L;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected Map session;
	protected String pageName;
	protected T entity;
	protected Map jsonResponse;

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public T getEntity() {
		return entity;
	}

	public void prepare() throws Exception {
		this.entity = getEntityClass();
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public T getModel() {
		return entity;
	}

	public T getEntityClass() {
		T t = null;
		try {
			t = ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0])
					.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;

	}

	public Map getJsonResponse() {
		return jsonResponse;
	}

	public void setJsonResponse(Map jsonResponse) {
		this.jsonResponse = jsonResponse;
	}

	
	
	
}
