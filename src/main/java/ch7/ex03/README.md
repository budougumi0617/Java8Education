#練習問題3
jjsを実行しなさい。そして次の呼び出しを行いなさい。
var b = new java.math.BigInteger('1234567890987654321')
それから、bを表示しなさい（単にbと入力してEnterを押します）。何が得られましたか。
b.mod(java.math.BigInteger.TEN)の値は何ですか。bはなぜ、奇妙に表示されるのですか。
bの実際の値をどうやって表示できますか。

##解答
bはJSで表現できる整数の最大値を超えているから。  
`java.lang.String.format`でJavaの処理表現を用いて`b`を処理すれば正しい値が表示できる。  
`b.mod(java.math.BigInteger.TEN)`が正しく処理できる理由は不明。  


```sh
budougumi0617@~/git/Java8Education/src/main/java/ch7 (master@Java8Education)
$  cat ex03/Ex03.js
b = new java.math.BigInteger('1234567890987654321')
print(b)
print(java.lang.String.format('%d', b))
result = b < 1.79 * Math.pow(2, 53)
print(result)
c = b.mod(java.math.BigInteger.TEN)
print(c)
budougumi0617@~/git/Java8Education/src/main/java/ch7 (master@Java8Education)
$  $JAVA_HOME/bin ex03/Ex03.js
1234567890987654400
1234567890987654321
false
1
```


```
ECMAScript Language Specification 3rd edition

4.3.20 Number Type

The type Number is a set of values representing numbers. In ECMAScript, the set of values represents the double-precision 64-bit format IEEE 754 values including the special “Not-a-Number” (NaN) values, positive infinity, and negative infinity.
```


IEEE 754の倍精度浮動小数点数は52ビットの仮数部を持っていて、53ビットの精度で仮数を表現することができる。  
つまり、2の53乗 (9,007,199,254,740,992) 未満の整数であれば桁落ちの心配をせずに扱うことができる。

###参考URL
http://liosk.blog103.fc2.com/blog-entry-197.html


