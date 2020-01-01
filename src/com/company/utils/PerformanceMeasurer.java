package com.company.utils;

public class PerformanceMeasurer {
    public static long measurePerformance(Runnable methodToTest, int numberOfIterations) {
        long startTime = System.nanoTime();

        for (int i = 0; i < numberOfIterations; i++)
            methodToTest.run();

        long endTime = System.nanoTime() - startTime;
        long averageExecutionTime = endTime / numberOfIterations;

        System.out.println("Average execution time (" + numberOfIterations + " executions): " + averageExecutionTime + " ns");
        return averageExecutionTime;
    }
}
