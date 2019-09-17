public class Parsing {
    private Proposal buyProposal;
    private Proposal sellProposal;

    void setBuyProposal()
    {
        buyProposal = new ParserBuyUSD().getBuyUSDProposal();
    }
    void setSellProposal()
    {
        sellProposal = new ParserSellUSD().getSellUSDProposal();
    }

    public Proposal getBuyProposal() {
        return buyProposal;
    }

    public Proposal getSellProposal() {
        return sellProposal;
    }
}
