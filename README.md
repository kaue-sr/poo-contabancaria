# Projeto — Classe ContaBancaria

## Sobre o projeto

Este projeto foi desenvolvido para a disciplina de **Programação Orientada a Objetos (POO)** na FIAP, aplicando na prática conceitos de modelagem, proteção de estado e abstração em Java.

A classe `ContaBancaria` simula o funcionamento de uma conta corrente do mundo real, gerenciando o saldo do usuário e aplicando regras de negócio para depósitos, saques e uso de limite de cheque especial.

---

## Classe ContaBancaria

A classe `ContaBancaria` possui os seguintes atributos para definir o estado da conta:

* `titular`: representa o nome do titular da conta.
* `numeroConta`: representa o identificador ou número da conta bancária.
* `saldo`: representa o valor disponível em conta corrente.
* `limiteChequeEspecial`: representa o valor de limite adicional concedido ao titular para saques quando o saldo for insuficiente.

---

## Proteção do Estado e Regras de Negócio

Para evitar que o objeto fique em um estado inconsistente (como aceitar depósitos negativos ou permitir saques além do limite configurado), os métodos contêm validações de regras de negócio.

As regras implementadas são:

* **Validação de Depósito:** O valor do depósito precisa ser estritamente maior que zero (`valor > 0`).
* **Validação de Saque Negativo:** Não é permitido realizar saques de valores menores ou iguais a zero (`valor > 0`).
* **Cobertura de Cheque Especial:** O valor solicitado para saque não pode ultrapassar o valor total disponível na soma do saldo com o limite do cheque especial (`valor <= saldo + limiteChequeEspecial`).

---

## Métodos

### `depositar(double valor)`

Adiciona fundos ao saldo do titular.

Exemplo:
`conta1.depositar(200.0);`

Valores maiores que zero são somados ao saldo. Depósitos com valores negativos ou zerados são rejeitados e exibem uma mensagem de erro no terminal.

### `sacar(double valor)`

Realiza retiradas da conta corrente respeitando o limite disponível.

Exemplo:
`conta1.sacar(100.0);`

Se o valor solicitado for menor ou igual ao saldo atual, a dedução ocorre normalmente. Caso o valor supere o saldo, mas esteja dentro da margem permitida pelo limite de cheque especial, o saque é autorizado e o saldo fica negativo (indicando a utilização do cheque especial).

---

## Exemplo de utilização

Exemplo prático de instanciação e chamadas de métodos extraído da classe `SistemaPrincipal`:

package br.com.contabancaria.main;

import br.com.contabancaria.model.ContaBancaria;

public class SistemaPrincipal {
    public static void main(String[] args) {
        // Criando conta com saldo 0.0 e limite de R$ 50.00
        ContaBancaria conta1 = new ContaBancaria("Kaue Souza", "0709", 50.0);
        conta1.depositar(200.0);
        conta1.sacar(100.0);
        System.out.println("Saldo final: R$ " + conta1.saldo);

        System.out.println("---");

        // Criando conta com saldo 0.0 e limite de R$ 100.00
        ContaBancaria conta2 = new ContaBancaria("Beatriz Alves", "0907", 100.0);
        conta2.depositar(150.0);
        
        // Saque utilizando o cheque especial (150 de saldo + 100 de limite = 250 liberados)
        conta2.sacar(240.0); 
        System.out.println("Saldo final: R$ " + conta2.saldo); // Exibe -90.0
    }
}

### Testes com valores inválidos ou acima do limite:

// Tentativa de depósito com valor inválido
conta1.depositar(-50.0); 

// Tentativa de saque com valor zerado/negativo
conta1.sacar(0.0); 

// Tentativa de saque que ultrapassa a soma do saldo + cheque especial
conta1.sacar(1000.0); 

Nesses casos, as regras de negócio barram a execução e garantem que a integridade financeira e os dados da conta sejam preservados.

---

## Como Executar o Projeto

1. Navegue até a pasta `src`:
   `cd src`

2. Compile os arquivos Java:
   `javac br/com/contabancaria/model/ContaBancaria.java br/com/contabancaria/main/SistemaPrincipal.java`

3. Execute o programa principal:
   `java br.com.contabancaria.main.SistemaPrincipal`

---

## Objetivo

O objetivo principal deste projeto é consolidar conceitos fundamentais da **Programação Orientada a Objetos em Java**, tais como: **instanciação de objetos, encapsulamento de atributos, construção de métodos com validações de estado e controle de regras de negócio em sistemas bancários**.