package com.example.bangproject_0522.datas;

public class Room {

    private int price; //만원단위로 기록
    private String address; //구 동 만 기록
    private int floor; //층수 나타내기
    private String description;
    public String getFormattedPrice(){
        if(price<10000){
//            몇천만원 8,000으로 ","만 찍어주기
         return String.format("%,d",price);
        }
        else{
//            2억 8,500 이런식으로 가공
        return String.format("%d억%,d",this.price / 10000,this.price%10000);
        }
    };

    public Room(int price, String address, int floor, String description) {
        this.price = price;
        this.address = address;
        this.floor = floor;
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
