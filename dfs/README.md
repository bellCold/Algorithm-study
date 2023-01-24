***깊이 우선 탐색***

* 재귀적으로 동작(재귀, 스택)
* 그래프 탐색의 경우, 어떤 노드를 방문했었는지 여부를 반드시 검사
  (검사하지 않으면 무한루프)
* 모든 노드 방문하고자 할 때 사용
* BFS 보다 간단, BFS 비해서 검색 속도 느림

```java
public static void dfs(int i) {
	visit[i] = true;
	for(int j=1; j<n+1; j++) {
		if(sector[i][j] == 1 && visit[j] == false) {
			dfs(j);
		}
	}
}
```