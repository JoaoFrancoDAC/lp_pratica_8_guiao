package pt.ulusofona.lp2.homeBanking;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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


        //boolean sucesso = conta.levantar(150);

        assertEquals("100", conta.getSaldo(), "O saldo deve ser 100");
    }

    @Test
    public void testConstrutorNegativo() {
        ContaBancaria conta = new ContaBancaria(-100);

        assertEquals("0", conta.getSaldo(), "O saldo deve ser 0");
    }

    @Test
    public void testTransferencia() {
        ContaBancaria conta = new ContaBancaria(100);
        ContaBancaria seguntaConta = new ContaBancaria(100);





        assertEquals("100", conta.getSaldo(), "O saldo deve ser 100");
    }

}
