import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Prova {
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        //exercicio1();
        // exercicio2();
        testeForca();
    }

    public static void testeForca() {
        while (teclado.hasNext()) {
            int n = teclado.nextInt();
            int[] pontuacoes = criarVetor(n);
            int k = teclado.nextInt();
            pontuacoes = lerVetor(pontuacoes);
            pontuacoes = mergeSort(pontuacoes);
            pontuacoes = inverterVetor(pontuacoes, 0, n-1);
            int soma = 0;
            for (int i = 0; i < k; i++) {
                soma += pontuacoes[i];
            }
            System.out.println(soma);
        }
    }

    public static int[] inverterVetor(int[] v, int i, int j) {
        if (i >= j) {
            return v;
        }
        int temp = v[i];
        v[i] = v[j];
        v[j] = v[i];
        return inverterVetor(v, i+1, j-1);
    }

    public static void fraseCompleta() {
        String frase = teclado.nextLine();
        String[] caracteres = frase.toLowerCase().split("");
        String[] alfabeto = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        for (String n : caracteres) {
        for (int i = 0; i < alfabeto.length; i++) {
            if (n == alfabeto[i]) {
                alfabeto[i] = "0";
            }
        }
        }

        int zeros = 0;
        for (int i = 0; i < alfabeto.length; i++) {
            if (!alfabeto[i].equals("0")) {
                zeros++;
            }
        }

        if (zeros==26) {
            String resposta = “frasecompleta”;
        }
    }

    public static void exercicio2() {
        int n = teclado.nextInt();
        n = tribonacci(n, 0, 0, 0, 1, 3);
        System.out.println(n);
    }

    // public static int pell(int n) {
    //     if (n == 0) {
    //         return valor;
    //     }
    //     valor =  2*pell(n-1) + pell(n=2);

    // }

    public static int tribonacci(int n, int valor, int a, int b, int c, int d) {
        if (n == 3) {
            return 1;
        } else if (n == 1 || n ==2) {
            return 0;
        } if (d == n) {
            return valor;
        }    
        a = b;
        b = c;
        return tribonacci(n, c, a, b, a+b, d+1);

    }

    public static void exercicio1() {
        //O método está invertendo um vetor
    }

    //0 0 1 1 2 4 7 


























    public static int quickSort(int[] v) {
        int movimentos = quickSortRec(v, 0, v.length - 1);
        imprimirVetor(v);
        return movimentos;
    }

    private static int quickSortRec(int[] v, int inicio, int fim) {
        int movimentos = 0;
        if (inicio < fim) {
            int[] resultadoParticao = particionar(v, inicio, fim);
            int pivoIndex = resultadoParticao[0];
            movimentos += resultadoParticao[1];

            movimentos += quickSortRec(v, inicio, pivoIndex - 1);
            movimentos += quickSortRec(v, pivoIndex + 1, fim);
        }
        return movimentos;
    }

    private static int[] particionar(int[] v, int inicio, int fim) {
        int pivo = v[fim];
        int i = inicio - 1;
        int movimentos = 0;

        for (int j = inicio; j < fim; j++) {
            if (v[j] <= pivo) {
                i++;
                swap(v, i, j);
                movimentos++;
            }
        }
        swap(v, i + 1, fim);
        movimentos++;

        return new int[] { i + 1, movimentos };
    }

    public static int[] swap(int[] v, int i, int j) {
        int temp = v[i];
        v[i] = v[j];
        v[j] = temp;
        return v;
    }


    public static int[] mergeSort(int[] v) {
        if (v.length < 2) {
            return v;
        }

        int meio = v.length / 2;
        int[] direita = criarVetor(v.length - meio);
        int[] esquerda = criarVetor(meio);

        for (int i = 0; i < meio; i++) {
            esquerda[i] = v[i];
        }
        for (int i = meio; i < v.length; i++) {
            direita[i - meio] = v[i];
        }

        mergeSort(esquerda);
        mergeSort(direita);
        mesclarVetor(v, esquerda, direita);

        return v;
    }

    public static int[] mesclarVetor(int[] v, int[] esquerda, int[] direita) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < direita.length && j < esquerda.length) {
            if (direita[i] <= esquerda[j]) {
                v[k] = direita[i];
                k++;
                i++;
            } else {
                v[k] = esquerda[j];
                k++;
                j++;
            }
        }

        while (i < direita.length) {
            v[k] = direita[i];
            k++;
            i++;
        }

        while (j < esquerda.length) {
            v[k] = esquerda[j];
            k++;
            j++;
        }

        return v;
    }

    public static void imprimirVetor(int[] n) {
        for (int i = 0; i < 10; i++) {
            System.out.print(n[i] + "  ");
        }
        System.out.println();
    }

    public static int[] lerVetor(int[] v) {
        for (int i = 0; i < v.length; i++) {
            v[i] = teclado.nextInt();
        }
        return v;
    }

    public static int[] criarVetor(int n) {
        int[] vetor = new int[n];
        return vetor;
    }
}
