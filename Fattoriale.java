
import java.util.Scanner;

public class Fattoriale {

    public static int fattoriale(int n)
    {
        System.out.println("Entro in fatt. n = "+n);
        int risultato = 0;
        //if (n == 1) return 1; else return n*fattoriale(n-1);
        if (n == 1) risultato = 1; else risultato = n*fattoriale(n-1);
        System.out.println("Esco da fatt. n = " + n + "= " + risultato );
        return risultato;
    }

    public static void main(String[] s)
    {
        System.out.println("Esempio di funzione ricorsiva.");
        Scanner input = new Scanner(System.in);
        System.out.println("Inserisci un intero: ");
        int i = input.nextInt();
        System.out.println("Fattoriale di " + i + " = " + fattoriale(i));
    }
};