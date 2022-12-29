Feature: hissedarlara gönderilecek mesaj özelliği
  Scenario: Hissedarlara Kurban kesildi mesajının gönderilmesi senaryosu
    Given Hissedarın, halihazırda kurban seçip hissedar listesinde ismi olmalıdır
    When Hissedarların kurbanı kesildiğinde
    Then Hissedarlara kurban kesildi mesajı gönderilir

