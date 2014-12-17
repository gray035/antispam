package main.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangshenneng on 14/12/16.
 */
public class TestList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        for(int i = 0; i < list.size(); i++) {
            list.get(i);
        }
    }
}
