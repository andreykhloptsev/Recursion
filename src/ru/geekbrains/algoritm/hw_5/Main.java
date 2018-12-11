package ru.geekbrains.algoritm.hw_5;


public class Main {
    static int counter=0;
    public static void main(String[] args) {
        //Написать программу по возведению числа в степень с помощью рекурсии.
        System.out.println(powRec(2,10));

        //Ханойские башни
        int n=5;
        Stack<String>[] towers = new Stack[3];
        for (int i = 0; i <towers.length ; i++) {
            towers[i]= new Stack<>();
        }
        for (int i = 0; i <n ; i++) {
            towers[0].push("_"+(n-i));
        }
        System.out.println("First :"+towers[0].toString());
        System.out.println("Second :"+towers[1].toString());
        System.out.println("Third :"+towers[2].toString());

        hanoiRec(towers[0],towers[1],towers[2],n);

        System.out.println("First :"+towers[0].toString());
        System.out.println("Second :"+towers[1].toString());
        System.out.println("Third :"+towers[2].toString());

        System.out.println(counter);
    }

    public static void hanoiRec(Stack<String> from, Stack<String> to, Stack<String> temp, int n){
        counter++;
        if (n==1) {
            to.push(from.pop());
        } else {
                hanoiRec(from,temp,to,n-1);
                to.push(from.pop());
                hanoiRec(temp,to,from,n-1);
        }
    }


    public static long powRec(long a, int n ){
        if (n==1) {
            return a;
        }
        else return a*powRec(a,n-1);
    }

        }
