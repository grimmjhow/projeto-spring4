package br.com.caelum.contas.modelo;

public enum TipoDaConta {
	ENTRADA("Entrada"),
	SAIDA("Saída");
	
	private final String descricao;
	
	private TipoDaConta(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao(){
		return this.descricao;
	}
}
