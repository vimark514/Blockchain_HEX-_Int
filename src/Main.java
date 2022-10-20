import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your HEX:\n>");
        String str = scanner.nextLine();

        String[] strHex = str.split("x");
        int len = strHex[1].length() / 2;
        BigInteger hex1 = new BigInteger(strHex[1], 16);

        StringBuilder strForLE = new StringBuilder();
        strForLE.append(strHex[1]);
        strForLE.reverse();
        BigInteger hex2 = new BigInteger(String.valueOf(strForLE), 16);

        String strHex1 = String.format("0x%x", hex1);

        StringBuilder strForHex = new StringBuilder();
        strForHex.append(hex2);
        strForHex.reverse();
        String strHex2 = String.format("0x%x", hex2);
        int lenOfStrHex2 = strHex2.length() - 2;
        for(int i = 0; i < (len*2 - lenOfStrHex2); i++){
            strHex2 += "0";
        }

        System.out.print("Value(BE to Hex): " + strHex1 +
                "\nValue(LE to Hex): " + strHex2 +
                "\nNumber of bytes: " + len +
                "\nLittle-Endian: " + hex2 +
                "\nBig-Endian: " + hex1);
    }
}
