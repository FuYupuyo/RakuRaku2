# 楽天ランキングアプリ  
* 勉強用アプリです  

# 考慮すべきこと
* オブジェクト指向を意識する  
  * クラスの分割があいまいで、リファクタリングで対応しているが動かない状態を解決  
  * 手続き型に慣れてしまっている部分を意識する  

* インプット
  * IDはだめ
  * Integerはクラスだからintより重い。単純なforならintでいい
  * try／cacheで全体を囲うとネストが深くなるから、修正しましょう
  * Activity自体を渡すのはでかいのでは？
  * mActivityはいらない。thisでいいし、無名クラスに渡すのでもMainActivity.thisで良い
  * 全体的に前回に比べると良くなった

# 次回までの課題 3/20まで
* Volleyクラスの理解
  * 参考url: http://stackoverflow.com/questions/16682595/android-volley-imageloader-bitmaplrucache-parameter
* シリアライズの理解
  * https://groups.google.com/forum/#!msg/android-group-japan/2ZFmEK-17z4/uVaoJGwMAeQJ
  * http://d.hatena.ne.jp/hidecheck/20091008/1255023688

# 技術的課題  
* SQLiteの利用  
  * SQLiteを利用する
  * アプリ内をデータ保持する  

* Fragmentの利用  
  * ActivityとFragment間のコールバックメソッドの理解  
  * タブレット対応等  

* ActionBarを使いこなす  
  * 各種デザインパターンの学習  
