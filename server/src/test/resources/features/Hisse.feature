Feature: Hisse işlemleri özelliği

  Background:
    Given Aşağıdaki kurban eklenmiş olsun
      | id | kupeNo      | cins     | kunye | kilo | yas | fiyat | resimUrl   |
      | k1 | 2022A137700 | BUYUKBAS | DANA  | 535  | 24  | 57000 | kurban.png |

    Given Aşağıdaki hissedar eklenmiş olsun
      | id | ad     | soyad | tel         |
      | h1 | mehmet | ercan | 05358594652 |

  Scenario: Hisse ekleme senaryosu
    When "k1" nolu kurbana "h1" nolu hissedar eklenmek istendiğinde
    Then Hisse ekleme işlemi başarılı olur