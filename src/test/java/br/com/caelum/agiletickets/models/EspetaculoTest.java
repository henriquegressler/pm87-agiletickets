package br.com.caelum.agiletickets.models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.Weeks;
import org.junit.Test;

public class EspetaculoTest {

	@Test
	public void deveInformarSeEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertTrue(ivete.Vagas(5));
	}

	@Test
	public void deveInformarSeEhPossivelReservarAQuantidadeExataDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertTrue(ivete.Vagas(6));
	}

	@Test
	public void DeveInformarSeNaoEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertFalse(ivete.Vagas(15));
	}

	@Test
	public void DeveInformarSeEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(4));

		assertTrue(ivete.Vagas(5, 3));
	}

	@Test
	public void DeveInformarSeEhPossivelReservarAQuantidadeExataDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(4));

		assertTrue(ivete.Vagas(10, 3));
	}

	@Test
	public void DeveInformarSeNaoEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(2));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertFalse(ivete.Vagas(5, 3));
	}

	private Sessao sessaoComIngressosSobrando(int quantidade) {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(quantidade * 2);
		sessao.setIngressosReservados(quantidade);

		return sessao;
	}
	
	@Test
	public void criaSessoesComPeriocidadeDiaria(){
		List<Sessao> lista = new ArrayList<Sessao>();
		LocalDate inicio = new LocalDate();
		LocalDate fim = inicio.plusDays(10);
		LocalTime horario = new LocalTime(20,0);
		Espetaculo espetaculo = new Espetaculo();
				
		lista = espetaculo.criaSessoes(inicio, fim, horario, Periodicidade.DIARIA);
		
		Assert.assertEquals(11, lista.size());
	
		int cont = 0;
		for (Sessao sessao : lista) {
			Assert.assertEquals(espetaculo, sessao.getEspetaculo());
			Assert.assertEquals(inicio.plusDays(cont++).toDateTime(horario), sessao.getInicio());
		}
	}
	
	@Test
	public void criaSessoesComPeriocidadeSemanal(){
		List<Sessao> lista = new ArrayList<Sessao>();
		LocalDate inicio = new LocalDate();
		LocalDate fim = inicio.plusDays(10);
		LocalTime horario = new LocalTime(20,0);
		Espetaculo espetaculo = new Espetaculo();
				
		lista = espetaculo.criaSessoes(inicio, fim, horario, Periodicidade.SEMANAL);
		
		Assert.assertEquals(3, lista.size());
		int cont = 0;
		for (Sessao sessao : lista) {
			Assert.assertEquals(espetaculo, sessao.getEspetaculo());
			Assert.assertEquals(inicio.plusWeeks(cont++).toDateTime(horario), sessao.getInicio());
		}
	}
	
	@Test
	public void criaUmaSessaoParaDatasIguaisComPeriocidadeDiaria(){
		List<Sessao> lista = new ArrayList<Sessao>();
		LocalDate inicio = new LocalDate();
		LocalDate fim = new LocalDate();
		LocalTime horario = new LocalTime(20,0);
		Espetaculo espetaculo = new Espetaculo();
				
		lista = espetaculo.criaSessoes(inicio, fim, horario, Periodicidade.DIARIA);
		
		Assert.assertEquals(1, lista.size());
	
		int cont = 0;
		for (Sessao sessao : lista) {
			Assert.assertEquals(espetaculo, sessao.getEspetaculo());
			Assert.assertEquals(inicio.plusDays(cont++).toDateTime(horario), sessao.getInicio());
		}
	}
}
