package com.company;

/**
 * Created by student2 on 02.12.16.
 */
public class HalfBetter extends Better
{
    @Override
    public int decide(int cash) {
        return (cash + 1) / 2;
    }

    ;
}
