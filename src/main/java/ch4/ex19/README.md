#練習問題19

`Stream<T>`のメソッドである
`<U> U reduce(U identity, BiFunction<U, ? super T, U> accumlator, BinaryOperator<U> combiner)`
を見てみなさい。
`BiFunction`への最初の型引数で`U`を`? super U`と宣言すべきですか。その理由は何ですか。

#解答
すべきではない。P76より、「ジェネリック型を引数とするラムダ式を受け付けるメソッドを実装する場合、戻り値型として使用されていない引数型には`? super `を追加する」と記載されている。
UはBiFunctionの戻り値型として使用されているので不変であるべき。また、`reduce`メソッドが求めるBiFunctionは結合的な累積関数である必要があるため、U以外のクラスを受け付けてはいけない。
