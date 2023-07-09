package com.cg.gateway.config;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class RouteValidator {
	
	public static final List<String> OPEN_APIS=List.of(
			"/user/register", 
			"/user/token", 
			"/user/validate",
			"user/authenticate");
	
	public Predicate<ServerHttpRequest> isSecured=request->
		OPEN_APIS.stream().noneMatch(uri-> request.getURI().getPath().contains(uri));
	

}
