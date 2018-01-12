package Calculator;

import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.Locale;

class CalculatorImpl implements Calculator {

    CalculatorImpl() {
    }

    private static boolean bracketsCount(String statement){
        boolean flag = false;
        int result = 0;
        for(int i = 0; i<statement.length(); i++){
            int counter = 0;

            char b = statement.charAt(i);
            if(b == '('){
                counter ++;
            }
            if(b == ')'){
                counter --;
            }
            result = counter;
        }
        if(result == 0){
            flag = true;
        }
        return flag;

    }

    /**
     * <p>Проверка на наличие разделителя</p>
     *
     * @param c текущий символ
     * @return возвращает true, если символ разделитель
     */
    private static boolean isDelimiter(char c) {
        return c == ' ';
    }

    /**
     * <p>Проверка,  является ли символ оператором</p>
     *
     * @param c текуущий символ
     * @return возвращает true, если сивол это операция
     */
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    /**
     * <p>Определяет приоритет выполнения опреаций</p>
     *
     * @param operator символ операции
     * @return возвращает число уровня приоритета
     */
    private static int priority(char operator) {
        switch (operator) { // при + или - возврат 1, при * /  2, иначе -1
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    /**
     * <p>Выполняет одно из поддерживаемых арифметических действий для пары последних элементов в стеке</p>
     *
     * @param stack массив можества чисел
     * @param operator одна из выполняемых операций
     */
    private static void executeOperator(LinkedList<Double> stack, char operator) {
        if (stack.size()==1 && operator == '-'){
            String lastDouble = String.valueOf(operator)+String.valueOf(stack.removeLast());

            stack.add(Double.parseDouble( lastDouble  ));
        } else {
            double last = 0;
            double penult = 0;


            if (stack.size() >= 2) {
                last = stack.removeLast();
                penult = stack.removeLast();
            }

            switch (operator) {
                case '+':
                    stack.add(penult + last);
                    break;
                case '-':
                    stack.add(penult - last);
                    break;
                case '*':
                    stack.add(penult * last);
                    break;
                case '/':
                    stack.add(penult / last);
                    break;
            }
        }
    }

    /**
     * <p>Производим округление результата до последнего знака или до 4-го после запятой</p>
     *
     * @param num параметр типа double, который показывает кол-во цифр после запятой
     * @return округленную строку
     */
    private static String toRound(double num){
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.ENGLISH);
        formatter.setMaximumFractionDigits(4);
        formatter.setMinimumFractionDigits(0);
        return formatter.format(num);
    }

    /**
     * <p>Производим считывание арифметического выражения</p>
     *
     * @param statement арифметическое выражение
     * @return полученное число в результате выполнения арифметического выражения
     */
    public String evaluate(String statement) {
        LinkedList<Double> digits = new LinkedList<>();
        LinkedList<Character> operators = new LinkedList<>();
        try {
            for (int i = 0; i < statement.length(); i++) {

                char c = statement.charAt(i);

                if (isDelimiter(c)) {
                    continue;
                }
                if (c == '(') {
                    operators.add('(');
                } else if (c == ')') {
                    while (operators.getLast() != '(') {
                        executeOperator(digits, operators.removeLast());
                    }
                    operators.removeLast();
                } else if (isOperator(c) ) {
                    while (!operators.isEmpty() && priority(operators.getLast()) >= priority(c)) {
                        executeOperator(digits, operators.removeLast());
                    }
                    operators.add(c);

                } else {
                    String operand = "";
                    while (i < statement.length() && (Character.isDigit(statement.charAt(i)) || statement.charAt(i) == '.')) {
                        operand += statement.charAt(i++);
                    }
                    --i;
                    digits.add(Double.parseDouble(operand));
                }
            }
            while (!operators.isEmpty()) {
                executeOperator(digits, operators.removeLast());

            }

        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }

        return toRound(digits.get(0));
    }

}