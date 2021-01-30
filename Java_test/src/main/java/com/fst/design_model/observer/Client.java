package com.fst.design_model.observer;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditions currentConditions = new CurrentConditions();
        weatherData.registerObsver(currentConditions);
        System.out.println("通知各个注册的观察者");
        weatherData.setData(10f,34f,32f);

    }
}
interface Subject{
    public void registerObsver(Observer o);
    public void removeObsver(Observer o);
    public void notifyObsver();
}
//观察者接口
interface Observer{
    public void update(float temperature,float pressure,float humidity);
}
class CurrentConditions implements Observer{
    private float temperature;
    private float pressure;
    private float humidity;

    @Override
    public void update(float temperature, float pressure, float humidity) {
        this.humidity= humidity;
        this.pressure = pressure;
        this.temperature = temperature;
        display();
    }

    public void display(){
        System.out.println("***********");
        System.out.println("***********");
        System.out.println("***********");
    }
}
class WeatherData implements Subject{
    private float temperature;
    private float pressure;
    private float humidity;
    private CurrentConditions currentConditions;
    //
    private ArrayList<Observer> observers;

    public WeatherData(){
        observers = new ArrayList<>();
    }

    public WeatherData(CurrentConditions currentConditions){
        this.currentConditions = currentConditions;
    }
    public float getTemperature(){
        return temperature;
    }
    public float getPressure(){
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public CurrentConditions getCurrentConditions() {
        return currentConditions;
    }
    public void dataChange(){
        notifyObsver();
    }
    public void setData(float temperature,float pressure,float humidity){
        this.humidity= humidity;
        this.pressure = pressure;
        this.temperature = temperature;
        dataChange();
    }

    @Override
    public void registerObsver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObsver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObsver() {
        for(int i=0;i<observers.size();i++){
            observers.get(i).update(this.temperature,this.pressure,this.humidity);
        }
    }
}









































