package struct_data.graph;

public class GraphDfs {

    private final int Max_Verts = 20;
    private Vertex[] vertes;
    private int[][] adjMat;
    private int nVerts;
    private StackX theStack;

    public GraphDfs(){
        vertes = new Vertex[Max_Verts];
        adjMat = new int[Max_Verts][Max_Verts];
        nVerts = 0;
        for (int i = 0; i < Max_Verts; i++) {
            for (int j = 0; j <Max_Verts; j++) {
                adjMat[i][j] = 0;
            }
        }
        theStack = new StackX();
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

    public void dfs(){
        vertes[0].wasVisited = true;
        displayVertex(0);
        theStack.push(0);
        while (!theStack.isEmpty()){
            int v = getAdjUnvisitedVertex(theStack.peek());
            if (v == -1)theStack.pop();
            else {
                vertes[v].wasVisited = true;
                displayVertex(v);
                theStack.push(v);
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
