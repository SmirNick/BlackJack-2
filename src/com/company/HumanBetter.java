package com.company;

import java.util.Scanner;

/**
 * Created by student2 on 02.12.16.
 */

public class HumanBetter extends Better
{
    private Scanner in = new Scanner(System.in);

    @Override
    public int decide(int cash) {
        System.out.println("Your have " + cash + ". " + "How much do you want to bet?");
        while (true)
        {
            int inp = in.nextInt();
            if (cash - inp >= 0  && inp > 0)
                return inp;

            System.out.println("Incorrect!");
        }
    }
}
