import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your HEX:\n>");
        String str = scanner.nextLine();

        String[] strHex = str.split("x");
        int len = strHex[1].length() / 2;

        BL_Endian hex1 = new BL_Endian(strHex[1]);

        StringBuilder revString = toRev(strHex[1]);

        BL_Endian hex2 = new BL_Endian(revString);

        String dec1 = String.format("0x%x", hex1.getBLE());

        String dec2 = String.format("0x%x", hex2.getBLE());
        int lenOfStrHex2 = dec2.length() - 2;
        for(int i = 0; i < (len*2 - lenOfStrHex2); i++){
            dec2 += "0";
        }

        System.out.print("Value(BE to Hex): " + dec1 +
                "\nValue(LE to Hex): " + dec2 +
                "\nNumber of bytes: " + len +
                "\nLittle-Endian: " + hex2.getBLE() +
                "\nBig-Endian: " + hex1.getBLE());
    }

    static StringBuilder toRev(String string){
        StringBuilder revString = new StringBuilder();
        revString.append(string);
        revString.reverse();
        return revString;
    }
}

class BL_Endian{
    private BigInteger BLE;
    public BL_Endian(String hex) {
        BLE = new BigInteger(hex, 16);
    }

    public BL_Endian(StringBuilder hex) {
        BLE = new BigInteger(String.valueOf(hex), 16);
    }

    public BigInteger getBLE() {
        return BLE;
    }
}