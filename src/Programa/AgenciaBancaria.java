package Programa;

import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {

  static Scanner input = new Scanner(System.in);
  static ArrayList<Conta> contasBancarias;

  public static void main(String[] args) {
    contasBancarias = new ArrayList<Conta>();
    operacoes();
  }

  public static void operacoes() {

    System.out.println("________________________________________________________________");
    System.out.println("___________________Bem vindos a nossa Agencia___________________");
    System.out.println("**********Selecione uma operação que deseja realizar************");
    System.out.println("________________________________________________________________");
    System.out.println("|     Opção 1 - Criar conta     |");
    System.out.println("|     Opção 2 - Depositar       |");
    System.out.println("|     Opção 3 - Sacar           |");
    System.out.println("|     Opção 4 - Transferir      |");
    System.out.println("|     Opção 5 - Listar          |");
    System.out.println("|     Opção 6 - Sair            |");

    int operacao = input.nextInt();

    switch (operacao) {
      case 1:
      criarConta();
        break;
      case 2:
        depositar();
        break;
      case 3:
        sacar();
        break;
      case 4:
        transferir();
        break;
      case 5:
        listarContas();
        break;
      case 6:
        System.out.println("Obrigado pela preferencia!");;
        System.exit(0);

      default:
        System.out.println("Opção inválida!");
        operacoes();
        break;

    }

  }

  public static void criarConta() {
    System.out.println("\nNome: ");
    String nome = input.next();

    System.out.println("\nCPF: ");
    String cpf = input.next();

    System.out.println("\nEmail: ");
    String email = input.next();

    Cliente cliente = new Cliente(nome,cpf, email);

    Conta conta = new Conta(cliente);

    contasBancarias.add(conta);
    System.out.println("Conta criada com sucesso!");

    operacoes();
  }

   private static Conta encontarConta (int numeroConta) {
    Conta conta = null;
    if(contasBancarias.size() > 0) {
      for(Conta c: contasBancarias) {
        if(c.getNumeroConta() == numeroConta) {
        conta = c;
        }
      }
    }
    return conta;
  }

  public static void depositar() {
    System.out.println("Número da conta: ");
    int numeroConta = input.nextInt();

    Conta conta = encontarConta(numeroConta);

    if (conta != null) {
      System.out.println("Valor do depósito ");
      Double valorDeposito = input.nextDouble();
      conta.depositar(valorDeposito);
      System.out.println(" Depósito efetuado! ");
    }else {
      System.out.println(" Conta não encontrada ");
    }
    operacoes();
  }

  public static void sacar() {
    System.out.println("Número da conta: ");
    int numeroConta = input.nextInt();

    Conta conta = encontarConta(numeroConta);

    if (conta != null) {
      System.out.println("Valor do saque ");
      Double valorSaque = input.nextDouble();
      conta.sacar(valorSaque);

    }else {
      System.out.println(" Conta não encontrada ");
    }
    operacoes();

  }

  public static void transferir() {
    System.out.println("Digite sua conta: ");
    int numeroMinhaConta = input.nextInt();

    Conta minhaConta = encontarConta(numeroMinhaConta);

    if (minhaConta != null) {
      System.out.println("Digite a conta depósito: ");
      int numeroContaDeposito = input.nextInt();

      Conta contaDeposito = encontarConta(numeroContaDeposito);

      if (contaDeposito != null) {
        System.out.println("Valor da transferencia: ");
        Double valor = input.nextDouble();

        minhaConta.transferir(contaDeposito, valor);
      }else {
        System.out.println("Conta não encontrada");
      }
    }else {
      System.out.println("Conta não encontrada");
    }
    operacoes();
  }

  public static void listarContas () {
    if (contasBancarias.size() >0) {
      for (Conta conta: contasBancarias) {
        System.out.println(conta);
      }
      }else {
      System.out.println("Não há contas cadastradas!");
    }
    operacoes();
  }

}
