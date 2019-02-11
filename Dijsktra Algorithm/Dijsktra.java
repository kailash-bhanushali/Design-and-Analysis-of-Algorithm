/////////////////////////////////////////////////////
/*
Name : Kailash Shankar Bhanushali
ID : 1001398090
Program : Dijkstra Algorithm
*/
/////////////////////////////////////////////////////
import java.util.*; 
import java.lang.*; 
import java.io.*;
import java.util.Arrays;

class Dijsktra{
    // Function to find the index of an element in a primitive array
    public int find(String[] a, String target, boolean diff)
    {
        for (int i = 0; i < a.length; i++)
            if (target.equals(a[i]))
                if (diff == true)
                    return i;
                else
                    return 1;
        return -1;
    }
    // To find the vertex with minimum distance value, from the set of vertices not yet included in shortest path tree 
    public int minDistance(int dist[], Boolean sptSet[], int vertex) 
	{ 
		// Initialize min value 
		int min = Integer.MAX_VALUE, min_index=-1; 
		for (int v = 0; v < vertex; v++) 
			if (sptSet[v] == false && dist[v] <= min){ 
				min = dist[v]; 
				min_index = v; 
            }
        return min_index; 
    }
    // function to print the array
    void printSolution(int dist[], int n, String src, String[] patharray, String[] vname) 
	{ 
        String[] finalarray = new String[n];
        String temp="";
        int indexstart=0;
        System.out.println();
		System.out.println("\nVertex Distance from: "+src); 
		for (int i = 0; i < n; i++) {            
		    if(temp == "")
		    temp=temp+patharray[i];
		    else
            temp=temp+", "+patharray[i]; // append the element/character to previous element for the output displaying purpose
            indexstart = find(vname, patharray[i], true); // find the current index character which is getting processed from the vname/ user defined sequence input character
            finalarray[indexstart]=temp; // build the output as requested
        }
        for(int i=0;i<n;i++)
            if(!(finalarray[i].equals(src)))
                System.out.println(src+"->"+vname[i]+"("+finalarray[i]+": "+dist[i]+")"); // print the distance mapping output
	} 
    public void shortestpath(int vertex, String[] vname, int[][] graph, String src){
        String[] patharray=new String[vertex];
        int dist[] = new int[vertex];  // output array and will hold the shortest distance
        Boolean sptSet[] = new Boolean[vertex]; //will true if vertex i is included in shortest path tree
        for (int i = 0; i < vertex; i++) { //initialize all distance to infinite and sptset to false, as none of the vertex is yet included in the array
			dist[i] = Integer.MAX_VALUE; 
			sptSet[i] = false; 
        } 
        int indexstart = find(vname, src, true); // to find the source index value as we have to keep path to itself as zero
        dist[indexstart]=0;
        // find shortest path for all vertices
        for (int count = 0; count < vertex-1; count++){ 
            int u = minDistance(dist, sptSet, vertex); // pick the min. distance vertex which is not yet processed. u is equal to src vertex for the first iteration
            patharray[count] = vname[u]; // enter the vertex which is done processing
            sptSet[u] = true; // mark the picked vertex as processed.
            // Update dist value of the adjacent vertices of the picked vertex
            for (int v = 0; v < vertex; v++) 
				if (!sptSet[v] && graph[u][v]!=0 && dist[u] != Integer.MAX_VALUE && dist[u]+graph[u][v] < dist[v]) 
					dist[v] = dist[u] + graph[u][v];  // update dist[v] only if it is not present in sptSet, edge present from u to v and its value is smaller than current value
        }
        for(int i=0;i<vertex;i++){
            if(find(patharray, vname[i], false) == -1)  
                patharray[vertex-1]=vname[i]; // find if any of the vertex name is not present, then add it to its respective index
        }
        printSolution(dist, vertex, src, patharray, vname); // print the shortest path output generated
    }
    public void matrixmanipulate(int[][] pathmatrix, int conncount, String[] connstring, int vertex, String[] vname, String entrypoint){
        String start="",end="";int distance=0,startindex=0,endindex=0;
        for(int i=0;i<conncount;i++){
            start = Character.toString(connstring[i].charAt(0)); // extract first character from string stored in array as startpoint
            end = Character.toString(connstring[i].charAt(1)); // extract second character from string stored in array as endpoint
            distance = Integer.parseInt(Character.toString(connstring[i].charAt(2))); // extract third character from string and convert to int for weight calculation
            startindex=find(vname, start, true); // using find function, find the index of the start loc.
            endindex=find(vname, end, true); // using find function, find the index of the end loc.
            if(startindex != -1 && endindex != -1){  // store the distance after fetching both the index position
                pathmatrix[startindex][endindex]=distance; // as it is undirected graph, we have to store at both location. eg. AB and BA both will possess the same value
                pathmatrix[endindex][startindex]=distance;
            }
        }
        System.out.println();
        System.out.println("*** Adjacency Matrix ***");
        System.out.print("[\n");
        for(int i=0;i<vertex;i++){
            System.out.print("[ ");
            for(int j=0;j<vertex;j++)
                if(j == vertex-1)
                    System.out.print(pathmatrix[i][j]+" "); // we have already form the matrix, display it here, in the format as requested
                else
                    System.out.print(pathmatrix[i][j]+", "); // we have already form the matrix, display it here, in the format as requested
            System.out.print("],");
            System.out.println();
        }
        System.out.print("]");
        shortestpath(vertex, vname, pathmatrix, entrypoint); // find the shortest path
    }
    public static void main(String args[]){
        Dijsktra d=new Dijsktra();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        // vertices count
        System.out.print("Enter number of vertices: ");
        int vertex = sc.nextInt();
        String stvertex="", loopcheck="";
        String[] vname=new String[vertex]; // vertices name

        int[][] pathmatrix = new int[vertex][vertex];
        //keep a track of characters which we are going to use for indexing, hence, it should be in serial order
        System.out.println("\n***Enter name of vertex in serial order***");
        for(int i=0;i<vertex;i++){
            System.out.print("Enter Character "+(i+1)+" of "+vertex+": ");
            vname[i] = sc.next();
            //System.out.println();
        }
        //create a 2d matrix with default value as zero
        for(int i=0;i<vertex;i++)
            for(int j=0;j<vertex;j++)
                pathmatrix[i][j]=0; 
        System.out.print("\nHow many number connection you would like to make: "); // connection count
        int conncount = sc.nextInt();
        String[] connstring=new String[conncount];
        for(int i=0;i<conncount;i++){ // loop to get and store connection between vertices
            System.out.println();
            System.out.println("\n***Enter Details for Connection "+(i+1)+"***");
            System.out.print("Start Node: ");
            connstring[i]=sc.next(); // start node save
            //System.out.println();

            System.out.print("End Node: ");
            connstring[i] = connstring[i]+sc.next(); // end node append to start  node
            //System.out.println();

            System.out.print("Distance weight: ");
            connstring[i] = connstring[i]+sc.next(); // weight append to the node
            //System.out.println();
        }
        d.matrixmanipulate(pathmatrix, conncount, connstring, vertex, vname, vname[0]); // perform dijkstra for default source i.e. first character input eg. A
        while(true){ // to ask user for userdefined selection input as source variable and keep it in loop unless user press "n" when asked
            if(flag == true){
                System.out.println("\nHere are the list of vertices to choose from for user defined starting point");
                for(int i=0;i<vertex;i++)
                    System.out.print(vname[i]+" "); // print vertices list
                
                System.out.println("\nEnter the Starting vertex which you would like to try out? ");
                stvertex=sc.next(); //new source vertex user defined input
                //System.out.print(stvertex);
                d.matrixmanipulate(pathmatrix, conncount, connstring, vertex, vname, stvertex); // perform dijkstra for new user defined source
                System.out.println("\nDo you want to try out other Starting point? y or n");
                loopcheck=sc.next();
                if (loopcheck.equals("n")) flag=false; // take input in loopcheck variable and check if user wants to try other source, if not make flag false and break the loop
            }
            else break;
        }
    }

}