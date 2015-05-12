練習問題3

ユークリッドのアルゴリズム（200年以上前のものです）は、２つの数値の最大公約数
(greatest common divisor)を計算します。bが０であれば、gcd(a,b)=aであり、
そうでなければ、`gcd(a,rem(a,b))`です。`rem`は、余りを意味しています。
aかbが負であったとしても、明らかにgcdは負になるべきではありません（なぜならば、
その値の符号を正にしたもののほうがより大きな約数となるからです。）。
gcdのアルゴリズムを`%`、`floormMod`、数学的な（負ではない）余りを生成する`rem`関数で実装しなさい。
これらの３つの方法のどれが負の値に対して最も簡単ですか


解答
`floorMod`が簡単。`floorMod`のみaの符号を気にせずに実装できる。