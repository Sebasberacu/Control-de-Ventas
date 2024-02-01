package Objects;

import java.util.ArrayList;

public class UsersLog {
    private ArrayList<Employee> employees;
    private ArrayList<Client> clients;

    public UsersLog() {
        this.employees = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    public UsersLog(ArrayList<Employee> employees, ArrayList<Client> clients) {
        this.employees = employees;
        this.clients = clients;
    }

    // Setters y Getters
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    // Employee
    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public Employee consultEmployee(String nickname) {
        for (Employee employee : employees) {
            if (employee.getName().equals(nickname)) {
                return employee;
            }
        }
        return null;
    }

    public boolean inactivateEmployee(String nickname) {
        for (Employee employee : employees) {
            if (employee.getNickname().equals(nickname)) {
                employee.setState(false); // Inactivate
                return true;
            }
        }
        return false;
    }

    // Client
    public void addClient(Client client) {
        this.clients.add(client);
    }

    public Client consultClient(String nickname) {
        for (Client client : clients) {
            if (client.getNickname().equals(nickname)) {
                return client;
            }
        }
        return null;
    }

    public boolean inactivateClient(String nickname) {
        for (Client client : clients) {
            if (client.getNickname().equals(nickname)) {
                client.setState(false); // Inactivate
                return true;
            }
        }
        return false;
    }
    public ArrayList<Employee> getActiveEmployees() {
        ArrayList<Employee> activeEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.isActivo()) {
                activeEmployees.add(employee);
            }
        }
        return activeEmployees;
    }

    public ArrayList<Client> getActiveClients() {
        ArrayList<Client> activeClients = new ArrayList<>();
        for (Client client : clients) {
            if (client.isActivo()) {
                activeClients.add(client);
            }
        }
        return activeClients;
    }
    
    public boolean editEmployee(Employee employee) {
        int index = lookEmployeeIndex(employee.getPassword());
        if (index != -1) {
            this.employees.set(index, employee);
            return true;
        }
        return false;
    }

    private int lookEmployeeIndex(String nickname) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getPassword().equals(nickname)) {
                return i;
            }
        }
        return -1;
    }

    public boolean editClient(Client client) {
        int index = lookClientIndex(client.getPassword());
        if (index != -1) {
            this.clients.set(index, client);
            return true;
        }
        return false;
    }

    private int lookClientIndex(String nickname) {
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getPassword().equals(nickname)) {
                return i;
            }
        }
        return -1;
    }
}

