package Programa;

import Programas.Utilitarios.Utils;

import javax.swing.*;

public class Conta {

  private static int contadorDeContas = 1;

  private int numeroConta;
  private Cliente cliente;
  private Double saldo = 0.0;

  public Conta( Cliente cliente   ) {
    this.numeroConta = contadorDeContas;
    this.cliente = cliente;
    contadorDeContas += 1;
  }

  public int getNumeroConta() {
    return numeroConta;
  }

  public void setNumeroConta(int numeroConta) {
    this.numeroConta = numeroConta;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Double getSaldo() {
    return saldo;
  }

  public void setSaldo(Double saldo) {
    this.saldo = saldo;
  }

  @Override
  public String toString() {
    return "\nNúmero da conta: " + this.getNumeroConta()+
           "\nNome: " + this.cliente.getNome() +
           "\nCPF: " + this.cliente.getCPF() +
           "\nEmail: " + this.cliente.getEmail() +
           "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
           "\n";
  }

  public void depositar(Double valor) {
    if (valor > 0) {
      setSaldo(getSaldo() + valor);
      JOptionPane.showMessageDialog(null,"Depósito realizado com sucesso! ");
    }else {
      JOptionPane.showMessageDialog(null,"Erro ao depositar ");
    }
  }

  public void sacar(Double valor) {
    if(valor > 0 && this.getSaldo() >= valor) {
      setSaldo(getSaldo() - valor);
      JOptionPane.showMessageDialog(null,"Saque realizado com sucesso! ");
    }else {
      JOptionPane.showMessageDialog(null,"Saldo não permite saque ");
    }
  }

  public void transferir(Conta contaParaDeposito, Double valor) {
    if(valor > 0 && this.getSaldo() >= valor) {
      setSaldo(getSaldo() - valor);

      contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
      JOptionPane.showMessageDialog(null,"Transferencia realizada com sucesso! ");
    }else {
      JOptionPane.showMessageDialog(null,"Não foi possível realizar a transferencia ");
      System.out.println("Não foi possível realizar a transferencia");
    }
  }
}
