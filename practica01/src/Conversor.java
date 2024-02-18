import java.util.Scanner;

public class Conversor{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println("****BIENVENIDO****");
        int numBaseI=0, numBaseF=0;
        do{
            System.out.print("Introduza la base inicial (2, 8, 10, 16): ");
            numBaseI = Integer.parseInt(in.nextLine());
        }
        while(numBaseI != 2 && numBaseI != 8 && numBaseI != 10 && numBaseI != 16);
        do{
            System.out.print("Introduza la base requerida (2, 8, 10, 16): ");
            numBaseF = Integer.parseInt(in.nextLine());
        }
        while(numBaseF != 2 && numBaseF != 8 && numBaseF != 10 && numBaseF != 16);
        String numero;
        do{
            System.out.print("Introduzca el número: ");
            numero = in.nextLine();
        }
        while(!validarNumero(numero, numBaseI));

        numero = depurado(numero);
        String binario=null;
        switch(numBaseI){
        case 2:
            binario = numero;
            break;
        case 8:
            binario = octalBinario(numero);
            break;
        case 10:
            binario = decimalBinario(numero);
            break;
        case 16:
            binario = hexadecimalBinario(numero);
            break;
        }

        String res = null;
        switch(numBaseF){
        case 2:
            res = binario;
            break;
        case 8:
            res = binarioOctal(binario);
            break;
        case 10:
            res = binarioDecimal(binario);
            break;
        case 16:
            res = binarioHexadecimal(binario);
            break;
        }

        System.out.println(depurado(res));
    }

    public static String octalBinario(String octal){
        char[] symbOct = octal.toCharArray();
        char[] symbBin = new char[3*symbOct.length];
        for(int i=symbOct.length-1; i >= 0 ;i--){
            char[] symb = decimalBinario(symbOct[i]+"").toCharArray();
            for(int j=0; j<3 ;j++){
                if(j < symb.length)
                    symbBin[i*3+(2-j)] = symb[(symb.length-1)-j];
                else
                    symbBin[i*3+(2-j)] = '0';
            }
        }
        return new String(symbBin);
    }

    public static String decimalBinario(String decimal){
        int numDecimal = Integer.parseInt(decimal);
        if(numDecimal < 0)
            throw new IllegalArgumentException();
        String binario = "";
        if(numDecimal == 0)
            return 0+"";
        while(numDecimal != 0){
            binario = numDecimal%2+binario;
            numDecimal /= 2;
        }
        return binario;
    }

    public static String hexadecimalBinario(String hexa){
        char[] charHex = hexa.toUpperCase().toCharArray();
        String[] symbHex = new String[charHex.length];
        for(int i=0; i<charHex.length ;i++){
            int ascii = (int) charHex[i];
            if(47 < ascii && ascii < 58)
                symbHex[i] = charHex[i]+"";
            if(64 < ascii && ascii < 71)
                symbHex[i] = (ascii - 55)+"";
        }
        char[] symbBin = new char[4*symbHex.length];
        for(int i=symbHex.length-1; i >= 0 ;i--){
            char[] symb = decimalBinario(symbHex[i]).toCharArray();
            for(int j=0; j<4 ;j++){
                if(j < symb.length)
                    symbBin[i*4+(3-j)] = symb[(symb.length-1)-j];
                else
                    symbBin[i*4+(3-j)] = '0';
            }
        }
        return new String(symbBin);
    }

    public static String binarioOctal(String binario){
        char[] charBin = binario.toCharArray();
        int faltante = (3-charBin.length%3)%3;
        String[] symbBin = new String[(charBin.length+faltante)/3];
        String octal="";
        int ls = charBin.length-1;
        for(int i=symbBin.length-1; i>=0 ;i--){
            for(int j=0; j<3 && ls-j > -1; j++){
                if(symbBin[i]!=null)
                    symbBin[i] = charBin[ls-j]+symbBin[i];
                else
                    symbBin[i] = charBin[ls-j]+"";
            }
            ls -= 3;
            octal = binarioDecimal(symbBin[i])+octal;
        }
        return octal;
    }

    public static String binarioDecimal(String binario){
        char[] symbBin = binario.toCharArray();
        int decimal = 0;
        for(int i=symbBin.length-1; i>=0 ;i--){
            decimal += Math.pow(2,(symbBin.length-1)-i)*Integer.parseInt(symbBin[i]+"");
        }
        return decimal+"";
    }

    public static String binarioHexadecimal(String binario){
        char[] charBin = binario.toCharArray();
        int faltante = (4-charBin.length%4)%4;
        String[] symbBin = new String[(charBin.length+faltante)/4];
        char[] symbHex = new char[symbBin.length];
        int ls = charBin.length-1;
        for(int i=symbBin.length-1; i>=0 ;i--){
            for(int j=0; j<4 && ls-j > -1; j++){
                if(symbBin[i]!=null)
                    symbBin[i] = charBin[ls-j]+symbBin[i];
                else
                    symbBin[i] = charBin[ls-j]+"";
            }
            ls -= 4;
            String decimal = binarioDecimal(symbBin[i]);
            int temp = Integer.parseInt(decimal);
            if(temp+55 > 64)
                symbHex[i] = (char) (temp+55);
            else
                symbHex[i] = decimal.charAt(0);
        }
        return new String(symbHex);
    }

    public static boolean validarNumero(String numero, int base){
        char[] symb = numero.toCharArray();
        if(base == 16){
          for(int i=0; i < symb.length ;i++){
            if(symb[i] < 48 || (57 < symb[i] && symb[i]<65) || 70 < symb[i])
                return false;
          }
        }
        else if(base == 10){
          for(int i=0; i < symb.length ;i++){
            if(symb[i] < 48 || 57 < symb[i])
                return false;
          }
        }
        else if(base == 8){
          for(int i=0; i < symb.length ;i++){
            if(symb[i] < 48 || 55 < symb[i])
                return false;
          }
        }
        else if(base == 2){
          for(int i=0; i < symb.length ;i++){
            if(symb[i] != 48 && symb[i] != 49)
                return false;
          }
        }
        return true;
    }

    public static String depurado(String numero){
        char[] symb = numero.toCharArray();
        int ceros = 0;
        for(int i=0; i<symb.length ;i++){
            if(symb[i] == 48)
                ceros++;
            else
                break;
        }
        char[] newSymb = new char[symb.length-ceros];
        for(int i=0; i<newSymb.length ;i++){
            newSymb[i] = symb[i+ceros];
        }
        return new String(newSymb);
    }
}
