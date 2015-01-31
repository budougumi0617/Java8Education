#練習問題6
一連のシェルコマンドを受け取り、１つのコマンドの出力を次のコマンドの入力として接続し、
最後の出力を返すJavaScriptのpipe関数を書きなさい。たとえば、`pipe('find .', 'grep -v class', 'sort')`と呼び出せます。
単純に`$EXEC`を繰り返し呼び出しなさい。



```sh
budougumi0617@~/git/Java8Education/src/main/java/ch7 (master@Java8Education)
$  $JAVA_HOME/bin -scripting ex06/pipe.js
total 0
drwxr-xr-x   7 budougumi0617  staff  238 Jan 26 22:55 .
drwxr-xr-x  10 budougumi0617  staff  340 Jan 19 22:38 ..
drwxr-xr-x   3 budougumi0617  staff  102 Jan 19 22:38 ex01
drwxr-xr-x   5 budougumi0617  staff  170 Jan 26 22:19 ex02
drwxr-xr-x   4 budougumi0617  staff  136 Jan 26 21:54 ex03
drwxr-xr-x   4 budougumi0617  staff  136 Jan 26 22:38 ex04
drwxr-xr-x   5 budougumi0617  staff  170 Jan 31 13:20 ex06

.
./ex01
./ex01/README.md
./ex02
./ex02/Ex02.java
./ex02/Ex02.js
./ex02/README.md
./ex03
./ex03/Ex03.js
./ex03/README.md
./ex04
./ex04/Ex04.js
./ex04/README.md
./ex06
./ex06/.pipe.js.swp
./ex06/pipe.js

Need argument
```
