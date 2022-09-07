package country;

import java.util.Arrays;

public class Pais {
	//Atributos da classe
	String nomePais;
	String nomeCapital;
	double dimensao;
	String fronteira;
	
	//Construtor
	Pais(String nomePais, String nomeCapital, double dimensao){
		this.nomePais = nomePais;
		this.nomeCapital = nomeCapital;
		this.dimensao = dimensao;
	}
	
	//Métodos get
	public String getNomePais() {
		return nomePais;
	}
	
	public String getNomeCapital() {
		return nomeCapital;
	}
	
	public double getDimensao() {
		return dimensao;
	}
	
	//Métodos set
	public void setNomePais(String nomePais) {
		this.nomePais = nomePais;
	}
	
	public void setNomeCapital(String nomeCapital) {
		this.nomeCapital = nomeCapital;
	}
	
	public void setDimensao(double dimensao) {
		this.dimensao = dimensao;
	}
	
	//Verificar se dois países são iguais
	public boolean equals(Pais outro) {
		if(this.nomePais.equals(outro.nomePais) && this.nomeCapital.equals(outro.nomeCapital)) {
			return true;
		}else {
			return false;
		}
	}
	
	//Setar os países que fazem fronteiras
	public void setFronteiras(Pais[] fronteira) {
		int contador = 0;
		for(int i = 0; i < fronteira.length; i++) {
			if (this.equals(fronteira[i])){
				contador++;
			}
		}
		if(contador == 0) {
			String[] paises = new String[fronteira.length];
			for(int i = 0; i < fronteira.length; i++) {
				paises[i] = fronteira[i].nomePais;
			}
			this.fronteira = Arrays.toString(paises);
		}else {
			this.fronteira = "Erro, nao e possivel um pais fazer fronteira consigo mesmo";
		}
	}
	
	//Obter os países que fazem fronteira
	public String getFronteiras(){
		return this.fronteira;
	}
}
