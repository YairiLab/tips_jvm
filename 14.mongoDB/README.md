非リレーショナルデータベースのMongoDBに、JDBCで読み書きしてみる。  
スキーマの定義がいらず、JSONのような構造化データを扱える。
ので、ちょっとしたときにわりと便利かもしれない。

読み書きそれぞれにエントリポイントが２つあるので、
SBT実行時はどちらを使うか聞かれる。

実行には、ローカルでmongoのサービスが稼働していなければならない。
ポートは27017らしい（コードには出てこないが）。