package Objects;

import java.util.Vector;

public class CatalogsLog {
    private Vector<Branch> branches;
    private Vector<ApplianceCategory> applianceCategories;
    private Vector<Appliance> appliances;
    
    public CatalogsLog(){
        this.branches = new Vector<>();
        this.applianceCategories = new Vector<>();
        this.appliances = new Vector<>();
    }

    public CatalogsLog(Vector<Branch> branches, Vector<ApplianceCategory> applianceCategories, Vector<Appliance> appliances) {
        this.branches = branches;
        this.applianceCategories = applianceCategories;
        this.appliances = appliances;
    }

    // Setters y Getters
    public Vector<Branch> getBranches() {
        return branches;
    }

    public void setBranches(Vector<Branch> branches) {
        this.branches = branches;
    }

    public Vector<ApplianceCategory> getApplianceCategories() {
        return applianceCategories;
    }

    public void setApplianceCategories(Vector<ApplianceCategory> applianceCategories) {
        this.applianceCategories = applianceCategories;
    }

    public Vector<Appliance> getAppliances() {
        return appliances;
    }

    public void setAppliances(Vector<Appliance> appliances) {
        this.appliances = appliances;
    }
    
    // Necessary methods
    public void addBranch(Branch branch) {
        this.branches.add(branch);
    }

    public boolean editBranch(Branch branch) {
        int index = lookBranchIndex(branch.getName());
        if (index != -1) {
            this.branches.set(index, branch);
            return true;
        }
        return false;
    }

    public void inactivateBranch(String name) {
        int index = lookBranchIndex(name);
        if (index != -1) {
            this.branches.get(index).setState(false);
        }
    }

    public void addApplianceCategory(ApplianceCategory category) {
        this.applianceCategories.add(category);
    }

    public boolean editApplianceCategory(ApplianceCategory category) {
        int index = lookApplianceCategoryIndex(category.getName());
        if (index != -1) {
            this.applianceCategories.set(index, category);
            return true;
        }
        return false;
    }

    public void inactivateApplianceCategory(String name) {
        int index = lookApplianceCategoryIndex(name);
        if (index != -1) {
            this.applianceCategories.get(index).setState(false);
        }
    }

    public void addAppliance(Appliance appliance) {
        this.appliances.add(appliance);
    }

    public boolean editAppliance(Appliance appliance) {
        int index = lookApplianceIndex(appliance.getDescription());
        if (index != -1) {
            this.appliances.set(index, appliance);
            return true;
        }
        return false;
    }

    public void inactivateAppliance(String description) {
        int index = lookApplianceIndex(description);
        if (index != -1) {
            this.appliances.get(index).setState(false);
        }
    }

    // Métodos privados para buscar índices
    private int lookBranchIndex(String name) {
        for (int i = 0; i < branches.size(); i++) {
            if (branches.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    private int lookApplianceCategoryIndex(String nombre) {
        for (int i = 0; i < applianceCategories.size(); i++) {
            if (applianceCategories.get(i).getName().equals(nombre)) {
                return i;
            }
        }
        return -1;
    }

    private int lookApplianceIndex(String descripcion) {
        for (int i = 0; i < appliances.size(); i++) {
            if (appliances.get(i).getDescription().equals(descripcion)) {
                return i;
            }
        }
        return -1;
    }
    
    public Vector<Branch> getActiveBranches() {
        Vector<Branch> activeBranches = new Vector<>();
        for (Branch sucursal : branches) {
            if (sucursal.isActivo()) {
                activeBranches.add(sucursal);
            }
        }
        return activeBranches;
    }

    public Vector<ApplianceCategory> getActiveApplianceCategories() {
        Vector<ApplianceCategory> activeCategories = new Vector<>();
        for (ApplianceCategory categoria : applianceCategories) {
            if (categoria.isActive()) {
                activeCategories.add(categoria);
            }
        }
        return activeCategories;
    }

    public Vector<Appliance> getActiveAppliances() {
        Vector<Appliance> activeAppliances = new Vector<>();
        for (Appliance electrodomestico : appliances) {
            if (electrodomestico.isActive()) {
                activeAppliances.add(electrodomestico);
            }
        }
        return activeAppliances;
    }

    public Branch consultBranchByName(String nombre) {
        for (Branch sucursal : branches) {
            if (sucursal.getName().equals(nombre)) {
                return sucursal;
            }
        }
        return null;
    }

    public ApplianceCategory consultApplianceCategoryByName(String name) {
        for (ApplianceCategory categoria : applianceCategories) {
            if (categoria.getName().equals(name)) {
                return categoria;
            }
        }
        return null;
    }

    public Appliance consultApplianceByDescription(String description) {
        for (Appliance electrodomestico : appliances) {
            if (electrodomestico.getDescription().equals(description)) {
                return electrodomestico;
            }
        }
        return null;
    }

}
