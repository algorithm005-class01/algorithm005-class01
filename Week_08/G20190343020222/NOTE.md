学习笔记

字符串处理javascript
一、charAt()
返回在指定位置的字符。
var str="abc"
console.log(str.charAt(0))//a
二、charCodeAt()
返回在指定的位置的字符的 Unicode 编码。
var str="abc"
 console.log(str.charCodeAt(1))//98
三、concat()
连接字符串。
 var a = "abc";  
 var b = "def";  
 var c = a.concat(b);
 console.log(c);//abcdef
四、indexOf()
检索字符串。indexOf() 方法对大小写敏感！
var str="Hello world!"
console.log(str.indexOf("Hello"))//0
console.log(str.indexOf("World"))//-1
console.log(str.indexOf("world"))///6
五、match()
match() 方法可在字符串内检索指定的值，或找到一个或多个正则表达式的匹配。该方法类似 indexOf() 和 lastIndexOf()，但是它返回指定的值，而不是字符串的位置。
var str="1 abc 2 def 3"
console.log(str.match(/\d+/g))//123
六、replace()
replace() 方法用于在字符串中用一些字符替换另一些字符，或替换一个与正则表达式匹配的子串。
var str="abc Def!"
console.log(str.replace(/abc/, "CBA"))//CBA Def!
七、search()
search() 方法用于检索字符串中指定的子字符串，或检索与正则表达式相匹配的子字符串。要执行忽略大小写的检索，请追加标志 i。如果没有找到任何匹配的子串，则返回 -1。

var str="abc DEF!"
console.log(str.search(/DEF/))//4
八、slice()
提取字符串的片断，并在新的字符串中返回被提取的部分。
stringObject.slice(start,end);
start :要抽取的片断的起始下标。如果是负数，则该参数规定的是从字符串的尾部开始算起的位置。也就是说，-1 指字符串的最后一个字符，-2 指倒数第二个字符，以此类推。

var str="abc def ghk"
console.log(str.slice(6))//f ghk
九、split()
把字符串分割为字符串数组。

var str="abc def ghi jkl"    
console.log(str.split(" "))//["abc", "def", "ghi", "jkl"]
console.log(str.split("") )//["a", "b", "c", " ", "d", "e", "f", " ", "g", "h", "i", " ", "j", "k", "l"]
console.log(str.split(" ",3))//["abc", "def", "ghi"]

十二、toLowerCase()
把字符串转换为小写。

var str="ABC def!"
console.log(str.toLowerCase())//abc def!
十三、toUpperCase()
把字符串转换为大写。

var str="ABC def!"
console.log(str.toUpperCase())//ABC DEF!
十四、substr()
从起始索引号提取字符串中指定数目的字符。
stringObject.substr(start,length)。
start：必需。要抽取的子串的起始下标。必须是数值。如果是负数，那么该参数声明从字符串的尾部开始算起的位置。也就是说，-1 指字符串中最后一个字符，-2 指倒数第二个字符，以此类推。
length：可选。子串中的字符数。必须是数值。如果省略了该参数，那么返回从 stringObject 的开始位置到结尾的字串。

var str="abc def"
console.log(str.substr(2))//c def
console.log(str.substr(2,4))// c de 
十五、substring()
提取字符串中两个指定的索引号之间的字符。
stringObject.substring(start,stop)。
start ：必需。一个非负的整数，规定要提取的子串的第一个字符在 stringObject 中的位置。
stop ：可选。一个非负的整数，比要提取的子串的最后一个字符在 stringObject 中的位置多 1。如果省略该参数，那么返回的子串会一直到字符串的结尾。

var str="abc def"
console.log(str.substring(2))//c def
console.log(str.substring(2,4))// c 
相同点：如果只是写一个参数，两者的作用都一样：都是是截取字符串从当前下标以后直到字符串最后的字符串片段。
substr(startIndex);
substring(startIndex);

var str = '123456789';
console.log(str.substr(2));    //  "3456789"
console.log(str.substring(2)) ;//  "3456789"
不同点：第二个参数
substr（startIndex,lenth）： 第二个参数是截取字符串的长度（从起始点截取某个长度的字符串）；
substring（startIndex, endIndex）： 第二个参数是截取字符串最终的下标 （截取2个位置之间的字符串,‘含头不含尾’）。

console.log("123456789".substr(2,5));    //  "34567"
console.log("123456789".substring(2,5)) ;//  "345"
