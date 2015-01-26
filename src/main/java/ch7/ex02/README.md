#練習問題2
jjsを実行し、ストリームライブラリを使用して、次の問題に対する解法をインタラクティブに求めなさい。
問題：あるファイルに含まれている長い単語（12文字より長い）を重複なしで全てソートして表示しなさい。最初に単語を読み込んで、
長い単語を選択してという具合に行いなさい。このインタラクティブな取り組み方は、通常のワークフローと比較してどうですか。

解答
Javascriptに慣れていないと以下の点が難しい。

- StringやArrayがJS仕様になってしまう。
- エラーがよくわからない。
- JavaとJSの言語仕様が共存してしまう（正規表現、ラムダ式など）


#Javascriptコード

```js
Files = java.nio.file.Files
Paths = java.nio.file.Paths
StandardCharsets = java.nio.charset.StandardCharsets
Arrays = java.util.Arrays
String = java.lang.String
contents = new String(Files.readAllBytes(Paths.get('../../../resources/ch2/alice.txt')), StandardCharsets.UTF_8)
s = Arrays.stream(Java.to(contents.split(/\W/), "java.lang.String[]")).distinct()
s = s.filter(function(w) w.length() >= 12)
s = s.sorted()
s.forEachOrdered(function(w) print(w))
```


##実行結果

```sh
budougumi0617@~/git/Java8Education/src/main/java/ch7/ex02 (master@Java8Education)
$  $JAVA_HOME/bin/jjs Ex02.js
CONSEQUENTIAL
Contributions
International
MERCHANTIBILITY
Multiplication
Redistributing
Redistribution
Uglification
accidentally
affectionately
circumstances
confirmation
considerable
consultation
contemptuous
contemptuously
contradicted
contributions
conversation
conversations
difficulties
disappointment
distributing
distribution
electronically
explanations
extraordinary
frontispiece
hippopotamus
identification
infringement
inquisitively
intellectual
interrupting
modification
neighbouring
nevertheless
nonproprietary
occasionally
opportunities
particularly
performances
redistribute
redistributing
redistribution
refreshments
representations
requirements
restrictions
solicitation
straightened
straightening
thoughtfully
thunderstorm
transcription
triumphantly
uncomfortable
uncomfortably
unenforceability
```

