package toyRaffleInStore;

public class Raffle {
    public static void main(String[] args) {
        ToyStore store = new ToyStore();

        Toy toy1 = new Toy(1, "Машинка", 100, 20);
        Toy toy2 = new Toy(2, "Мяч", 50, 30);
        Toy toy3 = new Toy(3, "Кукла", 200, 40);
        Toy toy4 = new Toy(4, "Мишка", 40, 10);
        Toy toy5 = new Toy(5, "Конструктор", 60, 25);

        store.addToy(toy1);
        store.addToy(toy2);
        store.addToy(toy3);
        store.addToy(toy4);
        store.addToy(toy5);

        store.changeToyFrequency(1, 30);
        store.startRaffle();

        Toy prizeToy = store.getPrizeToy();
        if (prizeToy != null) {
            System.out.println("Призовая игрушка: " + prizeToy);
        }

    }

}
