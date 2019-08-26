Feature: Differences
  As a user, I want to get correct info about differences between two products

  Background:
    Given a Chrome browser is opened
    And Rozetka site is opened

  Scenario: Get differences between two notebooks
    When user moves cursor to "Ноутбуки и компьютеры"
    And user clicks "Ноутбуки" on hidden menu
    And user selects "Ноутбуки с SSD" on catalog page
    And user adds 1st product to compare list
    And user adds 2nd product to compare list
    And user clicks Compare icon on Header
    And user clicks Compare button on Compare list
    And user gets different rows from all rows
    And user clicks only different tabs
    Then count of different rows is correct