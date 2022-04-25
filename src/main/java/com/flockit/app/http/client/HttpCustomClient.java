package com.flockit.app.http.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.flockit.app.service.ProvinceServiceImpl;

public class HttpCustomClient {
	
	private static final Logger logger = LoggerFactory.getLogger(HttpCustomClient.class);

	private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    public static HttpResponse<String> makeRequest(String name) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://apis.datos.gob.ar/georef/api/provincias?nombre=" + encodeValue(name)))
                //.setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .build();

        logger.info("Making request: " + request.toString());
        
		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

		return response;
	}
    
    private static String encodeValue(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }
}
