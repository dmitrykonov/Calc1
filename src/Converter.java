public class Converter implements NumberLibrary{             // В данном случае, несовсем корретное применение, но опять же, чтобы показать, что "могу, умею, практикую" )
    /**
     * Метод первода арабских чисел в римские
     * @param number
     * @return String
     */
    public static String toRoman(int number)
    {
        StringBuilder sb = new StringBuilder();              // Использовал лишь для "понта" и ненужной в данном примере потокобезопасности :)

        while ( number > 0 )                                 // Пока у нас есть число мы работаем (вычитаем уже найденные числа)
        {
            for (int i = arabNum.length-1; i >= 0; i-- )     // Бежим с конца в начало. Так учили в JavaRush. Слева направо я постоянно нарываюсь на ошибки переполнения или цикл
            {
                if ( number >= arabNum[i] )                  // Нашли позицию нашего числа в массиве
                {
                    number -= arabNum[i];                    // Вычитаем найденное число из исходной цифры. Берем остаток и продолжаем
                    sb.append(rimNum[i]);                    // Добавляем римские символы согласно найденной позиции, во все еще не нужный строковый буфер
                    break;                                   // Прервали цикл ФОР в надежде еще раз вернуться если N != 0
                }
            }
        }
        return sb.toString();                                // Наконец избавились от буфера и вернули понятную всем строку
    }

    public static String toRoman(double number)
    {
        StringBuilder sb = new StringBuilder();              // Использовал лишь для "понта" и ненужной в данном примере потокобезопасности :)

        while ( number > 0 )                                 // Пока у нас есть число мы работаем (вычитаем уже найденные числа)
        {
            for (int i = arabNum.length-1; i >= 0; i-- )     // Бежим с конца в начало. Так учили в JavaRush. Слева направо я постоянно нарываюсь на ошибки переполнения или цикл
            {
                if ( number >= arabNum[i] )                  // Нашли позицию нашего числа в массиве
                {
                    number -= arabNum[i];                    // Вычитаем найденное число из исходной цифры. Берем остаток и продолжаем
                    sb.append(rimNum[i]);                    // Добавляем римские символы согласно найденной позиции, во все еще не нужный строковый буфер
                    break;                                   // Прервали цикл ФОР в надежде еще раз вернуться если N != 0
                }
            }
        }
        return sb.toString();                                // Наконец избавились от буфера и вернули понятную всем строку
    }

    /**
     * Метод первода строки римских чисел в арабские
     * путем простого сравнения позиций в двух массивах
     * @param roman
     * @return Integer
     */

    public static int toArabic(String roman) {
        int result = 0;                                         // Итоговый счетчик результата
        for (int i = arabNum.length-1; i >= 0; i-- ) {          // Бежим по массиву арабских чисел справа налево

            while (roman.indexOf(rimNum[i]) == 0 && i > 0) {    // Если нашли знакомый символ в строке и строка не закончилась
                result += arabNum[i];                           // Складываем старое и новое значения согласно позиции из массива ар.чисел
                roman = roman.substring(rimNum[i].length());    // Удаляем найденные символы длинной (кол-вом) сначала строки
            }
        }
        return result;                                          // НоуКоммент
    }


    static String firstNumber;
    static String secondNumber;
    static String mathOperator;
    static boolean flagRome;

    public static void numberFill(String line, String operator) throws Exception {
        String regex="^M{0,3}(CM|CD|D?C{0,3})?(XC|XL|L?X{0,3})?(IX|IV|V?I{0,3})?$";     // Паттерн регулярки для проверки римских чисел
        int a = line.indexOf(operator);
        firstNumber = line.substring(0, a);
        secondNumber = line.substring(a + 1);

        if (firstNumber.matches("[-+]?\\d+") && secondNumber.matches("[-+]?\\d+")){
            flagRome=false;
        } else if (firstNumber.matches(regex) && secondNumber.matches(regex)){
            flagRome=true;
        }
        else throw new Exception("Вы ввели некорректные данные. \nТребуется выражение, либо только римскими, либо только арабскими числами");


    }
}
