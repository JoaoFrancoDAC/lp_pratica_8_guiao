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

    //Testes de levantar
    @Test
    public void levantarValoresNegativos(){
        ContaBancaria conta = new ContaBancaria(2);
        conta.levantar(-3);

        assertEquals("2", conta.getSaldo(), "Levantar valores negativos aumenta o valor da conta");
    };

    @Test
    public void levantarValoresPositivosSuperioresAoValorDaConta(){
        ContaBancaria conta = new ContaBancaria(2);
        conta.levantar(3);

        assertEquals("2", conta.getSaldo(), "Levantar valores superiores ao valor atual da conta devolve false mas executa e mete o saldo a 0");
    };

    @Test
    public void levantarValoresNegativosDevolveTrue(){
        ContaBancaria conta = new ContaBancaria(3);
        //conta.levantar(3);

        assertEquals(false, conta.levantar(-3), "Deveria devolver false mas devolve true");
    };
}
