package xyz.yakdmt.navremote.database;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END

import xyz.yakdmt.navremote.utils.Saveable;

/**
 * Entity mapped to table "CHECKPOINT".
 */
public class Checkpoint implements Saveable {

    private String id;
    private String name;
    private String country_code;
    private String info;
    private String type;
    private String city_name;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public Checkpoint() {
    }

    public Checkpoint(String id) {
        this.id = id;
    }

    public Checkpoint(String id, String name, String country_code, String info, String type, String city_name) {
        this.id = id;
        this.name = name;
        this.country_code = country_code;
        this.info = info;
        this.type = type;
        this.city_name = city_name;
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

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    // KEEP METHODS - put your custom methods here
    @Override
    public void save() {
        DaoTask.getInstance().getSession().getCheckpointDao().insertOrReplace(this);
    }
    // KEEP METHODS END

}
