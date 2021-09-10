package ee.ttu.algoritmid.friends;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AL06 {
    public UndirectedGraph graph = new UndirectedGraph();

    /**
     * Use buildGraphAndFindLink to build a graph using the UndirectedGraph class and then use its breadthFirstSearch to
     * return the links.
     *
     * @param friends the list of friends as pairs (people are denoted as integers)
     *                (e.g., [[2, 7], [9, 5]] means that 2 is friends with 7 and 9 is friends with 5)
     * @param pair    the pair to be searched
     * @return the number of people that connect the searched pair including the pair itself (e.g., if pair is
     * = [1, 4] and path is [1, 2, 3, 4], the number of people is 4) the list of people that connect
     * the searched pair (e.g., pair = [1, 4] => result = [1, 7, 11, 3, 2, 4])
     */
    public SimpleEntry<Integer, List<Integer>> buildGraphAndFindLink(List<SimpleEntry<Integer, Integer>> friends,
                                                                     SimpleEntry<Integer, Integer> pair) {
        for (SimpleEntry<Integer, Integer> friend : friends) {
            graph.addEdge(friend.getKey(), friend.getValue());
        }
        System.out.println(graph.getGraph());
        return graph.breadthFirstSearch(pair.getKey(), pair.getValue());
    }

    private class UndirectedGraph {
        private HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();

        /**
         * Add undirected edge to the graph.
         *
         * @param one   one element of the edge
         * @param other the other element of edge
         */
        public void addEdge(Integer one, Integer other) {
            if (!graph.containsKey(one)) {
                List<Integer> edges = new ArrayList<Integer>();
                edges.add(other);
                graph.put(one, edges);
            } else {
                if (!graph.get(one).contains(other)) {
                    graph.get(one).add(other);
                }
            }
            if (!graph.containsKey(other)) {
                List<Integer> edges = new ArrayList<Integer>();
                edges.add(one);
                graph.put(other, edges);
            } else {
                if (!graph.get(other).contains(one)) {
                    graph.get(other).add(one);
                }
            }
        }

        /**
         * Return the graph.
         *
         * @return the internal graph structure.
         */
        public HashMap<Integer, List<Integer>> getGraph() {
            return graph;
        }

        /**
         * Perform breadth first search.
         *
         * @param start the vertex to start the search from
         * @param goal  the goal vertex to find
         * @return the number of vertices of the path from start to goal including start and goal (e.g.,
         * start = A, goal = C, path = A, B, C => 3) and the path itself as a list of integers.
         * NB! You can return null as path and only return the number of nodes
         * that connect the start and goal vertices for partial credit
         * (some tests only check for number of nodes)
         */
        public SimpleEntry<Integer, List<Integer>> breadthFirstSearch(Integer start, Integer goal) {
            int counter = 1;
            List<Integer> friend_path = new ArrayList<>();
            friend_path.add(start);
            if (graph.get(start).contains(goal)) {
                friend_path.add(goal);
                counter++;
                return new SimpleEntry<>(counter, friend_path);
            }
            for (Integer f1 : graph.get(start)) {
                if (graph.get(f1).contains(goal)) {
                    friend_path.add(f1);
                    friend_path.add(goal);
                    counter += 2;
                    return new SimpleEntry<>(counter, friend_path);
                }
                for (Integer f2 : graph.get(f1)) {
                    if (graph.get(f2).contains(goal)) {
                        friend_path.add(f1);
                        friend_path.add(f2);
                        friend_path.add(goal);
                        counter += 3;
                        return new SimpleEntry<>(counter, friend_path);
                    }
                    for (Integer f3 : graph.get(f2)) {
                        if (graph.get(f3).contains(goal)) {
                            friend_path.add(f1);
                            friend_path.add(f2);
                            friend_path.add(f3);
                            friend_path.add(goal);
                            counter += 4;
                            return new SimpleEntry<>(counter, friend_path);
                        }
                        for (Integer f4 : graph.get(f3)) {
                            if (graph.get(f4).contains(goal)) {
                                friend_path.add(f1);
                                friend_path.add(f2);
                                friend_path.add(f3);
                                friend_path.add(f4);
                                friend_path.add(goal);
                                counter += 5;
                                return new SimpleEntry<>(counter, friend_path);
                            }
                            for (Integer f5 : graph.get(f4)) {
                                if (graph.get(f5).contains(goal)) {
                                    friend_path.add(f1);
                                    friend_path.add(f2);
                                    friend_path.add(f3);
                                    friend_path.add(f4);
                                    friend_path.add(f5);
                                    friend_path.add(goal);
                                    counter += 6;
                                    return new SimpleEntry<>(counter, friend_path);
                                }
                            }
                        }
                    }
                }
            }

            return null;
        }
    }
}
