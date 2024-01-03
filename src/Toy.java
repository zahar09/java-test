public class Toy {
    @Override
    public String toString() {
        return "Toy [name=" + name + "]";
    }

    private int id;
    private String name;
    private int amount;
    private int lossRate;

    Toy(String name, int amount, int lossRate, int id){
        this.name = name;
        this.amount = amount;
        this.lossRate = lossRate;
        this.id = id;
    }

    public void ChangeLossrate(int newLossRate){
        this.lossRate = newLossRate;
    }

    public void ChangeAmount(){
        if(amount >= 1){
            amount -= 1;
        }
        else{
            amount = 0;
        }
    }

    public int getAmount() {
        return amount;
    }

    public int getLossRate(){
        return lossRate;
    }
}
