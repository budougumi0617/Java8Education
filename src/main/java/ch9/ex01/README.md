#練習問題1

212ページの9.1.1節「try-with-resoruces文」の最後にあるScannerとPrinterを生成しているコードを、
try-with-resoruces文を使用しないで実装しなさい。両方のオブジェクトが適切に生成された場合には、
両方のオブジェクトをきちんとクローズしなさい。次の事柄を考慮すること。

- Scannerのコンストラクタは例外をスローする。
- PrintWriterのコンストラクタは例外をスローする。
- in.close()は例外をスローする。
- out.close()は例外をスローする。