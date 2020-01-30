
class Calcola2 {
    public static int oplevel(char c) {
        switch(c) {
            case '+': case '-': return 1; 
            case '*': case '/': return 2; 
        }
        return 0;
    }
    
    public static void compute(Stack num, Stack op) {
        while (! op.isEmpty())
        {
            char x = (char)op.pop();
            int a = num.pop();
            int b = num.pop();
            switch(x) {
            case '-':
                //System.out.printf("faccio %d - %d = %d\n",b,a,b-a);
                num.push(b-a); break;
            case '+':
                //System.out.printf("faccio %d + %d = %d\n",a,b,a+b);
                num.push(a+b); break;
            case '*':
                //System.out.printf("faccio %d * %d = %d\n",a,b,a*b);
                num.push(a*b); break;
            case '/':
                //System.out.printf("faccio %d / %d = %d\n",b,a,b/a);
                num.push(b/a); break;
            }
        }
    }
    
    public static void main(String[] args)
    {      
        final int OUT = 0;
        final int IN = 1; 
        int stato = OUT; 
        // leggiamo un espressione da linea di comando
        // nella variabile l.
        String l = "3+4";
        if (args.length > 0)
            l = args[0];
        
        // convertiamo l in un array di caratteri.
        char[] espressione =  l.toCharArray();
        
        // stack degli argomenti.
        Stack numeri = new Stack(20);
        Stack operatori = new Stack(20);
        // leggo la stringa con l'epressione
        // carattere per carattere
        
        int numstart = 0, count = 0;
        for (char c : espressione) {
            if (Character.isDigit(c)) {
                if (stato == OUT) { 
                    stato = IN; numstart = count; 
                }
            } else {
                if (stato == IN) {
                    stato = OUT;  
                    numeri.push(Integer.parseInt(l.substring(numstart,count)));
                }
                switch (c) {
                case ' ': break;
                case '+': case '-':
                    if (!operatori.isEmpty() && oplevel((char)operatori.top()) > 1)
                        compute(numeri,operatori);
                case '/': case '*': operatori.push((int)c); break;
                default: {
                    System.out.println("errore, operazione non valida");
                    System.exit(0);
                   }
                }
            }
            count++; 
        }
        if (stato == IN) {
            stato = OUT;  
            numeri.push(Integer.parseInt(l.substring(numstart,count)));
        }
        System.out.print(l+" = \n");
        compute(numeri,operatori);
        System.out.println(numeri.top());
    }
}
