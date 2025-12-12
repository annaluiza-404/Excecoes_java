import java.util.Scanner;
public class Main{
    public static void main(String[]args){
        Scanner entrada=new Scanner(System.in);
        ContaBancaria conta=null;
        
        for(;;){
            System.out.println("MENU\n1-Cadastro titular\n2-Depositar\n3-Sacar\n4-Dados da conta\n5-Sair");
            int op= entrada.nextInt();
            if(op==5){
                System.out.println("Saindo do programa...");
                break;
            }
            entrada.nextLine();
            if (conta == null && op >= 2 && op <= 4) {
                System.out.println("\nERRO: Você precisa cadastrar a conta primeiro (Opção 1).");
                continue;
            }
            
            switch(op){
                case 1:
                    System.out.println("Digite o numero da conta:");
                    String numConta=entrada.nextLine();
                    System.out.println("Digite o nome do titular:");
                    String titular=entrada.nextLine();
                    conta=new ContaBancaria(numConta,titular,0.0);
                    break;
                case 2:
                    System.out.println("Digite o valor a ser depositado:");
                    double valorDeposito=entrada.nextDouble();
                    System.out.println("Valor depositado com sucesso!");
                    conta.depositar(valorDeposito);
                    break;
                case 3:
                    System.out.println("Digite o valor que deseja sacar:");
                    double valorSaque=entrada.nextDouble();
                    try{
                        conta.sacar(valorSaque);
                    } catch(SaldoInsuficienteException e){
                        System.out.println("Erro: "+e.getMessage());
                    }
                    break;
                case 4:
                    conta.exibir();
                    break;
            }
        }
        
    }
}
