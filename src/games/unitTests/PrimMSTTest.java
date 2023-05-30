/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package games.unitTests;

import games.IMC.model.IMCGraphModel;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author lihin
 */
public class PrimMSTTest {
    
    static List<Integer> correctEdges = new ArrayList<>();
    private static int numCities = 4;

    @Test
    public void testPrimMST() {
        int[][] graph = {
                {0, 2, 4, 0},
                {2, 0, 1, 5},
                {4, 1, 0, 3},
                {0, 5, 3, 0}
        };
       
        IMCGraphModel model = new IMCGraphModel();
        model.primMST(graph);

        List<Integer> expectedEdges = new ArrayList<>();
        expectedEdges.add(2);  // Edge from node 0 to node 2
        expectedEdges.add(1);  // Edge from node 1 to node 0
        expectedEdges.add(3);  // Edge from node 2 to node 1

        Assertions.assertEquals(expectedEdges, model.getCorrectEdges());
    }

}
