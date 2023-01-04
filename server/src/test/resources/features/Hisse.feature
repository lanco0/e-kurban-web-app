Feature: Hisse işlemleri özelliği

  Background:
    Given Aşağıdaki kurban eklenmiş olsun
      | kupeNo      | cins     | kunye | kilo | yas | fiyat | resimUrl         |
      | 2022A137700 | BUYUKBAS | DANA  | 535  | 24  | 57000 | kurban.png       |

    Given Aşağıdaki hissedar eklenmiş olsun
      | ad     | soyad | tel |
      | mehmet | ercan | +545 |

  Scenario: Hisse ekleme senaryosu
    When Hisse eklenmek istendiğinde
    Then İlgili kurbana hisse eklenmiş olur