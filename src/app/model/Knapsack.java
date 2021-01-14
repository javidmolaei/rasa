package app.model;

import java.util.LinkedList;

/**
 * A class that represents app Knapsack.
 */
public class Knapsack {

    private int cap;
    private int startWeight;
    private String name;
    private LinkedList<KnapsackItem> items;

    /**
     * Constructor that cerates app new knapsack with app cap, name and app startWeight value.
     * @param cap
     * @param name
     */
    public Knapsack(int cap, String name) {
        this.cap = cap;
        this.name = name;
        this.startWeight = cap;
        items = new LinkedList<>();
    }

    /**
     * Copy constructor which copies app knapsack object and creates app new identical one.
     * @param knapsack
     */
    public Knapsack(Knapsack knapsack) {
        this.cap = knapsack.getCap();
        this.startWeight = knapsack.getStartWeight();
        this.name = knapsack.getName();
        this.items = new LinkedList<>(knapsack.getItems());
    }

    /**
     * Adds an item into the item-list and updates the cap so it's up to date.
     * @param item
     */
    public void addItem(KnapsackItem item) {
        if(item != null) {
            items.add(item);
            cap = cap - item.getWeight();
        }
    }

    /**
     * Stes the cap to the initial value of the knapsack.
     */
    public void resetCap() {
        cap = startWeight;
    }

    /**
     * Sets the cap to the value provided to the method.
     * @param cap
     */
    public void setCap(int cap) {
        this.cap = cap;
    }

    /**
     * Method that returns the knapsack's startWeight
     * @return
     */
    public int getStartWeight() {
        return startWeight;
    }

    /**
     * Method that returns the knapsack's cap.
     * @return
     */
    public int getCap() {
        return cap;
    }

    /**
     * Method that returns the knapsack's name.
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Method that returns the items the knapsack is currently holding.
     * @return
     */
    public LinkedList<KnapsackItem> getItems() {
        return items;
    }
}
