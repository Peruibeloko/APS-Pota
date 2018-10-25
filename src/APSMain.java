
import java.util.Arrays;
import java.util.Random;

public class APSMain {

    /*

    Carlos Mendonca - 20948288
    Laura Damaceno  - 20964736

     */

    public static void main(String[] args) {

        int[] vetor1 = new int[5];
        int[] vetor2 = new int[10];
        int[] vetor3 = new int[50];
        int[] vetor4 = new int[100];
        int[] vetor5 = new int[1000];
        int[] vetor6 = new int[10000];
        int[][] matVetores = {vetor1, vetor2, vetor3, vetor4, vetor5, vetor6};

        for (int i = 0; i <= matVetores[0].length; i++) {

            Sorting s = new Sorting();

            s.fillRandom(matVetores[i]);
            System.out.printf("Vetor no. %d: %s\n", i + 1, Arrays.toString(matVetores[i]));

        } // preencher vetores

        for (int i = 0; i <= matVetores[0].length; i++){

            for (int j = 0; j < 5; j++) {

                Sorting s = new Sorting();

                int[] vetTemp = matVetores[i].clone();
                long tempo = System.currentTimeMillis();
                int comparacoes = s.sort(j, vetTemp);

                System.out.printf("\nResultado com %d elementos (Algoritmo no. %d): %s", matVetores[i].length, j + 1, Arrays.toString(vetTemp));
                System.out.printf("\nTotal de comparacoes: %d", comparacoes);
                System.out.printf("\nTempo de Execucao(ms): %d\n", (System.currentTimeMillis() - tempo));
            }
        }
    }
}
