#練習問題10
なぜ、次の呼び出しができないのでしょうか。

```
UnaryOperator<Color> op = Color::brighter;
Image finalImage =
transform(image, op.compose(Color::grayscale));
```

`UnaryOperator<T>`の`compose`メソッドの戻り値型を注意深く調べなさい。
なぜ、`transform`メソッドに対しては、適切ではないのでしょうか。
関数合成に関しては、ストラクチャル型(structural type)と
ノミナル型(nominal type)のどちらがより役立つでしょうか。
＃ストラクチャル型は、構造が同じであれば、名前が異なっていても、同じ型とみなされ、ノミナル型は名前が同じでなければ、同じ型とみなされません。

#解答

```
Type mismatch: cannot convert from Function<Color,Color> to UnaryOperator<Color>
```

`UnaryOperator<T>`は`Funciton`を特殊化した`Function<T,T>`型で、composeメソッドは`Function<T,T>`型を返却している。キャストしても実行時エラーになる。

Java8の関数合成はP62の通りノミナル型付けであるため、エラーになってしまう。関数合成に関しては、ストラクチャル型のほうが柔軟性があり使いやすい。
