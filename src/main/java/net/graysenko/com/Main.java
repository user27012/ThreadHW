package net.graysenko.com;

public class Main {
    public static void main(String[] args) {
        Thread first = new Thread(new MyRunnable("First"));
        Thread second = new Thread(new MyRunnable("First"));
        Thread Third = new Thread(new MyRunnable("First"));

        first.start();
        second.start();
        Third.start();

        try{
            first.join();
            System.out.println("Поток 1 выполнил свою работу!");
            second.sleep(1000);
            second.join();
            System.out.println("Поток 2 выполнил свою работу!");
            Third.sleep(1000);
            Third.join();
            System.out.println("Поток 3 выполнил свою работу!");
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class MyRunnable implements Runnable{
    private String threadName;

    public MyRunnable(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 5; i++){
            System.out.println("Выполнение действия процессов: " + i);
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }
}
