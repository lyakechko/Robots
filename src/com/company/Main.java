package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ResourceFactory resourceFactory = new ResourceFactory();
        FirstScientist firstScientistse = new FirstScientist(resourceFactory);
        SecondScientist secondScientist = new SecondScientist(resourceFactory);
        for (int i = 1; i < 101; i++) {
            System.out.println("Ночь " + i);
            Thread thread1 = new Thread(firstScientistse);
            Thread thread2 = new Thread(secondScientist);
            thread1.start();
            thread2.start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Ночь "+i+" закончилась.");
            resourceFactory.addParts();

        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Количество собранных роботов 1-го учёного: " + firstScientistse.totalNumberOfRobots(firstScientistse.getListFirstScientist()));
        System.out.println("Количество собранных роботов 2-го учёного: " + secondScientist.totalNumberOfRobots(secondScientist.getListSecondScientist()));


    }
}
