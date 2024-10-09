import java.util.ArrayList;
import java.util.Random;

public class Tamagochi {

    // Privata
    private int hunger;
    private int boredom;
    private final ArrayList<String> words;
    private boolean isALive;
    private final Random generator;

    private void reduceBoredom(){
        int reduce = generator.nextInt(2)+ 1;
        boredom = Math.max(0, boredom - reduce);
        System.out.println(name + " blev mindre uttråkad! Tristess minskade med " + reduce);

    }

    // Publik
    public String name;

    public Tamagochi(String name) {
        this.name = name;
        this.hunger = 0;
        this.boredom = 0;
        this.isALive = true;
        this.words = new ArrayList<>();
        this.generator = new Random();
        this.words.add("Hello");
    }

    public void feed(){
        int food = generator.nextInt(3)+ 1;
        hunger = Math.max(0, hunger - food);
        System.out.println(name + " blev matad! Hunger minskade med " + food);
    }

    public void speak(){
        if (!words.isEmpty()){
            String word = words.get(generator.nextInt(words.size()));
            System.out.println(name + " säger: " + word);
        } else {
            System.out.println(name + "har inga ord att säga.");
        }
        reduceBoredom();
    }

    public void teach(String word){
        words.add(word);
        System.out.println(name + " lärde sig ett nytt ord: " + word);
        reduceBoredom();
    }

    public void tick(){
        hunger ++;
        boredom ++;

        if (hunger > 10 || boredom > 10){
            isALive = false;
            System.out.println(name + " har tyvärr dött...");
        }
    }

    public void printStats() {
        System.out.println("Name: " + name + " || Hunger: " + hunger + " || Boredom: " + boredom + " || Vocabulary: " + words.size() + "words");
    }

    public boolean isAlive(){
        return isALive;
    }
}
