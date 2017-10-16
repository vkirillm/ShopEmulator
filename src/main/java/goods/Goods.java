package goods;

public class Goods {
    String name = null;         // имя
    double price = 0;           // цена
    String type = null,         // класс/группа
    volume = null,              // объем
    sort = null;                // крепкость напитка/состав
    int amount = 0;             // количество шт.
    int goodSold = 0;           // продано шт.
    int goodsPurchased = 0;     // докуплено шт.
    double profit = 0;          // прибыль
    double spendingMoney = 0;   // потрачено на закупку

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
