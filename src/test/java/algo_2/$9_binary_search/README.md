### 二分查找
* 套路

```python
left, right = 0, len(array) - 1
while left <= right
    mid = (right - left) / 2 + left
    if (array[mid] == targe)
        // find the target
        // break or return result
    else if (array[mid] < target)
        left = mid + 1
    else
        right = mid - 1
    
```