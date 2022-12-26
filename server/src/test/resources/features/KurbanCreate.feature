Feature: Kurban Ekleme İşlemi

  Scenario: Kullanıcı kurban eklemek istediği zaman tüm alanların doldurmaz ise hata alır
    Given Kullanıcı kurban ekleme sayfasına bilgileri doldurmaya başlamıştır
      | id | kupeNo      | cinsi    | kunyesi | kilosu | yasi | fiyati | kesimSirasi | kurbanPNG  |
      | k1 | 2022A137700 | buyukBas | dana    | 535    | 24   |        | ks1         | kurban.png |
    When Kullanıcı kurban bilgilerinden en az bir tanesini boş bıraktığında
    Then Ekleme işlemi başarısız olur

  Scenario: Kullanıcı Ekleme işlemi yaparken kurban resmini yuklemeden kayıt etmek isterse hata alır
    Given Kurban bilgilerini girmiş olmalıdır
    When Kurban resmini yuklemeden kayıt etmek istediğinde
    Then Ekleme işlemi başarısız olur

  Scenario: Kullanıcı bilgilerin tamamını eksiksiz doldurduğu zaman ekleme işlemi başarılı olur
    When Kullanıcı tüm bilgileri doldurduğunda
    Then Ekleme işlemi başarılı olur

  Scenario: Kurban ekleme işleminde kesim sırası, (mevcut kurban sayıs+1) olmalıdır
    Given Kurban Listesinde sadece aşağıdaki kurban eklenmiş olsun
      | id | kupeNo      | cinsi    | kunyesi | kilosu | yasi | fiyati | kesimSirasi | kurbanPNG  |
      | k1 | 2022A137700 | buyukBas | dana    | 535    | 24   | 57000  | ks1         | kurban.png |
    When Yeni Kurban eklenmek istendiğinde
    Then Yeni kurbanın kesim sayısı kurban listesinden 1 fazla olmalıdır.
