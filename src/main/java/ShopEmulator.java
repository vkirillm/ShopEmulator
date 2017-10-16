import csv.Csv;
import goods.Goods;
import report.Report;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ShopEmulator {
    static ArrayList<Goods> goods = new ArrayList<Goods>();



    public static void main(String[] args) {
        CsvToGoods();

        for(int day = 1; day<=30; day++){
//            System.out.println("+++++DAY#"+day+"++++++++++++++++");
            workday(day);
            purchase();
        }

        new Report(goods);
        GoodsToCsv();
    }


    public static void CsvToGoods() {
        Csv.Reader reader = null;
        try {
            reader = new Csv.Reader(new InputStreamReader(new FileInputStream("src\\main\\resources\\goods.csv"), "UTF-8")).delimiter(',').ignoreComments(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<String> temp = reader.readLine();
        int i = 0;

        while(temp!= null){
            System.out.println(temp);
            goods.add(new Goods());

            goods.get(i).setName(temp.get(0));
            goods.get(i).setPrice(Double.parseDouble(temp.get(1)));
            goods.get(i).setType(temp.get(2));
            goods.get(i).setVolume(temp.get(3));
            goods.get(i).setSort(temp.get(4));
            goods.get(i).setAmount(Integer.parseInt(temp.get(5)));

            temp = reader.readLine();
            i++;
        }

    }

    public static void GoodsToCsv() {
        Csv.Writer writer = new Csv.Writer("src\\main\\resources\\goods.csv").delimiter(',');

        for (Goods i: goods) {
            writer.value(i.getName())
                    .value(new DecimalFormat("#0.00")
                            .format((double)Math.round(i.getPrice()*100)/100)
                            .replace(',', '.')+"")
                    .value(i.getType())
                    .value(i.getVolume())
                    .value(i.getSort())
                    .value(i.getAmount()+"").newLine();
        }
        writer.close();
    }



    private static void workday(int day){
        Random random = new Random();

        for(int hour = 8; hour < 21; hour++){
//            System.out.println("+++++HOUR#"+hour+"++++++++++++++++++");
            int buyers = random.nextInt(10)+1;
            for(int buyer = 1; buyer <= buyers; buyer++){

                int sale = random.nextInt(11);
                int[] listDrinks = new int[goods.size()];
//                System.out.println("+++++ Buyer#"+buyer+" buys drinks = "+sale);
                for (int i = sale; ((i > 0)&&(!checkEmptyGoods(i))); i--) { //Выбор товара покупателем и проверка его наличия
                    int drink = random.nextInt(goods.size());
                    if (goods.get(drink).getAmount() - (listDrinks[drink] + 1) >= 0) {
                        listDrinks[drink] += 1;
                    } else {
                        i++;
                    }
                }

                for(int drink = 0; drink < listDrinks.length; drink++){
                    int numberDrinks = listDrinks[drink];
                    if (numberDrinks != 0) markup(drink, numberDrinks, hour, day); //Калькуляция скидки на товар
                }

            }
        }
    }

    private static void purchase(){
        for (Goods i: goods) {
            if(i.getAmount()<10){
                i.setAmount(i.getAmount()+150);
                i.setGoodsPurchased(i.getGoodsPurchased()+150);             //Количество проданного товара
                i.setSpendingMoney(i.getSpendingMoney()+150*i.getPrice());  //Затраченные средства на дозакупку товара
            }
        }
    }


    private static void markup(int drink, int num, int hour, int day){
        double price = goods.get(drink).getPrice();
        goods.get(drink).setGoodSold( goods.get(drink).getGoodSold() + num);    //Количество проданного товара
        goods.get(drink).setAmount( goods.get(drink).getAmount() - num);        //Количество товара

        for(int i = 1; i<= num; i++){
            double coefficient = 1.1;
            if(i > 2){
                coefficient = 1.07;
            }else{
                if( (18 <= hour) && (hour < 20) ){
                    coefficient = 1.08;
                }else{
                    if((day%7 == 0)||(day%7 == 6)){
                        coefficient = 1.15;
                    }
                }
            }

            double profit = ((double)( (int)((price*coefficient-price)*100) ))/100;     //Прибыль за еденицу товара
            goods.get(drink).setProfit( goods.get(drink).getProfit() + profit );        //Прибыль магазина
            salesLog(drink,((double)( (int)((price*coefficient)*100) ))/100,coefficient);

        }

    }

    private static boolean checkEmptyGoods(int num){
        int counter = 0;
        for (Goods i: goods) {
            counter += i.getAmount();
            if(counter >= num) return false;
        }
        return true;
    }

    private static void salesLog(int drink, double price, double coefficient){
        System.out.println("Что продано: "+goods.get(drink).getName()
                +"; Цена продажи: "+new DecimalFormat("#0.00")
                    .format((double)Math.round(price*100)/100)
                    .replace(',', '.')
                +"; Правила наценки: "+((int)(coefficient*100) % 100)
                +"%;");
    }




}
