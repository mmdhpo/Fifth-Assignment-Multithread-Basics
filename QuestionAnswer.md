## Theoretical Questions 📝 
1. **What will be printed after interrupting the thread?**

```java
public static class SleepThread extends Thread {
        public void run() {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted!");
            } finally {
                System.out.println("Thread will be finished here!!!");
            }
        }
    }

    public static void main(String[] args) {
        SleepThread thread = new SleepThread();
        thread.start();
        thread.interrupt();
    }
```
2. In Java, what would be the outcome if the `run()` method of a `Runnable` object is invoked directly, without initiating it inside a `Thread` object?
```java
public class DirectRunnable implements Runnable {
    public void run() {
        System.out.println("Running in: " + Thread.currentThread().getName());
    }
}

public class Main {
    public static void main(String[] args) {
        DirectRunnable runnable = new DirectRunnable();
        runnable.run();
    }
}
```
3. Elaborate on the sequence of events that occur when the `join()` method of a thread (let's call it `Thread_0`) is invoked within the `Main()` method of a Java program.
```java
public class JoinThread extends Thread {
    public void run() {
        System.out.println("Running in: " + Thread.currentThread().getName());
    }
}

public class Main {
    public static void main(String[] args) {
        JoinThread thread = new JoinThread();
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Back to: " + Thread.currentThread().getName());
    }
}
```
## Answers 📝
1.**Thread was interrupted!**

**Thread will be finished here!!!**

2.**The program will have only one thread and the run method will execute like the other methods.**

3.**When the join method is called, the main thread is kept until the desired thread ends, then it continues**