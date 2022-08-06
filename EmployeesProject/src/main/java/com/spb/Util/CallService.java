package com.spb.Util;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spb.Dao.Impl.EmployeesDaoImpl;

public class CallService {
	
	private static Logger logger = LoggerFactory.getLogger(EmployeesDaoImpl.class.getName());
	
	public CallService() {

	}
	
	public HttpResponse<String>  callServices(String nombre, String URL) {
		logger.info("Llama al servicio ["+nombre+"]");
		HttpResponse<String> response = null;
		
		try {
			HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
	        
			HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(URL)).build();
			
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
						
		}catch (Exception e) {
			logger.error("ERROR CONSUMIENDO SERVICIO => ["+nombre+"] => "+e.getMessage());
		}
		
		return response;
	}

}
