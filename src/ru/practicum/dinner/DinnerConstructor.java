package ru.practicum.dinner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {

    HashMap<String, ArrayList<String>> dishMenu;

    public DinnerConstructor() {
        dishMenu = new HashMap<>();
    }

    /* Проверяем что меню не пустое */
    public boolean isEmptyDishMenu() {
        return dishMenu.isEmpty();
    }

    /* Проверяем что в меню есть искомое блюдо  */
    public boolean checkDishType(String dishType) {
        return dishMenu.containsKey(dishType);
    }

    /* Добавляем блюдо в меню  */
    public void addDish(String dishType, String dishName) {
        if (!dishMenu.containsKey(dishType)) {
            ArrayList<String> dishList = new ArrayList<>();
            dishMenu.put(dishType, dishList);
            dishList.add(dishName);
        } else if (!dishMenu.get(dishType).contains(dishName)) {  // Проверяем что у нас в меню еще нет такого блюда
            dishMenu.get(dishType).add(dishName);
        } else {  // Если такое блюдо уже есь в меню
            System.out.println("Такое блюдо удже есть в меню");
        }
        System.out.println(" " + dishMenu);
    }

    /*  Генерируем наборы для комбо - возвращаем список наборов  */
    public ArrayList<ArrayList<String>> getComboOfDish(ArrayList<String> listDishType, int numberOfCombos) {

        ArrayList<ArrayList<String>> combos = new ArrayList<>();
        String dishName = "";
        Random random = new Random();
        ArrayList<String> nextListOfDish;
        int randomNumberOfDish;

        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> comboListOfDish = new ArrayList<>();  // массив для одного комбо
            for (String dishType : listDishType) {    // проход по типам блюд
                nextListOfDish = dishMenu.get(dishType);   // находим спиок блюд по их типу
                randomNumberOfDish = random.nextInt(nextListOfDish.size());  // рандомно вычисляем номер блюда
                dishName = nextListOfDish.get(randomNumberOfDish); // по рандомному номеру получаем имя блюда
                comboListOfDish.add(dishName); // добавляем блюдо в комбо
            }
            combos.add(comboListOfDish);
        }
        return combos;
    }
}
