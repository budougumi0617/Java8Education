#練習問題8

みなさんのコンピュータでは、`Arrays.parallelSort()`は、配列がどのくらいの大きさであれば`Arrays.sort()`より速くなりますか。
環境情報


実行結果

```
-----------
Double Array size is  12
result time : Single Sort  :     8000
result time : Parallel Sort :     7000
-----------
```



システム環境

```sh
$  system_profiler SPHardwareDataType
Hardware:

    Hardware Overview:

      Model Name: MacBook Air
      Model Identifier: MacBookAir6,2
      Processor Name: Intel Core i5
      Processor Speed: 1.3 GHz
      Number of Processors: 1
      Total Number of Cores: 2
      L2 Cache (per Core): 256 KB
      L3 Cache: 3 MB
      Memory: 4 GB
```