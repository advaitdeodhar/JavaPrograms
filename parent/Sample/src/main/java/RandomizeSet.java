import java.util.*;

class RandomizedSet {

    HashMap<Integer, Integer> locations;
    Random rand;
    ArrayList<Integer> list;

    public RandomizedSet() {
        locations = new HashMap<>();
        rand = new Random();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if ( locations.containsKey(val) ) {
            return false;
        }
        locations.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        Integer location = locations.get(val);
        if ( location == null) {
            return false;
        }

        if ( location != list.size() - 1) {
            int last = list.get(list.size() - 1);
            list.set(location, last);

            locations.put(last, location);
        }

        locations.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */