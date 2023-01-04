Feature: Hissedar CRUD işlemleri

  Scenario: Hissedar Görüntüleme işleminde liste boşken istek attığında ekranda listenin boş gözükmesi
    When Kullanıcı hissedar listesini görüntülemek istediğinde
    Then Görütüleme işleminin başarılı olması
    And Listenin boş olması

  Scenario: Kullanıcı listede hissedar mevcutken görüntülemek istediğinde işlemin başarılı olması
    Given Listede aşağıdaki bilgileri verilen hissedar mevcut olsun
      | Ad   | Soyad   | Telefon       |
      | Emre | Yavuzzz | +905388694637 |
    When Kullanıcı hissedar listesini görüntülemek istediğinde
    Then Görütüleme işleminin başarılı olması
    And Listenin boş olmaması

  Scenario: Hissedar Ekleme işleminin başarılı olması
    When Hissedar bilgileri aşağıdaki bilgiler ile kaydedilmek istendiğinde
      | Ad     | Soyad | Telefon       |
      | Bektas | Isik  | +905358594652 |
    Then Hissedar ekleme işlemi başarılı olur

  Scenario: Hissedar Ekleme işleminde eksik veri durumunda işlemin başarısız olması
    When Hissedar bilgileri aşağıdaki bilgiler ile kaydedilmek istendiğinde
      | Ad     | Soyad | Telefon       |
      | Bektas |       | +905358594652 |
    Then Hissedar ekleme işlemi başarısız olur

  Scenario: Hissedar güncelleme işleminin başarılı olması
    When "+905388694637" telefon numaralı hissedarın bilgileri aşağıdaki gibi güncellenmek istendiğinde
      | Ad   | Soyad | Telefon       |
      | Emre | Yavuz | +905388694637 |
    Then Hissedar güncelleme işlemi başarılı olur
    And Yeni soyadı "Yavuz" olmalıdır

  Scenario: Hissedar güncelleme işlemide eksik veri olması durumunda işlemin başarısız olması
    When "+905388694637" telefon numaralı hissedarın bilgileri aşağıdaki gibi güncellenmek istendiğinde
      | Ad   | Soyad | Telefon       |
      | Emre |       | +905388694637 |
    Then Hissedar güncelleme işlemi başarısız olur

  Scenario: Hissedar silme işleminin başarılı olması
    When "+905388694637" telefon numaralı hissedar silinmek istendiğinde
    Then Hissedar silme işlemi başarılı olmalıdır