package skibin;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final int S0 = 0;
    public static final int S1 = 1;
    public static final int S2 = 2;
    public static final int S3 = 3;
    public static final int S4 = 4;
    public static final int S5 = 5;
    public static final int S6 = 6;
    public static final int S7 = 7;
    public static final int S8 = 8;
    public static final int S9 = 9;
    public static final int S10 = 10;
    public static final int S11 = 11;
    public static final int S12 = 12;


    public static void main(String[] args) {
        List<Character> zeroNine = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        List<Character> oneNine = Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9');
        List<Character> zeroOne = Arrays.asList('0', '1');
        List<Character> zeroTwo = Arrays.asList('0', '1', '2');
        List<Character> three = Arrays.asList('3');
        List<Character> specialSymbol = Arrays.asList('.');
        List<Integer> finalStates = Arrays.asList(S12);
        Automat automat = new Automat(S0, finalStates);

        //добавление заданных переходов в таблицу
        automat.addStep(S0, zeroTwo, S1);
        automat.addStep(S0, three, S2);
        automat.addStep(S1, oneNine, S3);
        automat.addStep(S2, zeroOne, S3);

        automat.addStep(S3, specialSymbol, S4);

        automat.addStep(S4, '0', S5);
        automat.addStep(S4, '1', S6);
        automat.addStep(S5, zeroNine, S7);
        automat.addStep(S6, zeroTwo, S7);

        automat.addStep(S7, specialSymbol, S8);

        automat.addStep(S8, zeroNine, S9);
        automat.addStep(S9, zeroNine, S10);
        automat.addStep(S10, zeroNine, S11);
        automat.addStep(S11, zeroNine, S12);


        Scanner sc = new Scanner(System.in);
        while(true){
            String str = sc.nextLine();
            System.out.println(automat.doesMatch(str));
        }
        //String str = "-1214FCXFXCFXDFXFXCFXCFCXFXFXCFCXFXC";
    }
}
