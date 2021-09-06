Feature: Reservar vuelo

  Scenario: Reservar vuelo Medellin-Bogota
    Given el usuario desea reservar un vuelo
    When ingresa la ciudad de origen 
    And ingresa el destino
    And selecciona la fecha
    And da click en buscar
    And selecciona el primer vuelo de la pagina
    And da click en continuar en la panlla de suma de equipaje 
    Then el usuario visualiza el mensaje Falta poco Completa tus datos y finaliza tu compra
