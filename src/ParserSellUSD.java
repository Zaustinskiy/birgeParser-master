import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class ParserSellUSD {

   private List<Proposal> proposalList = new ArrayList<Proposal>();
   private String value = "";
   private String phone = "";
   private Double valueDouble;
   private String bankName = "";
   private String inf = "";
   private Double maxValue = 0d;
   private String addString = "";
   final String url = "https://cash.rbc.ru/?currency=3&city=1&deal=sell&amount=100";
    public Proposal getSellUSDProposal() {
        try {

            final Document doc = Jsoup.connect(url).get();
            Elements listEl = doc.select("div.quote__office__content.js-office-content");
            for (Element row : listEl.select("div.quote__office__one.js-one-office"))
            {
                value = row.select("div.quote__office__cell.quote__office__one__rate.quote__mode_list_view").text();
                value = value.substring(0, 5);
                valueDouble = Double.parseDouble(value);
                Elements row1 = row.select("div.quote__office__cell");
                bankName = row1.select("a.quote__office__one__name").text();
                phone = row1.select("div.quote__office__one__phone").text();
                inf = " в " + bankName + " " + phone;
                proposalList.add(new Proposal(valueDouble, inf));
            }

            for (Proposal i : proposalList){
                if (i.getExRate()>maxValue){
                    maxValue = i.getExRate();
                    addString = i.getBankInf();
                }
            }


           // System.out.println(maxValue + "  " + addString);


        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new Proposal(maxValue, addString);
    }
}
