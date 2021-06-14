package mz.com.soto.junior.pedido.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import mz.com.soto.junior.pedido.model.Oferta;


public class RequisicaoNovaOferta {
	
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private Long pedidoId;
	//construindo um pattern comecando com um ou mais digitos
	@Pattern(regexp = "^\\d+(\\.\\d+{2})?$")
	@NotNull
	private String valor;
	
	//dois digitos, para di, outros dois para mes, e outros quatros digitos para o ano
	@Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
	@NotNull
	private String dataDaEntrega;
	
	private String comentario;

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDataDaEntrega() {
		return dataDaEntrega;
	}

	public void setDataDaEntrega(String dataDaEntrega) {
		this.dataDaEntrega = dataDaEntrega;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Oferta toOferta() {
		Oferta oferta = new Oferta();
		oferta.setComentario(this.comentario);
		oferta.setDataDaEntrega(LocalDate.parse(this.dataDaEntrega, formatter));
		oferta.setValor(new BigDecimal(this.valor));
		return oferta;
	}
	
	
}
