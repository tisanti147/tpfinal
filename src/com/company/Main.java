package com.company;

import Interfaz.Menu;
import java.io.Serializable;

public class Main implements Serializable {

    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.ejecutarMenu();
    }
}
