package banco;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Banco b1 = new Banco("Santander");
		Banco b2 = new Banco("Caixa");
		Banco b3 = new Banco("Bradesco");
		
		Conta c1 = new Conta("Karine", 2808, 5000);
		Conta c2 = new Conta("Rodrigo", 1108, 4500);
		
		b1.cadastrarConta(c1);
		b1.cadastrarConta(c2);
		
		Scanner scan = new Scanner(System.in);
		
		Map<Integer, Banco> bancos = new HashMap<>();
		bancos.put(1, b1);
		bancos.put(2, b2);
		bancos.put(3, b3);
		
		first: while(true) {
			Banco.exibirMenuInicial();
			
			int escolhaBanco = scan.nextInt();
			while(escolhaBanco > bancos.size()) {
				System.out.println("Banco invalido. Selecione uma das opcoes acima: ");
				escolhaBanco = scan.nextInt();
			}
			second: while(true) {
				Banco b = null;
				for(Entry<Integer, Banco> banco: bancos.entrySet()) {
					if(banco.getKey() == escolhaBanco) {
						System.out.printf("Bem vindo ao banco %s%n%n", banco.getValue().getNome());
						b = banco.getValue();
					}
				}
				
				System.out.print("Informe o numero da sua conta: ");
				int numeroConta = scan.nextInt();
				Conta c = b.procurarConta(numeroConta);
				if(c == null) {
					System.out.println("\nConta inexistente, deseja criar uma nova conta? \r\n"
							+ "\r\n"
							+ "1. Sim\r\n"
							+ "2. Nao");
					int escolha = scan.nextInt();
					if(escolha == 1) {
						System.out.print("\nInforme o seu nome: ");
						String nome = scan.next();
						Random random = new Random();
						int numero = random.nextInt(1000, 10000);
						System.out.printf("Numero da conta gerado: %d", numero);
						Conta nova = new Conta(nome, numero);
						if(b.cadastrarConta(nova)) {
							System.out.println("\nConta cadastrada com sucesso");
						}else {
							System.out.println("Houve algum erro!");
						}
					}
				}
				while (true) {
					if(c != null) {
						System.out.printf("%nOla %s, selecione uma opcao: %n", c.getNome());
						Banco.exibirMenuInterno();
						int opcao = scan.nextInt();
						
						switch(opcao) {
						case 1:
							System.out.printf("Saldo: R$%.2f", c.getSaldo());
							break;
						case 2:
							System.out.println("Informe o valor que voce quer sacar: R$");
							double valorSaque = scan.nextDouble();
							if(b.sacarValor(c, valorSaque)) {
								System.out.printf("Valor sacado com sucesso. Saldo restante: R$%.2f", c.getSaldo());
								break;
							}
						case 3:
							System.out.print("Informe o valor a ser depositado: R$");
							double valorDeposito = scan.nextDouble();
							b.depositarValor(c, valorDeposito);
							System.out.printf("Valor depositado. Novo saldo: R$%.2f", c.getSaldo());
							break;
						case 4:
							System.out.print("Informe o numero da conta para qual quer transferir: ");
							numeroConta = scan.nextInt();
							Conta contaDestino = b.procurarConta(numeroConta);
							if(contaDestino != null) {
								System.out.print("Informe o valor que sera transferido: R$");
								valorDeposito = scan.nextDouble();
								Conta cAuxiliar = b.procurarConta(numeroConta);
								if(b.transferirValor(c, cAuxiliar, valorDeposito)) {
									System.out.printf("Valor depositado com sucesso. Saldo restante: R$%.2f", c.getSaldo());
								}
							}else {
								System.out.println("Conta inexistente!");
							}
							
							break;
						case 5:
							System.out.print("\nInforme o seu nome: ");
							String nome = scan.next();
							Random random = new Random();
							int numero = random.nextInt(1000, 10000);
							System.out.printf("Numero da conta gerado: %d", numero);
							Conta nova = new Conta(nome, numero);
							if(b.cadastrarConta(nova)) {
								System.out.println("\nConta cadastrada com sucesso");
							}else {
								System.out.println("Houve algum erro!");
							}
							break;
						}
					}
					System.out.println("\nEscolha uma opcao"
							+ "\n1. Sair"
							+ "\n2. Trocar de Banco"
							+ "\n3. Menu Inicial do Banco atual");
					int choice = scan.nextInt();
					if(choice == 1) {
						break first;
					}else if(choice == 2) {
						break second;
					}
				}
			}
		}
		
		
		scan.close();
	}
}
