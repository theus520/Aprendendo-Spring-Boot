package com.matheusrabelo.mr.domain;

import javax.persistence.Entity;

import com.matheusrabelo.mr.domain.enums.EstadoPagamento;
@Entity
public class PagamentoComCartao extends Pagamento {

	private static final long serialVersionUID = 1L;

	private Integer numeroDeParcela;
	
	public PagamentoComCartao() {
	
	}

	
	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcela) {
		super(id, estado, pedido);
		this.numeroDeParcela = numeroDeParcela;
		
	}


	public Integer getNumeroDeParcela() {
		return numeroDeParcela;
	}


	public void setNumeroDeParcela(Integer numeroDeParcela) {
		this.numeroDeParcela = numeroDeParcela;
	}

	
}

