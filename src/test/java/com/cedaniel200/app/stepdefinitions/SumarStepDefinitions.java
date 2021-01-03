package com.cedaniel200.app.stepdefinitions;

import com.cedaniel200.app.calculo.Suma;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.sql.*;
import org.junit.Assert;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SumarStepDefinitions {

    private Suma sumador;
    private int resultado;
    private java_jdbc mySql;

    @Given("^quiero sumar$")
    public void prepararSuma() {
        sumador = new Suma();
    }

    @When("^cuando sumo (\\d+) mas (\\d+)$")
    public void sumar(int arg1, int arg2) {
        resultado = sumador.sumar(arg1, arg2);
    }

    @Then("^deberia ver que el resultado es (\\d+)$")
    public void verificarResultado(int arg1) throws SQLException, ClassNotFoundException {

        Assert.assertEquals(arg1, resultado);
        java_jdbc.select();
    }

}
