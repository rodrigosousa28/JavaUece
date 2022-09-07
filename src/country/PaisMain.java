package country;

public class PaisMain {
	
	public static void main(String[] args) {
		
		Pais a = new Pais("Brasil", "Brasilia", 8516000);
		Pais b = new Pais("Canada", "Ottawa", 9985000);
		Pais c = new Pais("China", "Pequim", 9597000);
		Pais d = new Pais("Estados Unidos", "Nova Iorque", 9000);
		Pais teste = new Pais("Canada", "Vancouver", 8516000);
		
		
		//Testando os métodos get
		System.out.println(a.getNomePais());
		System.out.println(b.getNomeCapital());
		System.out.println(c.getDimensao());
		
		//Testando métodos set
		d.setNomePais("EUA");
		System.out.println(d.getNomePais());
		d.setNomeCapital("Washington");
		System.out.println(d.getNomeCapital());
		d.setDimensao(9834000);
		
		//Testando se um país é igual ao outro
		System.out.println(teste.equals(b));
		
		//Testando o método de setar os países vizinhos e o de recuperar esses países
		Pais[] vizinhos1 = {a, b, c, teste};
		Pais[] vizinhos2 = {a, b, c};
		
		teste.setFronteiras(vizinhos1);
		System.out.println(teste.getFronteiras());
		
		teste.setFronteiras(vizinhos2);
		System.out.println(teste.getFronteiras());
	}
}
