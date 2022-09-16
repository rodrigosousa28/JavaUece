package banco;

import java.util.ArrayList;

public class Banco {

	private String nome;
	private ArrayList<Conta> contas = new ArrayList<>(); //O ArrayList de contas sendo declarado
	private int tamanhoAtual = 0;
	
	
	//Método get
	public String getNome() {
		return nome;
	}
	
	public int getTamanhoAtual() {
		return tamanhoAtual;
	}
	

	//Método set
	public void setNome(String nome) {
		this.nome = nome;
	}


	//Construtor
	public Banco(String nome) {
		this.nome = nome;	
	}
	
	public boolean cadastrarConta(Conta c) {
		for(Conta conta: contas) {
			if(c.getNumero() == conta.getNumero()) {
				return false;
			}
		}
		contas.add(c);
		return true;
	}
	
	public Conta procurarConta(int numero) {
		for(Conta conta: contas) {
			if(conta.getNumero() == numero) {
				return conta;
			}
		}
		return null;
	}
	
	public boolean sacarValor(Conta c, double saldo) {
		if(c.getSaldo() >= saldo) {
			c.setSaldo(c.getSaldo() - saldo);
		}else {
			return false;
		}
		return true;
	}
	
	public void depositarValor(Conta c, double saldo) {
		c.setSaldo(c.getSaldo() + saldo);
	}
	
	public boolean transferirValor(Conta c1, Conta c2, double saldo) {
		if(sacarValor(c1, saldo)) {
			depositarValor(c2, saldo);
		}else {
			return false;
		}
		return true;
	}
	
	public static void exibirMenuInicial() {
		System.out.println("Bem vindo ao caixa Eletronico\n");
		System.out.println("Selecione o seu Banco:\r\n"
				+ "\r\n"
				+ "1. Santander\r\n"
				+ "2. Caixa\r\n"
				+ "3. Bradesco");
	}
	
	public static void exibirMenuInterno() {
		System.out.println("1. Consultar saldo\r\n"
				+ "2. Sacar\r\n"
				+ "3. Depositar\r\n"
				+ "4. Transferir\r\n"
				+ "5. Cadastrar");
	}
}
