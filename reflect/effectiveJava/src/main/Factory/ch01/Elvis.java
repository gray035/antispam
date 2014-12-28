package main.Factory.ch01;

/**
 * Created by yangshenneng on 14/12/28.
 */
public class Elvis {
    private String name;
    public static Elvis INSTANCE = null;
    private Elvis() {}
    public static Elvis getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Elvis();
        }
        return INSTANCE;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
    public void leaveTheBuilding() {}
}
