GoogleのJava用HTTPクライアントライブラリで、
適当にページをダウンロードしてみる。

GoogleのJavaライブラリ群の中では、Google APIのクライアントライブラリや
OAuthのライブラリもこのHTTPライブラリに依存している。
本当は他のより高度な機能を使おうとしたら、
このHTTPライブラリが独特で、じわりと時間を取られたのでメモ。

URLのオブジェクトには、いつものjava.net.URLでなく、GenericUrlを使う。  
HTTPクライアントとしては、
標準JavaのHttpURLConnectionやApache HttpClientなどの
他の複数の低レベルHTTPクライアントを切り替えられるよう
HttpTransportというオブジェクトを使うようになっている。
今回は、標準Java由来のNetHttpTransportを使った。

HttpResponseは、パーサをちゃんと与えると、
オブジェクトを自動的に生成してくれるらしい。
が、今回はラクをして文字列を取り出しただけで、
ただコンソールに出力している。

## 参考
- [HTTP TransportについてGoogleの説明](https://developers.google.com/api-client-library/java/google-http-java-client/transport)
- [公式サンプルコードのGit](https://github.com/google/google-http-java-client/blob/dev/samples/googleplus-simple-cmdline-sample/src/main/java/com/google/api/services/samples/googleplus/cmdline/simple/GooglePlusSample.java)
