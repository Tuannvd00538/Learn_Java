/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise;

/**
 *
 * @author Ngo Van Tuan
 */
public class EntityEnterprise {
    private int id;
    private String name;
    private String createAt;
    private int taxcode;
    private int status;

    public EntityEnterprise() {
    }

    public EntityEnterprise(String name, String createAt, int taxcode) {
        this.name = name;
        this.createAt = createAt;
        this.taxcode = taxcode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public int getTaxcode() {
        return taxcode;
    }

    public void setTaxcode(int taxcode) {
        this.taxcode = taxcode;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
