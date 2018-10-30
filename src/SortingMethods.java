import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class SortingMethods {
    final static String STOP = "Stop";
    final static String TAK = "Tak";
    final static String NIE = "Nie";
    final static String NICK = "Nick";
    final static String SCORE = "Wynik";


    static void addPlayer(ArrayList<Player> listOfPlayers) {


        for (int i = 0; i < 3; i++) {
            System.out.println("Podaj nick gracza: ");
            Scanner addName = new Scanner(System.in);
            String name = (addName.nextLine());
            if (name.equals(STOP)) {
                System.out.println("Jak rozumiem chcesz zakończyć? Czy chcesz posortować tabele wyników? ");
                System.out.println("Jeśli Twoja odpowiedź brzmi 'Tak', wybierz kryterium sortowania.\n");
                System.out.println("1. Wybierz 'Nick', jeśli chesz psortować tabele wyników po nicku gracza.");
                System.out.println("2. Wybierz 'Wynik' jeśli chcesz posortować tabelę według osiągętego wyniku.");
                sortList(addName.nextLine(),addName.nextLine(), listOfPlayers);
                break;
            }
            System.out.println("Podaj liczbę punktów: ");
            Scanner addScore = new Scanner(System.in);
            int score = (addScore.nextInt());

            listOfPlayers.add(new Player(name, score));
        }
        for (Player list : listOfPlayers) {
            System.out.println("Nick gracza: " + list.getName() + ", Wynik: " + list.getScore());
        }
    }
    static void sortList(String choice,String sorting, List<Player> players) {
        switch (choice)
        {
            case TAK:
                switch(sorting) {
                    case NICK:
                        comparePlayersByName(players);
                        fileWriter(players);
                        break;
                    case SCORE:
                        comparePlayersByScore(players);
                        fileWriter(players);
                        break;
                }
                break;
            case NIE:
                System.out.println("W takim razie zapisuję tabelę w pliku w takiej formie. ");
                fileWriter(players);
                break;
        }
    }
    static void comparePlayersByName(List<Player> players) {
        Collections.sort(players, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }
    static void comparePlayersByScore(List<Player>players){
        Collections.sort(players);
    }
    static void fileWriter(List<Player> listOfPlayers) {

        String fileName = "Wyniki zawodów.txt";
        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Player player : listOfPlayers) {
                bw.write("Nick gracza: " + player.getName() + "  Wynik: " + player.getScore() + " ");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Wyniki zapisano do pliku.");
    }
}

