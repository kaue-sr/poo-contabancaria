package br.com.contabancaria.main;

import br.com.contabancaria.model.ContaBancaria;

public class SistemaPrincipal {
    public static void main(String[] args) {
        // Conta 1: Saldo inicial 0, Cheque Especial 50
        ContaBancaria conta1 = new ContaBancaria("Kaue Souza", "0709", 50.0);
        conta1.depositar(200.0);
        conta1.sacar(100.0);
        System.out.println("saldo: " + conta1.saldo);

        System.out.println("---");

        // Conta 2: Saldo inicial 0, Cheque Especial 100
        // Após depositar 150, o limite de saque passa a ser 250 (150 + 100)
        ContaBancaria conta2 = new ContaBancaria("Beatriz Alves", "0907", 100.0);
        conta2.depositar(150.0);
        conta2.sacar(240.0); // O saque é permitido e o saldo fica negativo em -90.0
        System.out.println("saldo: " + conta2.saldo);
    }
}