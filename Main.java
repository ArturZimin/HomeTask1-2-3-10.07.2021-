package by.minsk.itakademy.arturzimin;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class Main {

    public static void main(String[] args) {
/**1  сгенерировать 3 произвольных целых числа x,y,z.Если x больше z ,то вывести на экран сумму x и y,иначе вывести на экран значение z.
 * Вывести на экран среднее орифметическое этих чисел. */

        int x = 3;
        int y = 5;
        int z = 10;
        if (x > z) {
            System.out.println(x + y);
        } else {
            System.out.println(z);
        }
        double averageNumber = (x + y + z) / 3;
        System.out.println(averageNumber);

        /**2*/

        int[] arrayRandomNumber = new int[10];
        int max = 0;
        int indexMaxElementArray = 0;
        for (int i = 0; i < 10; i++) {
            arrayRandomNumber[i] = ThreadLocalRandom.current().nextInt(-300, 300);
        }
        for (int a = 0; a < arrayRandomNumber.length; a++) {
            System.out.print(arrayRandomNumber[a] + " ");
            if (arrayRandomNumber[a] > max) {
                indexMaxElementArray = a;
                max = arrayRandomNumber[a];
            }
        }
        int min = arrayRandomNumber[0];
        for (int s = 0; s < arrayRandomNumber.length; s++) {
            if (arrayRandomNumber[s] < min) {
                min = arrayRandomNumber[s];
            }
        }
        System.out.println("result before: " + arrayRandomNumber[indexMaxElementArray] + "  ");
        arrayRandomNumber[indexMaxElementArray] = min * max;
        System.out.println(" result after: " + arrayRandomNumber[indexMaxElementArray] + "  ");
        System.out.println(" result: " + min + "  " + max);


        /**Task 3*/

        Car car3 = new Car("Lexus", CarModel.MINIVAN, 1500);
        List<Car> listCars = new ArrayList<>(10);
        for (int i = 0; i < 8; i++) {
            listCars.add(new Car("Bmw", CarModel.WAGON, 2000));
        }
        listCars.add(0, new Car("Ford", CarModel.SEDAN, 1800));
        listCars.add(3, new Car("MercedesBenz", CarModel.WAGON, 2300));
        listCars.add(5, new Car("Lada", CarModel.HATCHBACK, 1500));

        Map<Integer, List<Car>> map = listCars.stream()               //coздаем стрим из arrayListCar
                .collect(Collectors.groupingBy(car -> car.capacity)); //группируем по объему двигателя
        map.entrySet()                                                //метод возвращает набор элементов коллекции
                .stream()                                             //создание стрима из набора элементов коллекции
                .sorted(Comparator.comparingInt(Map.Entry::getKey))   //сортируем от меньшего к большему(capacity)
                .forEach(System.out::println);

        listCars.stream()
                .filter(car -> car.capacity == 2000)                                                    //фильтруем по объему ,чтобы записать в файл объект класса кар с соответствующим объемом
                .map(car -> "<" + car.name + ">" + "<" + car.carModel + ">" + car.capacity + ">" + "\n")//преобразует каждый элемент стрима в нужный шаблон для вывода
                .forEach(value -> {                                                                      //записываем в файл
                    try {
                        FileWriterUtil.writeToFileEnd("C:\\Users\\Office\\IdeaProjects\\HomeWork(08_07_2021)\\src\\by\\minsk\\itakademy\\arturzimin\\file.txt", value);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });


    }
}