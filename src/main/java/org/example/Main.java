package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
//    Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит
//    тарелка спагетти.
//    Вилки лежат на столе между каждой парой ближайших философов.
//    Каждый философ может либо есть, либо размышлять.
//    Философ может есть только тогда, когда держит две вилки — взятую справа и слева.
//    Философ не может есть два раза подряд, не прервавшись на размышления (можно не учитывать)
//
//    Описать в виде кода такую ситуацию. Каждый философ должен поесть три раза
    public static void main(String[] args) throws InterruptedException {
        List<Philosopher> listP = new ArrayList<>();
        listP.add(new Philosopher("Платон"));
        listP.add(new Philosopher("Аристотель"));
        listP.add(new Philosopher("Сократ"));
        listP.add(new Philosopher("Цицерон"));
        listP.add(new Philosopher("Пифагор"));
        for (Philosopher el:listP) {
            el.start();
        }

        for (Philosopher el:listP) {
            el.join();
        }

        for (Philosopher el:listP) {
            System.out.println(el.getCountEat());
        }


    }
}