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
    And user clicks Compare icon
    And user clicks Compare button
    And user clicks only different tabs
    And user checks different rows