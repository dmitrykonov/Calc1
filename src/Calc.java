import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calc extends Converter {                                               //Удовлетворяем требования ТЗ по наследованию от базового класса


    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.println("Введите числа: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //Открываем буфер на чтение строк с консоли

            String line = "";
            try {
                line = reader.readLine();                                               //Читаем строку
            } catch (IOException e) {
                 e.printStackTrace();
            }

            if (line.contains("+")) {                                                   //Проверяем арифметическое действие и передаем его и строку методу
                Calculator(line, "+");
            } else if (line.contains("-")) {
                Calculator(line, "-");
            } else if (line.contains("*")) {
                Calculator(line, "*");
            } else if (line.contains("/")) {
                Calculator(line, "/");
            } else {
                System.out.println("Возможно вы ошиблись, попробуйте еще раз");
                throw new Exception("Не нашли математического оператоа");
            }
        }
    }

    public static void Calculator(String line, String operator) throws Exception {  // Сам метод расчета "Калькулятор"
        if (operator.contains("+")) {                                               // Ветвление if-else-if
            numberFill(line, operator);
            if (flagRome) {                                                         // Если число римское производим 2ое преобразование
                int a = toArabic(firstNumber);
                int b = toArabic(secondNumber);
                if (a <= 10 && b <= 10) {                                           // Ограничение ввода до 10 согласно ТЗ
                    System.out.println(toRoman(a + b));
                } else {
                    System.out.println("Калькулятор считает работает с числами не более 10");
                }
            } else {                                                                // Оба чила арабские, считаем в лоб
                int a = Integer.parseInt(firstNumber);
                int b = Integer.parseInt(secondNumber);
                if (a <= 10 && b <= 10) {
                    System.out.println(a + b);
                } else {
                    System.out.println("Калькулятор считает работает с числами не более 10");
                }
            }
        } else if (operator.contains("-")) {
            numberFill(line, operator);
            if (flagRome) {
                int a = toArabic(firstNumber);
                int b = toArabic(secondNumber);
                if (a <= 10 && b <= 10) {
                    System.out.println(toRoman(a - b));
                } else {
                    System.out.println("Калькулятор считает работает с числами не более 10");
                }
            } else {
                int a = Integer.parseInt(firstNumber);
                int b = Integer.parseInt(secondNumber);
                if (a <= 10 && b <= 10) {
                    System.out.println(a - b);
                } else {
                    System.out.println("Калькулятор считает работает с числами не более 10");
                }
            }
        } else if (operator.contains("*")) {
            numberFill(line, operator);
            if (flagRome) {
                int a = toArabic(firstNumber);
                int b = toArabic(secondNumber);
                if (a <= 10 && b <= 10) {
                    System.out.println(toRoman(a * b));
                } else {
                    System.out.println("Калькулятор считает работает с числами не более 10");
                }
            } else {
                int a = Integer.parseInt(firstNumber);
                int b = Integer.parseInt(secondNumber);
                if (a <= 10 && b <= 10) {
                    System.out.println(a * b);
                } else {
                    System.out.println("Калькулятор считает работает с числами не более 10");
                }
            }
        } else if (operator.contains("/")) {
            numberFill(line, operator);
            if (flagRome) {
                int a = toArabic(firstNumber);
                int b = toArabic(secondNumber);
                if (a <= 10 && b <= 10) {
                    //        System.out.println(toRoman(Math.ceil(a / b)));                  // Перезгузка метода. Полиморфизм в полный рост.
                    System.out.println(toRoman(a / b));                  // Перезгузка метода. Полиморфизм в полный рост.
                    // Округление в большую сторону (по примеру ТЗ),
                    // с  привидением к Integer внутри метода (чтобы отбросить дробную часть)
                } else {
                    System.out.println("Калькулятор считает работает с числами не более 10");
                }
            } else {
                int a = Integer.parseInt(firstNumber);
                int b = Integer.parseInt(secondNumber);
                if (a <= 10 && b <= 10) {
                    System.out.println(a / b);
                } else {
                    System.out.println("Калькулятор считает работает с числами не более 10");
                }
            }
        }
    }
}
