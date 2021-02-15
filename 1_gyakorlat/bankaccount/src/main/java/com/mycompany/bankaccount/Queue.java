
package com.mycompany.bankaccount;

import java.util.List;


public class Queue {
    private List<String> queue;

    public List<String> getQueue() {
        return queue;
    }

    public void setQueue(List<String> queue) {
        this.queue = queue;
    }

    public Queue(List<String> queue) {
        this.queue = new ArrayList<>();
    }
    
    public void push(String string){
        queue.add(string);
    }
    public String top(){
        if(queue.isEmpty()){
            throw new IllegalArgumentException();
        }
        return queue.get(0);
    }
    public String pop(){
        if(queue.isEmpty()){
            throw new IllegalArgumentException();
        }
        return queue.remove(0);
    }
    
    public boolean isEmpty(){
        return queue.isEmpty();
    }
    public void empty(){
        queue.clear();
    }

    @Override
    public String toString() {
        return "Queue{" + "queue=" + queue + '}';
    }
    
}

