public class ContaBancaria{
    private String numeroConta;
    private String nomeTitular;
    private double saldo;
    
    //construtor
    public ContaBancaria(String numeroConta, String nomeTitular, double saldo){
        this.numeroConta=numeroConta;
        this.nomeTitular=nomeTitular;
        this.saldo=saldo;
    }
    
    public String getNumeroConta(){
        return numeroConta;
    }
    public void setNumeroConta(String numeroConta){
        this.numeroConta=numeroConta;
    }
    
    public String getNomeTitular(){
        return nomeTitular;
    }
    public void setNomeTitular(String nomeTitular){
        this.nomeTitular=nomeTitular;
    }
    public double getSaldo(){
        return saldo;
    }
    public void setSaldo(double saldo){
        this.saldo=saldo;
    }
    
    
    public void depositar(double valor){
        saldo+=valor;
    }
    
    public void sacar(double valor) throws SaldoInsuficienteException{
        if(saldo<valor){
            throw new SaldoInsuficienteException("o saldo é insufieciente para esse valor de saque!");
        }else{
            saldo-=valor;
            System.out.println("Saque efetuado com sucesso!");
        }
    }
    public void exibir(){
        System.out.println("Numero da conta: "+numeroConta+"\nTitular: "+nomeTitular+"\nSaldo: "+saldo);
    }
    
}
