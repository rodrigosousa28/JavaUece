package compra;

public class Compra {
	ItemDeCompra[] produtos = new ItemDeCompra[5]; //Array com os produtos comprados (Nome, preço e todas os atributos de um objeto da classe ItemDeCompra)
	double total = 0.0; //Valor total da compra, que será definido com os métodos de inserir item e o de dar desconto, mas que por padrão é zero
	double desconto = 0.0;
	int formaDePagamento;
	int quantidadeParcelas = 0; // Por padrão é zero, mas o usuário escolhe
	
	//Construtor padrão
	Compra() {
		
	}
	
	//Construtor iniciando com um array de Itens de Compra
	Compra(ItemDeCompra[] produtos){
		this.produtos = produtos;
	}
	
	//Método de inserir um item no array de Itens de Compra
	public void inserirItem(ItemDeCompra itemDeCompra) {
		for(int i = 0; i < produtos.length; i++) {
			if(produtos[i] == null) {
				produtos[i] = itemDeCompra;
				break;
			}
		}
	}
	
	//Calcular o valor bruto da compra
	public double calcularTotalCompra() {
		double total = 0.0;
		for(int i = 0; i < produtos.length; i++) {
			if(produtos[i] != null) {
				total += produtos[i].calcularTotal();
			}
		}
		return total;
	}
	
	//Calcular o valor do desconto
	public void darDesconto(double porcentagem) {
		this.desconto = calcularTotalCompra()*porcentagem/100;
	}
	
	//Calcular o valor liquido da compra
	public void calcularTotalFinal() {
		this.total = calcularTotalCompra() - desconto;
	}
	
	
	//Exibir o cupom fiscal
	public void gerarRelatorio() {
		System.out.println();
		System.out.println("-------------CUPOM FISCAL-------------");
		System.out.println();
		for(int i = 0; i < produtos.length; i++) {
			if(produtos[i] != null) {
				System.out.println("Produto:               " + produtos[i].nome);
				System.out.println("Codigo do Produto:     " + produtos[i].codigo);
				System.out.println("Preco unitario:        R$" + produtos[i].precoUnitario);
				System.out.println("Quantidade:            " + produtos[i].quantidadeComprada);
				System.out.println();
			}
		}
		System.out.println("...........................................................");
		switch(this.formaDePagamento) {
		case 1:
			System.out.println("Forma de Pagamento:     A vista");
			System.out.println("Valor bruto             R$" + calcularTotalCompra());
			System.out.println("Valor do desconto       R$" + desconto);
			System.out.printf("Valor total da compra:  R$%.2f", this.total);
			break;
		case 2:
			System.out.println("Forma de Pagamento:     Cartao de Credito");
			System.out.println("Valor bruto             R$" + calcularTotalCompra());
			System.out.println("Valor do desconto       R$" + desconto);
			System.out.printf("Numero de Parcelas:     %d%n", quantidadeParcelas);
			System.out.printf("Valor de cada parcela:  R$%.2f%n", this.total / quantidadeParcelas);
			System.out.printf("Valor total da compra:  R$%.2f", this.total);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
}
