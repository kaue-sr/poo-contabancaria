package br.com.contabancaria.model;

public class ContaBancaria {
    private Cliente titular;
    private String numeroConta;
    private double saldo;
    private double limiteChequeEspecial;

    public ContaBancaria(Cliente titular, String numeroConta) {
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

        if (valor > (this.saldo + this.limiteChequeEspecial)) {
            System.out.println("O valor é maior que o saldo disponível");
            return;
        }

        this.saldo -= valor;
        System.out.println("Saque realizado com sucesso, seu saldo atual é de: " + this.saldo);
    }

    public void exibirResumo() {
        System.out.println("\n--- RESUMO DA CONTA ---");
        System.out.println("Número da Conta: " + this.numeroConta);
        System.out.println("Titular: " + this.titular.getNome());
        System.out.println("CPF do Titular: " + this.titular.getCpf());
        System.out.println("Saldo Atual: R$ " + this.saldo);
        System.out.println("-----------------------\n");
    }

    public Cliente getTitular() {
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

    private void setTitular(Cliente titular) {
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