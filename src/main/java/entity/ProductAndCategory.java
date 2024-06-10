package entity;

public class ProductAndCategory extends product {
    private int idCategory;
    private String nameCategory;

    public ProductAndCategory() {
    }

    public ProductAndCategory(int id, String name, double price,int quantity, String color, String nameCategory) {
        super(id, name, price,quantity, color, nameCategory);
        this.nameCategory = nameCategory;
    }

    public ProductAndCategory(int id, String name, double price,int quantity, String color, String description,String nameCategory) {
        super(id, name, price,quantity, color, description);
        this.nameCategory = nameCategory;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
