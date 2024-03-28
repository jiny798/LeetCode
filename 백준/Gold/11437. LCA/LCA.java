
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

	public static ArrayList<Integer>[] node;
	public static int[] parents;
	public static int[] depths;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int nodeCount = Integer.parseInt(br.readLine());
		node = new ArrayList[nodeCount+1];
		for (int i = 1; i <= nodeCount; i++) {
			node[i] = new ArrayList<>(); // 각 노드마다 다른 노드를 연결할 수 있는 공간을 만든다
		}

		parents = new int[nodeCount + 1]; // 각 노드마다 부모를 저장할 공간
		depths = new int[nodeCount + 1];  // 각 노드마다 깊이를 저장할 공간
		Arrays.fill(depths, -1); // 깊이는 일단 -1로 세팅

		for (int i = 0; i < nodeCount - 1; i++) {
			Integer[] pair = Stream.of(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.boxed()
				.toArray(Integer[]::new);
			int a = pair[0];
			int b = pair[1];
			node[a].add(b); // 노드 마다 연결
			node[b].add(a);
		}

		calculateDepthAndParent(1, 1, 0); // 1번 은 깊이가 1, 그리고 부모는 0으로 설정

		int answerCount = Integer.parseInt(br.readLine());
		for (int i = 0; i < answerCount; i++) {
			String[] str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);

			int result = LCA(a, b);

			bw.write(String.valueOf(result));
			bw.newLine();
		}

		bw.flush();
		bw.close();
		br.close();
	}

	public static int LCA(int a, int b) {
		int aDepth = depths[a];
		int bDepth = depths[b];
		while (aDepth > bDepth) {
			a = parents[a]; // a가 더크면 a의 부모를 찾는다
			aDepth--;
		}
		while (aDepth < bDepth) {
			b = parents[b]; // b가 더크면 b의 부모를 찾는다
			bDepth--;
		}

		//길이 맞추고 다르다면
		while (a != b) { // 부모가 같을때 까지 반복
			a = parents[a];
			b = parents[b];
		}
		return a; // 부모 반환
	}

	public static void calculateDepthAndParent(int current, int depth, int parent) {
		depths[current] = depth;
		parents[current] = parent;
		for (Integer nextNode : node[current]) { // 현재 노드에 연결된 노드
			if (nextNode != parent) { // 부모와 연결되어 있을수도 있으므로, 제거해준다
				calculateDepthAndParent(nextNode, depth + 1, current); // 다음 노드, 깊이 1증가, 현재 노드가 부모이다
			}
		}
	}
}