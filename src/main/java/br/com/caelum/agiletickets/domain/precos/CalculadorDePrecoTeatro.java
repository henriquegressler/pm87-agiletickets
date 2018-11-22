package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;

public class CalculadorDePrecoTeatro implements CalculadorDePreco {

	@Override
	public BigDecimal calcula(Sessao sessao) {
		return sessao.getPreco();
	}

}
