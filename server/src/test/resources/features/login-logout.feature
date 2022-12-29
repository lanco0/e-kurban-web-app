Feature: Login/Logout Olma İşlemleri

  Scenario Outline: Kullanıcının başarılı login olma senaryosu
    Given Kullanıcının giriş bilgileri kendisine verilmiştir "<eposta>" ve "<sifre>"
    When Mail adresi ve şifre ile giriş yapılır
    Then Kullanıcı sisteme girmiş olur

    Examples:
      | eposta           | sifre |
      | user@ekurban.com | 1234  |

  Scenario Outline: Kullanıcının başarısız login olma senaryosu
    Given Kullanıcının giriş bilgileri kendisine verilmiştir "<eposta>" ve "<sifre>"
    When Mail adresi ve şifre ile giriş yapılır
    Then Kullanıcı sistemde kayıtlı olmadığı için sisteme giriş yapamaz

    Examples:
      | eposta           | sifre |
      | user@ekurban.com | 123   |
      | use@gmail.com    | 1234  |
      | use@outlook.com  |       |
      |                  | 156   |
      |                  |       |

  Scenario Outline: Kullanıcının başarılı logout olma senaryosu
    Given Kullanıcı sisteme login olmuş olmalıdır "<eposta>" ve "<sifre>"
    When Kullanıcı çıkış yapmak istediğinde
    Then Kullanıcı sistenden çıkış yapar

    Examples:
      | eposta           | sifre |
      | user@ekurban.com | 1234  |