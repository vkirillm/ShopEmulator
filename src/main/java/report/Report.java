package report;

import goods.Goods;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Report {

    public Report(ArrayList<Goods> goods){

        try(FileWriter writer = new FileWriter("src\\main\\resources\\report.txt", false))
        {
            for (Goods drink: goods) {
                String text = drink.getName()+" "+drink.getVolume()+
                        "\n Количество проданного товара "+drink.getGoodSold()+
                        "\n Количество дозакупленного товара "+drink.getGoodsPurchased()+
                        "\n Прибыль магазина от продаж  "+new DecimalFormat("#0.00")
                                .format((double)Math.round(drink.getProfit()*100)/100)
                                .replace(',', '.')+
                        "\n Затраченные средства на дозакупку товара "+new DecimalFormat("#0.00")
                        .format((double)Math.round(drink.getSpendingMoney()*100)/100)
                        .replace(',', '.');
//                System.out.println(text);

                    writer.write(text);
                    writer.append('\n');
                    writer.flush();
            }
            writer.close();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

    }

}
