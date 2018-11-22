package br.com.caelum.agiletickets.models;

public enum Periodicidade {
	
	DIARIA {
		@Override
		public CriadorDeSessoes getCriador() {
			// TODO Auto-generated method stub
			return new CriadorDeSessoesDiarias();
		}
	}, SEMANAL {
		@Override
		public CriadorDeSessoes getCriador() {
			// TODO Auto-generated method stub
			return new CriadorDeSessoesSemanais();
		}
	};
	
	public abstract CriadorDeSessoes getCriador();
}
