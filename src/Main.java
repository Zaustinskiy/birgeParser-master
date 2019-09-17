import java.io.IOException;
public class Main {

    public static void main(String[] args) throws IOException {

        ParserBuyUSD parser = new ParserBuyUSD();
        Proposal prop1 = parser.getBuyUSDProposal();
        System.out.println("To buy:");
        prop1.printProposal();
        ParserSellUSD parser1 = new ParserSellUSD();
        prop1 = parser1.getSellUSDProposal();
        System.out.println("To sell:");
        prop1.printProposal();
    }
}
