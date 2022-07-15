package Programa;

import javax.swing.*;

import java.util.ArrayList;


public class AgenciaBancaria {

  static ArrayList<Conta> contasBancarias;

  public static void main(String[] args) {
    contasBancarias = new ArrayList<Conta>();
    operacoes();
  }

  public static void operacoes() {

    int operacao = Integer.parseInt(JOptionPane.showInputDialog("|--- Selecione uma operação ---" +

                   "|     Opção 1 - Criar conta " +
                   "|     Opção 2 - Depositar " +
                   "|     Opção 3 - Sacar " +
                   "|     Opção 4 - Transferir " +
                   "|     Opção 5 - Listar " +
                   "|     Opção 6 - Sair "));


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
        JOptionPane.showMessageDialog(null,"Obrigado pela preferencia!");
        System.exit(0);

      default:
        JOptionPane.showMessageDialog(null,"Opção inválida!");
        operacoes();
        break;

    }

  }

  public static void criarConta() {

    Cliente cliente = new Cliente();

    cliente.setNome(JOptionPane.showInputDialog("Nome:"));

    cliente.setCPF(JOptionPane.showInputDialog("CPF:"));

    cliente.setEmail(JOptionPane.showInputDialog("Email:"));



    Conta conta = new Conta(cliente);

    contasBancarias.add(conta);
    JOptionPane.showMessageDialog(null,"Conta criada com sucesso!");
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

    int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Número da conta para depósito:"));

    Conta conta = encontarConta(numeroConta);

    if (conta != null) {
      Double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Valor do depósito: "));
      conta.depositar(valorDeposito);
      JOptionPane.showMessageDialog(null,"Depósito efetuado! ");
    }else {
      JOptionPane.showMessageDialog(null,"Conta não encontrada ");
    }
    operacoes();
  }

  public static void sacar() {
    int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Número da conta: "));

    Conta conta = encontarConta(numeroConta);

    if (conta != null) {
      Double valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Valor do saque "));
      conta.sacar(valorSaque);

    }else {
      JOptionPane.showMessageDialog(null,"Conta não encontrada ");
    }
    operacoes();

  }

  public static void transferir() {
    int numeroMinhaConta = Integer.parseInt(JOptionPane.showInputDialog("Digite sua conta: "));

    Conta minhaConta = encontarConta(numeroMinhaConta);

    if (minhaConta != null) {
      int numeroContaDeposito = Integer.parseInt(JOptionPane.showInputDialog("Digite a conta depósito: "));

      Conta contaDeposito = encontarConta(numeroContaDeposito);

      if (contaDeposito != null) {
        Double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor da transferencia: "));

        minhaConta.transferir(contaDeposito, valor);
      }else {
        JOptionPane.showMessageDialog(null,"Conta não encontrada ");
      }
    }else {
      JOptionPane.showMessageDialog(null,"Conta não encontrada ");
    }
    operacoes();
  }

  public static void listarContas () {
    if (contasBancarias.size() >0) {
      for (Conta conta: contasBancarias) {
        JOptionPane.showMessageDialog(null,conta);
      }
      }else {
      JOptionPane.showMessageDialog(null,"Não há contas cadastradas! ");
         }
    operacoes();
  }

}
