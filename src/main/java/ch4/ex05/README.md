#練習問題5

次のメソッドを書きなさい。

```java
public static <T, R> ObserableValue<R> observe(
Function<T,R> f, ObservableValue<T> t)
public static <T, U, R> ObservableValue<R> observe(
BiFunction<T, U, R> f, ObservableValue<T> t, ObservableValue<U> u)
```

このメソッドは、`ObservableValue`を返し、その`ObservableValueのgetValue`メソッドは、ラムダ式の値を返します。
そして、その`ObservableValue`の`InvalidationListener`と`ChangeListener`が、入力のどれかが無効あるいは変更になったときに
呼び出されるようにしなさい。例えば、次の通りです。

```java
larger.disableProperty().bind(observe(
t -> t.intValue() => 100, gauge.widthProperty()));
```


