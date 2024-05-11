package sbu.cs;

import java.util.*;

public class TaskScheduler
{
    public static class Task implements Runnable
    {
        /*
            ------------------------- You don't need to modify this part of the code -------------------------
         */
        String taskName;
        int processingTime;

        public Task(String taskName, int processingTime) {
            this.taskName = taskName;
            this.processingTime = processingTime;
        }
        /*
            ------------------------- You don't need to modify this part of the code -------------------------
         */

        @Override
        public void run() {
            /*
            TODO
                Simulate utilizing CPU by sleeping the thread for the specified processingTime
             */
            try {
                Thread.sleep(processingTime);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static ArrayList<String> doTasks(ArrayList<Task> tasks) {
        ArrayList<String> finishedTasks = new ArrayList<>();

        /*
        TODO
            Create a thread for each given task, And then start them based on which task has the highest priority
            (highest priority belongs to the tasks that take more time to be completed).
            You have to wait for each task to get done and then start the next task.
            Don't forget to add each task's name to the finishedTasks after it's completely finished.
         */
        tasks.sort(new Comparator<Task>() {
            @Override
            public int compare(Task p1, Task p2) {
                return p2.processingTime - p1.processingTime;
            }
        });

        for(Task task: tasks){
            Thread thread = new Thread(task, task.taskName);
            thread.start();
            try {
                thread.join();
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
            finishedTasks.add(task.taskName);
        }

        return finishedTasks;
    }

    public static void main(String[] args) {
        // Test your code here
    }
}

