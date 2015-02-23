#練習問題9

ユーザーの年齢を取得して、年齢に1を加えて、Next year, You will be ...と表示するnextYear.jsスクリプトを書きなさい。
年齢は、コマンドラインで指定するか、環境変数AGEで指定することができます。どちらも指定されていなければ、ユーザーに問い合わせるようにしなさい。



##Execut result

```sh
budougumi0617@~/git/Java8Education/src/main/java/ch7 (master@Java8Education)
$  $JAVA_HOME/bin/jjs -scripting ex09/nextYear.js
Input your age : 28
Next year, You will be ...29 old.
budougumi0617@~/git/Java8Education/src/main/java/ch7 (master@Java8Education)
$  $JAVA_HOME/bin/jjs -scripting ex09/nextYear.js -- 14
Next year, You will be ...15 old.
budougumi0617@~/git/Java8Education/src/main/java/ch7 (master@Java8Education)
$  export AGE=100
budougumi0617@~/git/Java8Education/src/main/java/ch7 (master@Java8Education)
$  $JAVA_HOME/bin/jjs -scripting ex09/nextYear.js
Next year, You will be ...101 old.
```