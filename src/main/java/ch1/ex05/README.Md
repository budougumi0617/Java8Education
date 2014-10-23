# 練習問題1.5
自分のプロジェクトの1つから、AcrionListenerやRunnableといったインターフェースを多数使用している
ファイルを1つ選んで下さい。それらのインタフェースの仕様をラムダ式に置き換えなさい。
置き換えた結果、コードは何行短くなりましたか。コードは読みやすくなりましたか。
メソッド参照を使用することはできましたか。


##13行短くなった

### 置き換えのためのクラスの参考URL

http://www.javaroad.jp/java_thread3.htm

```sh
budougumi0617@~/git/Java8Education/src/main/java/ch1/ex05
$  wc -l Ex05.java ExThread3.java
  44 Ex05.java
  57 ExThread3.java
 101 total
budougumi0617@~/git/Java8Education/src/main/java/ch1/ex05
$  diff Ex05.java ExThread3.java
4c4
<  * Ex05.java
---
>  * ExThread3.java
17c17
< public class Ex05 {
---
> public class ExThread3 {
19,21c19,21
<     public static void main(String[] args) {
<
<         Thread thread1 = new Thread(() -> {
---
>     private static class ShowName implements Runnable {
>         // (2)runメソッドの本体を定義
>         public void run() {
29,30c29,34
<         });
<         Thread thread2 = new Thread(() -> {
---
>         }
>     }
>
>     private static class ShowFurigana implements Runnable {
>
>         public void run() {
38c42,52
<         });
---
>         }
>     }
>
>     public static void main(String[] args) {
>         ShowName sn = new ShowName();
>
>         ShowFurigana sf = new ShowFurigana();
>
>
>         Thread thread1 = new Thread(sn);
>         Thread thread2 = new Thread(sf);
43d56
<
```