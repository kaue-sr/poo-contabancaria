package br.com.contabancaria.main;

import br.com.contabancaria.model.ContaBancaria;

public class SistemaPrincipal {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria("Kaue","12345");
        // Fazendo um deposito
        conta.depositar(200.0);
        // Fazendo um saque
        conta.sacar(100.0);
        // Consultar o saldo
        System.out.println("saldo: " + conta.getSaldo());

        // Consultar número da conta
        System.out.println("Número da conta:" + conta.getNumeroConta());
    }
}