
import java.util.Random;

public class Sorting {

    /*

    Carlos Mendonca - 20948288
    Laura Damaceno  - 20964736

     */

    private int globalCount = 0;

    public Sorting() {
    }

    public int sort(int algorithm, int[] vet){

        switch (algorithm){

            case 0:
                return bubble(vet);

            case 1:
                return selection(vet);

            case 2:
                return insertion(vet);

            case 3:
                mergeCall(vet, 0, vet.length - 1);
                return globalCount;

            case 4:
                quickCall(vet, 0, vet.length - 1);
                return globalCount;

            default:
                return -1;
        }
    }

    private int bubble(int[] vetor) {

        boolean invertido = true;
        int numero;
        int comparacoes = 0;

        while (invertido) {

            invertido = false;

            for (int i = 0; i < vetor.length - 1; i++) {

                if (vetor[i + 1] < vetor[i]) {

                    numero = vetor[i + 1];
                    vetor[i + 1] = vetor[i];
                    vetor[i] = numero;
                    invertido = true;
                }
                comparacoes++;
            }
        }

        return comparacoes;
    }

    private int selection(int[] vetor) {

        int temp;
        int comparacoes = 0;

        for (int i = 0; i < vetor.length - 1; i++) {

            int dado = i;

            for (int j = i + 1; j < vetor.length; j++) {

                if (vetor[j] < vetor[dado]) {
                    dado = j;
                }
                comparacoes++;
            }

            temp = vetor[i];
            vetor[i] = vetor[dado];
            vetor[dado] = temp;
        }

        return comparacoes;
    }

    private int cocktail(int[] vetor) {

        boolean invertido;
        int numero;
        int comparacoes = 0;

        do {

            invertido = false;
            for (int i = 1; i <= vetor.length - 1; i++) { // IDA

                if (vetor[i - 1] > vetor[i]) {

                    numero = vetor[i - 1];
                    vetor[i - 1] = vetor[i];
                    vetor[i] = numero;
                    invertido = true;
                }
                comparacoes++;
            }

            if (!invertido) {
                return comparacoes;
            }

            invertido = false;

            for (int i = vetor.length - 1; i >= 1; i--) { // VOLTA

                if (vetor[i - 1] > vetor[i]) {

                    numero = vetor[i - 1];
                    vetor[i - 1] = vetor[i];
                    vetor[i] = numero;
                    invertido = true;
                }
                comparacoes++;
            }

        } while (invertido);

        return comparacoes;
    }

    private int insertion(int[] vetor) {

        int j;
        int comparacoes = 0;

        for (int i = 1; i < vetor.length - 1; i++) {

            j = i;

            while (j > 0 && vetor[j - 1] > vetor[j]) {

                int temp = vetor[j - 1];
                vetor[j - 1] = vetor[j];
                vetor[j] = temp;
                j = j - 1;
                comparacoes++;
            }
        }

        return comparacoes;
    }

    private int shell(int[] vetor) {

        int valor;
        int gap = 1;
        int comparacoes = 0;

        while (gap < vetor.length) {

            gap = 3 * gap + 1;
        }

        while (gap > 1) {

            gap /= 3;

            for (int i = gap; i < vetor.length; i++) {

                valor = vetor[i];
                int j = i;

                while (j >= gap && valor < vetor[j - gap]) {

                    vetor[j] = vetor[j - gap];
                    j = j - gap;
                    comparacoes++;
                }

                vetor[j] = valor;
            }
        }

        return comparacoes;
    }

    private void mergeCall(int A[], int p, int r){

        globalCount = 0;
        merge(A, p, r);
    }

    private void merge(int A[], int p, int r) {

        if (p < r) {

            int q = (p + r) / 2;
            merge(A, p, q);
            merge(A, q + 1, r);
            intercala(A, p, q, r);
        }
    }

    private void quickCall(int a[], int p, int r){

        globalCount = 0;
        quick(a, p, r);
    }

    private void quick(int a[], int p, int r) {

        if (p < r) {

            int q = split(a, p, r);
            quick(a, p, q - 1);
            quick(a, q + 1, r);
        }
    }

    // Metodos utilitarios

    private int split(int[] a, int p, int q) {

        int i = p + 1;
        int j = q;

        while (i <= j) {

            globalCount++; // fez a comparacao do while e deu verdadeiro

            if (a[i] < a[p]) {

                globalCount++; // entrou no 1o if
                i++;

            } else {

                if (a[j] > a[p]) {

                    globalCount++; // entrou no 2o if
                    j--;

                } else {

                    globalCount++; // entrou no 2o else

                    int aux = a[i];
                    a[i] = a[j];
                    a[j] = aux;
                    i++;
                    j--;
                }

                globalCount++; // entrou no 1o else
            }
        }

        int aux = a[p];
        a[p] = a[j];
        a[j] = aux;

        return j;
    }

    private void intercala(int[] A, int p, int q, int r) {

        int[] B = new int[A.length];
        int i, j, k;

        for (i = p; i <= q; i++) {

            B[i] = A[i];
        }

        for (j = q + 1; j <= r; j++) {

            globalCount++;
            B[r + q + 1 - j] = A[j];
        }

        i = p;
        j = r;

        for (k = p; k <= r; k++) {

            if (B[i] <= B[j]) {

                globalCount++;
                A[k] = B[i];
                i = i + 1;

            } else {

                globalCount++;
                A[k] = B[j];
                j = j - 1;
            }
            globalCount++;
        }
    }

    public void fillRandom (int[] v){

        Random r = new Random();

        for (int i = 0; i < v.length; i++) {

            v[i] = 1 + r.nextInt(101);
        }
    }
}