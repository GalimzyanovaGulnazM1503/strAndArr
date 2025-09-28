package ru.netology.stats;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class StatsServiceTest {

    private StatsService service;
    private long[] exampleSales;

    @BeforeEach
    void setUp() {
        service = new StatsService();
        exampleSales = new long[]{8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18};
    }

    @Test
    void testCalculateTotalSalesWithExampleData() {
        long result = service.calculateTotalSales(exampleSales);
        assertEquals(180, result);
    }

    @Test
    void testCalculateTotalSalesWithEmptyArray() {
        long result = service.calculateTotalSales(new long[0]);
        assertEquals(0, result);
    }

    @Test
    void testCalculateTotalSalesWithNull() {
        long result = service.calculateTotalSales(null);
        assertEquals(0, result);
    }

    @Test
    void testCalculateTotalSalesWithLargeNumbers() {
        long[] largeSales = {5_000_000_000L, 2_500_000_000L, 3_000_000_000L};
        long result = service.calculateTotalSales(largeSales);
        assertEquals(10_500_000_000L, result);
    }

    @Test
    void testCalculateAverageSalesWithExampleData() {
        double result = service.calculateAverageSales(exampleSales);
        assertEquals(15.0, result, 0.001);
    }

    @Test
    void testCalculateAverageSalesWithEmptyArray() {
        double result = service.calculateAverageSales(new long[0]);
        assertEquals(0.0, result, 0.001);
    }

    @Test
    void testCalculateAverageSalesWithSingleElement() {
        double result = service.calculateAverageSales(new long[]{100});
        assertEquals(100.0, result, 0.001);
    }

    @Test
    void testCalculateAverageSalesWithFractionalResult() {
        long[] sales = {10, 20, 30};
        double result = service.calculateAverageSales(sales);
        assertEquals(20.0, result, 0.001);
    }

    @Test
    void testFindPeakSalesMonthWithExampleData() {
        int result = service.findPeakSalesMonth(exampleSales);
        assertEquals(7, result); // Последний месяц с максимальным значением 20 (индекс 7)
    }

    @Test
    void testFindPeakSalesMonthWithMultiplePeaks() {
        long[] sales = {10, 20, 15, 20, 25, 25, 20};
        int result = service.findPeakSalesMonth(sales);
        assertEquals(5, result); // Последний пик (индекс 5)
    }

    @Test
    void testFindPeakSalesMonthWithSingleElement() {
        int result = service.findPeakSalesMonth(new long[]{100});
        assertEquals(0, result);
    }

    @Test
    void testFindPeakSalesMonthWithEmptyArray() {
        int result = service.findPeakSalesMonth(new long[0]);
        assertEquals(-1, result);
    }

    @Test
    void testFindMinSalesMonthWithExampleData() {
        int result = service.findMinSalesMonth(exampleSales);
        assertEquals(8, result); // Месяц с минимальным значением 7 (индекс 8)
    }

    @Test
    void testFindMinSalesMonthWithMultipleMins() {
        long[] sales = {10, 5, 15, 5, 20, 3, 3};
        int result = service.findMinSalesMonth(sales);
        assertEquals(6, result); // Последний минимум (индекс 6)
    }

    @Test
    void testFindMinSalesMonthWithSingleElement() {
        int result = service.findMinSalesMonth(new long[]{50});
        assertEquals(0, result);
    }

    @Test
    void testFindMinSalesMonthWithEmptyArray() {
        int result = service.findMinSalesMonth(new long[0]);
        assertEquals(-1, result);
    }

    @Test
    void testCountMonthsBelowAverageWithExampleData() {
        int result = service.countMonthsBelowAverage(exampleSales);
        assertEquals(5, result); // Месяцы: 0, 2, 8, 9, 10
    }

    @Test
    void testCountMonthsBelowAverageWithAllEqual() {
        long[] sales = {15, 15, 15, 15};
        int result = service.countMonthsBelowAverage(sales);
        assertEquals(0, result);
    }

    @Test
    void testCountMonthsBelowAverageWithEmptyArray() {
        int result = service.countMonthsBelowAverage(new long[0]);
        assertEquals(0, result);
    }

    @Test
    void testCountMonthsAboveAverageWithExampleData() {
        int result = service.countMonthsAboveAverage(exampleSales);
        assertEquals(5, result); // Месяцы: 4, 5, 6, 7, 11
    }

    @Test
    void testCountMonthsAboveAverageWithAllEqual() {
        long[] sales = {20, 20, 20, 20};
        int result = service.countMonthsAboveAverage(sales);
        assertEquals(0, result);
    }

    @Test
    void testCountMonthsAboveAverageWithEmptyArray() {
        int result = service.countMonthsAboveAverage(new long[0]);
        assertEquals(0, result);
    }

    @Test
    void testCountMonthsExactlyAtAverage() {
        long[] sales = {10, 20, 30}; // Среднее = 20
        int below = service.countMonthsBelowAverage(sales);
        int above = service.countMonthsAboveAverage(sales);

        assertEquals(1, below); // 10
        assertEquals(1, above); // 30
    }

    @Test
    void testIntegrationAllMethodsWithExampleData() {
        // Комплексная проверка всех методов на одном наборе данных
        assertEquals(180, service.calculateTotalSales(exampleSales));
        assertEquals(15.0, service.calculateAverageSales(exampleSales), 0.001);
        assertEquals(7, service.findPeakSalesMonth(exampleSales));
        assertEquals(8, service.findMinSalesMonth(exampleSales));
        assertEquals(5, service.countMonthsBelowAverage(exampleSales));
        assertEquals(5, service.countMonthsAboveAverage(exampleSales));
    }

    @Test
    void testWithNegativeValues() {
        long[] sales = {-5, 10, -3, 15, -1};

        assertEquals(16, service.calculateTotalSales(sales));
        assertEquals(3.2, service.calculateAverageSales(sales), 0.001);
        assertEquals(3, service.findPeakSalesMonth(sales));
        assertEquals(0, service.findMinSalesMonth(sales));
        assertEquals(3, service.countMonthsBelowAverage(sales));
        assertEquals(2, service.countMonthsAboveAverage(sales));
    }
}