package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResourceFactory {
    final int x = 1;
    final int y = 4;
    final int x1 = 0;
    final int y1 = 8;


    static List<SpareParts> listDetail = new ArrayList<>();

    public List<SpareParts> getListDetail() {
        return listDetail;
    }

    public void setListDetail(List<SpareParts> listDetail) {
        this.listDetail = listDetail;
    }

    public ResourceFactory() {
        for (int i = 0; i < 3; i++) {
            this.listDetail.addAll(Arrays.asList(SpareParts.values()));
        }
    }

    public void addParts() {
        int random_number3 = x + (int) (Math.random() * ((y - x) + 1));
        if (this.getListDetail().size() < 4) {
            for (int i = 0; i < random_number3; i++) {
                int random_number4 = x1 + (int) (Math.random() * ((y1 - x1) + 1));
                this.getListDetail().add(SpareParts.values()[random_number4]);
            }
        }else {
            for (int i = 0; i < random_number3; i++) {
                int random_number4 = x1 + (int) (Math.random() * ((y1 - x1) + 1));
                this.getListDetail().add(SpareParts.values()[random_number4]);

            }
    }
}}
