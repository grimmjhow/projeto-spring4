package br.com.caelum.contas.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller)throws Exception {
		
		Object usuario = request.getSession().getAttribute("usuarioLogado");
		String uri = request.getRequestURI();
		
		System.out.println(uri);
		
		if(uri.endsWith("loginForm") || uri.endsWith("efetuaLogin") || uri.contains("resources")) {
			return true;
		}
		
		
		if(usuario!=null) {
			return true;
		} else {
			response.sendRedirect("loginForm");
			return false;
		}
		
	}
}
