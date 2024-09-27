import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {
    private Map<Integer, Set<Integer>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    // Добавление вершины
    public void addVertex(int vertex) {
        adjList.putIfAbsent(vertex, new HashSet<>());
    }

    // Добавление ребра
    public void addEdge(int source, int destination) {
        if (!adjList.containsKey(source)) {
            addVertex(source);
        }
        if (!adjList.containsKey(destination)) {
            addVertex(destination);
        }
        adjList.get(source).add(destination);
        adjList.get(destination).add(source); // для неориентированного графа
    }

    // Удаление вершины
    public void removeVertex(int vertex) {
        if (!adjList.containsKey(vertex)) {
            return;
        }
        adjList.values().forEach(edges -> edges.remove(vertex));
        adjList.remove(vertex);
    }

    // Удаление ребра
    public void removeEdge(int source, int destination) {
        if (adjList.containsKey(source)) {
            adjList.get(source).remove(destination);
        }
        if (adjList.containsKey(destination)) {
            adjList.get(destination).remove(source);
        }
    }

    // Проверка существования вершины
    public boolean hasVertex(int vertex) {
        return adjList.containsKey(vertex);
    }

    // Проверка существования ребра
    public boolean hasEdge(int source, int destination) {
        return adjList.containsKey(source) && adjList.get(source).contains(destination);
    }

    @Override
    public String toString() {
        return adjList.toString();
    }
}
