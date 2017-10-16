package shopemulator.goods;

public class Goods {
    String name = null;
    double price = 0;
    String type = null,
    volume = null,
    sort = null;
    int amount = 0;
    int goodSold = 0;
    int goodsPurchased = 0;
    double profit = 0;
    double spendingMoney = 0;

    public Goods() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setGoodSold(int goodSold) {
        this.goodSold = goodSold;
    }

    public void setGoodsPurchased(int goodsPurchased) {
        this.goodsPurchased = goodsPurchased;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public void setSpendingMoney(double spendingMoney) {
        this.spendingMoney = spendingMoney;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getVolume() {
        return volume;
    }

    public String getSort() {
        return sort;
    }

    public int getAmount() {
        return amount;
    }

    public int getGoodSold() {
        return goodSold;
    }

    public int getGoodsPurchased() {
        return goodsPurchased;
    }

    public double getProfit() {
        return profit;
    }

    public double getSpendingMoney() {
        return spendingMoney;
    }
}
