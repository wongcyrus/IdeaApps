package vtc.edu.hk.idea.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: It is not a good idea to use static method!
 */
public class IdeaContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<IdeaItem> ITEMS = new ArrayList<IdeaItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<Integer, IdeaItem> ITEM_MAP = new HashMap<Integer, IdeaItem>();


    public static void addItem(IdeaItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.getId(), item);
    }

    public static void cleanUp() {
        ITEMS.clear();
        ITEM_MAP.clear();
    }



}
