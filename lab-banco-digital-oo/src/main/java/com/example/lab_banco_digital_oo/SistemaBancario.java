package com.example.lab_banco_digital_oo;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SistemaBancario {
  private List<Banco> bancos = new ArrayList<>();

  public SistemaBancario(List<Banco> bancos) {
    this.bancos = bancos;
  }

  public void addBanco(Banco banco) {
    this.bancos.add(banco);
  }

  public Banco getBancoPorNome(String nome) {

    return bancos.stream()
        .filter(banco -> banco.getNome().equalsIgnoreCase(nome))
        .findFirst()
        .orElse(null);

  }

  public Conta getContaPorNumero(int numeroContaSacar) {
    for (Banco banco : bancos) {
      for (Conta conta : banco.getContas()) {
        if (conta.getAgencia() == Conta.AGENCIA_PADRAO && conta.getNumero() == numeroContaSacar) {
          return conta;
        } else {
          System.out.println("Conta não encontrada.");
          break;
        }
      }
    }
    return null;
  }

}
