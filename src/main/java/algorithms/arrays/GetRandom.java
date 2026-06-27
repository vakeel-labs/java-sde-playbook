package algorithms.arrays;

import java.util.Arrays;

public class GetRandom {

    private ArrayList<Integer> list;
    Map<Integer, Integer> map;
    Random random;

    public GetRandom() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {

        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }

        Integer removeIndex = map.get(val);
        Integer lasElementIndex = list.size() - 1;
        Integer lastValue = list.get(lasElementIndex);

        list.set(removeIndex,lastValue);
        map.put(lastValue,removeIndex);


        map.remove(val);
        list.remove(list.size()-1);

        return true;
    }

    public int getRandom() {
        int i = random.nextInt(list.size());
        return list.get(i);
    }
}
