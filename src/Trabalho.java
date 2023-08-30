import java.util.*;
import java.util.Random;
import java.util.stream.Collectors;

public class Trabalho {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int contador = 1;

        List<String> listaPalavras = listaDePalavras();

        System.out.println("");
        System.out.println("             Descubra a palavra embaralhada");
        System.out.println("-------------------------------------------------------------");
        System.out.println("                     [1] Regras");
        System.out.println("                     [2] Jogar");
        System.out.println("                     [3] Sair");
        System.out.println("-------------------------------------------------------------");
        System.out.print("Digite o número da opcão desejada: ");
        int opcao = sc.nextInt();

        while (opcao != 0) {
            if (opcao == 1) {
                System.out.println("-------------------------------------------------------------");
                System.out.println("Regras:");
                System.out.println("-1: Você tem que adivinhar a palavra embaralhada que lhe for mostrada");
                System.out.println("-2: Você terá 3 tentativas para adivinhar a palavra");
                System.out.println("-------------------------------------------------------------");
                System.out.println();
            } else if (opcao == 2) {
                var palavra = palavraEscolhida(listaPalavras);
                var palavraEmbaralhada = palavraEmbaralhada(palavra);
                contador = 1;

                System.out.println("-------------------------------------------------------------");
                System.out.println("Tente adivinhar a seguinte palavra: " + palavraEmbaralhada);
                System.out.printf("-%d° tentativa: ", contador);
                sc.nextLine();
                String tentativa = sc.nextLine();
                contador++;

                while (!tentativa.equals(palavra) && contador <= 3) {
                    System.out.printf("-%d° tentativa: ", contador);
                    tentativa = sc.nextLine();
                    contador++;
                }

                if (tentativa.equals(palavra)) {
                    System.out.println("Parabéns, você acertou!!");
                } else {
                    System.out.println("Acabou suas tentativas, tente novamente!");
                }

                System.out.println("-------------------------------------------------------------");
            } else if (opcao == 3) {
                System.out.println("Obrigado por jogar!!");
                break;
            } else {
                System.out.println("Opção inválida!");
                System.out.println("-------------------------------------------------------------");
            }

            System.out.println("             Descubra a palavra embaralhada");
            System.out.println("-------------------------------------------------------------");
            System.out.println("                     [1] Regras");
            System.out.println("                     [2] Jogar");
            System.out.println("                     [3] Sair");
            System.out.println("-------------------------------------------------------------");
            System.out.print("Digite o número da opção desejada: ");
            opcao = sc.nextInt();
        }
    }

    public static List<String> listaDePalavras() {
        var listaPalavras = new ArrayList();
        listaPalavras.add("paralelepípedo");
        listaPalavras.add("bicicleta");
        listaPalavras.add("onibus");
        listaPalavras.add("passarela");
        listaPalavras.add("binóculo");
        listaPalavras.add("computador");
        listaPalavras.add("capacete");
        listaPalavras.add("teclado");
        listaPalavras.add("esqueleto");
        listaPalavras.add("descubra");
        listaPalavras.add("espada");

        return listaPalavras;
    }

    public static String palavraEscolhida(List<String> listaPalavras) {
        Random random = new Random();
        String palavra = listaPalavras.get(random.nextInt(listaPalavras.size()));

        return palavra;
    }

    public static String palavraEmbaralhada(String palavra) {
        List<Character> palavraEmabaralhada = palavra.chars().boxed().map(c -> (char) c.intValue()).collect(Collectors.toList());
        Collections.shuffle(palavraEmabaralhada);
        StringBuilder t = new StringBuilder(palavra.length());
        palavraEmabaralhada.forEach(t::append);
        return t.toString();
    }
}