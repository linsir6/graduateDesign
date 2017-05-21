package com.lin_sir.beautycar.model;

/**
 * Created by linSir on 17/3/8.预约的实体类
 */
public class CarDetails {

    public String time;
    public String type;
    public String context;
    public String userPhone;
    public String userName;
    private String isFinish;

    public CarDetails(String time, String type, String context, String userPhone, String userName, String isFinish) {
        this.time = time;
        this.type = type;
        this.context = context;
        this.userPhone = userPhone;
        this.userName = userName;
        this.isFinish = isFinish;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(String isFinish) {
        this.isFinish = isFinish;
    }
}
