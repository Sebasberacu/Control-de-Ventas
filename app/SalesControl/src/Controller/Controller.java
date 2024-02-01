/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Objects.ApplianceCategory;
import Objects.Client;
import Objects.Appliance;
import Objects.Employee;
import Objects.Bill;
import Objects.CatalogsLog;
import Objects.BillingLog;
import Objects.UsersLog;
import Objects.Branch;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 */
public class Controller {
    
    private UsersLog registroUsuarios;
    private CatalogsLog registroCatalogos;
    private BillingLog registroFacturacion;

    public Controller() {
        this.registroUsuarios = new UsersLog();
        this.registroCatalogos = new CatalogsLog();
        this.registroFacturacion = new BillingLog();
    }
    
    //Ingresar
    public boolean ingresarEmpleado(Employee empleado){
        registroUsuarios.addEmployee(empleado);
        return true;
    }
    public boolean ingresarCliente(Client cliente){
        registroUsuarios.addClient(cliente);
        return true;
    }
    public boolean ingresarSucursal(Branch sucursal){
        registroCatalogos.addBranch(sucursal);
        return true;
    }
    public boolean ingresarElectrodomestico(Appliance electrodomestico){
        registroCatalogos.addAppliance(electrodomestico);
        return true;
    }
    public boolean ingresarCategoriaElectrodomestico(ApplianceCategory categoriaElectrodomestico){
        registroCatalogos.addApplianceCategory(categoriaElectrodomestico);
        return true;
    }
    public boolean ingresarFactura(Bill factura){
        registroFacturacion.addBill(factura);
        return true;
    }
    
    // Editar
    public boolean editarEmpleado(Employee empleado){
        // Se debe verificar que no hayan Electrodomesticos con este empleado para poder ser editado.
        Vector<Appliance> electrodomesticosActuales = registroCatalogos.getAppliances();
        for (Appliance electrodomestico : electrodomesticosActuales){
            if (electrodomestico.getEmployeeInCharge().equals(empleado)){
                return false;
            }
        }
        return registroUsuarios.editEmployee(empleado);
    
    }
    public boolean editarCliente(Client cliente){
        return registroUsuarios.editClient(cliente);
    
    }
    public boolean editarSucursal(Branch sucursal){
        // Se debe verificar que no hayan Electrodomesticos en esta sucursal para poder ser editado.
        Vector<Appliance> electrodomesticosActuales = registroCatalogos.getAppliances();
        for (Appliance electrodomestico : electrodomesticosActuales){
            if (electrodomestico.getBranch().equals(sucursal)){
                return false;
            }
        }
        return registroCatalogos.editBranch(sucursal);
    }
    public boolean editarElectrodomestico(Appliance electrodomestico){
        return registroCatalogos.editAppliance(electrodomestico);
    }
    public boolean editarCategoriaElectrodomestico(ApplianceCategory categoriaElectrodomestico){
       // Se debe verificar que no hayan Electrodomesticos con esta categoría para poder ser editado.
        Vector<Appliance> electrodomesticosActuales = registroCatalogos.getAppliances();
        for (Appliance electrodomestico : electrodomesticosActuales){
            if (electrodomestico.getCategory().equals(categoriaElectrodomestico)){
                return false;
            }
        }
        return registroCatalogos.editApplianceCategory(categoriaElectrodomestico);
    }
    
    // Consultar
    public ArrayList<Employee> consultarEmpleados(){
        return registroUsuarios.getActiveEmployees();
    }
    public ArrayList<Client> consultarClientes(){
        return registroUsuarios.getActiveClients();
    }
    public Vector<Branch> consultarSucursales(){
        return registroCatalogos.getActiveBranches();
    }
    public Vector<Appliance> consultarElectrodomesticos(){
        return registroCatalogos.getActiveAppliances();
    }
    public Vector<ApplianceCategory> consultarCategoriaElectrodomesticos(){
        return registroCatalogos.getActiveApplianceCategories();
    }
    public ArrayList<Bill> consultarFacturas(){
        return registroFacturacion.getBills();
    }
    
    // Consultar único
    public Employee consultarEmpleado(String nickname){
        return registroUsuarios.consultEmployee(nickname);
    }
    public Client consultarCliente(String nickname){
        return registroUsuarios.consultClient(nickname);
    }
    public Branch consultarSucursal(String nombre){
        return registroCatalogos.consultBranchByName(nombre);
    }
    public Appliance consultarElectrodomestico(String descripcion){
        return registroCatalogos.consultApplianceByDescription(descripcion);
    }
    public ApplianceCategory consultarCategoriaElectrodomestico(String nombre){
        return registroCatalogos.consultApplianceCategoryByName(nombre);
    }
    public Bill consultarFactura(String descripcion){
        return registroFacturacion.checkBill(descripcion);
    }
    
    
    // Desactivar
    public boolean inactivarEmpleado(Employee empleadoPorEliminar){
        // Se debe verificar que no hayan Electrodomesticos con este empleado para poder ser desactivado.
        Vector<Appliance> electrodomesticosActuales = registroCatalogos.getAppliances();
        for (Appliance electrodomestico : electrodomesticosActuales){
            if (electrodomestico.getEmployeeInCharge().equals(empleadoPorEliminar)){
                return false;
            }
        }
        registroUsuarios.inactivateEmployee(empleadoPorEliminar.getNickname());
        return true;
    }
    
    public boolean inactivarCliente(Client clientePorEliminar){
        // Client no pertenece a la información de ningún catálogo. Se puede desactivar directamente.
        registroUsuarios.inactivateClient(clientePorEliminar.getNickname());
        return true;
        
    }
    
    public boolean inactivarSucursal(Branch sucursalPorEliminar){
        // Se debe verificar que no hayan Electrodomesticos en esta sucursal para poder ser desactivado.
        Vector<Appliance> electrodomesticosActuales = registroCatalogos.getAppliances();
        for (Appliance electrodomestico : electrodomesticosActuales){
            if (electrodomestico.getBranch().equals(sucursalPorEliminar)){
                return false;
            }
        }
        registroCatalogos.inactivateBranch(sucursalPorEliminar.getName());
        return true;
        
    }
    
    public boolean inactivarCategoriaElectrodomestico(ApplianceCategory categoriaElectrodomesticoPorEliminar){
        // Se debe verificar que no hayan Electrodomesticos con esta categoría para poder ser desactivado.
        Vector<Appliance> electrodomesticosActuales = registroCatalogos.getAppliances();
        for (Appliance electrodomestico : electrodomesticosActuales){
            if (electrodomestico.getCategory().equals(categoriaElectrodomesticoPorEliminar)){
                return false;
            }
        }
        registroCatalogos.inactivateApplianceCategory(categoriaElectrodomesticoPorEliminar.getName());
        return true;
        
    }
    
    public boolean inactivarElectrodomestico(Appliance electrodomesticoPorEliminar){
        // No hay que verificar ningún catalogo para desactivar un electrodoméstico.
        registroCatalogos.inactivateAppliance(electrodomesticoPorEliminar.getDescription());
        return true;
    }
    
    public boolean inactivarFactura(Bill factura){
        registroFacturacion.cancelBill(factura);
        return true;
    }
    
    
}
