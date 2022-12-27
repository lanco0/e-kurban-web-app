Feature: Login Olma İşlemleri

  Scenario Outline: Kullanıcının başarılı login olma senaryosu
    Given Kullanıcının giriş bilgileri kendisine verilmiştir "<username>" ve "<password>"
    When Mail adresi ve şifre ile giriş yapılır
    Then Kullanıcı sisteme girmiş olur

    Examples:
      | username | password |
      | user     | 1234     |

  Scenario Outline: Kullanıcının başarısız login olma senaryosu
    Given Kullanıcının giriş bilgileri kendisine verilmiştir "<username>" ve "<password>"
    When Mail adresi ve şifre ile giriş yapılır
    Then Kullanıcı sistemde kayıtlı olmadığı için sisteme giriş yapamaz

    Examples:
      | username | password |
      | use      | 1234     |
      | user     | 123      |
      |          | 156      |
      |          |          |