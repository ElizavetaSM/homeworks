package homeworks.homework13.utils;

import java.util.Scanner;

public class App {
    public static int parseCount(String value) throws Exception {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new Exception("Невалидное значение");
        }
    }
    // Функция для валидации целочисленного значения
    public static int validateCount(String value) {
        try {
            return parseCount(value);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1; // Возвращаем -1 или любое другое значение, указывающее на ошибку
        }
    }
    // Функция для парсинга дробного значения
    public static double parseNumber(String value) throws Exception {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new Exception("Невалидное значение");
        }
    }
    public static void main(String[] args) {
        // Примеры использования методов
        Scanner scanner = new Scanner(System.in);
        try {
            String string = scanner.nextLine();
            System.out.println("Parsed Count: " + parseCount(string));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Validated Count: " + validateCount("string"));
        System.out.println("Validated Count: " + validateCount("54"));

        try {
            System.out.println("Parsed Number: " + parseNumber("3.45"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Parsed Number: " + parseNumber("tgy")); // Вызовет ошибку
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

