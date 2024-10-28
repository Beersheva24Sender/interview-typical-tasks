package telran.interview;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class ConnectionPool {

    private LinkedHashMap<String, Connection> connectionsMap;
    private final int maxSize;

    public ConnectionPool(int size) {
        this.maxSize = size;
        this.connectionsMap = new LinkedHashMap<>(size * 2, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Connection> eldest) {
                return size() > maxSize;
            }
        };
    }

    public void addConnection(Connection connection) {
        String id = connection.connectionId();
        if (connectionsMap.containsKey(id)) {
            throw new IllegalStateException("Connection with ID " + id + " already exists.");
        }
        connectionsMap.put(id, connection);
    }

    public Connection getConnection(String connectionId) {
        if (!connectionsMap.containsKey(connectionId)) {
            throw new NoSuchElementException("No connection found with ID " + connectionId);
        }
        return connectionsMap.get(connectionId);
    }
}
