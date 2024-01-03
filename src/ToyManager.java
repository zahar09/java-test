import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyManager {
    private List<Toy> toys;
    private List<Toy> prizeToys;
    //private FileWriter fileWriter;

    ToyManager(){
        this.toys = new ArrayList<>();
        this.prizeToys = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "ToyManager [toys=" + toys + ", prizeToys=" + prizeToys + "]";
    }


    public void CreatToy(String name, int amount, int lossRate){
        Toy toy = new Toy(name, amount, lossRate, toys.size());
        this.toys.add(toy);
        this.prizeToys.add(toy);
    }

    public void ChoicePrizeToy(){
        // if(toys.size() > 2){
        //     List<Integer> sums = new ArrayList<>();
        //     int sum = 0;
        //     for(int i = 0;i < this.toys.size();i++){
        //         sum += this.toys.get(i).getAmount() * this.toys.get(i).getLossRate();
        //         sums.add(i, this.toys.get(i).getAmount() * this.toys.get(i).getLossRate());
        //     }
        //     int maximum = sum;
        //     int minimum = 1;
        //     Random rn = new Random();
        //     int randomNum = rn.nextInt(maximum - minimum + 1) + minimum;
        //     for(int i = 1;i < sums.size() - 1;i++){
                
                
        //     }
        // }

        Random rand = new Random();
        int totalDropRate = 0;
        List<Integer> dropRates = new ArrayList<>();
        for(int i = 0;i < this.toys.size();i++){
            dropRates.add(this.toys.get(i).getLossRate());
        }
        for (int rate : dropRates) {
            totalDropRate += rate;
        }

        int randomNumber = rand.nextInt(totalDropRate);

        int cumulativeRate = 0;
        for (int i = 0; i < this.toys.size(); i++) {
            cumulativeRate += dropRates.get(i);
            if (randomNumber < cumulativeRate) {
                this.prizeToys.add(toys.get(i));
                toys.get(i).ChangeAmount();
                if(toys.get(i).getAmount() == 0){
                    toys.remove(toys.get(i));
                }
                return;
            }
        }
        
    }

    public void GetPrizeToy(){
        try(FileWriter writer = new FileWriter("notes.txt", true))
        {
            Toy toy = this.prizeToys.get(0);
            writer.append(toy.toString());
            writer.append("\n");
            this.prizeToys.remove(0);
            //System.out.println(prizeToys.toString());
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        } 

        
        //return toy;
    }

}
