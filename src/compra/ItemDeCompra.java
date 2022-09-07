package compra;

public class ItemDeCompra {
	int codigo;
	String nome;
	double precoUnitario;
	int quantidadeComprada;
	
	ItemDeCompra(int codigo, String nome, double precoUnitario, int quantidadeComprada){
		this.codigo = codigo;
		this.nome = nome;
		this.precoUnitario = precoUnitario;
		this.quantidadeComprada = quantidadeComprada;
	}
	
	//Métodos get
	public int getCodigo() {
		return codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public double getPrecoUnitario() {
		return precoUnitario;
	}
	
	public int getQuantidadeComprada() {
		return quantidadeComprada;
	}
	
	//Métodos set
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	
	public void setQuantidadeComprada(int quantidadeComprada) {
		this.quantidadeComprada = quantidadeComprada;
	}
	
	//Método para calcular o valor total
	public double calcularTotal() {
		return precoUnitario * quantidadeComprada;
	}
}
