package br.com.contabancaria.model;

public class ContaBancaria {
    public String titular;
    public String numeroConta;
    public double saldo;
    public double limiteChequeEspecial;

    public ContaBancaria(String titular, String numeroConta, double limiteChequeEspecial) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.limiteChequeEspecial = limiteChequeEspecial;
        this.saldo = 0.0;
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
}