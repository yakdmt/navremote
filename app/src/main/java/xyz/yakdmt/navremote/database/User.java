package xyz.yakdmt.navremote.database;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table "USER".
 */
public class User {

    private String id;
    private String password;
    private String username;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public User() {
    }

    public User(String id) {
        this.id = id;
    }

    public User(String id, String password, String username) {
        this.id = id;
        this.password = password;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}
