package com.desafio.d20210318.servicio.cliente.model;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

public class ConsultaTipoIndicadorModel implements Serializable{
	   
	private static final long serialVersionUID = -8493849801913595675L;
	
	private String version;
	private String autor;
	private Date fecha;
	private UFModel uf;
	private IVPModel ivp;
	private DolarModel dolar;
	private DolarIntercambioModel dolar_intercambio;
	private EuroModel euro;
	private IPCModel ipc;
	private UTMModel utm;
	private ImacecModel imacec;
	private TPMModel tpm;
	private LibraCobreModel libra_cobre;
	private TasaDesempleoModel tasa_desempleo;
	private BitcoinModel bitcoin;
	
	
	public ConsultaTipoIndicadorModel() {
		super();
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public UFModel getUf() {
		return uf;
	}

	public void setUf(UFModel uf) {
		this.uf = uf;
	}

	public IVPModel getIvp() {
		return ivp;
	}

	public void setIvp(IVPModel ivp) {
		this.ivp = ivp;
	}

	public DolarModel getDolar() {
		return dolar;
	}

	public void setDolar(DolarModel dolar) {
		this.dolar = dolar;
	}

	public DolarIntercambioModel getDolar_intercambio() {
		return dolar_intercambio;
	}

	public void setDolar_intercambio(DolarIntercambioModel dolar_intercambio) {
		this.dolar_intercambio = dolar_intercambio;
	}

	public EuroModel getEuro() {
		return euro;
	}

	public void setEuro(EuroModel euro) {
		this.euro = euro;
	}

	public IPCModel getIpc() {
		return ipc;
	}

	public void setIpc(IPCModel ipc) {
		this.ipc = ipc;
	}

	public UTMModel getUtm() {
		return utm;
	}

	public void setUtm(UTMModel utm) {
		this.utm = utm;
	}

	public ImacecModel getImacec() {
		return imacec;
	}

	public void setImacec(ImacecModel imacec) {
		this.imacec = imacec;
	}

	public TPMModel getTpm() {
		return tpm;
	}

	public void setTpm(TPMModel tpm) {
		this.tpm = tpm;
	}

	public LibraCobreModel getLibra_cobre() {
		return libra_cobre;
	}

	public void setLibra_cobre(LibraCobreModel libra_cobre) {
		this.libra_cobre = libra_cobre;
	}

	public TasaDesempleoModel getTasa_desempleo() {
		return tasa_desempleo;
	}

	public void setTasa_desempleo(TasaDesempleoModel tasa_desempleo) {
		this.tasa_desempleo = tasa_desempleo;
	}

	public BitcoinModel getBitcoin() {
		return bitcoin;
	}

	public void setBitcoin(BitcoinModel bitcoin) {
		this.bitcoin = bitcoin;
	}

}
