package algo.tu;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Administrator
 * @Date 2024/4/24 22:02
 * @Version 1.0
 */
public class GraphAdjMat {

    List<Integer> vertices;

    List<List<Integer>> adjMat;


    public GraphAdjMat(int[] vertices, int[][] edges) {
        this.vertices = new ArrayList<>();
        this.adjMat = new ArrayList<>();
        for (int vertex : vertices) {
            addVertex(vertex);
        }
        for (int[] e : edges) {
            addEdge(e[0],e[1]);
        }

    }

    public int size(){
        return vertices.size();
    }

    public void addVertex(int val){
        int n = size();
        vertices.add(val);
        List<Integer> newRow = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            newRow.add(0);
        }
        adjMat.add(newRow);
        for (List<Integer> row : adjMat) {
            row.add(0);
        }
    }


    public void removeVertex(int i){
        if (i<0 || i>=size()){
            throw new IndexOutOfBoundsException();
        }
        vertices.remove(i);
        adjMat.remove(i);
        for (List<Integer> row : adjMat) {
            row.remove(i);
        }
    }


    public void addEdge(int i,int j){
        if (i<0 || j < 0 || i>=size() || j >= size() || i==j){
            throw new IndexOutOfBoundsException();
        }
        adjMat.get(i).set(j,1);
        adjMat.get(j).set(i,1);
    }

    public void removeEdge(int i,int j){
        if (i<0 || j < 0 || i>=size() || j >= size() || i==j){
            throw new IndexOutOfBoundsException();
        }
        adjMat.get(i).set(j,0);
        adjMat.get(j).set(i,0);
    }


}
