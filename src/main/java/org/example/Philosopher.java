package org.example;

import javax.lang.model.element.Name;

public class Philosopher extends Thread{
    private int countEat = 3;
    private final String name;
    private final int number;
    private boolean isEat=false;
    private int fork1;
    private int fork2;
    private static volatile boolean [] forks = new boolean[]{true,true,true,true,true};
    private static int count =0;
    public Philosopher(String name) {
        this.name = name;
        this.number = ++count;
        if(count==1){
            this.fork1 =4;
            this.fork2 = 0;
        }else {
            this.fork1=count-2;
            this.fork2=count-1;
        }

    }

    @Override
    public void  run() {
        while(countEat!=0){
            if(getForks()){
                eat();
                countEat--;
            }
            think();
        }
        System.out.println(name +" я все");
    }

    private synchronized boolean getForks(){
        if(forks[fork1]==true && forks[fork2] == true && isEat == false){
            forks[fork1]=false;
            forks[fork2] =false;
            System.out.println(name+ " взял вилки! "+fork1+" "+ fork2);
            isEat=true;
        }
        return isEat;
    }
    private synchronized void eat(){
        if(isEat) {
            try {
                System.out.println(name + " кушает " + countEat);
                Thread.sleep(1000);
                isEat=false;
                forks[fork1]=true;
                forks[fork2] =true;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private void think(){
        try {
            System.out.println(name + " думает");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getCountEat() {
        return countEat;
    }
}
