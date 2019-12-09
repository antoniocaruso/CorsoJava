
import java.util.Scanner;

public class AddIntegers {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Inserisci un intero: ");
		int a = input.nextInt();

		System.out.print("Inseriscine un altro: ");
		int b = input.nextInt();
		int somma = a + b;

		System.out.print("La somma è ");
		System.out.print(somma);
        System.out.print(" ed è ");
                
        if (somma % 2 == 0)
            System.out.println("PARI.");
        else 
            System.out.println("DISPARI.");
        System.out.println("Finito.");
    }
};
