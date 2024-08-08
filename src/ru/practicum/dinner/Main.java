package ru.practicum.dinner;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {

        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        dc.addDish(dishType, dishName);
    }

    private static void generateDishCombo() {

        if (dc.isEmptyDishMenu()) { // проверка что меню не пустое
            System.out.println("Меню пустое. Сначала добавьте в меню блюда");
            return;
        }

        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        while (numberOfCombos <= 0) {
            System.out.println("Количесво наборов не может быть меньше или рано 0, введите заново: ");
            numberOfCombos = scanner.nextInt();
        }

        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();
        //ввод типов блюд
        ArrayList<String> itemList = new ArrayList<>();
        while (!nextItem.isEmpty()) {
            if (dc.checkDishType(nextItem)) {  // проверка что такой тип блюда есть в меню
                itemList.add(nextItem);
            } else {
                System.out.println("Такого типа блюда нет в меню, добавьте другое");
            }
            nextItem = scanner.nextLine();
        }

        ArrayList<ArrayList<String>> combo = dc.getComboOfDish(itemList, numberOfCombos);

        for (int i = 0; i < combo.size(); i++) {
            System.out.println("Комбо " + (i + 1));
            System.out.println(combo.get(i));
        }

    }


}

