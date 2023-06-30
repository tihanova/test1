import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InputMismatchException{

        Scanner  scanner = new Scanner(System.in);
        String userInput = "";
        double result;
        while (!"q".equals(userInput)) {
            try {
                System.out.println("Введите первое число!");
                int firstNumber = scanner.nextInt();
                System.out.println("Введите второе число!");
                int secondNumber = scanner.nextInt();
                System.out.println("Введите символ опереации:" +
                        " + (сложение), -(вычитание), / (деление), * (умножение, !(факториал), q - выход из программы");
                userInput = scanner.nextLine(); //считывается только остаток строки - \n.
                userInput = scanner.nextLine();
                switch (userInput) {
                    case "+":
                        result = plus(firstNumber, secondNumber);
                        break;
                    case "-":
                        result = minus(firstNumber, secondNumber);
                        break;
                    case "*":
                        result = ymn(firstNumber, secondNumber);
                        break;
                    case "/":
                        if (secondNumber == 0) {
                            System.out.println("Деление на на ноль запрщено!");
                            continue;
                        }
                        result = del(firstNumber, secondNumber);
                        break;
                    case "!":
                        result = fact(firstNumber);
                        break;
                    case "q":
                        System.out.println("Осуществлен выход из программы");
                        continue;
                    default:
                        System.out.println("Вы ввели некорректный символ операции!");
                        continue;
                }
                System.out.println(result);
            } catch (InputMismatchException ex){
                System.out.println("Вы ввели некорректные данные!");
                scanner.skip(".*\n");
                continue;
            }

        }


    }

    private static int plus(int numberOne, int numberTwo){
        return numberOne + numberTwo;
    }
    private static int minus(int numberOne, int numberTwo){
        return numberOne - numberTwo;
    }
    private static int ymn(int numberOne, int numberTwo){
        return numberOne * numberTwo;
    }
    private static int del(int numberOne, int numberTwo){
        return numberOne / numberTwo;
    }
    private static int fact(int numberOne){
        int res = 1;
        for (int i = 1; i < numberOne; i++) {
            res *= i;
        }
        return res;
    }
}