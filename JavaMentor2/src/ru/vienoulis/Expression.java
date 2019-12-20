package ru.vienoulis;
// Клис Выражение, пожелел конечно что так назвал, но не стал рефакторить.
// Родитель наших чисел. Туда засунул то что общего у остальных
// (ArabicExpression можно было сделать родителем, но это исторически не верно)
public abstract class Expression {

//  Мне не очень нравятся модификаторы которые использовал ... везде
//  Для работы прогрыммы нужны три поля, они у всех одинаковые
    protected String sign;
    protected int firstValue;
    protected int secondValue;


// Находим знак если его нет выбрасываем исключения
    protected void setSign(String inputValue) throws Exception {

        if (inputValue.contains("+"))
            this.sign = "+";
        else if (inputValue.contains("/"))
            this.sign = "/";
        else if (inputValue.contains("*"))
            this.sign = "*";
        else if (inputValue.contains("-"))
            this.sign = "-";
        else
            throw new Exception();

    }

//    Устанавливаем значение первого значения. больше нуля меньше равно 10 иначе исключение
    protected void setFirstValue(String inputValue ) throws Exception {
        int firstValue = Integer.parseInt(inputValue.substring(0,inputValue.indexOf(this.sign)));
        if (firstValue > 0 && firstValue <=10) this.firstValue = firstValue;
        else throw new Exception();
    }

//    Второе значение аналогично
    protected void setSecondValue(String inputValue ) throws Exception {
        int secondValue = Integer.parseInt(inputValue.substring(inputValue.indexOf(this.sign) + 1));
        if (secondValue > 0 && secondValue <=10) this.secondValue = secondValue;
        else throw new Exception();
    }

//    Конструктор, на входе строка.
    public Expression( String inputValue) throws Exception {
        inputValue = inputValue.replace(" ","");
        this.setSign(inputValue);
        this.setFirstValue(inputValue);
        this.setSecondValue(inputValue);
    }

//    Само действие над числами.
        private int sum(){
            return this.firstValue + this.secondValue;
        }

        private int div(){
            return this.firstValue / this.secondValue;
        }

        private int minus(){
            return this.firstValue - this.secondValue;
        }

        private int multiply(){
            return this.firstValue * this.secondValue;
        }

//        В зависимости от знака вызываем нужный метод
        protected int getResult(){
            int res;
            switch (this.sign) {
                case "+":
                    res = this.sum();
                    break;
                case "/":
                    res = this.div();
                    break;
                case "*":
                    res = this.multiply();
                    break;
                default:
                    res = this.minus();
                    break;
            }

            return res;
        }

//      Нужно чтобы вывел на экран значение. Переопределен для римских
         public void justDoIt() throws Exception {
             System.out.println(getResult());
         }

}
