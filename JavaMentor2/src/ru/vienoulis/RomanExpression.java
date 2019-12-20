package ru.vienoulis;

import org.omg.PortableServer.THREAD_POLICY_ID;

public class RomanExpression extends Expression {
    // Впринципе переопределение некторых методов.
    // Проверка параметров идет при преобразовании из римских в арабские и обратно
    @Override
    protected void setFirstValue(String inputValue) throws Exception {
        this.firstValue =
                RomanToArabicOrBack.getArabicNumbers(inputValue.substring(0,inputValue.indexOf(this .sign)));
    }

    public RomanExpression(String inputValue) throws Exception {
        super(inputValue);
    }

    @Override
    protected void setSecondValue(String inputValue) throws Exception {
        this.secondValue =
                RomanToArabicOrBack.getArabicNumbers(inputValue.substring(inputValue.indexOf(sign) + 1));
    }

    @Override
    public void justDoIt() throws Exception {
        System.out.println(RomanToArabicOrBack.getRomanNumbers(getResult()));
    }
}
