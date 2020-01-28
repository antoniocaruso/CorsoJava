
class Calcola {
    public static void main(String[] args)
    {
        String l = args[0];
        int n = l.length();
        char[] ch =  l.toCharArray();
        // Printing array
        int[] numeri = new int[2];
        int pos = 0;
        char op = ' ';
        for (char c : ch) {
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                numeri[pos++] = Character.digit(c,10);
            } else {
                switch (c) {
                case '+':
                case '-':
                case '/':
                case '*': op = c; break;
                default: {
                    System.out.println("errore, operazione non valida");
                    System.exit(0);
                }
                }
            }
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