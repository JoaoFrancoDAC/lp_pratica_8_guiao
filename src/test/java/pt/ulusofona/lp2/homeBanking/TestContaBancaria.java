package pt.ulusofona.lp2.homeBanking;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestContaBancaria {
    @Test
    public void testeFalhaLevantamentoNaoDeveZerarConta() {
        ContaBancaria conta = new ContaBancaria(100);


        boolean sucesso = conta.levantar(150);
        assertFalse(sucesso, "Levantamento falha e saldo deveria se manter");

        assertEquals("100", conta.getSaldo(), "O saldo não deve ser alterado após um levantamento falhado.");
    }

    @Test
    public void testConstrutorPositivo() {
        ContaBancaria conta = new ContaBancaria(100);

        assertEquals("100", conta.getSaldo(), "O saldo deve ser 100");
    }

    @Test
    public void testConstrutorNegativo() {
        ContaBancaria conta = new ContaBancaria(-100);

        assertEquals("0", conta.getSaldo(), "O saldo deve ser 0");
    }

    @Test
    public void testDepositarZero(){
        ContaBancaria conta = new ContaBancaria(10);
        conta.depositar(0);


        assertEquals("10", conta.getSaldo(), "Depositar 0 não deveria alterar nada");
    }

    @Test
    public void testTransferencia_Taxa(){
        ContaBancaria conta = new ContaBancaria(2);
        ContaBancaria segundaConta = new ContaBancaria(100);

        boolean deveSerFalso = conta.transferirPara(segundaConta, 1);
        assertFalse(deveSerFalso);

        assertEquals("2", conta.getSaldo(), "O saldo deve ser 2, a transferencia deve falhar");
        assertEquals("100", segundaConta.getSaldo(), "O saldo deve permanecer 100");

    }

    @Test
    public void testTransferencia_ForaDosLimites() {
        ContaBancaria conta = new ContaBancaria(100);
        ContaBancaria segundaConta = new ContaBancaria(100);

        conta.transferirPara(segundaConta,99);

        assertEquals("100", conta.getSaldo(), "O saldo deve ser 100 pois a transferencia deveria falhar, mas nao falha");
        assertEquals("100", segundaConta.getSaldo(), "O saldo deve ser 100");
    }



    @Test
    void construtorDefineSaldoInicial() {
        ContaBancaria conta = new ContaBancaria(100);

        assertEquals("100", conta.getSaldo());
    }

    @Test
    void construtorDefineSaldoInicialNegativo() {
        ContaBancaria conta = new ContaBancaria(-100);

        assertEquals("-100", conta.getSaldo());
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
        assertEquals("100", conta.getSaldo());
    }

    @Test
    void levantarPositivo(){
        ContaBancaria conta = new ContaBancaria(100);

        assertEquals("100", conta.getSaldo());
        assertTrue(  conta.levantar(20));
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

    @Test
    void levantarNegativoErroboolean(){
        ContaBancaria conta = new ContaBancaria(100);

        assertEquals("100", conta.getSaldo());
        assertFalse(  conta.levantar(-20));
    }

    @Test
    void levantarNegativoErroNaoPermite(){//erro da mas mexe no valor do saldo na mesma
        ContaBancaria conta = new ContaBancaria(100);

        assertEquals("100", conta.getSaldo());
        assertTrue(  conta.levantar(-20));
        assertEquals("100", conta.getSaldo());
    }
    @Test
    void levantarPositivoMaiorSaldo(){//erro da mas mexe no valor do saldo na mesma
        ContaBancaria conta = new ContaBancaria(100);

        assertEquals("100", conta.getSaldo());
        assertFalse(  conta.levantar(120));
        assertEquals("100", conta.getSaldo());
    }
}
