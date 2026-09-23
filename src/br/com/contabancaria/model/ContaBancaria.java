package br.com.contabancaria.model;

public class ContaBancaria {
    private String titular;
    private String numeroConta;
    private double saldo;
    private double limiteChequeEspecial;

    public ContaBancaria(String titular, String numeroConta) {
        this.setTitular(titular);
        this.setNumeroConta(numeroConta);
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Por favor digite um valor maior que 0");
            return;
        }

        this.saldo += valor;
        System.out.println("Valor depositado com sucesso! Seu saldo é de: " + this.saldo);
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Não é possível sacar valores menores ou iguais a 0");
            return;
        }

        // Permite sacar até o valor total (Saldo + Cheque Especial)
        if (valor > (this.saldo + this.limiteChequeEspecial)) {
            System.out.println("O valor é maior que o saldo disponível");
            return;
        }

        this.saldo -= valor;
        System.out.println("Saque realizado com sucesso, seu saldo atual é de: " + this.saldo);
    }

    public String getTitular() {
        return this.titular;
    }

    public String getNumeroConta() {
        return this.numeroConta;
    }

    public double getLimiteCheque() {
        return this.limiteChequeEspecial;
    }

    public double getSaldo() {
        return this.saldo;
    }

    private void setTitular(String titular) {
        this.titular = titular;
    }

    private void setNumeroConta(String numeroConta) {
        if (numeroConta.length() >= 1 && numeroConta.length() <= 5) {
            this.numeroConta = numeroConta;
        } else {
            System.out.println("Número da conta inválido!");
        }
    }
}

// Criar Getters e Setters automáticos para todos os atributos sem nenhum critério é um problema, porque a IDE não conhece as regras do mundo real.
// Isso compromote o sistema de duas formas, fazendo com que atributos fundamentais do código sejam definidos logo no início do objeto e não sejam mais modificados.
//E a violação do Encapsulamento, que faz com que o saldo da conta não seja editado, sendo modificado apenas com operações do próprio sistema, se o saldo fosse publico poderiamos injetar qualquer valor no saldo sem passar por nenhuma validação. Eliminando esse setter, deixamos com que esse objeto só possa ser modificado a partir dos métodos "depositar" e "sacar".