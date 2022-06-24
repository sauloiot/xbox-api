package com.ghost.xboxapi.utils;

import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

public class RetryUtils {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(RetryUtils.class);

    @FunctionalInterface
    public interface RunnableWithException {
        void run() throws Exception;
    }

    public static <V> V retry(Callable<V> callable, String message, Integer retry, long delay) {
        return attemptRetry(callable, message, retry, delay);
    }

    public static void retry(RunnableWithException runnable, String message, Integer retry, long delay) {
        attemptRetry(() -> {
            runnable.run();
            return null;
        },  message, retry, delay);
    }

    private static <T> T attemptRetry(Callable<T> callable, String message, Integer retry, long delay) {
        int counter = 0;

        Exception exception = new Exception();

        while (counter < retry) {
            try {
                return callable.call();
            } catch (Exception e) {
                counter++;
                LOGGER.error("Tentativa de execução n° " + counter + "/" + retry);

                try {
                    Thread.sleep(delay);
                } catch (InterruptedException interruptedException) {
                    exception = interruptedException;
                }

                if (counter == retry) {
                    exception = e;
                }
            }
        }

        LOGGER.error(message, exception);
        return (T) new Exception(message, exception);
    }
}
