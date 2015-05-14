#練習問題11
パスワードで保護されたウェブページの内容を取得するプログラムを書きなさい。
`URLConnection connection = url.openConnection();`を呼び出しなさい。
文字列username:passwordを生成して、それをBase64でエンコードしなさい。
それから`connection.setRequestProperty("Authentication","Basic" + encoded string)`
を呼び出し、次に`connection.connect`と`connection.getInputStream()`を呼び出しなさい。