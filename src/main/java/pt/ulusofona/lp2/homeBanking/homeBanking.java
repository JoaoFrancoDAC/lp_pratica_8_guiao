package pt.ulusofona.lp2.homeBanking;

public class homeBanking {


    public static void main(String[] args) {

        ContaBancaria joao = new ContaBancaria(0);
        ContaBancaria pedro = new ContaBancaria(10);

        a primeiroA = new a(0);
        a segundoA = new a(10);

        joao.depositar(100);
        joao.levantar(20);

        System.out.println(primeiroA.a());
        System.out.println(segundoA.a());

        System.out.println("Saldo do João: " + joao.getSaldo());
        System.out.println("Saldo do Pedro: " + pedro.getSaldo());

        joao.levantar(999);

        System.out.println("Saldo do João: " + joao.getSaldo());
        System.out.println("Saldo do Pedro: " + pedro.getSaldo());
    }
}
