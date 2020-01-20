### BFS 广度优先套路
* 使用 队列 + 循环的方式
* 广度不需要递归, while循环检查队列长度即可
* 如果是图数据结构, 就可能有环, 所以要记录是否访问过

```python
def BFS(graph, start, end):
    queue, visited = []
    queue.append([start])
    visited.add(start)
    
    while queue:
        node = queue.pop()
        visited.add(node) // 取出后标记访问过了
        
        process(node) // 根据需要做操作
        nodes = genernate_related_nodes(node) // 根据当前节点,找到子节点,判断没访问过 
        queue.append(nodes) // 子节点进入队列
        
        ### 其他操作

```

---

### DFS 深度优先套路
* 使用 递归的形式
    * 因为本身递归就是栈的数据结构
* 也可以 栈 + 循环来实现, 但是需要手动维护 栈
* 通常在面试中使用递归实现

递归写法
```python
visited = set()
def DFS(node, visited):
    visited.add(node)
    # process current node here
    for next_node in node.children():
        if not next_node in visited:
            dfs(next_node, visited)

```

非递归写法
```python
def DFS(self, tree):
    if tree.root is None:
        return []
    
    visited, stack = [], [tree.root]
    
    while stack:
        node = stack.pop()
        visited.add(node)
        
        process(node)
        nodes = genernate_children_nodes(node)
        stack.push(nodes)
        
        # other processing work
```

