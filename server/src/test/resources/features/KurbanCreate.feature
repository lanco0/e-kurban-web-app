Feature: Kurban Ekleme İşlemi

  Scenario: Kullanıcı kurban eklemek istediği zaman tüm alanların doldurmaz ise hata alır
    Given Kullanıcı kurban ekleme sayfasına bilgileri doldurmaya başlamıştır
      | kupeNo      | cins     | kunye | kilo | yas | fiyat | resimUrl   |
      | 2022A137700 | BUYUKBAS | DANA  | 535  | 24  |       | kurban.png |
    When Kullanıcı kurbanı eklemek istediğinde
    Then Ekleme işlemi başarısız olur

  Scenario: Kullanıcı Ekleme işlemi yaparken kurban resmini yuklemeden kayıt etmek isterse hata alır
    Given Kullanıcı kurban ekleme sayfasına bilgileri doldurmaya başlamıştır
      | kupeNo      | cins     | kunye | kilo | yas | fiyat | resimUrl |
      | 2022A137700 | BUYUKBAS | DANA  | 535  | 24  | 57000 |          |
    When Kullanıcı kurbanı eklemek istediğinde
    Then Ekleme işlemi başarısız olur

  Scenario: Kullanıcı bilgilerin tamamını eksiksiz doldurduğu zaman ekleme işlemi başarılı olur
    Given Kullanıcı kurban ekleme sayfasına bilgileri doldurmaya başlamıştır
      | kupeNo      | cins     | kunye | kilo | yas | fiyat | resimUrl   |
      | 2022A137700 | BUYUKBAS | DANA  | 535  | 24  | 57000 | kurban.png |
    When Kullanıcı kurbanı eklemek istediğinde
    Then Ekleme işlemi başarılı olur

  Scenario: Kurban ekleme işleminde kesim sırası, (mevcut kurban sayıs+1) olmalıdır
    Given Kurban Listesinde sadece aşağıdaki kurban eklenmiş olsun
      | kupeNo      | cins     | kunye | kilo | yas | fiyat | resimUrl   |
      | 2022A137700 | BUYUKBAS | DANA  | 535  | 24  | 57000 | kurban.png |
    When Yeni Kurban eklenmek istendiğinde
    Then Yeni kurbanın kesim sayısı "ks1" kurban listesinden 1 fazla olmalıdır.
