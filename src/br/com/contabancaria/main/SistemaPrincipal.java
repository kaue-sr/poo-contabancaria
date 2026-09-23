package br.com.contabancaria.main;

import br.com.contabancaria.model.Cliente;
import br.com.contabancaria.model.ContaBancaria;

public class SistemaPrincipal {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Kaue", "123.456.789-00");

        ContaBancaria conta = new ContaBancaria(cliente, "12345");

        conta.depositar(200.0);

        conta.sacar(100.0);

        System.out.println("saldo: " + conta.getSaldo());

        System.out.println("Número da conta: " + conta.getNumeroConta());

        conta.exibirResumo();
    }
}