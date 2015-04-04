#練習問題5
第2章の初めで、リスト内の長い単語を`words.stream().filter(w -> w.length > 12).count()`
で数えました。
ラムダ式を用いて、ストリームを使用しないで、同じコトを行いなさい。
長いリストに対してはどちらの操作が速いですか。


#結果
ストリームを利用したほうが高速

```
Average
Use Stream time 4500540
Not Stream time 9820010
```