import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int operand1;
        int operand2;
        int result;
        String romanResult;
        System.out.println("Выберите тип цифр:\n1) Арабские\n2) Римские\n");
        byte choise = sc.nextByte();
        if (choise == 1){
                operand1 = getArabian();
                operand2 = getArabian();
                char operation = getOperation();
                result = calc(operand1, operand2, operation);
                System.out.println("Результат: " + result);
        } else if(choise == 2){
                String stroperand1 = getRoman();
                String stroperand2 = getRoman();
                operand1 = romanToArabian(stroperand1);
                operand2 = romanToArabian(stroperand2);
                char operation1 = getOperation();
                result = calc(operand1, operand2, operation1);
                romanResult = arabianToRoman(result);
                System.out.println("Результат: " + romanResult);
        } else {
            System.out.println("Вы ввели неверный вариант");
        }
    }

    public static int getArabian() {
        System.out.println("Введите арабское число: ");
        int operand;
        if (sc.hasNextInt()) {
            operand = sc.nextInt();
        } else {
            System.out.println("Ошибка при вводе числа. Повторите ввод.");
            sc.next();
            operand = getArabian();
        }
        return operand;
    }

    public static String getRoman() {
        System.out.println("Введите римское число: ");
        String operand;
        operand = sc.next();
        for(int i = 0; i < operand.length(); i++){
            if(operand.charAt(i) == 'I' ||
            operand.charAt(i) == 'V' || 
            operand.charAt(i) == 'X' || 
            operand.charAt(i) == 'L' || 
            operand.charAt(i) == 'C' ||  
            operand.charAt(i) == 'D' || 
            operand.charAt(i) == 'M'){
                continue;
            } else {
            System.out.println("Ошибка при вводе числа. Повторите ввод.");
            operand = getRoman();
            }
        }
        return operand;
    }
    
    public static char getOperation() {
        System.out.println("Введите операцию: ");
        char operation;
        if(sc.hasNext()) {
            operation = sc.next().charAt(0);
        } else {
            System.out.println("Ошибка ввода операции. Повторите ввод.");
            sc.next();
            operation = getOperation();
        }
        return operation;
    }

    public static int calc(int operand1, int operand2, char operation) {
        int res;
        switch (operation){
            case '+':
                res = operand1 + operand2;
                break;
            case '-':
                res = operand1 - operand2;
                break;
            case '*':
                res = operand1 * operand2;
                break;
            case '/':
                res = operand1 / operand2;
                break;
            default:
            System.out.println("Такой операции нет");
            res = calc(operand1, operand2, getOperation());
        }    
        return res;
    }

    public static int romanToArabian(String operand) {
        ArrayList<Integer> mass = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < operand.length(); i++) {
            char sym = operand.charAt(i);
            switch(sym){
                case 'M':
                    mass.add(1000);
                    break;
                case 'D':
                    mass.add(500);
                    break;
                case 'C':
                    mass.add(100);
                    break;
                case 'L':
                    mass.add(50);
                    break;
                case 'X':
                    mass.add(10);
                    break;
                case 'V':
                    mass.add(5);
                    break;
                case 'I':
                    mass.add(1);
                    break;
                default:
                    System.out.println("В числе присутствует неизвестный символ. Ошибка");
            }
        }
        mass.add(0);
        for (int el = 0; el < mass.size()-1; el++) {
            if(mass.get(el) >= mass.get(el + 1) ) {
                int element = mass.get(el);
                sum+=element;
            } else {
                int element = mass.get(el);
                sum-=element;
            }
        }
        return sum;
    }

    public static String arabianToRoman(int res) {
        String romanRes = "";
    while (res >= 1000) {
        romanRes += "M";
        res -= 1000;        }
    while (res >= 900) {
        romanRes += "CM";
        res -= 900;
    }
    while (res >= 500) {
        romanRes += "D";
        res -= 500;
    }
    while (res >= 400) {
        romanRes += "CD";
        res -= 400;
    }
    while (res >= 100) {
        romanRes += "C";
        res -= 100;
    }
    while (res >= 90) {
        romanRes += "XC";
        res -= 90;
    }
    while (res >= 50) {
        romanRes += "L";
        res -= 50;
    }
    while (res >= 40) {
        romanRes += "XL";
        res -= 40;
    }
    while (res >= 10) {
        romanRes += "X";
        res -= 10;
    }
    while (res >= 9) {
        romanRes += "IX";
        res -= 9;
    }
    while (res >= 5) {
        romanRes += "V";
        res -= 5;
    }
    while (res >= 4) {
        romanRes += "IV";
        res -= 4;
    }
    while (res >= 1) {
        romanRes += "I";
        res -= 1;
    }    
    return romanRes;
    }

}



