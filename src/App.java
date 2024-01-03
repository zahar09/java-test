public class App {
    public static void main(String[] args) throws Exception {
        ToyManager toyManager = new ToyManager();
        toyManager.CreatToy("dragon", 6, 20);
        toyManager.CreatToy("car", 8, 40);
        toyManager.CreatToy("ball", 8, 200);
        toyManager.ChoicePrizeToy();
        toyManager.ChoicePrizeToy();
        toyManager.ChoicePrizeToy();
        toyManager.ChoicePrizeToy();
        toyManager.ChoicePrizeToy();
        toyManager.GetPrizeToy();
        toyManager.GetPrizeToy();
        toyManager.GetPrizeToy();
        toyManager.GetPrizeToy();
    }
}
