#練習問題1
例えば、ZonedDateTimeクラスなど、試してみたいJava APIを選びなさい。  
その上で、オブジェクトの生成、メソッドの呼び出し、戻り値の表示など、jjsを使った実験を行いなさい。  
また、Javaでテストプログラムを書くよりは簡単かどうかを検証しなさい。

## テストプログラムを書くより簡単か
Javaでテストプログラムを書くのと比較すると、一長一短である。  
IDEを起動するよりは簡単に検証することができる。  
ある程度複雑な処理の検証をする場合は、入力補完などが利用しにくいので、テストプログラムを書くほうが速い。  
JavaScriptの構文を理解している開発者ならば、`jjs`のほうが扱い易いのかもしれない。


## 実行結果

```zsh
$  $JAVA_HOME/bin/jjs
jjs> LocalDate = java.time.LocalDate
[JavaClass java.time.LocalDate]
jjs> LocalDate.now()
2015-01-19
jjs> christmas = LocalDate.of(2014, 12, 25)
2014-12-25
jjs> christmas.toString()
2014-12-25
jjs> quit()
```


