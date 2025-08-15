package gene.recombine.stuhubsys.utils;

import java.util.HashMap;
import java.util.Map;

public class UserContext {

    private static final ThreadLocal<Map<String, Object>> context = new ThreadLocal<>();
    public static void set(String key, Object value) {
        Map<String, Object> map = context.get();
        if (map == null) {
            map = new HashMap<>();
            context.set(map);
        }
        map.put(key, value);
    }

    public static Object get(String key) {
        Map<String, Object> map = context.get();
        return map != null ? map.get(key) : null;
    }

    public static void clear() {
        context.remove();
    }
}