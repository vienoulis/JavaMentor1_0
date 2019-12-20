package ru.vienoulis;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
// Этот класс нужен, что бы преобразовывать арабские числа в римские
public class RomanToArabicOrBack {

//    Метод который принимает в качестве аргумента число (арабские числа) и возвращает строку (римские числа)
//    Данное преобразование используеться для вывода результата операции над римаскими числами.
//    Числа могут быть от -9 до 100 (метод учитывает числа от -100)
    public static String getRomanNumbers(int i) throws Exception {
        String romanNumbers = "";
        if (i < 0 ){
            i *= -1;
            romanNumbers +="-";
        }

        if (i > 100) {
            throw new Exception();
        }
        if (i / 100 == 1) romanNumbers += "C";
        else if (i / 10 != 0) {
            switch (i / 10) {
                case 9:
                    romanNumbers += "XC";
                    break;
                case 8:
                    romanNumbers += "LXXX";
                    break;
                case 7:
                    romanNumbers += "LXX";
                    break;
                case 6:
                    romanNumbers += "LX";
                    break;
                case 5:
                    romanNumbers += "L";
                    break;
                case 4:
                    romanNumbers += "XL";
                    break;
                case 3:
                    romanNumbers += "XXX";
                    break;
                case 2:
                    romanNumbers += "XX";
                    break;
                case 1:
                    romanNumbers += "X";
                    break;
            }
        }
            if (i % 10 != 0) {
                switch (i % 10) {
                    case 9:
                        romanNumbers += "IX";
                        break;
                    case 8:
                        romanNumbers += "VIII";
                        break;
                    case 7:
                        romanNumbers += "VII";
                        break;
                    case 6:
                        romanNumbers += "VI";
                        break;
                    case 5:
                        romanNumbers += "V";
                        break;
                    case 4:
                        romanNumbers += "IV";
                        break;
                    case 3:
                        romanNumbers += "III";
                        break;
                    case 2:
                        romanNumbers += "II";
                        break;
                    case 1:
                        romanNumbers += "I";
                        break;
                }
            } else if (i == 0) romanNumbers = "O";

            return romanNumbers;
        }

// Преобразование из римских в арабские. Принимает строку возвращает число.
// Не нашел метода для работы с римскими цислами
    public static int getArabicNumbers(String s) throws Exception {
         // В примерах все значения с большой буквы, но малоли
        s = s.toUpperCase();
        int[] ints = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] strings = new String[]{"I","II","III","IV","V","VI","VII","VIII","IX","X"};
        int rez = 0;
        for (int i = 0; i < ints.length; i++){
            if (strings[i].equals(s)) rez = ints[i];
        }

        if (rez == 0) throw new Exception();
        return rez;
    }




}








