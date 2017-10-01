package com.itemsharing.zuulserver.filter;

import org.springframework.stereotype.Component;

import com.netflix.zuul.context.RequestContext;

@Component
public class FilterUtils {
	public static final String CORRELATION_ID = "is-correlation-id";
	public static final String AUTH_TOKEN = "is-auth-token";
	public static final String USER_ID = "is-user-id";
	public static final String PRE_FILTER_TYPE = "pre";
	public static final String POST_FILTER_TYPE = "post";
	public static final String ROUTE_FILTER_TYPE = "route";
	
	public String getCorrelationId() {
		RequestContext ctx = RequestContext.getCurrentContext();
		
		if(ctx.getRequest().getHeader(CORRELATION_ID) != null) {
			return ctx.getRequest().getHeader(CORRELATION_ID);
		} else {
			return ctx.getZuulRequestHeaders().get(CORRELATION_ID);
		}
	}
	
	public void setCorrelationId(String correlationId) {
		RequestContext ctx = RequestContext.getCurrentContext();
		ctx.addZuulRequestHeader(CORRELATION_ID, correlationId);
	}
	
	public final String getUserId() {
		RequestContext ctx = RequestContext.getCurrentContext();
		
		if(ctx.getRequest().getHeader(USER_ID) != null) {
			return ctx.getRequest().getHeader(USER_ID);
		} else {
			return ctx.getZuulRequestHeaders().get(USER_ID);
		}
	}
	
	public void setUserId(String userId) {
		RequestContext ctx = RequestContext.getCurrentContext();
		ctx.addZuulRequestHeader(USER_ID, userId);
	}
	
	public final String getAuthToken() {
		RequestContext ctx = RequestContext.getCurrentContext();
		return ctx.getRequest().getHeader(AUTH_TOKEN);
	}
	
}
