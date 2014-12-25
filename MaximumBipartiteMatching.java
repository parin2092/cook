import java.util.*;

public class MaximumBipartiteMatching<V,E>
{
	public enum Choice {DFS, BFS};
	private Graph<V,E> graph;
	private Set<E> maximumMatching, edges;
	private Set<V> partition;
	private List<V> vertices;
	boolean[] visited, isInPartition;
	private int[] pair, predecessor;
	private int[][] adjList;
	private int n;
	private Choice choice;

	public MaximumBipartiteMatching(Graph<V,E> graph, Set<V> partition){
		this(graph, partition, Choice.DFS);
	}

	public MaximumBipartiteMatching(Graph<V,E> graph, Set<V> partition, Choice choice){
		this.choice = choice;
		this.graph = graph;
		this.partition = partition;
		this.vertices = new ArrayList<V>(graph.vertexSet());
		this.edges = null;
		n = vertices.size();

		calculateAdjList();
		computeMatching();
		constructSet();

		this.graph = null;
		this.partition = null;
		this.vertices = null;
		this.edges = null;
		this.adjList = null;
		this.pair = null;
		this.predecessor = null;
		this.visited = null;
		this.isInPartition = null;
	}

	public Set<E> getMatching(){
		return maximumMatching;
	}


	public int sizeOfMatching(){
		return maximumMatching.size();
	}



	private void calculateAdjList(){
		adjList = new int[n][];
		isInPartition = new boolean[n];
		Map<V, Integer> map = new HashMap<V, Integer>();

		for(int i = 0; i < n; i++){
			map.put(vertices.get(i), i);
		}

		for(int i = 0; i < n; i++){
			V vertex = vertices.get(i);
			isInPartition[i] = partition.contains(vertex);

			edges = graph.edgesOf(vertex);
			adjList[i] = new int[edges.size()];
			int j = 0;

			for(E edge : edges){
				V v1 = graph.getEdgeSource(edge);
				V v2 = graph.getEdgeTarget(edge);

				adjList[i][j] = (!vertex.equals(v1) ? map.get(v1) : map.get(v2));
				j++;
			}

		}
	}

	private void computeMatching(){
		pair = new int[n];
		predecessor = new int[n];
		Arrays.fill(pair, -1);

		visited = new boolean[n];

		if(choice == Choice.DFS){

			for(int i = 0; i < n; i++){
				Arrays.fill(predecessor, -1);
				Arrays.fill(visited, false);

				if(isInPartition[i] && pair[i] == -1){
					int finish = dfs(i);

					if(finish != -1){
						switching(i, finish, predecessor);
					}
				}
			}

		}else{

			for(int i = 0; i < n; i++){
				Arrays.fill(predecessor, -1);
				Arrays.fill(visited, false);

				if(isInPartition[i] && pair[i] == -1){
					int finish = bfs(i);

					if(finish != -1){
						switching(i, finish, predecessor);
					}
				}
			}
		}
	}


	private void constructSet(){
		maximumMatching = new HashSet<E>();
		for(int i = 0; i < n; i++){

			if(pair[i] == -1)
				continue;

			maximumMatching.add(graph.getEdge(vertices.get(i), vertices.get(pair[i])));
		}
	}

	private int dfs(int vertex) {

		int current;
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(vertex);


		while(!stack.empty()){
			current = stack.pop();

			visited[current] = true;

			if(isInPartition[current]){

				for(int i = 0; i < adjList[current].length; i++){
					if(!visited[adjList[current][i]]){
						stack.add(adjList[current][i]);
						predecessor[adjList[current][i]] = current;
					}
				}
			}else{
				if(pair[current] == -1)
					return current;
				if(!visited[pair[current]]){
					stack.add(pair[current]);
					predecessor[pair[current]] = current;
				}
			}
		}
		return -1;
	}


	private int bfs(int vertex) {

		int current;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(vertex);

		while(!queue.isEmpty()){
			current = queue.poll();

			visited[current] = true;

			if(isInPartition[current]){
				for(int i = 0; i < adjList[current].length; i++){
					if(!visited[adjList[current][i]]){
						queue.add(adjList[current][i]);
						predecessor[adjList[current][i]] = current;
					}
				}
			}else{
				if(pair[current] == -1)
					return current;
				if(!visited[pair[current]]){
					queue.add(pair[current]);
					predecessor[pair[current]] = current;
				}
			}
		}
		return -1;
	}

	private void switching(int start, int finish,int[] path){
		while(start != finish){
			if(!isInPartition[finish]){
				pair[finish] = path[finish];
				pair[path[finish]] = finish;
			}
			finish = path[finish];
		}
	}

}