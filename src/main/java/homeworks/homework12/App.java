package homeworks.homework12;

import homeworks.homework12.exceptions.UnexpectedCountValueException;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введите данные в формате: Фамилия Имя Отчество датарождения номертелефона пол возраст");
            String inputPerson = scanner.nextLine();
            if (inputPerson.equals("END")) break;
            String[] input = inputPerson.split(" ");

            if (input.length != 7) {
                throw new UnexpectedCountValueException("Введено меньше или больше данных, чем требуется. Ожидается 7.");
            } else {
                try {
                    String surname = input[0].trim();
                    String name = input[1].trim();
                    String patronymic = input[2].trim();
                    if (containsDigits(surname) || containsDigits(name) || containsDigits(patronymic)) {
                        throw new RuntimeException("Имя, фамилия или отчество не должны содержать цифр");
                    }
                    String birthDate = input[3].trim();
                    validateDate(birthDate);
                    String phoneString = input[4].trim();
                    if (!phoneString.matches("\\d+")) {
                        throw new IllegalArgumentException("Номер телефона должен быть целым беззнаковым числом.");
                    }
                    Long phoneNumber = Long.parseLong(phoneString);

                    String gender = input[5].trim();
                    if (!gender.equals("f") && !gender.equals("m")) {
                        throw new IllegalArgumentException("Пол должен быть 'f' или 'm'");
                    }
                    String ageString = input[6].trim();
                    if (!ageString.matches("\\d+")) {
                        throw new IllegalArgumentException("Возраст должен быть целым числом.");
                    }
                    Integer age = Integer.parseInt(ageString);
                    Person person = new Person(surname, name, patronymic, birthDate, phoneNumber, gender, age);
                    personList.add(person);
                    writeToFile(surname, person.toString());

                } catch (IllegalArgumentException | ParseException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    private static void validateDate(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        sdf.parse(date); // Если формат неверный, выбросится ParseException
    }
    private static boolean containsDigits(String str) {
        return str.matches(".*\\d.*");
    }

    private static void writeToFile(String surname, String personData) throws IOException {
        try (FileWriter writer = new FileWriter(surname + ".txt", true)) {
            writer.write(personData + System.lineSeparator());
        }
    }
}
