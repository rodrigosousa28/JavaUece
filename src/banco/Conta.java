package banco;

public class Conta {
	private String nome;
	private int numero;
	private double saldo;
	
	public Conta(String nome, int numero, double saldo) {
		this.nome = nome;
		this.numero = numero;
		this.saldo = saldo;
	}
	
	public Conta(String nome, int numero) {
		this.nome = nome;
		this.numero = numero;
		this.saldo = 0;
	}

	//Métodos get
	public String getNome() {
		return nome;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public double getSaldo() {
		return saldo;
	}

	//Métodos set
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
}
