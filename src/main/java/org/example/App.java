package org.example;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService scheduledExecutorService = Executors.newFixedThreadPool(4);

//        Callable<String> hello = () -> {
//            Thread.sleep(2000L);
//          return "hello";
//        };
//
//        Callable<String> java = () -> {
//            Thread.sleep(2000L);
//            return "java";
//        };
//
//        Callable<String> kibong = () -> {
//            Thread.sleep(2000L);
//            return "kibong";
//        };
//
//        String futures = scheduledExecutorService.invokeAny(Arrays.asList(hello,java,kibong));
//
//        System.out.println(futures);
//
//        scheduledExecutorService.shutdown();
        Const.GOOD.equals("hello");
        FunctionalInterFace functionalInterFace = new FunctionalInterFace();

        functionalInterFace.doFunction();
    }
}
