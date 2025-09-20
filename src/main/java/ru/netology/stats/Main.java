package ru.netology.stats;

public class Main {
    public static void main(String[] args) {
        StatsService service = new StatsService();

        // Пример данных из задания
        long[] sales = {8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18};

        System.out.println("Сумма всех продаж: " + service.calculateTotalSales(sales));
        System.out.println("Средняя сумма продаж: " + service.calculateAverageSales(sales));
        System.out.println("Месяц с пиком продаж: " + (service.findPeakSalesMonth(sales) + 1));
        System.out.println("Месяц с минимумом продаж: " + (service.findMinSalesMonth(sales) + 1));
        System.out.println("Месяцев ниже среднего: " + service.countMonthsBelowAverage(sales));
        System.out.println("Месяцев выше среднего: " + service.countMonthsAboveAverage(sales));
    }
}

