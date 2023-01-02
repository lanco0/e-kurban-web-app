Feature: Hissedar İşlemleri

  Background
    Given Aşağıdaki kurbanlar eklenmiş olsun
      | kupeNo      | cins     | kunye | kilo | yas | fiyat | resimUrl         |
      | 2022A137700 | BUYUKBAS | DANA  | 535  | 24  | 57000 | kurban.png       |
      | 2022A137701 | KUCUKBAS | KOYUN | 25   | 13  | 5000  | kucuk-kurban.png |
      | 2022A137702 | BUYUKBAS | INEK  | 500  | 20  | 53000 | kurban.png       |
      | 2022A137703 | KUCUKBAS | KUZU  | 25   | 9   | 3500  | kucuk-kurban.png |

  Scenario Kurbana hissedar eklendiğinde başarılı olunması
    When "2022A137700" nolu küpe numarasına aşağıdaki hissedar eklendiğinde
      | Ad   | Soyad | Telefon    |
      | Emre | Yavuz | 5551112233 |
    Then Hissedar ekleme işlemi başarılı olur