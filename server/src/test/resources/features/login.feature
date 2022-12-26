Feature: Login Olma İşlemleri

  Scenario Outline: Kullanıcının login olma senaryosu
    Given Kullanıcının giriş bilgileri kendisine verilmiştir "<username>" ve "<password>"
    When Mail adresi ve şifre ile giriş yapılır
    Then Kullanıcı sisteme girmiş olur

    Examples:
    |username|password|
    |user    |1234    |