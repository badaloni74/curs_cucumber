Feature: Restar
  Yo como matematico
  Quiero restar
  Para no errar en el calculo

  Scenario Outline: Restar dos numeros enteros
    Given quiero restar
    When cuando resto <primerNumero> menos <segundoNumero>
    Then deberia ver que el resultado de la resta es <tercerNumero>
    And parametre '<parametro>'
  Examples:
    |primerNumero|segundoNumero|tercerNumero|parametro|
    |5           |2            |3           |hola     |
    |10          |5            |5           |adeu     |