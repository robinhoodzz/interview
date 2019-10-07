### 并查集

```java

public class QuickUnionFind {
    private int[] roots;
    
    public QuickUnionFind(int n) {
        roots = new int[n];
        for(int i = 0; i < n; i++){
            roots[i] = i;
        }
    }
    
    private int findRoot(int i ) {
        int root = i;
        while (root != roots[root]){
            root = roots[root];
        }
        while (i != roots[i]) {
            int tmp = roots[i];
            root[i] = root;
            i = tmp;
        }
    }
    
    public boolean connected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }
    
    public void union(int p, int q) {
        int proot = findRoot(p);
        int qroot = findRoot(q);
        roots[proot] = qroot;
    }

}


```