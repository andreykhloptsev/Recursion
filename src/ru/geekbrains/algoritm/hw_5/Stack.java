package ru.geekbrains.algoritm.hw_5;


import java.util.NoSuchElementException;

public class Stack<Item> {

    private int size;
    private Object[] stack = new Object[1];

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    private void resize(int capacity){
        Object[] temp = new Object[capacity];
        System.arraycopy(stack,0,temp,0,size);
        stack = temp;
    }

    public void push(Item item){
        if (stack.length==size)
        {
            resize(stack.length*2);
        }
        stack[size++]=item;
    }

    public Item pop(){
        if (isEmpty()) {
            throw  new NoSuchElementException();
        }
        Item item= (Item)stack[size-1];
        size--;
        if (size>0 && size<stack.length/4){
            resize(stack.length/2);
        }
        return item;
    }

    public void reverse(){
        Stack<Object> temp = new Stack<>();
        int startSize = size;
        for (int i = 0; i <startSize ; i++) {
            temp.push(pop());
        }
        for (int i = 0; i <temp.getSize() ; i++) {
            push((Item)temp.stack[i]);
        }
        System.out.println(temp);
    }


    @Override
    public String toString() {
        StringBuilder s=new StringBuilder(size);
        for (int i = 0; i <size ; i++) {
            s.append(stack[i]);
        }
        return s.toString();
    }
}
