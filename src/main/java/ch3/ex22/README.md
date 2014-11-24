#練習問題22

CompletableFutureに対するflatMap操作は存在しますか。存在するなら、それは何ですか。

#解答

`<U> CompletableFuture<U>  thenCompose(Function<? super T,? extends CompletionStage<U>> fn)`



`thenCompose`がflatMap操作に相当すると思います。
`CompletableFuture<T>`から新しい`CompletableFuture<U>`を生成します。
https://docs.oracle.com/javase/jp/8/api/java/util/concurrent/CompletableFuture.html#thenCompose-java.util.function.Function-
test.java.ch3.ex22.Ex22Test.javaを参照。


```java
        CompletableFuture<Integer> cfInteger = CompletableFuture.supplyAsync(
                () -> integerElement, service);
        CompletableFuture<String> cfString = cfInteger.thenCompose(t -> CompletableFuture
                .supplyAsync(() -> t.toString(), service));
```
