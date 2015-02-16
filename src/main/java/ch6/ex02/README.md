#練習問題2
増加するID列を生成するためにLongAdderは役立ちますか。その答えを理由に述べなさい。

---

##解答
役立たない。インクリメントするたびに値を取得する必要がある場合、`LongAdder`は`syncronized`が必要

```
generateIdByNotSync() generates contain id : 1153
generateIdBySync() generates contain id : 0
```


`LongAdder`のJavaDocより引用

https://docs.oracle.com/javase/jp/8/api/java/util/concurrent/atomic/LongAdder.html

```java
public long sum()

現在の合計を返します。返される値は原子的スナップショットではありません。並行更新がない場合の呼出しでは正確な結果が返されますが、合計の計算中に発生した並行更新は組み込まれない可能性があります。
```

最終的な合計値のみが必要な場合は`LongAdder`は高速に処理できる。

`LongAdder`と`AtomicLong`のベンチマークテストの結果より引用

http://www.infoq.com/jp/news/2014/03/java8-release-candidates

```
シングルスレッドでは、新しいLongAdderは3分の1遅くなりますが、スレッドがフィールドを増やそうと争っている場合、LongAdderはその価値を現します。各スレッドはただカウンタを増やそうとしているだけであり、これはもっとも極端な人工的とも言えるベンチマークです。実世界のアプリケーションで見られるよりも、差がはっきり示されていますが、このような共有カウンタは、時々、必要になるでしょう。そのような場合、LongAdderがとても役に立ちます。
```



