学习笔记
week2 summary

同学·泛互联网人·分享：

	人与人之间最大的差异是认知差异，认知决定一切！架构也是一样 ,那么我们对于认知分为五个阶段 :

	1.不知道自己不知道

	2.知道自己不知道

	3.知道自己知道

	4.不知道自己知道

	5.大师

	一定要有自己的智慧 ,智慧可以理解为你的知识 + 经验积累 ,这个阶段就属于知道自己知道 ,这个时候呢可能你会对某个技术深入的去挖掘 ,等你达到一定高度的时候 你这个时候你的知识类似与一棵树 ,与数据结构和算法差不多 形成自己的树结构 .最后一个阶段可以理解为道 ,这个阶段你会发现架构哲学的魅力所在。

	那么架构哲学的本质是什么呢？ 降本增效 ,还有一个概念交静态知识 ,静态知识是说比如你会那个那个技术 这些值钱吗？值钱也不值钱 ,万事万物你会发现都是伪命题 。

	架构到底是什么 ?我们围绕着三个概念出发 高可用/高并发/高扩展 

	架构的演变首先说单体架构，使用场景可能就是小公司了 在公司创业初期 ，业务场景简单 功能不复杂 研发人员比较少 ，优点： 便于扩展  缺点： 耦合性高 。

	我们做架构的目的是为了快速迭代和持续交付  。

	进一步面向服务架构（SOA） 可以理解为垂直架构 ，这种情况下是如何进行拆分的呢 ，比如我的项目里有用户模块 商品模块 交易模块 ，那么我们的拆分策略就是 用户单独一个服务  商品单独一个服务   交易单独一个服务 ，缺点SOA架构是通过ESB（企业服务总线 ）进行交互的 所以说整体的效率是非常低的 。

	接下来水平分层架构 ，我们会拆分出  app 、网关层 、业务逻辑层  、数据访问层 ，app与网关分离 ，网关与业务逻辑分离 ，业务逻辑与数据访问分离 ，网关层做了那些事情呢？ 请求鉴权 数据完整性检查  协议转化  路由转发  服务治理 ，请求鉴权 数据完整性检查  协议转化  路由转发 这些属于功能维度服务治理属于服务治理维度。

	单体架构 拆分有两种 水平分层 垂直拆分  然后就是微服务接着服务网格（service Mesh）  其次中台架构 ，最后云原生架构。还有一个要强较的点就是 单体架构 水平 垂直 微服务 服务网格 中台是属于架构设计维度云架构属于运维维度的。

---

golang https://leetcode-cn.com/problems/valid-anagram/详解

1. 排序
   时间复杂度：O(nlogn)
   空间复杂度：O(1)
       func isAnagram(s string, t string) bool {
       	if len(s) != len(t) {
       		return false
       	}
       	sl := []byte(s)
       	tl := []byte(t)
       	sort.Slice(sl, func(i, j int) bool {
       		return sl[i] < sl[j]
       	})
       	sort.Slice(tl, func(i, j int) bool {
       		return tl[i] < tl[j]
       	})
       	for i, elem := range sl {
       		if elem != tl[i] {
       			return false
       		}
       	}
       	return true
       }
   字符串怎么排序呢？不管怎么做都要变成切片，不然没法排序。
   而go中字符串，是作为ascii码存的，也就是说看起来是字母，其实拿到手之后是数字
   而字符串转切片，是不能b := []string(s)这样转的。不然：
   sl := []string{"a", "v", "b", "c",.....}
   sort.Sort(sort.StringSlice(sl))
   就直接排序完了
   只能把字符串转成byte或uint8 sl := []byte(s)这样
   排序这个，就只能手写一个sort.Slice函数，用第二个参数写一个函数来返回排序的方法
   然后还需要最后循环对比一下数组

1. 哈希表
   时间复杂度：O(n)
   空间复杂度：O(1)
   先用s加，然后再用t减，如果有小于0的情况，就直接判false
   如果t中有s没有的值，那么就直接变成false，或者如果有令其为0的值，也变成false
       func isAnagram(s string, t string) bool {
       	if len(s) != len(t) {
       		return false
       	}
       	count := make(map[uint8]int)
       	for i := 0; i < len(s); i++ {
       		count[s[i]]++
       	}
       	for i := 0; i < len(t); i++ {
       		count[t[i]]--
       		if count[t[i]] < 0 {
       			return false
       		}
       	}
       	return true
       }
   

1. 使用数组
   时间复杂度：O(n)
   空间复杂度：O(1)
   创建一个数组，一共26个格子，对应26个字母。如果s有就在那个位置+1，t就-1
       func isAnagram(s string, t string) bool {
       	if len(s) != len(t) {
       		return false
       	}
       	m := make([]int, 26)
       	for i := 0; i < len(s); i++ {
       		m[s[i]-'a']++
       	}
       	for i := 0; i < len(s); i++ {
       		m[t[i]-'a']--
       		if m[t[i]-'a'] < 0 {
       			return false
       		}
       	}
       	return true
       }
2. map实现
   时间复杂度：O(n)
   空间复杂度：O(1)
       package main
       
       import (
       	"fmt"
       	"reflect"
       )
       
       func isAnagram(s string, t string) bool {
           m1 := make(map[rune]int)
           m2 := make(map[rune]int)
       
       	for _, v := range s {
       		m1[v] += 1
       	}
       	for _, v := range t {
       		m2[v] += 1
       	}
       
       	return reflect.DeepEqual(m1, m2)
       }
       func main() {
       	s := "aacc"
       	t := "ccac"
       	fmt.Println(isAnagram(s, t))
       }
3. 桶排序
   时间复杂度：O(n)
   空间复杂度：O(1)
   使用两个数组，数组是值类型，相同类型，相同长度是一个类型，可以直接对比
       func isAnagram(s string, t string) bool {
       	if !(len(s) == len(t)) {
       		return false
       	}
       	var (
       		bucket1 [26]int
       		bucket2 [26]int
       	)
       	for _, v := range s {
       		bucket1[v-'a']++
       	}
       	for _, v := range t {
       		bucket2[v-'a']++
       	}
       	return bucket1 == bucket2
       }
   

