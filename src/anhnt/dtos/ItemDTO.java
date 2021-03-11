/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhnt.dtos;

/**
 *
 * @author TRUNG ANH
 */
public class ItemDTO {
    String supCode, itemCode, itemName, unit, supName;
    float price;
    boolean supplying;
    

    public ItemDTO() {
        supCode = itemCode = itemName = unit = "";
        price = 0;
        supplying = false;
        supName = "";
    }

    public ItemDTO(String supCode, String itemCode, String itemName, String unit, float price, boolean supplying) {
        this.supCode = supCode;
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.unit = unit;
        this.price = price;
        this.supplying = supplying;
    }

    public ItemDTO(String supCode, String itemCode, String itemName, String unit, String supName, float price, boolean supplying) {
        this.supCode = supCode;
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.unit = unit;
        this.supName = supName;
        this.price = price;
        this.supplying = supplying;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }
    
    

    public String getSupCode() {
        return supCode;
    }

    public void setSupCode(String supCode) {
        this.supCode = supCode;
    }
    
    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isSupplying() {
        return supplying;
    }

    public void setSupplying(boolean supplying) {
        this.supplying = supplying;
    }
}
