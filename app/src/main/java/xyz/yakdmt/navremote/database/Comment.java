package xyz.yakdmt.navremote.database;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END

import xyz.yakdmt.navremote.utils.Column;
import xyz.yakdmt.navremote.utils.Saveable;

/**
 * Entity mapped to table "COMMENT".
 */
public class Comment implements Saveable {

     @Column(name = "Запись Но.")
    private String id;
     @Column(name = "Объект ID")
    private String object_id;
     @Column(name = "Тип Объекта")
    private String object_type;
     @Column(name = "Дата")
    private String date;
     @Column(name = "Комментарий")
    private String text;
     @Column(name = "Автор")
    private String author;
     @Column(name = "Отдел")
    private String department;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public Comment() {
    }

    public Comment(String id) {
        this.id = id;
    }

    public Comment(String id, String object_id, String object_type, String date, String text, String author, String department) {
        this.id = id;
        this.object_id = object_id;
        this.object_type = object_type;
        this.date = date;
        this.text = text;
        this.author = author;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject_id() {
        return object_id;
    }

    public void setObject_id(String object_id) {
        this.object_id = object_id;
    }

    public String getObject_type() {
        return object_type;
    }

    public void setObject_type(String object_type) {
        this.object_type = object_type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // KEEP METHODS - put your custom methods here
    @Override
    public void save() {
        DaoTask.getInstance().getSession().getCommentDao().insertOrReplace(this);
    }
    // KEEP METHODS END

}
