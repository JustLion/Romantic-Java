### 1、 HashSet 如何区分元素是否重复
1. add 的时候首先调用 Object 的 hashCode() 方法判断
2. 如果 hashCode 相同就调用 Object 对象的 equals() 方法判断

### 2、 List 、 Set 、 Map
1. List Set 继承自 Collection 接口，Map 不是
2. List 元素有放入顺序，元素可重复，通过下标和值来存取
3. Map 元素按键值对存取，无放入顺序
4. Set 元素无存取顺序，元素不可重复