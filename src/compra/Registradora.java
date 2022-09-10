package compra;

import java.util.Scanner;


public class Registradora {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Compra c = new Compra();
		boolean choice;
		
		System.out.println("Bem vindo ao Mercadinho UECE");
		
		do {
			System.out.print("\nInforme o produto que deseja comprar: ");
			String nome = scan.next();
			System.out.printf("Informe o codigo de %s: ", nome);
			int codigo = scan.nextInt();
			for(int i = 0; i < c.getItensDeCompra().length; i++) {
				if(c.getItensDeCompra()[i] != null) {
					while(c.getItensDeCompra()[i].getCodigo() == codigo && c.getItensDeCompra()[i].getNome() != nome) {
						System.out.print("Erro, ja existe um produto com este codigo, informe outro: ");
						codigo = scan.nextInt();
					}
				}
			}
			System.out.printf("Informe o Preco de %s: ", nome);
			double precoUnitario = scan.nextDouble();
			System.out.printf("Quantos %ss voce vai comprar? ", nome);
			int quantidadeComprada = scan.nextInt();
			
			ItemDeCompra item = new ItemDeCompra(codigo, nome, precoUnitario, quantidadeComprada);
			c.inserirItem(item);
			
			System.out.print("Deseja continuar <S/N>? ");
			String esc = scan.next();
			esc = esc.substring(0).toUpperCase();
			if(esc.equals("S")) {
				choice = true;
			}else {
				choice = false;
			}
		}while(choice == true);
		
		System.out.println("\nInforme a forma de pagamento: ");
		System.out.println("1. A vista");
		System.out.println("2. Cartao de credito");
		
		int formaDePagamento = scan.nextInt();
		int valorDesconto = 0;
		
		if(formaDePagamento == 2) {
			System.out.print("\nInforme em quantas parcelas vai querer passar: ");
			int quantidadeParcelas = scan.nextInt();
			while(quantidadeParcelas > 3) {
				System.out.print("Maximo de 3 parcelas. Informe em quantas parcelas vai querer passar: ");
				quantidadeParcelas = scan.nextInt();
			}
			while(quantidadeParcelas <= 0) {
				System.out.print("No minimo 1 parcela. Informe em quantas parcelas vai querer passar: ");
				quantidadeParcelas = scan.nextInt();
			}
			c.setQuantidadeParcelas(quantidadeParcelas);
		}
		
		c.setFormaDePagamento(formaDePagamento);
		
		switch(formaDePagamento) {
		case 1:
			valorDesconto = 10;
			break;
		case 2:
			valorDesconto = 5;
			break;
		default:
			valorDesconto = 0;
		}
		
		c.calcularTotalCompra();
		c.darDesconto(valorDesconto);
		c.calcularTotalFinal();
		
		c.gerarRelatorio();
		
		scan.close();
	}
}
