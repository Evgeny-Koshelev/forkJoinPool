package org.example;

import java.util.concurrent.RecursiveTask;

public class FactorialTask extends RecursiveTask<Long> {

    private Integer n;

    public FactorialTask (Integer n) {
        this.n = n;
    }

    @Override
    protected Long compute() {
        if(n < 2)
            return 1L;

        else {
            FactorialTask factorialTask = new FactorialTask(n -1);
            factorialTask.fork();
            return n * factorialTask.join();
        }
    }
}
