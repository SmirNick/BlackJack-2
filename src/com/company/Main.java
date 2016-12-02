package com.company;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String[] names = {"Евгений"};
        Table table = new Table(2, names);

        table.betting();
        table.deal();
        table.play();
        table.results();


        }
    }

