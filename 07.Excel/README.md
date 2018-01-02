JavaでExcelを読み書きできるApache POIで、旧式のxlsファイルを読んでみる。  
POIは、xlsx形式にも対応している。
書き込みもできるが、自分でExcelに書き出すことはまずないので略。

データは、総務省統計局の人口データをそのまま使った。
出典を明記すれば、加工しても原則使える規約になっている
（詳しくは[利用規約](http://www.stat.go.jp/info/riyou.htm)を参照）。

何がどのシートのどのセルに入っているかは、Excelで開いてみればわかる。
行と列を見て調べて、プログラムで行と列の番号を明示して値を取った。
地味な方法…。
ただ、データのフォーマットが標準化されていないので他の工夫が難しい。
せめて統計局は、毎年のフォーマットを揃えてほしい。

## References
- [Apache POIのJavaDoc。Cellの説明](https://poi.apache.org/apidocs/org/apache/poi/ss/usermodel/Cell.html)
- [総務省統計局の人口推計](http://www.stat.go.jp/data/jinsui/2.htm#monthly)
