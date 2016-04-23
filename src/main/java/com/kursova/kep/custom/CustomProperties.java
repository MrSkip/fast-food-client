package com.kursova.kep.custom;

import com.kursova.kep.entity.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr. Skip.
 */

public class CustomProperties {

    public static Class getClassFromHeaderButtons(String buttonName) {
        Class aClass = null;
        switch (buttonName) {
            case "Меню":
                aClass = Menu.class;
                break;
            case "Заклади":
                aClass = Institution.class;
                break;
        }
        return aClass;
    }

    public static List<VariablesForCell> getCellFormat(String originTableName) {
        switch (originTableName) {
            case "Menu":
                return cellFormatForMenu();
            case "Institution":
                return cellFormatForInstitution();
        }
        return null;
    }

    private static List<VariablesForCell> cellFormatForMenu() {
        List<VariablesForCell> forCells = new ArrayList<>();
        forCells.add(new VariablesForCell("id", "Номер"));
        forCells.add(new VariablesForCell("nameOfKitchen", "Назва кухні"));
        forCells.add(new VariablesForCell("nameOfSnack", "Назва закуски"));
        forCells.add(new VariablesForCell("storage", "Склад"));
        forCells.add(new VariablesForCell("weight", "Вага"));
        forCells.add(new VariablesForCell("coast", "Вартість"));
        return forCells;
    }

    private static List<VariablesForCell> cellFormatForInstitution() {
        List<VariablesForCell> forCells = new ArrayList<>();
        forCells.add(new VariablesForCell("id", "Номер", null));
        forCells.add(new VariablesForCell("name", "Назва", null));
        forCells.add(new VariablesForCell("phone", "Телефон", "[0-9]"));
        forCells.add(new VariablesForCell("ratingInterior", "Рейтинг за інтер’єр"));
        forCells.add(new VariablesForCell("ratingService", "Рейтинг за сервіс"));
        forCells.add(new VariablesForCell("ratingKitchen", "Рейтинг за кухню"));
        forCells.add(new VariablesForCell("supplements", "Додадок"));
        forCells.add(new VariablesForCell("menuSet", "Меню"));
        return forCells;
    }
}