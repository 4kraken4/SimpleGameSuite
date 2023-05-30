/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package games.unitTests;

import games.SP.model.SPGraphModel;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
/**
 *
 * @author lihin
 */
public class ShortestPathsTest {

    @Test
    public void testGetShortestPaths() {
        int[][] adjacencyMatrix = {
                {0, 2, 4, 0},
                {2, 0, 1, 5},
                {4, 1, 0, 3},
                {0, 5, 3, 0}
        };
        int startNode = 0;
        SPGraphModel model = new SPGraphModel(4);
        model.getShortestPaths(adjacencyMatrix, startNode);

        List<Integer> expectedEdges = new ArrayList<>();
        expectedEdges.add(1);  // Edge from node 0 to node 1
        expectedEdges.add(2);  // Edge from node 1 to node 2
        expectedEdges.add(3);  // Edge from node 2 to node 3

         Assertions.assertEquals(expectedEdges,model.getCorrectEdges());
    }
}
