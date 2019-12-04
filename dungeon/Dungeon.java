package dungeon;

import java.util.*;

public class Dungeon {

    private int length;
    private int height;
    private int vampires;
    private int moves;
    private boolean vampiresMove;
    private Moveable player;
    private ArrayList<Moveable> listOfVampires;
    private Scanner reader;

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.length = length;
        this.height = height;
        this.vampires = vampires;
        this.moves = moves;
        this.vampiresMove = vampiresMove;
        this.reader = new Scanner(System.in);
        this.player = new Moveable(0, 0);
        this.listOfVampires = new ArrayList<Moveable>();
    }

    public int getHeight() {
        return this.height;
    }

    public int getLenght() {
        return this.length;
    }

    public void run() {
        initializeVampires();
        cycle();
    }

    private void cycle() {
        while (this.moves > 0) {
            System.out.println(this.moves);
            System.out.println();
            calculateMoves();
            stats();
            System.out.println();
            print();
            System.out.println();
            this.moves--;
            readInput();
            if (this.listOfVampires.isEmpty()) {
                System.out.println("YOU WIN");
                break;
            }
        }
        System.out.println("YOU LOSE");
    }

    private void calculateMoves() {
        Random random = new Random();
        ArrayList<Moveable> vampiresToBeRemoved = new ArrayList<Moveable>();
        for (Moveable vampire : this.listOfVampires) {
            if (vampire.getX() == player.getX() && vampire.getY() == player.getY()) {
                vampiresToBeRemoved.add(vampire);
            }
            listOfVampires.removeAll(vampiresToBeRemoved);
        }
        if (this.vampiresMove = false) {
            return;
        }
        for (Moveable vampire : this.listOfVampires) {
            int directionOfMovement = random.nextInt(4);
            switch (directionOfMovement) {
                case 0:
                    moveVertifierForVampires(0, 1, vampire);
                    break;
                case 1:
                    moveVertifierForVampires(1, 0, vampire);
                    break;
                case 2:
                    moveVertifierForVampires(-1, 0, vampire);
                    break;
                case 3:
                    moveVertifierForVampires(0, -1, vampire);
                    break;
                default:
                    break;
            }

            if (vampire.getX() == player.getX() && vampire.getY() == player.getY()) {
                vampiresToBeRemoved.add(vampire);
            }
            listOfVampires.removeAll(vampiresToBeRemoved);
        }
    }

    private void stats() {
        System.out.println("@ " + this.player.getX() + " " + this.player.getY());
        for (Moveable vampire : this.listOfVampires) {
            System.out.println("v " + vampire.getX() + " " + vampire.getY());
        }
    }

    private void print() {

        for (int i = 0; i < this.height; i++) {
            for (int count = 0; count < this.length; count++) {
                Moveable printerCoordinates = new Moveable(count, i);
                if (printerCoordinates.getX() == player.getX() & printerCoordinates.getY() == player.getY()) {
                    System.out.print("@");
                    continue;
                }
                Moveable vampire = this.listOfVampires.get(0);
                for (int counter = 0; counter < listOfVampires.size()-1; counter++) {
                    vampire = this.listOfVampires.get(counter);
                    if (printerCoordinates.getX() == vampire.getX() && printerCoordinates.getY() == vampire.getY()) {
                        System.out.print("v");
                    } else {
                        System.out.print(".");
                    }
                }
            }
            System.out.print("\n");
        }
    }

    private void readInput() {
        String input = reader.nextLine();
        char[] chars = input.toCharArray();
        for (char character : chars) {
            switch (character) {
                case 'w':
                    moveVertifierForPlayer(0, 1, player);
                    break;
                case 'a':
                    moveVertifierForPlayer(1, 0, player);
                    break;
                case 's':
                    moveVertifierForPlayer(0, -1, player);
                    break;
                case 'd':
                    moveVertifierForPlayer(-1, 0, player);
                    break;
                default:
                    break;
            }
        }
    }

    private void initializeVampires() {
        Random random = new Random();
        for (int i = 0; i < this.vampires; i++) {
            int x = random.nextInt(length);
            int y = random.nextInt(height);
            Moveable vampire = new Moveable(x, y);
            this.listOfVampires.add(vampire);
        }
    }

    private boolean moveVertifierForVampires(int dx, int dy, Moveable moveable) {
        int futureX = moveable.getX() + dx;
        int futureY = moveable.getY() + dy;
        if (futureX > this.length || futureY > this.height) {
            return false;
        }
        for (Moveable vampire : this.listOfVampires) {
            if (futureX == vampire.getX() && futureY == vampire.getY()) {
                return false;
            }
        }
        moveable.move(dx, dy);
        return true;
    }

    private boolean moveVertifierForPlayer(int dx, int dy, Moveable moveable) {
        int futureX = moveable.getX() + dx;
        int futureY = moveable.getY() + dy;
        if (futureX > this.length || futureY > this.height) {
            return false;
        }
        moveable.move(dx, dy);
        return true;
    }
}
