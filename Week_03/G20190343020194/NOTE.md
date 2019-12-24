# 学习笔记
## 主定理
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

## markdown语法
看了个博客记录的挺全面的 http://itmyhome.com/markdown/article/about/readme.html