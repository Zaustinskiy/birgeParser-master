public class Proposal {
   private Double exRate;
   private String bankInf;

    public Proposal(Double exRate, String bankInf) {
        this.exRate = exRate;
        this.bankInf = bankInf;
    }

    public Double getExRate() {
        return exRate;
    }

    public String getBankInf() {
        return bankInf;
    }

    public void setExRate(Double exRate) {
        this.exRate = exRate;
    }

    public void setBankInf(String bankInf) {
        this.bankInf = bankInf;
    }
    void printProposal(){
        System.out.println("Best value is: " + this.exRate + this.bankInf);
    }
}
