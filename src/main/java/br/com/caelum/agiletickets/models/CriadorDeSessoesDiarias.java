package br.com.caelum.agiletickets.models;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.Weeks;

public class CriadorDeSessoesDiarias implements CriadorDeSessoes {

	@Override
	public List<Sessao> CriaSessoes(LocalDate inicio, LocalDate fim,
			LocalTime horario, Periodicidade periodicidade,
			Espetaculo espetaculo) {
		List<Sessao> lista = new ArrayList<Sessao>();
		int numSessoes = Days.daysBetween(inicio, fim).getDays();
			
		if(inicio.isAfter(fim))
			return lista;
		
		for(int i=0; i<=numSessoes; i++){
			Sessao s = new Sessao();
			s.setEspetaculo(espetaculo);
			s.setInicio(inicio.plusDays(i).toDateTime(horario));
			lista.add(s);
		}
		return lista;
	}

}
