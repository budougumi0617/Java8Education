#練習問題9

指定された順序で、指定されたフィールドを比較するコンパレータを生成する
`lexicographicComparator(String... fieldNames)`メソッドを書きなさい。
たとえば、`lexicographicComparator("lastname", "firstname")`は、2つのオブジェクトを受け取り、
リフレクションを使用して、lastaNameフィールドの値を取得します。2つのオブジェクトのlastname
フィールドが異なれば、その差を返します。同じであれば、firstnameフィールドに移ります。
全てのフィールドが同じであれば、0を返します。