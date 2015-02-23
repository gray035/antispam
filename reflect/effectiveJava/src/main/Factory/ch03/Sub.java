package main.Factory.ch03;

import java.util.Date;

/**
 * Created by yangshenneng on 15/2/21.
 */
public final class Sub extends Super{
    private final Date date;

    public Sub() {
        date = new Date();
    }

    @Override
    public void overrideMe() {
        System.out.println(date);
    }

}
