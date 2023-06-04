Feature: As a user, I want to login to "http://xthb.huce.edu.vn/"
#  Data:
#  User_name:
#  Pass_word:

  Scenario Outline: LI_01 Check cannot login without password
    Given The login page is shown
    When User attempt to login with account is "<user_name>" and password is "<pass_word>"
    Then The message "<message>" is shown
    Then Close browser
    Examples:
    | user_name | pass_word | message                     |
    | kngan     |           | Vui lòng nhập vào mật khẩu  |
    |           | abc       | Vui lòng nhập vào tài khoản |

  Scenario: LI_01 Check cannot login without password
    Given The login page is shown
    When User attempt to login with data
      | User name | Pass word |
      | kngan     | abc       |
    Then The message "Vui lòng nhập vào mật khẩu" is shown
    Then Close browser
