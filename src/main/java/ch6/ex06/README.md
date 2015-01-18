#練習問題6
マップを更新するメソッドとして、mergeの代わりにcomuputeIfAbsentを使用して、練習問題5と同じアプリケーションを作成しなさい。 この方法の利点は何ですか。


##解答
不要なインスタンス生成をせずに済む。  
mergeメソッドを利用する場合、Keyが登録済みでも毎回Setインスタンスを生成する必要があった。
comuputeIfAbsentメソッドを利用する場合、SetインスタンスはKeyが未登録の時のみ生成される。



```java:Ex05.java
words.stream().forEach(
    word -> {
        Set<File> value = new HashSet<File>();
        value.add(file);
        wordMap.merge(word, value, 
            (existingSet, newSet) -> {
                existingSet.addAll(newSet);
                return existingSet;
            }
        );
    }
);
```


```java:Ex06.java
words.stream().forEach(
    word -> wordMap.computeIfAbsent(word,key -> new HashSet<File>()).add(file)
);
```