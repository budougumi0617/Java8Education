#練習問題4
文字列から部分文字列を抽出することでリテラルでないJavaScript文字列を生成し、
`getClass`メソッドを呼び出しなさい。結果はどのクラスになりますか。それから、そのクラスを
`java.lang.String.class.cast`へ渡しなさい。何が起きますか。それが起きた理由は何ですか。

#解答
部分文字列は`java.lang.String`になった。  
`String`クラスに`String`クラスをキャストしても特に何も起きなかった。

```sh
budougumi0617@~/git/Java8Education/src/main/java/ch7 (master@Java8Education)
$  cat ex04/Ex04.js
string = 'Hello'.slice(-2)
print(string)
print(string.getClass())
cast_class = string.getClass()
result = java.lang.String.class.cast(string)
print(result)
java.lang.String.class.cast(result)
print(result)
budougumi0617@~/git/Java8Education/src/main/java/ch7 (master@Java8Education)
$  $JAVA_HOME/bin ex04/Ex04.js
lo
class java.lang.String
lo
lo
```
