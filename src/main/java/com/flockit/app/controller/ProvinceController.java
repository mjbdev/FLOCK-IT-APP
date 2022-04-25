package com.flockit.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flockit.app.model.Province;
import com.flockit.app.service.ProvinceService;

import io.swagger.annotations.Api;

@RestController
@Api(tags = { "Province Endpoint" })
public class ProvinceController {

	private static final Logger logger = LoggerFactory.getLogger(ProvinceController.class);

	@Autowired
	private ProvinceService provinceService;

	@GetMapping(value = "/latAndLong", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Province> latAndLong(@RequestParam String provinceName) throws Exception {
		logger.info("*** Begin latAndLong ***");

		Province province = provinceService.findProvinceInfo(provinceName);

		return new ResponseEntity<>(province, HttpStatus.OK);
	}

}
