/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitpower.view.resource;

import fitpower.model.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ismael
 */
public class TableCustomerModel extends AbstractTableModel {

    private static final String[] COLUMNAS = {"N°", "DNI", "Email", "Objetivos", "Apellido", "Nombre"};
    private List<Customer> customers;

    public TableCustomerModel() {
        customers = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return customers == null ? 0 : customers.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object retorno = null;
        Customer customer = customers.get(rowIndex);

        switch (columnIndex) {
            case 0:
                retorno = rowIndex;
                break;
            case 1:
                retorno = customer.getDni();
                break;
            case 2:
                retorno = customer.getEmail();
                break;
            case 3:
                retorno = customer.getGoal();
                break;
            case 4:
                retorno = customer.getLastName();
                break;
            case 5:
                retorno = customer.getName();
                break;
        }

        return retorno;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMNAS[column];
    }

    public void setPersonas(List<Customer> customers) {
        this.customers = customers;
    }

    public Customer obtenerPersonaEn(int fila) {
        return customers.get(fila);
    }

    public int buscarFilaPersona(Customer personaBuscada) {
        int fila = 0;
        int contador = 0;
        for (Customer personaRecorrido : customers) {
            contador = contador + 1;
            if (personaBuscada.getId() == personaRecorrido.getId()) {
                fila = contador;
            }
        }
        return fila;
    }

}
