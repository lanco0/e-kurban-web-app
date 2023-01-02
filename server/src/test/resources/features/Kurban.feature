Feature: Kurban ile CRUD işlemleri

  Background:
    Given Kurban Listesinde sadece aşağıdaki kurban eklenmiş olsun
      | kupeNo      | cins     | kunye | kilo | yas | fiyat | resimUrl         |
      | 2022A137700 | BUYUKBAS | DANA  | 535  | 24  | 57000 | kurban.png       |
      | 2022A137701 | KUCUKBAS | KOYUN | 25   | 12  | 3500  | kucuk-kurban.png |


  Scenario Outline: Kullanıcı Listedeki mevcut kurbanlardan cinsine göre görüntülemek isterse başarılı olur
    When Kullanıcı kurban listesininin "<cins>" olanları görüntülemek isterse
    Then Kurbanlar başarılı şekilde ekrana yansıtılır
    Examples:
      | cins     |
      | BUYUKBAS |
      | KUCUKBAS |

  Scenario: Kullanıcı Listedeki mevcut tamamını görüntülemek isterse başarılı olur
    When Kullanıcı kurban listesininin tamamını görüntülemek isterse
    Then Kurbanlar başarılı şekilde ekrana yansıtılır

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
    When Yeni Kurban eklenmek istendiğinde
      | kupeNo      | cins     | kunye | kilo | yas | fiyat | resimUrl    |
      | 2022A137701 | BUYUKBAS | INEK  | 535  | 25  | 58000 | kurbann.png |
    Then Kurban listesinde mevcut kurban sayısı 1 artmalı

  Scenario: Kurban güncelleme işlemi yapıldığında kurban bilgilerinden birini boş bırakılması
    When Aşağıdaki bilgiler ile güncellenmek istendiğinde
      | kupeNo      | cins     | kunye | kilo | yas | fiyat | resimUrl   |
      | 2022A137700 | BUYUKBAS |       | 555  | 25  | 58000 | kurban.png |
    Then Güncelleme işlemi başarısız olur

  Scenario: Kurban güncelleme işlemi yapıldığında kurban bilgilerinin eksiksiz girilmesi durumunda başarılı olması
    When Aşağıdaki bilgiler ile güncellenmek istendiğinde
      | kupeNo      | cins     | kunye | kilo | yas | fiyat | resimUrl   |
      | 2022A137706 | KUCUKBAS | KOC   | 555  | 10  | 30000 | kurban.png |
    Then Kunye ismi "KOC" olmalıdır

