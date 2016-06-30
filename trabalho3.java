import java.util.Locale;
import java.util.Scanner;

public class trabalho3 {
    
    
    /**
	* Esta fun��o mostra um menu de op�oes	
	*/
	public static void Menu() {
		System.out.println("qual op�ao ? "
                                     + "1 � Imprimir tabela\n" +
                                    "2 � Pesquisar produto *\n" +
                                    "3 � Mostrar dados do produto mais caro\n" +
                                    "4 � Mostrar c�digo e descri��o dos produtos cuja quantidade est� abaixo de 10\n" +
                                    "5 � Ativo total do estoque **\n" +
                                    "6 � Efetuar uma venda ***\n" +
                                    "7 � Sair");
		
		}
	/**
	* Esta fun��o l� os dados dos produtos
	* @param cod � o vetor do codigo do produto
	* @param descr � o vetor de descri�ao do produto
        * @param estoque � o vetor que v� a quantidade em estoque.
	* @param valor � o vetor de pre�o do produto
	* 
	*/
	public static void lervet(String[] cod,String[] descr,double[] valor,int[] estoque){
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		Locale.setDefault(new Locale("en","US"));
		
		
		for(int i=0;i<cod.length;i++){
			System.out.print("\nEntre com o c�digo do "+(i+1)+"� produto: ");
			cod[i]=sc.next();
			System.out.print("\nEntre com a descri��o do "+(i+1)+"� produto: ");
			descr[i]=sc.next();	
			System.out.print("\nEntre com o pre�o do "+(i+1)+"� produto: ");
			valor[i]=sc.nextDouble();
			System.out.print("\nEntre com a quantidade do "+(i+1)+"� produto: ");
			estoque[i]=sc.nextInt();
		}		
	}
	
	/**
	* Esta fun��o trata o menu de op��es
	* @param op�ao operacao a ser realizada
	* @param cod � o vetor do codigo do produto
	* @param descr � o vetor de descri�ao do produto
        * @param estoque � o vetor que v� a quantidade em estoque.
	* @param valor � o vetor de pre�o do produto		
	*/
	public static void tratarMenu(int op�ao,String[] cod,String[] descr,double[] valor,int[] estoque){		
		if(op�ao == 1){
			impress�oTabela(cod,descr,valor,estoque);
		}
		if(op�ao == 2){
			pesquisaProduto(cod,descr,valor,estoque);			
		}
		if(op�ao == 3){
			mostrarMaisCaro(cod,descr,valor,estoque);			
		}
		if(op�ao == 4){
			mostraMenos10(cod,descr,estoque);
		}
		if(op�ao == 5){
			ativoEstoque(valor,estoque);
		}
		if(op�ao == 6){
			efetuarVenda(cod,descr,valor,estoque);
		}
		if(op�ao == 7){
			System.out.println("Programa terminado.");			
		}		
	}
	/**
	* Esta fun��o imprime a tabela de produtos
	* @param cod � o vetor do codigo do produto
	* @param descr � o vetor de descri�ao do produto
        * @param estoque � o vetor que v� a quantidade em estoque.
	* @param valor � o vetor de pre�o do produto			
	*/
	public static void impress�oTabela(String[] cod,String[] descr,double[] valor,int[] estoque){		
		for(int i=0;i<cod.length;i++){
			System.out.print("C�digo produto: "+cod[i]+"\t | \tDescri��o: "+descr[i]+" \t |" );
			System.out.printf("\tvalor: \t |",valor[i]);
			System.out.println( "\tQuantidade no Estoque: "+estoque[i]);
		}
	}
	/**
	* Esta fun��o imprime pruduto pesquisado
	* @param cod � o vetor do codigo do produto
	* @param descr � o vetor de descri�ao do produto
        * @param estoque � o vetor que v� a quantidade em estoque.
	* @param valor � o vetor de pre�o do produto			
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
			System.out.print("C�digo: "+cod[pos]+"\t | \tDescri��o"+descr[pos]+" \t | ");
			System.out.printf("\tPre�o:  ",valor[pos]);
			System.out.println(" \t | Quantidade no Estoque:"+estoque[pos]+" \t | ");
			System.out.printf("\tValor Total no Estoque: ",(estoque[pos]*valor[pos]));
		}
		else{
			System.out.println("n�o existe.");
		}		
	}	
	/**
	* Esta fun��o imprime pruduto mais caro
	* @param cod � o vetor do codigo do produto
	* @param descr � o vetor de descri�ao do produto
        * @param estoque � o vetor que v� a quantidade em estoque.
	* @param valor � o vetor de pre�o do produto		
	*/
	public static void mostrarMaisCaro(String[] cod,String[] descr,double[] valor,int[] estoque){
		int max=0;
		for(int i=0;i<valor.length;i++){
			if(valor[i]>valor[max]){
				max=i;
			}
		}
		System.out.print("C�digo: "+cod[max]+"\t | \tDescri��o"+descr[max]+" \t | ");
		System.out.printf("\tPre�o: ",valor[max]);
		System.out.print(" \t | Quantidade em Estoque:"+estoque[max]+" \t | ");
		System.out.printf("\tValor Total no Estoque: ",(estoque[max]*valor[max]));
		
	}
	/**
	* Esta fun��o imprime produtos com menos de 10 unidades no estoque
	* @param cod � o vetor do codigo do produto
	* @param descr � o vetor de descri�ao do produto
        * @param estoque � o vetor que v� a quantidade em estoque.		
	*/
	public static void mostraMenos10(String[] cod,String[] descr,int[] estoque){
		System.out.println(" produtos com menos de 10 unidades no estoque:");
		int cont=0;
		for(int i=0;i<estoque.length;i++){
			if(estoque[i]<10){
				System.out.println("C�digo: "+cod[i]+"\t | \tDescri��o: "+descr[i]);
					cont++;		
			}
		}
		if(cont==0){
			System.out.println("N�o h� produtos com menos de 10 unidades no estoque.");
		}
	}
	/**
	* Esta fun��o imprime o total ativo no estoque
	* @param valor � o vetor de pre�o do produto	
	* @param estoque � o vetor que v� a quantidade em estoque.		
	*/
	public static void ativoEstoque(double[] valor,int[] estoque){
		double te=0;
		for(int i=0;i<valor.length;i++){
			te=(valor[i]*estoque[i]);
		}
		System.out.printf("Total Ativo no Estoque:", te);
	}
	/**
	* Esta fun��o efetua compras
	* @param cod vetor de codigo do produto
	* @param descr � o vetor de descri�ao do produto
        * @param estoque � o vetor que v� a quantidade em estoque.
	* @param valor � o vetor de pre�o do produto		
	*/
	public static void efetuarVenda(String[] cod,String[] descr,double[] valor,int[] estoque){
		Scanner sc = new Scanner(System.in);
		System.out.println("Efetuar Venda:\nC�digo do produto:");
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
			System.out.println("C�digo n�o encontrado.");
		}
		else{
			System.out.print("C�digo: "+cod[pos]+"\t | \tDescri��o"+descr[pos]+" \t | ");
			System.out.printf("\tPre�o: R$%.2f ",valor[pos]);
			System.out.println(" \t | Quantidade em Estoque:"+estoque[pos]+" \t | ");
			System.out.println("\nInforme a quantidade de produtos a ser vendida:");
			int qv=sc.nextInt();
			if(qv<=estoque[pos]){
				estoque[pos]=qv;
				System.out.println("Venda efetuada com sucesso.");
			}
			else{
				System.out.println("N�o possuimos essa quantidade em estoque, venda n�o pode ser efetuada.");
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
