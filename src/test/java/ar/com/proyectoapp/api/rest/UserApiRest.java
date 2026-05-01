package ar.com.proyectoapp.api.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.proyectoapp.dtos.UserDto;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles(value = "test")
public class UserApiRest {

	@LocalServerPort
	private int port;
	@Autowired
	private ObjectMapper mapper ;
	
	@Test
	public void ListUser() {
		URI ur = URI.create("http://localhost:"+this.port+"/api/userdto");
		
		HttpRequest request = HttpRequest.
								newBuilder(ur).
								GET().
								header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).
								build();
								
		
	try {
		
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		
		
		List<UserDto> usuarios = mapper.readerForListOf(UserDto.class).readValue(response.body());
		response.body();
		
		assertNotNull(usuarios);
		assertEquals(7, usuarios.size());
		
	} catch (Exception e) {
		fail(e.getMessage());
	}}}

