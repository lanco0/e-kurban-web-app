Feature: Kurban bayramına kalan gün özelliği
  Scenario: Kurban bayramına kalan günün anasayfada gösterilmesi senaryosu
    Given Kurban bayramı günü sistemde tanımlı olmalıdır
    When Kullanıcı anasayfaya girdiğinde
    Then Kurban bayramına kalan günü görür