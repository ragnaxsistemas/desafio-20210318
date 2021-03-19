package com.desafio.d20210318.servicio;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.desafio.d20210318.entidad.Feriado;
import com.desafio.d20210318.entidad.Indicador;
import com.desafio.d20210318.exception.DesafioImplException;
import com.desafio.d20210318.exception.LogicaImplException;
import com.desafio.d20210318.repository.FeriadoRepository;
import com.desafio.d20210318.repository.IndicadorRepository;
//import com.desafio.d20210318.repository.IndicadoresDAO;
import com.desafio.d20210318.servicio.cliente.impl.MindicadorCliente;
import com.desafio.d20210318.servicio.cliente.model.ConsultaIndicadorFechaModel;

/**TODO Para usar el commons por el momento es necesario hacer esta Wea**/
@Service
public class DesafioServiceImpl implements DesafioService {
	/*****Segun se necesite se van creando llamadas al repositorio para devolver entities.*****/
	private static final Logger LOGGER = LoggerFactory.getLogger(DesafioServiceImpl.class);

	@Autowired
	private MindicadorCliente mindicadorCliente;

	@Autowired
	private FeriadoRepository feriadoRepository;
	
	@Autowired
	private IndicadorRepository indicadorRepository;

	/******* Feriado Feriado***/
	/******* Feriado Feriado***/
	/******* Feriado Feriado***/
	public Feriado almacenarFechaFeriado(String sFeriado) throws DesafioImplException {

		try {
			if(validarFormatoFecha(sFeriado)) {
				/**Validar el formato de la fecha**/
				Pageable pageByFecha = PageRequest.of(0, 1, Sort.by("fechaFeriado").descending());

				Page<Feriado> pageFeriado  = feriadoRepository.findByFechaFeriado(sFeriado, pageByFecha);

				if(pageFeriado==null || pageFeriado.isEmpty()){

//					Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idFeriado").descending());
//
//					Page<Feriado> pageIdFeriado = feriadoRepository.findAll(pageByidDesc);
//
//					Integer idFeriado = (!pageIdFeriado.isEmpty()) ? (Integer) pageIdFeriado.getContent().get(0).getIdFeriado() + 1 : 1; 

//					Feriado objFeriado = new Feriado(idFeriado, sFeriado);

//					feriadoRepository.save(objFeriado);

					return feriadoRepository.save(new Feriado(sFeriado));

				}else {
					throw new LogicaImplException("DESAFIO_01", "No se puede crear Feriado, parametros ya existen en identificador valido");
				}
			}else {
				throw new LogicaImplException("DESAFIO_01", "Formato de Fecha invalido");
			}

		} catch (LogicaImplException e) {
			LOGGER.error("LogicaImplException: ", e);
			throw new DesafioImplException(e.getCodigoLogicaImplException(), e.getMessage());
		} catch (Exception e) {
			LOGGER.error("Exception: ", e);
			throw new DesafioImplException("DESAFIO_503", e.getMessage());
		}
	}

	public Indicador buscarIndicadorxCodigoxFecha(String codigoIndicador, String fechaIndicador) throws DesafioImplException {

		try {
			if(validarFormatoFecha(fechaIndicador)) {
				/*****Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.*****/
				/**Validar el formato de la fecha**/
				Pageable pageByFecha = PageRequest.of(0, 1, Sort.by("fechaFeriado").descending());

				Page<Feriado> pageFeriado  = feriadoRepository.findByFechaFeriado(fechaIndicador, pageByFecha);

				if(pageFeriado.isEmpty()){
					//
					Indicador indicador = indicadorRepository.findByCodigoIndicadorAndFecha(codigoIndicador, fechaIndicador);

					if(indicador==null || indicador.getIdIndicador()==null) {
						ConsultaIndicadorFechaModel consultaIndicadorFechaModel = mindicadorCliente.obtenerIndicadoresxCodigoIndicadorxFecha(codigoIndicador, fechaIndicador);

						indicador = obtenerIndicadorByConsultaIndicadorFechaModel(consultaIndicadorFechaModel);
						
						indicadorRepository.save(indicador);
					}

					return indicador;

				}else {
					throw new LogicaImplException("DESAFIO_01", "la fecha seleccionada es feriado no se puede buscar indicador");
				}
			}else {
				throw new LogicaImplException("DESAFIO_01", "Formato de Fecha invalido");
			}

		} catch (LogicaImplException e) {
			LOGGER.error("LogicaImplException: ", e);
			throw new DesafioImplException(e.getCodigoLogicaImplException(), e.getMessage());
		} catch (Exception e) {
			LOGGER.error("Exception: ", e);
			throw new DesafioImplException("DESAFIO_503", e.getMessage());
		}
		}

		private Indicador obtenerIndicadorByConsultaIndicadorFechaModel(ConsultaIndicadorFechaModel consultaIndicadorFechaModel) throws LogicaImplException{
			
			try {
				if(!consultaIndicadorFechaModel.getSerie().isEmpty()) {
					DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
					DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyy", Locale.ENGLISH);
					LocalDate date = LocalDate.parse(consultaIndicadorFechaModel.getSerie().get(0).getFecha(), inputFormatter);
					String formattedDate = outputFormatter.format(date);
					System.out.println(formattedDate); // prints 10-04-2018
					
					return new Indicador(consultaIndicadorFechaModel.getCodigo(), formattedDate, consultaIndicadorFechaModel.getSerie().get(0).getValor());
				}
				throw new LogicaImplException("DESAFIO_02", "No existe Serie para el Indicador");
				
//				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//				String sDate = sdf.format();
//				return new Indicador(consultaIndicadorFechaModel.getCodigo(), sDate, consultaIndicadorFechaModel.getSerie().get(0).getValor());
			} catch (Exception e) {
				LOGGER.error("Exception: ", e);
				throw new LogicaImplException("DESAFIO_02", e.getMessage());
			}
		}

		private boolean validarFormatoFecha(String fecha) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			sdf.setLenient(false);
			return sdf.parse(fecha, new ParsePosition(0)) != null;
		}


	}
