package ru.vienoulis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
// Да простит меня прочитавший это, за ошибки грамотические. Я старался.
public class Main {

    public static void main(String[] args) throws Exception{
//        Создаем reader для чтения данных
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String inputValue = reader.readLine();

            Expression expression = initExpression(inputValue);
            expression.justDoIt();

            reader.close();
        }

    private static Expression initExpression(String inputValue) throws Exception {
        Expression expression;
//        Я уверен, что это не совсем правильно, использовать так контрукцию. Если да, то почему нет?
        try{
            int firstValue = Integer.parseInt(inputValue.substring(0, 1));
            expression = new ArabicExpression(inputValue);
        } catch (Exception e ){
            expression = new RomanExpression(inputValue);

        }
        return expression;
    }
}

