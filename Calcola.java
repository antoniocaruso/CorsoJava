
class Calcola {
    public static void main(String[] args)
    {
        String l = args[0];
        int n = l.length();
        char[] ch =  l.toCharArray();
        // Printing array
        int[] numeri = new int[10];
        int pos = 0;
        
        
        char[] digits = new char[10];
        int digits_pos = 0;
     
        /*
        System.out.printf("%d\n",(int)digits[2]);
        String s = new String(digits).trim();
        System.out.println(Integer.parseInt(s));
        System.exit(1);
        */
        
        final int OUT = 0;
        final int IN = 1; 
        int stato = OUT;     
        
        
        char op = ' ';
        for (char c : ch) {
            if (c == ' ') {
                if (stato == IN) {
                    for (int i=digits_pos; i<10; i++) digits[i] = ' ';
                    numeri[pos++] = Integer.parseInt(new String(digits).trim());
                    stato = OUT;
                    digits_pos = 0;
                }
                continue;  
            } 
            if (Character.isDigit(c)) {
                digits[digits_pos++] = c; 
                stato = IN;
            } else {
                if (stato == IN) {
                    for (int i=digits_pos; i<10; i++) digits[i] = ' ';
                    numeri[pos++] = Integer.parseInt(new String(digits).trim());
                    stato = OUT;
                    digits_pos = 0;
                }
                switch (c) {
                case '+': case '-': case '/': case '*': op = c;  break;
                default: {
                    System.out.println("errore, operazione non valida");
                    System.exit(0);
                   }
                }
            }
        } 
        
        if (stato == IN)
        {
            for (int i=digits_pos; i<10; i++) digits[i] = ' ';
            numeri[pos++] = Integer.parseInt(new String(digits).trim());
            System.out.println(numeri[pos-1]);
            stato = OUT;
            digits_pos = 0;
        }
        
        System.out.print(l+" = ");
        switch (op) {
            case '+': System.out.println(numeri[0]+numeri[1]); break;
            case '-': System.out.println(numeri[0]-numeri[1]); break;
            case '*': System.out.println(numeri[0]*numeri[1]); break;
            case '/': System.out.println(numeri[0]/numeri[1]); break;
        }
    }
}