import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class ParserBuyUSD {
    private List<Proposal> proposalList = new ArrayList<Proposal>();
    private String value = "";
    private String bankName = "";
    private String phone = "";
    private Double valueInt;
    private String inf = "";
    private Double minValue = 1000d;
    private String addString = "";
    final String url = "https://cash.rbc.ru/?currency=3&city=1&deal=buy&amount=100";
    public Proposal getBuyUSDProposal(){
        try{
            final Document doc = Jsoup.connect(url).get();
            Elements listEl = doc.select("div.quote__office__content.js-office-content");
            for (Element row : listEl.select("div.quote__office__one.js-one-office"))
            {
                value = row.select("div.quote__office__cell.quote__office__one__rate.quote__mode_list_view").text();
                value = value.substring(0, 5);
                valueInt = Double.parseDouble(value);
                Elements row1 = row.select("div.quote__office__cell");
                bankName = row1.select("a.quote__office__one__name").text();
                phone = row1.select("div.quote__office__one__phone").text();
                inf = " в " + bankName + " " + phone;
                proposalList.add(new Proposal(valueInt, inf));
            }

            for (Proposal i: proposalList)
            {
                if (i.getExRate() < minValue) {
                    minValue = i.getExRate();
                    addString = i.getBankInf();
                }
            }
           // System.out.println("Min value to buy USD is: " + minValue + addString);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new Proposal(minValue, addString);
    }
}
