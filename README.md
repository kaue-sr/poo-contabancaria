# Projeto Conta Bancária - POO

Projeto desenvolvido para a disciplina de Programação Orientada a Objetos (FIAP). 

## Descrição do Objeto
A classe `ContaBancaria` representa uma conta corrente no mundo real, gerenciando o saldo do usuário com suporte a limite de cheque especial.

## Métodos Implementados
- `depositar(double valor)`: Adiciona fundos à conta (requer valor maior que zero).
- `sacar(double valor)`: Realiza retiradas validando se o valor está dentro da soma do saldo com o cheque especial.

## Como Executar
1. Navegue até a pasta `src`:
   ```bash
   cd src

## Compile os arquivos:
javac br/com/contabancaria/model/ContaBancaria.java br/com/contabancaria/main/SistemaPrincipal.java

## Execute o projeto:
java br.com.contabancaria.main.SistemaPrincipal