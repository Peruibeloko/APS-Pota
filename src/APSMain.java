
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
        String[] algoritmos = {"Bubble", "Selection", "Insertion", "Merge", "Quick"};

        for (int i = 0; i <= matVetores[0].length; i++) {

            Sorting s = new Sorting();

            s.fillRandom(matVetores[i]);
            System.out.printf("Vetor no. %d: %s\n", i + 1, Arrays.toString(matVetores[i]));

        } // preencher vetores

        long[][] tempos1 = new long[6][5], tempos2 = new long[6][5];
        int[][] comparacoes = new int[6][5];

        for (int i = 0; i <= matVetores[0].length; i++){

            for (int j = 0; j < 5; j++) {

                Sorting s = new Sorting();

                int[] vetTemp = matVetores[i].clone();

                tempos1[i][j] = System.nanoTime();
                comparacoes[i][j] = s.sort(j, vetTemp);
                tempos2[i][j] = System.nanoTime();

                System.out.printf("\nResultado com %d elementos (%s): %s", matVetores[i].length, algoritmos[j], Arrays.toString(vetTemp));
                System.out.printf("\nTotal de comparações: %d", comparacoes[i][j]);
                System.out.printf("\nTempo de Execuçao: %.3fms\n", (double) (tempos2[i][j] - tempos1[i][j])/1000000);

            }
        }

        /* //Auxilio para a criacao de tabelas

        for (int k = 0; k < 6; k++){

            for (int l = 0; l < 5; l++) {

                System.out.printf("%d;", comparacoes[k][l]);
                if (l == 4)
                    System.out.print("\n");
            }
        }

        for (int k = 0; k < 6; k++){

            for (int l = 0; l < 5; l++) {

                System.out.printf("%.4f;", (double) (tempos2[k][l] - tempos1[k][l]) / 1000000);
                if (l == 4)
                    System.out.print("\n");
            }
        }

        */
    }
}
