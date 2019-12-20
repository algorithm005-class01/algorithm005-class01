学习笔记
看完预习课程后对编程的认识更深刻了
也是这个契机开始对编程语言中的数据结构开始了更深刻的探讨
也对将解决一个问题抽象为数据结构和算法有了更深刻的理解

------------JavaScript复杂数据类型对比
JavaScript数据类型分两种：
基本数据类型（string / number / boolear / null / undefine）栈内存
引述数据类型（object / array / map / set / function / date / regexp）堆内存
object,array,map,set,这四种数据类型承担了开发中的几乎所有复杂数据的存取，(map，set为ES6新添加的数据类型)

array vs set
  对比项	       array	                    set	                    备注
有无索引	有 [1,1,2,2][0] => 1	     无 new Set(1,1)[0] => undefine	关键区别
重复元素	有 [1,1,2,2]	             无 [1,2]	                    set对象元素非同一引用也可[{},{}]
构造	   new Array() [] Array.from()	new Set()	                   -
判断有否属性	 includes()	              has()	                        -
添加属性	push() unshift() splice()	  add()	                        -
删除属性	pop shift() splice()	     delete()	                    -
大小	    Array.length	            Set.size	                    -

object vs map
   对比项	        object	            map	                                        备注
健（key）	        string,symbol(es6)	无限制	                                    关键区别
构造	     new Object() {}	        new Map() new Map(Arrany<entry object>)	    -
取值	            . []	            get(key)	

Objects 和 maps 的比较
Objects 和 Maps 类似的是，它们都允许你按键存取一个值、删除键、检测一个键是否绑定了值。因此（并且也没有其他内建的替代方式了）过去我们一直都把对象当成 Maps 使用。不过 Maps 和 Objects 有一些重要的区别，在下列情况里使用 Map 会是更好的选择：

一个Object的键只能是字符串或者 Symbols，但一个 Map 的键可以是任意值，包括函数、对象、基本类型。
Map 中的键值是有序的，而添加到对象中的键则不是。因此，当对它进行遍历时，Map 对象是按插入的顺序返回键值。
你可以通过 size 属性直接获取一个 Map 的键值对个数，而 Object 的键值对个数只能手动计算。
Map 可直接进行迭代，而 Object 的迭代需要先获取它的键数组，然后再进行迭代。
Object 都有自己的原型，原型链上的键名有可能和你自己在对象上的设置的键名产生冲突。虽然 ES5 开始可以用 map = Object.create(null) 来创建一个没有原型的对象，但是这种用法不太常见。
Map 在涉及频繁增删键值对的场景下会有些性能优势。


------------symbol基本数据类型
ES5 的对象属性名都是字符串，这容易造成属性名的冲突。比如，你使用了一个他人提供的对象，但又想为这个对象添加新的方法（mixin 模式），新方法的名字就有可能与现有方法产生冲突。如果有一种机制，保证每个属性的名字都是独一无二的就好了，这样就从根本上防止属性名的冲突。这就是 ES6 引入Symbol的原因。

ES6 引入了一种新的原始数据类型Symbol，表示独一无二的值。它是 JavaScript 语言的第七种数据类型，前六种是：undefined、null、布尔值（Boolean）、字符串（String）、数值（Number）、对象（Object）。

Symbol 值通过Symbol函数生成。这就是说，对象的属性名现在可以有两种类型，一种是原来就有的字符串，另一种就是新增的 Symbol 类型。凡是属性名属于 Symbol 类型，就都是独一无二的，可以保证不会与其他属性名产生冲突。

注意，Symbol函数前不能使用new命令，否则会报错。这是因为生成的 Symbol 是一个原始类型的值，不是对象。也就是说，由于 Symbol 值不是对象，所以不能添加属性。基本上，它是一种类似于字符串的数据类型。

Symbol函数可以接受一个字符串作为参数，表示对 Symbol 实例的描述，主要是为了在控制台显示，或者转为字符串时，比较容易区分。
注意，Symbol函数的参数只是表示对当前 Symbol 值的描述，因此相同参数的Symbol函数的返回值是不相等的。


------------Object key
当我们使用for/in遍历一个Object对象的时候，打印的结果是否按key的顺序打印出来呢？
答案是：不一定。
Object的key的排序规则到底是什么样子的呢？答案是：
如果key是整数（如：123）或者整数类型的字符串（如：“123”），那么会按照从小到大的排序。除此之外，其它数据类型，都安装对象key的实际创建顺序排序。
