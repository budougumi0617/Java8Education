#練習問題11
 次のメソッドを作成しなさい。

```java
public static<T> CompletableFuture<T> repeat(Supplier<T> action, Predicate<T> until)
```


このメソッドはuntil関数が受け入れる値を生成するまで、actionを非同期に繰り返します。until関数も非同期に実行されるべきです。

コンソールからjava.net.PasswordAuthenticationを読み込む関数、および、1秒間スリープすることで正当性検査をシミュレートし、パスワードが"secret"であるかを検査する関数を用いてテストしなさい。ヒント：再帰を使用します。