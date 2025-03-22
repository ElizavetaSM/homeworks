package homeworks.homeworks11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;



public class Main1 {
    public static void main (String [] args) {
        List<Cars> listOfCars = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("src/main/java/homeworks/homeworks11/input.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            line = bufferedReader.readLine();
            while (!(line = bufferedReader.readLine()).equals("END")) {
                String[] fields = line.split("/");
                if (fields.length == 5) {
                    String number = fields[0].trim();
                    String model = fields[1].trim();
                    String colour = fields[2].trim();
                    int mile = Integer.parseInt(fields[3].trim());
                    int price = Integer.parseInt(fields[4].trim());
                    Cars car = new Cars(number, model, colour, mile, price);
                    listOfCars.add(car);
                }

            }
            bufferedReader.close();
            for (Cars car:listOfCars) {
            System.out.println(car);
                }

        }
        catch(IOException ioException){
                    ioException.printStackTrace();
                }
        //переменные
        String colourToFind = "Black";
        int mileToFind = 0;
        double n = 700000; // Минимальная цена в тыс.
        double m = 900000; // Максимальная цена в тыс.
        String modelToFind = "Toyota";

        List<String> element = listOfCars.stream()
                .filter(cars -> cars.getColour().equals(colourToFind) || cars.getMiles()==mileToFind)
                .map(cars -> cars.getNumber())
                .collect(Collectors.toList());
        System.out.println("Номера   автомобилей   по   цвету   или   пробегу:" + element);

        long quantity = listOfCars.stream()
                .filter(cars -> cars.getPrice()>=n && cars.getPrice() <= m)
                .map(cars -> cars.getModel())
                .distinct()
                .count();
        System.out.println("Количество уникальных моделей в ценовом диапазоне от 700 до 900 тыс:" + quantity);

        String colourOfCar = listOfCars.stream()
                .min((listOfCars1, listOfCars2) -> Double.compare(listOfCars1.getPrice(), listOfCars2.getPrice()))
                .map(Cars::getColour)
                .orElse("Нет автомобилей");
        System.out.println("Цвет автомобиля с минимальной стоимостью:" + colourOfCar);

        OptionalDouble modelOfCar = listOfCars.stream()
                .filter(cars -> cars.getModel().equals(modelToFind))
                .mapToDouble(Cars::getPrice)
                .average();
        System.out.println("Средняя стоимость модели Toyota:" + modelOfCar);





            }

        }




