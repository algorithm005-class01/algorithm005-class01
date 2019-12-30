
# 学习笔记
## 主定理
主定理主要有三种形式参考wiki[链接](https://zh.wikipedia.org/wiki/%E4%B8%BB%E5%AE%9A%E7%90%86)

主定理的时间复杂度主要参考后面分割后f(n)的时间复杂度。
## map 使用
### map的遍历
```c
map<int, int>::iterator it = numsmap.begin();
while (it != numsmap.end()) {
    if (it->second > max) {
        max = it->second;
        res = it->first;
    }
    it++;
}
```
### map中查找是否存在某个建值
```c
if(numsmap.find(nums[i]) == numsmap.end()){
    // 用find函数如果找到则!=end
}
```
## vector初始化
主要参考[链接](https://blog.csdn.net/yjunyu/article/details/77728410)

二维数组的初始化和获取size  https://blog.csdn.net/qq_16583687/article/details/75276125

> 遇到的non-aggregate type 'vector<char>' cannot be initialized with an initializer list 这种问题可能是要在编译选项里加-std=c++11 参考[链接](https://stackoverflow.com/questions/39022787/error-non-aggregate-type-vectorint-cannot-be-initialized-with-an-initialize)
```c
int a[5] = {1,2,3,4,5};
//通过数组a的地址初始化，注意地址是从0到5（左闭右开区间）
vector<int> b(a, a+5);

/insert初始化方式将同类型的迭代器对应的始末区间（左闭右开区间）内的值插入到vector中
vector<int> a(6,6);
vecot<int> b;
//将a[0]~a[2]插入到b中，b.size()由0变为3
b.insert(b.begin(), a.begin(), a.begin() + 3);

```
> 调试的时候发现了一个问题 vector中的reserve方法只是新开了预留空间，并不会改变vector中size也不会改变.end()中的指针位置所以要是修改容器大小的话还是使用resize吧。

## 分治代码模版
```python
def divide_conquer(problem, param1, param2, ...): 
  # recursion terminator 
  if problem is None: 
	print_result 
	return 

  # prepare data 
  data = prepare_data(problem) 
  subproblems = split_problem(problem, data) 

  # conquer subproblems 
  subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
  subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
  subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
  …

  # process and generate the final result 
  result = process_result(subresult1, subresult2, subresult3, …)
	
  # revert the current level states
```
分治的代码和递归的基本形式很像，分治其实也是一种递归的思想。

## markdown语法
看了个博客记录的挺全面的 http://itmyhome.com/markdown/article/about/readme.html

## 深度搜索和广度搜索总结
### 深度搜索模版代码
```c
void dfs(){
  if(搜索结束条件){
    一般是结果处理
  }
  dfs();
}
```
### 广度搜索模版
```c
void bfs(){
  queue<Element> que;
  //放入第一个节点；
  que.push(firstnode);
  while(!que.empty){ //当队列不为空
      //取出队头元素。
      Element index = que.front();
      que.pop();

      //遍历队头把队头元素下一深度的都放入队列中
      for(){
        que.push();
      }
  }
}
```
## 二分查找
循环模版
```c
class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
```

二分法查找感觉精确查找还是很好理解的，但是很多时候查找需要找到左侧边界或者右侧边界（找到第一个大于或者第一个小于，或者查找的数据中存在重复数这样的问题），就设计到边界的问题。具体查看[链接](https://segmentfault.com/a/1190000016825704)
