# PriceEncyclopedia - 物価大辞典

これはマインクラフトサーバー [まんまみーや (まみや鯖)](https://minecraft.jp/servers/play.manmamiya.work:14400)
でのみ動く、サーバー内の[物価大辞典](http://wiki.manmamiya.work/d/%ca%aa%b2%c1%c2%e7%c1%b4%bd%b8)です。

![サンプル](https://gyazo.com/3a05de234f7ad1247cf7ce9ffc2d11c3.png)

物価は常に変動するのでjsonファイルで編集可能なようにしています。

1.19.3でのみ使用可能

[ここから入手](https://github.com/peco2282/PriceEncyclopedia/releases)

## 使い方

1. modファイルに入れる
2. 起動後自動的にconfigフォルダ内に `priceencyclopedia.json` ファイルが生成される。
3. 追加したいアイテムがあれば、以下のように設定する (石 - 32D/1LC の時)

- `price`: 価格の**数字部分**を**文字列**で記入 (32)
- `name`: マインクラフト内のIDを記入
- `payment`: 支払い時のDを小文字で記入 (d) (以下から選択 g(gold), d, std, db, stdb)
- `receipt`: 受け取り時の種類を小文字で記入 (lc) (以下から選択 one(1個のこと), st, c, lc),
- `type`: そのアイテムがブロックかアイテムかを記入(深い意味はない。) (block) (以下から選択 block, item)
  よって

```json
{
  "price": "32",
  "name": "stone",
  "payment": "d",
  "receipt": "lc",
  "type": "block"
}
```
と追記。

:warning:

- jsonの書き方が間違っていると全てのアイテムに適用されません。
- キーが不足している時は正しく適用されるかわかりません。
- シングルワールドに入れなくなることがあります。
- 反映されなかった場合、再起動で直ることがあります。
