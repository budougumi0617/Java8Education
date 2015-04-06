#練習問題16

市(city)、州(state)、郵便番号(zip code)を含む行を解析するために名前付きキャプチャグループを用いた正規表現を使用しなさい。
５桁と９桁の郵便番号の両方を受け付けるようにしなさい。


#実行結果

```
city = LAFAYETTE
state = NJ
zipcode = 07800
John Walton 123 EXAMPLE ROAD LAFAYETTE, NJ 07800 U.S.A.
city = JOSE
state = CA
zipcode = 078001234
Taro Yamada 1234 test St. SAN JOSE, CA 078001234 U.S.A.
city = JOSE
state = CA
zipcode = 078001234
test JOSE, CA 078001234 U.S.A.
```



アメリカの郵便物の宛て先の書き方は、以下のとおり
http://www.design-penguin.com/OC/life/address.html

- 相手の名前
- 番地
- ストリートの名前
- （あれば）アパート、またはスイートの番号。番号の前に「Apt.#」又は「Suite＃」と書いてください。
- 市名
- 州名（通常2文字の略式で書きます）
- Zip Code（日本で言う郵便番号）

Javaにおける正規表現
http://docs.oracle.com/javase/jp/8/docs/api/java/util/regex/Pattern.html