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
        System.out.print("Introduzca el número: ");
        String numero = in.nextLine();

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

        System.out.println(res);
    }

    public static String octalBinario(String octal){
        char[] symbOct = octal.toCharArray();
        char[] symbBin = new char[3*symbOct.length];
        for(int i=0; i < symbOct.length ;i++){
            char[] symb = decimalBinario(symbOct[i]+"").toCharArray();
            for(int j=0; j < 3; j++){
                int k = i*3+j;
                if(j < symb.length)
                    symbBin[k] = symb[j];
                else
                    symbBin[k] = '0';
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
        return null;
    }

    public static String binarioOctal(String binario){
        return null;
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
        return null;
    }
}