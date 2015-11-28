package xyz.yakdmt.navremote.database;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END

import xyz.yakdmt.navremote.utils.Column;
import xyz.yakdmt.navremote.utils.Saveable;

/**
 * Entity mapped to table "CLIENT".
 */
public class Client implements Saveable, java.io.Serializable {

     @Column(name = "Но.")
    private String id;
     @Column(name = "Название")
    private String name;
     @Column(name = "Расш. Название")
    private String external_name;
     @Column(name = "E-Mail")
    private String email;
     @Column(name = "Телефон")
    private String phone;
     @Column(name = "Контакт")
    private String contact;
     @Column(name = "Адрес(юрид.)")
    private String address_legal;
     @Column(name = "Адрес (факт.) ")
    private String address_actual;
     @Column(name = "Расш. Адрес")
    private String extended_address;
     @Column(name = "Приоритет Группа")
    private String priority_group;
     @Column(name = "Персонал.  Менеджер")
    private String manager;
     @Column(name = "ИНН")
    private String inn;
     @Column(name = "КПП")
    private String kpp;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public Client() {
    }

    public Client(String id) {
        this.id = id;
    }

    public Client(String id, String name, String external_name, String email, String phone, String contact, String address_legal, String address_actual, String extended_address, String priority_group, String manager, String inn, String kpp) {
        this.id = id;
        this.name = name;
        this.external_name = external_name;
        this.email = email;
        this.phone = phone;
        this.contact = contact;
        this.address_legal = address_legal;
        this.address_actual = address_actual;
        this.extended_address = extended_address;
        this.priority_group = priority_group;
        this.manager = manager;
        this.inn = inn;
        this.kpp = kpp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExternal_name() {
        return external_name;
    }

    public void setExternal_name(String external_name) {
        this.external_name = external_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress_legal() {
        return address_legal;
    }

    public void setAddress_legal(String address_legal) {
        this.address_legal = address_legal;
    }

    public String getAddress_actual() {
        return address_actual;
    }

    public void setAddress_actual(String address_actual) {
        this.address_actual = address_actual;
    }

    public String getExtended_address() {
        return extended_address;
    }

    public void setExtended_address(String extended_address) {
        this.extended_address = extended_address;
    }

    public String getPriority_group() {
        return priority_group;
    }

    public void setPriority_group(String priority_group) {
        this.priority_group = priority_group;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    // KEEP METHODS - put your custom methods here
    @Override
    public void save() {
        DaoTask.getInstance().getSession().getClientDao().insertOrReplace(this);
    }
    // KEEP METHODS END

}
