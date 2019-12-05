package struct_data.graph;

public class GraphBfs {
    private final int Max_Verts = 20;
    private Vertex[] vertes;
    private int[][] adjMat;
    private int nVerts;
    private Queue theQueue;

    public GraphBfs(){
        vertes = new Vertex[Max_Verts];
        adjMat = new int[Max_Verts][Max_Verts];
        nVerts = 0;
        for (int i = 0; i < Max_Verts; i++) {
            for (int j = 0; j <Max_Verts; j++) {
                adjMat[i][j] = 0;
            }
        }
        theQueue = new Queue();
    }

    public void addVertex(char lab) {
        vertes[nVerts++] = new Vertex(lab);
    }

    public void addEgde(int start,int end){
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v){
        System.out.println(vertes[v].label);
    }

    public void bfs(){
        vertes[0].wasVisited = true;
        displayVertex(0);
        theQueue.insert(0);
        int v2;
        while (!theQueue.isEmpty()){
            int v1 = theQueue.remove();
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1){
                vertes[v2].wasVisited = true;
                displayVertex(v2);
                theQueue.insert(v2);
            }
        }
        for (int i = 0; i < nVerts; i++) {
            vertes[i].wasVisited = false;
        }
    }

    private int getAdjUnvisitedVertex(int v) {
        for (int i = 0; i < nVerts; i++) {
            if (adjMat[v][i] == 1 && vertes[i].wasVisited == false){
                return i;
            }
        }
        return -1;
    }
}
