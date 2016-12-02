package com.company;

/**
 * Created by falyanguzov on 14.11.2016.
 */
public class Human extends Player {

    public Human(String name, ConsoleIntellect intellect, Better better, int cash) {
        super(name, new ConsoleIntellect(), better, cash);
    }
}
