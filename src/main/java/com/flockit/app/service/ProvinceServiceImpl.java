package com.flockit.app.service;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flockit.app.http.client.HttpCustomClient;
import com.flockit.app.model.ApiProvince;
import com.flockit.app.model.ApiResponse;
import com.flockit.app.model.Province;

@Service
public class ProvinceServiceImpl implements ProvinceService {

	private static final Logger logger = LoggerFactory.getLogger(ProvinceServiceImpl.class);

	@Autowired
	private ObjectMapper mapper;

	@Override
	public Province findProvinceInfo(String name) throws Exception {
		HttpResponse<String> response = null;
		try {
			response = HttpCustomClient.makeRequest(name);
		} catch (IOException | InterruptedException e) {
			logger.error("Error when trying to make request", e);
			throw new Exception(e.getMessage());
		}

		ApiResponse apiResponse = mapper.readValue(response.body(), ApiResponse.class);

		Province province = new Province();

		Optional<ApiProvince> apiProvinceOpt = apiResponse.getProvincias().stream().filter(p -> p.getNombre().equals(name)).findFirst();
		apiProvinceOpt.ifPresent(p -> getLatAndLog(p, province));

		return province;
	}

	private void getLatAndLog(ApiProvince p, Province province) {
		if (p.getCentroide() != null) {
			province.setLatitude(p.getCentroide().getLat());
			province.setLongitude(p.getCentroide().getLon());
		}
	}

}
