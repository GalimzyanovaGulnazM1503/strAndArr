package ru.netology.stats;

public class StatsService {

    /**
     * Сумма всех продаж
     */
    public long calculateTotalSales(long[] sales) {
        if (sales == null || sales.length == 0) {
            return 0;
        }

        long total = 0;
        for (long sale : sales) {
            total += sale;
        }
        return total;
    }

    /**
     * Средняя сумма продаж в месяц
     */
    public double calculateAverageSales(long[] sales) {
        if (sales == null || sales.length == 0) {
            return 0.0;
        }

        long total = calculateTotalSales(sales);
        return (double) total / sales.length;
    }

    /**
     * Номер месяца с пиком продаж (последний месяц с максимальной суммой)
     */
    public int findPeakSalesMonth(long[] sales) {
        if (sales == null || sales.length == 0) {
            return -1;
        }

        long max = sales[0];
        int peakMonth = 0;

        for (int i = 1; i < sales.length; i++) {
            if (sales[i] >= max) {
                max = sales[i];
                peakMonth = i;
            }
        }
        return peakMonth;
    }

    /**
     * Номер месяца с минимумом продаж (последний месяц с минимальной суммой)
     */
    public int findMinSalesMonth(long[] sales) {
        if (sales == null || sales.length == 0) {
            return -1;
        }

        long min = sales[0];
        int minMonth = 0;

        for (int i = 1; i < sales.length; i++) {
            if (sales[i] <= min) {
                min = sales[i];
                minMonth = i;
            }
        }
        return minMonth;
    }

    /**
     * Количество месяцев с продажами ниже среднего
     */
    public int countMonthsBelowAverage(long[] sales) {
        if (sales == null || sales.length == 0) {
            return 0;
        }

        double average = calculateAverageSales(sales);
        int count = 0;

        for (long sale : sales) {
            if (sale < average) {
                count++;
            }
        }
        return count;
    }

    /**
     * Количество месяцев с продажами выше среднего
     */
    public int countMonthsAboveAverage(long[] sales) {
        if (sales == null || sales.length == 0) {
            return 0;
        }

        double average = calculateAverageSales(sales);
        int count = 0;

        for (long sale : sales) {
            if (sale > average) {
                count++;
            }
        }
        return count;
    }
}
