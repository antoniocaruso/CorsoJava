import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class GestioneAgenda {
    final static int NOME = 0;
    final static int COGNOME = 1;
    final static int TEL = 2;
    
    final static int STAMPA_RUBRICA = 1;
    final static int CERCA_NOME = 2;
    final static int CERCA_COGNOME = 3;
    final static int CERCA_NUMERO = 4;
    
    // massimo indice di riga valido per l'agenda
    static int voci_valide = 0;   
    
    static String argomento = "";

	public static void main(String[] args) {
		// leggi i dati dall'agenda
		String[][] agenda = LeggiAgenda(System.in);
        voci_valide = agenda.length;
		int comando = InterfacciaUtente();
        switch (comando) {
            case CERCA_COGNOME:
                CercaCognome(agenda);
                break;
        }
	}
    
    public static void CercaCognome(String[][] agenda)
    {
        String cognome = argomento;
        boolean nontrovato = true;
        for (int i=0; i<voci_valide; i++)
            if (cognome.equals(agenda[i][COGNOME])) {
                nontrovato = false;
                System.out.println(agenda[i][NOME]+","+
                                   agenda[i][COGNOME]+","+
                                   agenda[i][TEL]);
            }
        if (nontrovato)
            System.out.println("Mi spiace, "+cognome+" non è in agenda.");
    }
    
    public static int InterfacciaUtente()
    {
        System.out.println("----------------------");
        System.out.println(" 1) Stampa Rubrica");
        System.out.println(" 2) Cerca Voce");
        System.out.println(" 3) Modifica Rubrica");
        System.out.println(" 4) Ordina");
        System.out.println(" 5) Salva Rubrica");
        System.out.println("-----------------------");
        System.out.println("- Inserisci un comando da eseguire: ");
        Scanner input = new Scanner(System.in);
        
        int scelta = 0;
        do { scelta = input.nextInt(); } while (scelta >= 6 || scelta < 1);
        if (scelta == 1) return STAMPA_RUBRICA;
        if (scelta == 2) {
            System.out.println("Vuoi cercare per a) nome b) cognome c) numero ?");
            String c = input.next();
            switch (c.charAt(0)) {
                case 'a':  System.out.println("Inserisci un nome:");
                           argomento = input.next();
                           break;
                case 'b':  System.out.println("Inserisci un cognome:");
                           argomento = input.next();
                           return CERCA_COGNOME;
                case 'c':  System.out.println("Inserisci un telefono:");
                           argomento = input.next();
                           break;
                default:    // errore
            }
        }
        return 0;
    }
	
	private static void StampaAgenda(String[][] agenda) {
		System.out.println("------- Agenda Corrente: --------");
		for (int i=0; i<agenda.length; i++) {
			String[] p = agenda[i];
			System.out.println(p[NOME]+" "+p[COGNOME]+" "+p[TEL]);
		}
		System.out.println("--------------------------------");		
	}


	private static String[][] LeggiAgenda(InputStream in) {
		final int COL = 3;
		//Scanner input = new Scanner(System.in);
		try {
			File fin = new File("agenda.txt");
			Scanner input = new Scanner(fin);
			
			// Leggiamo quante righe sono in agenda.
			int N = input.nextInt();
			input.nextLine();
		
			String[][] rubrica = new String[N][COL];
		
			for (int i=0; i<N; i++)
			{
				String l = input.nextLine();
				String[] colonne = l.split(",");
				rubrica[i][NOME] = colonne[NOME];
				rubrica[i][COGNOME] = colonne[COGNOME];
				rubrica[i][TEL] = colonne[TEL];
/*				System.out.println(rubrica[i][NOME]+" "+
                                   rubrica[i][COGNOME]+" "+
                                   rubrica[i][TEL]); */
			}
			return rubrica;
			
		} catch (FileNotFoundException e) {
			System.out.println("Mi spiace, rubrica non trovata.");
			System.exit(1);
		};
		return null;
	}

}
