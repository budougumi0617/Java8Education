#練習問題10


ユーザーにURLを問い合わせて、そのURLのウェブページを読み込み、全てのリンクを表示するプログラムを作成しなさい。

各ステップに対して、CompletableFutureを使用しなさい。getを呼び出さないこと。

プログラムの処理が終わる前に終了しないようにするために、次の呼び出しを行いなさい。

```java
ForkJoinPool.commonPool().awaitQuiescene(10, TimeUnit.SECONDS);
```