
public class CopiaArray {
	public static void main(String[] args)
	{
		int[] v = new int[10];
		System.out.println("Riempio un Array v:");
		for (int i=0; i<10; i++) {
			v[i] = 2*i;
			System.out.println(i+" "+v[i]);
		}
		System.out.println("-------------------");

		int[] w = new int[10];
		w = v;
		w[2] = 1000;
		for (int i=0; i<10; i++)
			System.out.printf("%d v = %d w = %d\n",i,v[i],w[i]);
	
        // Stringhe:
        String s = "Ciao";
        String t = "Pippo";
        System.out.println(s+" "+t);
        s = t;
        System.out.println(s+" "+t);
        s = "Pluto";
        System.out.println(s+" "+t);
        
        
    
    
    }
}
