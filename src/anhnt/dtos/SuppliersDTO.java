/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhnt.dtos;

import java.util.Vector;

/**
 *
 * @author TRUNG ANH
 */
public class SuppliersDTO extends Vector<SupplierDTO>{
    public SuppliersDTO() {
        super();
    }
    
    public int find(String supCode){
        for(int i = 0; i < this.size(); i++)
            if(supCode.equalsIgnoreCase(this.get(i).getSupCode()))
                return i;
        return -1;
    }
    
    public SupplierDTO findSupplier(String supCode){
        int pos = find(supCode);
        return pos < 0 ? null : this.get(pos);
    }
    
}
