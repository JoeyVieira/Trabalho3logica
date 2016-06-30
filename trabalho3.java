import java.util.Locale;
import java.util.Scanner;

public class trabalho3 {
    
    
    /**
	* Esta função mostra um menu de opçoes	
	*/
	public static void Menu() {
		System.out.println("qual opçao ? "
                                     + "1 – Imprimir tabela\n" +
                                    "2 – Pesquisar produto *\n" +
                                    "3 – Mostrar dados do produto mais caro\n" +
                                    "4 – Mostrar código e descrição dos produtos cuja quantidade está abaixo de 10\n" +
                                    "5 – Ativo total do estoque **\n" +
                                    "6 – Efetuar uma venda ***\n" +
                                    "7 – Sair");
		
		}
	/**
	* Esta função lê os dados dos produtos
	* @param cod é o vetor do codigo do produto
	* @param descr é o vetor de descriçao do produto
        * @param estoque é o vetor que vê a quantidade em estoque.
	* @param valor é o vetor de preço do produto
	* 
	*/
	public static void lervet(String[] cod,String[] descr,double[] valor,int[] estoque){
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		Locale.setDefault(new Locale("en","US"));
		
		
		for(int i=0;i<cod.length;i++){
			System.out.print("\nEntre com o código do "+(i+1)+"º produto: ");
			cod[i]=sc.next();
			System.out.print("\nEntre com a descrição do "+(i+1)+"º produto: ");
			descr[i]=sc.next();	
			System.out.print("\nEntre com o preço do "+(i+1)+"º produto: ");
			valor[i]=sc.nextDouble();
			System.out.print("\nEntre com a quantidade do "+(i+1)+"º produto: ");
			estoque[i]=sc.nextInt();
		}		
	}
	
	/**
	* Esta função trata o menu de opções
	* @param opçao operacao a ser realizada
	* @param cod é o vetor do codigo do produto
	* @param descr é o vetor de descriçao do produto
        * @param estoque é o vetor que vê a quantidade em estoque.
	* @param valor é o vetor de preço do produto		
	*/
	public static void tratarMenu(int opçao,String[] cod,String[] descr,double[] valor,int[] estoque){		
		if(opçao == 1){
			impressãoTabela(cod,descr,valor,estoque);
		}
		if(opçao == 2){
			pesquisaProduto(cod,descr,valor,estoque);			
		}
		if(opçao == 3){
			mostrarMaisCaro(cod,descr,valor,estoque);			
		}
		if(opçao == 4){
			mostraMenos10(cod,descr,estoque);
		}
		if(opçao == 5){
			ativoEstoque(valor,estoque);
		}
		if(opçao == 6){
			efetuarVenda(cod,descr,valor,estoque);
		}
		if(opçao == 7){
			System.out.println("Programa terminado.");			
		}		
	}
	/**
	* Esta função imprime a tabela de produtos
	* @param cod é o vetor do codigo do produto
	* @param descr é o vetor de descriçao do produto
        * @param estoque é o vetor que vê a quantidade em estoque.
	* @param valor é o vetor de preço do produto			
	*/
	public static void impressãoTabela(String[] cod,String[] descr,double[] valor,int[] estoque){		
		for(int i=0;i<cod.length;i++){
			System.out.print("Código produto: "+cod[i]+"\t | \tDescrição: "+descr[i]+" \t |" );
			System.out.printf("\tvalor: \t |",valor[i]);
			System.out.println( "\tQuantidade no Estoque: "+estoque[i]);
		}
	}
	/**
	* Esta função imprime pruduto pesquisado
	* @param cod é o vetor do codigo do produto
	* @param descr é o vetor de descriçao do produto
        * @param estoque é o vetor que vê a quantidade em estoque.
	* @param valor é o vetor de preço do produto			
	*/
	public static void pesquisaProduto(String[] cod,String[] descr,double[] valor,int[] estoque){
		Scanner sc = new Scanner(System.in);
                
		System.out.print("Insira o codigo do produto:");
		String code=sc.next();
		int cont=0;
                int pos=0;
		for(int i=0;i<cod.length;i++){
			if(code.equals(cod[i])){
				pos=i;
				cont++;
			}
		}
		if(cont!=0){				
			System.out.print("Código: "+cod[pos]+"\t | \tDescrição"+descr[pos]+" \t | ");
			System.out.printf("\tPreço:  ",valor[pos]);
			System.out.println(" \t | Quantidade no Estoque:"+estoque[pos]+" \t | ");
			System.out.printf("\tValor Total no Estoque: ",(estoque[pos]*valor[pos]));
		}
		else{
			System.out.println("não existe.");
		}		
	}	
	/**
	* Esta função imprime pruduto mais caro
	* @param cod é o vetor do codigo do produto
	* @param descr é o vetor de descriçao do produto
        * @param estoque é o vetor que vê a quantidade em estoque.
	* @param valor é o vetor de preço do produto		
	*/
	public static void mostrarMaisCaro(String[] cod,String[] descr,double[] valor,int[] estoque){
		int max=0;
		for(int i=0;i<valor.length;i++){
			if(valor[i]>valor[max]){
				max=i;
			}
		}
		System.out.print("Código: "+cod[max]+"\t | \tDescrição"+descr[max]+" \t | ");
		System.out.printf("\tPreço: ",valor[max]);
		System.out.print(" \t | Quantidade em Estoque:"+estoque[max]+" \t | ");
		System.out.printf("\tValor Total no Estoque: ",(estoque[max]*valor[max]));
		
	}
	/**
	* Esta função imprime produtos com menos de 10 unidades no estoque
	* @param cod é o vetor do codigo do produto
	* @param descr é o vetor de descriçao do produto
        * @param estoque é o vetor que vê a quantidade em estoque.		
	*/
	public static void mostraMenos10(String[] cod,String[] descr,int[] estoque){
		System.out.println(" produtos com menos de 10 unidades no estoque:");
		int cont=0;
		for(int i=0;i<estoque.length;i++){
			if(estoque[i]<10){
				System.out.println("Código: "+cod[i]+"\t | \tDescrição: "+descr[i]);
					cont++;		
			}
		}
		if(cont==0){
			System.out.println("Não há produtos com menos de 10 unidades no estoque.");
		}
	}
	/**
	* Esta função imprime o total ativo no estoque
	* @param valor é o vetor de preço do produto	
	* @param estoque é o vetor que vê a quantidade em estoque.		
	*/
	public static void ativoEstoque(double[] valor,int[] estoque){
		double te=0;
		for(int i=0;i<valor.length;i++){
			te=(valor[i]*estoque[i]);
		}
		System.out.printf("Total Ativo no Estoque:", te);
	}
	/**
	* Esta função efetua compras
	* @param cod vetor de codigo do produto
	* @param descr é o vetor de descriçao do produto
        * @param estoque é o vetor que vê a quantidade em estoque.
	* @param valor é o vetor de preço do produto		
	*/
	public static void efetuarVenda(String[] cod,String[] descr,double[] valor,int[] estoque){
		Scanner sc = new Scanner(System.in);
		System.out.println("Efetuar Venda:\nCódigo do produto:");
		String code=sc.next();
		int cont=0;
		int pos=0;
		for(int i=0;i<cod.length;i++){
			if(code.equals(cod[i])){
				pos=i;
				cont++;
			}
		}
		if(cont==0){
			System.out.println("Código não encontrado.");
		}
		else{
			System.out.print("Código: "+cod[pos]+"\t | \tDescrição"+descr[pos]+" \t | ");
			System.out.printf("\tPreço: R$%.2f ",valor[pos]);
			System.out.println(" \t | Quantidade em Estoque:"+estoque[pos]+" \t | ");
			System.out.println("\nInforme a quantidade de produtos a ser vendida:");
			int qv=sc.nextInt();
			if(qv<=estoque[pos]){
				estoque[pos]=qv;
				System.out.println("Venda efetuada com sucesso.");
			}
			else{
				System.out.println("Não possuimos essa quantidade em estoque, venda não pode ser efetuada.");
			}
		}
		
	}
	
	public static void main(String args[]){	
            
            
                    Scanner sc = new Scanner(System.in);
                    sc.useLocale(Locale.ENGLISH);
		  Locale.setDefault(new Locale("en","US"));
                  
		System.out.print("Digite a quantidade de produtos a serem digitados:");
		int N =sc.nextInt();	
                
		String cod[]=new String[N];
		String descr[]=new String[N];
		double valor[]=new double[N];
		int estoque[]=new int[N];		
		lervet(cod,descr,valor,estoque);
		int a=0;
		while(a!=7){
			Menu();
			a=sc.nextInt();
			tratarMenu(a,cod,descr,valor,estoque);
		}		
		sc.close();
	}
}
