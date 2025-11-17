import java.util.Scanner;
import java.util.Random;

class Esercizio {

    public static Scanner in = new Scanner( System.in );
    public static Random random = new Random();

    public static record Max(int massimo, int rIdx, int cIdx) { }

    public static Max calcolaMassimo( int[][] M, int RIGHE, int COLONNE ) {
        int max = M[0][0];
        int maxR = 0;
        int maxC = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (M[i][j] > max) {
                    max = M[i][j];
                    maxR = i;
                    maxC = j;
                }
            }
        }
        return new Max(max, maxR, maxC);
    }

    public static float calcolaMedia( int[][] M, int r, int c ) {
        float somma = 0;
        for (int i = 0; i < r; i++) {
            somma += M[i][c];
        }
        return somma / r;
    }

    public static void riempiCasuale( int[][] M, int r, int c, int valMin, int valMax) {
        Random rand = new Random();
        for (int i=0; i <= r-1; i=i+1 ) {
            for (int j=0; j <= c-1; j=j+1) {
                M[i][j] = valMin + rand.nextInt((valMax+1)-valMin);
            }
        }
    }

    public static void main(String args[]) {

        System.out.print("Inserisci numero righe: ");
        int r= in.nextInt();

        System.out.print("Inserisci numero colonne: ");
        int c= in.nextInt();

        int[][] M = new int[r][c];

        riempiCasuale(M, r, c, 0, 99);

        System.out.println("\nMatrice generata:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(M[i][j] + "\t");
            }
            System.out.println();
        }

        Max risultato = calcolaMassimo(M, r, c);
        System.out.println("\nValore massimo: " + risultato.massimo());
        System.out.println("Posizione -> riga: " + risultato.rIdx() +
                           ", colonna: " + risultato.cIdx());

        System.out.print("\nInserisci indice colonna per calcolare la media: ");
        int c = in.nextInt();

        float media = calcolaMedia(M, r, c);
        System.out.println("Media della colonna " + c + ": " + media);
    }
}