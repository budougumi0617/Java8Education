#練習問題24

Pair<T>に対するflatMapメソッドを定義することができますか。
できるとしたら、それは何ですか。できないとしたらその理由は何ですか。


#解答

出来ない。`U`型が必ず合成できることを保証できないため。

```java
<U> PairEx<U> flatMap(Function<? super T, PairEx<U>> mapper)
```

`Optional`クラスを参考に上記のようなflatMapメソッドを定義を試みる。


`Pair<T>`が保持する2つの`T`型要素に対して`mapper`を適用し、
`PairEx<U> Pair1`と`PairEx<U> pair2`を作成し、合成した`PairEx<U> pairResult`を生成したい。
 しかし、`PairEx<U>`型が保持する`U`型要素が必ず合成できる保証がない。