import javax.swing.table.DefaultTableModel;

public class classCalculateGraphs {
    final int MATRIXSIZE = 5;
    int[][] funCalculateAdjacencyMatrix(int[][] userGraphArray,int typeOrientationGraph)
    {
        int[][] adjacencyMatrix = new int[MATRIXSIZE][MATRIXSIZE];
        if(typeOrientationGraph == 1) //Undirected
        {

            for(int[] edgeCoordinate:userGraphArray)
            {
                if(edgeCoordinate[0] != 0 && edgeCoordinate[1] != 0) {
                    int i = edgeCoordinate[0];
                    int j = edgeCoordinate[1];
                    adjacencyMatrix[i-1][j-1]++;
                    if(i != j)
                    adjacencyMatrix[j-1][i-1]++;
                }
            }

        }
        else if(typeOrientationGraph == 2) //Directed
        {
            for(int[] edgeCoordinate:userGraphArray)
            {
                if(edgeCoordinate[0] != 0 && edgeCoordinate[1] != 0) {
                    int i = edgeCoordinate[0];
                    int j = edgeCoordinate[1];
                    adjacencyMatrix[i-1][j-1]++;
                }
            }
        }
        return  adjacencyMatrix;
    }

    int[][] funCalculateIncidenceMatrix(int[][] userGraphArray,int typeOrientationGraph,final int EDGESAMOUNT)
    {
        int[][] incidenceMatrix = new int[MATRIXSIZE][EDGESAMOUNT];
        if(typeOrientationGraph == 1) //Undirected
        {
            for(int edge = 0; edge < EDGESAMOUNT; edge++ )
            {
                    int i = userGraphArray[edge][0];
                    int j = userGraphArray[edge][1];
                    if(i>0 && j>0) {
                        incidenceMatrix[i-1][edge] = 1;
                        incidenceMatrix[j-1][edge] = 1;
                    }
            }
        }
        else if(typeOrientationGraph == 2) //Directed
        {
            for(int edge = 0; edge < userGraphArray.length; edge++ )
            {
                int i = userGraphArray[edge][0];
                int j = userGraphArray[edge][1];
                if(i>0 && j>0) {
                    incidenceMatrix[i-1][edge] = 1;
                    if(i!=j)
                    incidenceMatrix[j-1][edge] = -1;
                }
            }
        }
        return  incidenceMatrix;
    }
    DefaultTableModel funFillModel(int[][] calculatedArray, DefaultTableModel modelCalculatedGraph, int typeMatrixOutput)
    {
        if(typeMatrixOutput==0)//AdjacencyMatrix
        {
            for (int i = 0; i < calculatedArray.length; i++) {
                modelCalculatedGraph.addRow(new Object[]{calculatedArray[i][0], calculatedArray[i][1],
                        calculatedArray[i][2], calculatedArray[i][3], calculatedArray[i][4]});
            }
        }
        if(typeMatrixOutput==1)//IncidenceMatrix
        {
            for (int i = 0; i < calculatedArray.length; i++) {
                modelCalculatedGraph.addRow(new Object[]{calculatedArray[i][0], calculatedArray[i][1],
                        calculatedArray[i][2], calculatedArray[i][3], calculatedArray[i][4],
                        calculatedArray[i][5], calculatedArray[i][6], calculatedArray[i][7],
                        calculatedArray[i][8], calculatedArray[i][9]});
            }
        }
        return modelCalculatedGraph;
    }
}
