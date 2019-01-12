package com.example.maxfeldman.sole_mobileunit.Main.models;

public class MotorRequest
{
    private String id;
    private String port;
    private String speed;
    private String angle;
    private String delayAmount;

    public MotorRequest(String id, String port, String speed, String angle, String delayAmount) {
        this.id = id;
        this.port = port;
        this.speed = speed;
        this.angle = angle;
        this.delayAmount = delayAmount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getAngle() {
        return angle;
    }

    public void setAngle(String angle) {
        this.angle = angle;
    }

    public String getDelayAmount() {
        return delayAmount;
    }

    public void setDelayAmount(String delayAmount) {
        this.delayAmount = delayAmount;
    }
}
