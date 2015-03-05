#練習問題3

複数例外をキャッチするcatch節でキャッチした例外を再度スローする場合に、その処理が
書かれているメソッドのthrow宣言には、例外の型をどのように宣言しますか。例えば次の例を考えなさい。

```java
public void process() throws ...{
  try{
    ...
  }catch(FileNotFoundException |
         UnknownHostExceptin ex ) {
    logger.log(Level.SEVERE, "...", ex);
    throw ex;
  }
}
```

#参考

http://docs.oracle.com/javase/jp/7/technotes/guides/language/catch-multiple.html
