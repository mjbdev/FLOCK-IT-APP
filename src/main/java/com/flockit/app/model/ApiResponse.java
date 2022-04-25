package com.flockit.app.model;

import java.util.List;

public class ApiResponse {

	private Integer cantidad;
	private Integer inicio;
	private ApiParametros parametros;
	private List<ApiProvince> provincias;
	private Integer total;

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getInicio() {
		return inicio;
	}

	public void setInicio(Integer inicio) {
		this.inicio = inicio;
	}

	public ApiParametros getParametros() {
		return parametros;
	}

	public void setParametros(ApiParametros parametros) {
		this.parametros = parametros;
	}

	public List<ApiProvince> getProvincias() {
		return provincias;
	}

	public void setProvincias(List<ApiProvince> provincias) {
		this.provincias = provincias;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

}
