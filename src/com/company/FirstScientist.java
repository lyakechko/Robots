package com.company;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class FirstScientist implements Runnable {
    ResourceFactory resourceFactory;
    List<SpareParts> listFirstScientist = new ArrayList<>();

    public List<SpareParts> getListFirstScientist() {
        return listFirstScientist;
    }

    final int x = 1;
    final int y = 4;


    public FirstScientist(ResourceFactory resourceFactory) {
        this.resourceFactory = resourceFactory;
    }

    @Override
    public void run() {
        synchronized (resourceFactory) {
            int numberOfTaken = x + (int) (Math.random() * ((y - x) + 1));
            System.out.println("Количество запчастей на свалке с приходом первого: " + resourceFactory.getListDetail().size());
            collectionOfParts(resourceFactory.getListDetail(), numberOfTaken);

        }
    }

    public void collectionOfParts(List<SpareParts> list, int numberOfTaken) {
        System.out.println("FirstScientist.Забирает в ночь: " + numberOfTaken);
        if (list.size() == 0) {
            System.out.println("FirstScientist ушёл ни с чем. На свалке " + list.size() + " деталей");
        } else if (numberOfTaken <= list.size()) {
            for (int t = 0; t < numberOfTaken; t++) {
                int randomIndexDetail = (int) (Math.random() * ((list.size() - 1) + 1));
                listFirstScientist.add(list.get(randomIndexDetail));
                list.remove(randomIndexDetail);
            }
            System.out.println("Thread 1: " + listFirstScientist.size());
        } else {
            for (int t = 0; t < list.size() + 1; t++) {
                int randomIndexDetail = (int) (Math.random() * ((list.size() - 1) + 1));
                listFirstScientist.add(list.get(randomIndexDetail));
                list.remove(randomIndexDetail);
            }
            System.out.println("Thread 1: " + listFirstScientist.size());
        }
    }

    public int totalNumberOfRobots(List<SpareParts> list) {
        HashSet<SpareParts> hashSet = new HashSet();
        StringBuilder stringBuilder = new StringBuilder();
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int e = 0;
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;

        for (SpareParts s : list) {
            switch (s) {
                case CPU:
                    hashSet.add(SpareParts.CPU);
                    a++;
                case HDD:
                    hashSet.add(SpareParts.HDD);
                    b++;
                case RAM:
                    hashSet.add(SpareParts.RAM);
                    c++;
                case BODY:
                    hashSet.add(SpareParts.BODY);
                    d++;
                case HEAD:
                    hashSet.add(SpareParts.HEAD);
                    e++;
                case LEFTARM:
                    i++;
                    hashSet.add(SpareParts.LEFTARM);
                case LEFTLEG:
                    k++;
                    hashSet.add(SpareParts.LEFTLEG);
                case RIGHTARM:
                    l++;
                    hashSet.add(SpareParts.RIGHTARM);
                case RIGHTLEG:
                    hashSet.add(SpareParts.RIGHTLEG);
                    j++;
            }
        }
        int[] array = {a, b, c, d, e, i, k, l, j};
        return Arrays.stream(array).min().getAsInt();
    }


}
