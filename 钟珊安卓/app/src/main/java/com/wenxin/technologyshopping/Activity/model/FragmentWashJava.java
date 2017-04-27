package com.wenxin.technologyshopping.Activity.model;

/**
 * Created by Clive on 2015/8/6.
 */
public class FragmentWashJava {
    private int spring_laundry;
    private String spring_name;
    private String spring_amounts;

    public int getSpring_laundry() {
        return spring_laundry;
    }

    public void setSpring_laundry(int spring_shirt) {
        this.spring_laundry = spring_shirt;
    }

    public String getSpring_name() {
        return spring_name;
    }

    public void setSpring_name(String spring_name) {
        this.spring_name = spring_name;
    }

    public String getSpring_amounts() {
        return spring_amounts;
    }

    public void setSpring_amounts(String spring_amounts) {
        this.spring_amounts = spring_amounts;
    }

    @Override
    public String toString() {
        return "FragmentWashJava{" +
                "spring_shirt=" + spring_laundry +
                ", spring_name='" + spring_name + '\'' +
                ", spring_amounts='" + spring_amounts + '\'' +
                '}';
    }
}
