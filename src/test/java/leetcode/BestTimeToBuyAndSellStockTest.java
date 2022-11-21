package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BestTimeToBuyAndSellStockTest {

    @Test
    void case1() {
        BestTimeToBuyAndSellStock stock = new BestTimeToBuyAndSellStock();
        int[] prices = {7, 1, 5, 3, 6, 4};
        assertThat(stock.maxProfit(prices)).isEqualTo(5);
    }

    @Test
    void case2() {
        BestTimeToBuyAndSellStock stock = new BestTimeToBuyAndSellStock();
        int[] prices = {7,6,4,3,1};
        assertThat(stock.maxProfit(prices)).isZero();
    }

}