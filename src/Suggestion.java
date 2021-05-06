import java.util.*;

public class Suggestion {
    static class Item {
         Set<String> attributes;
    }

    List<Item> items = new ArrayList<>();

    List<Item> getSuggestions(Item item) {
        Set<Item> copy = new HashSet<>(items);
        for (Item i : copy) {
            i.attributes.retainAll(item.attributes);
        }
        List<Item> result = new ArrayList<>(copy);
        result.sort(Comparator.comparingInt(o -> o.attributes.size()));
        List<Item> temp = new ArrayList<>();
        for(int i=0;i<4;i++) {
            temp.add(result.get(i));
        }
        return temp;
    }



}
