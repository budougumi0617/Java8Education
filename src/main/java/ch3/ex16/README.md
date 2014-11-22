#問題
71ページの3.8節「例外の取り扱い」のdoInOrderAsyncを実装し、
2つ目のパラメータはBiConsumer<T,Throwalbe>としなさい。
うまいユースケースを示しなさい。 3つ目のパラメータは必要ですか

----

#解答
Supplier<T> firstからの例外をBiConsumer<T, Throwable> secondに処理させる。
secondが例外を処理するので、3つ目のパラメータConsumer<Throwable> handlerは不要。  
ユースケースはsrc/test/java/ch16/Ex16.java参照
