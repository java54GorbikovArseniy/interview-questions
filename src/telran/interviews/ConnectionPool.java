package telran.interviews;

import java.util.LinkedHashMap;
import java.util.Map;

public class ConnectionPool {
    private final LinkedHashMap<Long, Connection> linkedHashMap;

    public ConnectionPool(int size) {
        linkedHashMap = new LinkedHashMap<Long, Connection>(16, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Long, Connection> eldest) {
                return size() > size;
            }
        };
    }

    public Connection getConnection(Connection connection) {
        long id = connection.id();
        return linkedHashMap.computeIfAbsent(id, c -> connection);
    }

    public boolean isInPool(long id) {
        return linkedHashMap.containsKey(id);
    }
}