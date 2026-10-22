package pt.ulusofona.lp2.homeBanking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestContaBancaria {

    @Test
    void construtorDefineSaldoInicial() {
        ContaBancaria conta = new ContaBancaria(100);

        assertEquals("100", conta.getSaldo());
    }

    @Test
    void depositarSaldoPositivo(){
        ContaBancaria conta = new ContaBancaria(100);

        assertEquals("100", conta.getSaldo());
        conta.depositar(20);
        assertEquals("120", conta.getSaldo());
    }

    @Test
    void depositarSaldoNegativo(){
        ContaBancaria conta = new ContaBancaria(100);

        assertEquals("100", conta.getSaldo());
        conta.depositar(-20);
        assertEquals("80", conta.getSaldo());
    }
}
