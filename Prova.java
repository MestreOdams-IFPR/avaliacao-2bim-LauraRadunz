import java.util.Scanner;

public class Prova {
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        // respostaRecursivo();
        // recursvivo1();
        // recursivo2();
        // testeForca();
        // int casosFraseCompleta = teclado.nextInt();
        // fraseCompleta(casosFraseCompleta);
        buscaCristais();
    }

    public static void buscaCristais() {
        int caso = 0;
        while (true) {
            int cristaisKyber = teclado.nextInt();
            int consultas = teclado.nextInt();
            if (cristaisKyber == 0 && consultas == 0) {
                break;
            }
            int[] numerosKyber = criarVetor(cristaisKyber);
            numerosKyber = lerVetor(numerosKyber);

            numerosKyber = mergeSort(numerosKyber);
            numerosKyber = inverterVetor(numerosKyber, 0, cristaisKyber-1);

            for (int i = 0; i < consultas; i++) {
                int numero = teclado.nextInt();
                int valor = numero;
                numero = buscaBinaria(numerosKyber, numero, 0, cristaisKyber-1);
                caso++;
                System.out.println("CASE# "+caso+":");
                if (numero==-1) {
                    System.out.println(valor +" not found");
                    System.out.println();
                } else {
                    System.out.println(valor+" found at "+numero);
                    System.out.println();
                }
            }

        }

    }

    public static int buscaBinaria(int[] v, int num, int inicio, int fim) {
        int meio = (inicio+fim)/2;
        if (inicio==fim&&inicio!=num) {
            return -1;
        }
        if (v[meio] == num) {
            while (meio>0 && v[meio-1] == num) {
                meio --;
            }
            return meio;
        } else if (num<v[meio]) {
            return buscaBinaria(v, num, inicio, meio-1);
        } else {
            return buscaBinaria(v, num, meio+1, fim);
        }
    }

    public static void testeForca() {
        while (teclado.hasNext()) {
            int n = teclado.nextInt();
            int[] pontuacoes = criarVetor(n);
            int k = teclado.nextInt();
            pontuacoes = lerVetor(pontuacoes);
            pontuacoes = mergeSort(pontuacoes);
            pontuacoes = inverterVetor(pontuacoes, 0, n - 1);
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
        v[j] = temp;
        return inverterVetor(v, i + 1, j - 1);
    }

    public static void fraseCompleta(int casos) {
        teclado.next();
        int i = 0;
        while (true) {
            if (i == casos) {
                break;
            }
            String frase = teclado.nextLine();
            String[] caracteres = frase.toLowerCase().split("");
            String[] alfabeto = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
                    "r", "s", "t", "u", "v", "w", "x", "y", "z" };

            for (String n : caracteres) {
                for (int j = 0; j < alfabeto.length; j++) {
                    if (n.equals(alfabeto[j])) {
                        alfabeto[j] = "0";
                    }
                }
            }

            int zeros = 0;
            for (int j = 0; j < alfabeto.length; j++) {
                if (alfabeto[j].equals("0")) {
                    zeros++;
                }
            }
            String resposta = formularResposta(zeros);
            System.out.println(resposta);
            i++;
        }

    }

    public static String formularResposta(int zeros) {
        if (zeros == 26) {
            return "frasecompleta";
        }
        if (zeros >= 13) {
            return "frase quase completa";
        }
        return "frase mal elaborada";
    }

    public static void recursivo2() {
        int n = teclado.nextInt();
        n = pell(n);
        System.out.println(n);
    }

    public static void recursvivo1() {
        int n = teclado.nextInt();
        n = tribonacci(n);
        System.out.println(n);
    }

    public static int pell(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return 2 * pell(n - 1) + pell(n - 2);

    }

    public static int tribonacci(int n) {
        if (n == 0 || n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        }
        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }

    public static void respostaRecursivo() {
        // O método está invertendo um vetor
    }

    // 0 0 1 1 2 4 7

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
