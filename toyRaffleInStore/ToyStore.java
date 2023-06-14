package toyRaffleInStore;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ToyStore {
    private ArrayList<Toy> toys;
    private ArrayList<Toy> prizeToys;
    private String pathPrizeFile;

    public ToyStore() {
        toys = new ArrayList<>();
        prizeToys = new ArrayList<>();
        pathPrizeFile = "prize.txt";
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    //    метод для изменения частоты выпадения (веса) игрушки
    public void changeToyFrequency(int toyId, double newFrequency) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setFrequency(newFrequency);
            }
        }
    }

    //    метод для запуска нашего розыгрыша
    public void startRaffle() {
        prizeToys.clear();
        for (Toy toy : toys) {
            double random = Math.random() * 100;
            if (random < toy.getFrequency()) {
                prizeToys.add(toy);
            }
        }
    }

    //  метод выбора призовой игрушки
    public Toy getPrizeToy() {
        if (!prizeToys.isEmpty()) {
            Toy prizeToy = prizeToys.remove(0);
            prizeToy.setCount(prizeToy.getCount() - 1);
            try {
                FileWriter writer = new FileWriter(pathPrizeFile, true);
                writer.write(prizeToy.getName() + "\n");
                writer.close();
            } catch (IOException e) {
                System.out.println("Ошибка при записи в файл");
            }
            return prizeToy;
        } else {
            System.out.println("Игрушки закончились");
            return null;
        }
    }
}