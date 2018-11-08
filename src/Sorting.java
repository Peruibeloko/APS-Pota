
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

    private int insertion(int[] vetor) {

        int j;
        int comparacoes = 0;

        for (int i = 1; i < vetor.length; i++) {

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

            if (a[i] < a[p]) {

                i++;

            } else {

                if (a[j] > a[p]) {

                    j--;

                } else {

                    int aux = a[i];
                    a[i] = a[j];
                    a[j] = aux;
                    i++;
                    j--;
                }

                globalCount++;
            }

            globalCount++;
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

            B[r + q + 1 - j] = A[j];
        }

        i = p;
        j = r;

        for (k = p; k <= r; k++) {

            if (B[i] <= B[j]) {

                A[k] = B[i];
                i = i + 1;

            } else {

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