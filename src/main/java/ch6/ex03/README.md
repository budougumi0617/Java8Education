#問題3
1,000個のスレッドを生成し、各スレッドは、
ある１つのカウンターを100,000回だけ1ずつ増加させます。
AtomicLongとLongAdderを使用した場合の性能を比較しなさい。



```
Result :
By AtomicLong :5008247 msec
By LongAdder  : 630817 msec
```