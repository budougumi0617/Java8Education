#練習問題10

指定したファイルからデータを読み込み、パイチャートを表示するJavaFXプログラムをJavaScriptで書きなさい。
Javaでそのプログラムを開発するよりは、簡単ですか、難しいですか。その答えの理由は何ですか。

#実行例

```bash
budougumi0617@~/git/Java8Education/src/main/java/ch7/ex10 (master@Java8Education)
$  $JAVA_HOME/bin/jjs -fx getPieChart.js -- data.csv
```

#解答
小規模開発ならば簡単。簡単な動作確認をする場合は、Javaより容易に確認できる。  
JavaScriptを扱い慣れている場合、少ない記述量で作成することができる。  
コンパイラも利用しないため、すぐに実行結果を確認できる。
複雑なGUIや処理を記述する場合は、
IDEとJavaFx SceneBuilderを用いたほうが効率的だと思われる。