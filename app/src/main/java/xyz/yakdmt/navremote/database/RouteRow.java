package xyz.yakdmt.navremote.database;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here

import xyz.yakdmt.navremote.utils.Column;
import xyz.yakdmt.navremote.utils.Saveable;
// KEEP INCLUDES END
/**
 * Entity mapped to table "ROUTE_ROW".
 */
public class RouteRow implements Saveable {

    /** Not-null value. */
    private String id;
     @Column(name = "Доставка Но.")
    private String delivery_id;
     @Column(name = "Строка Но.")
    private String string_number;
     @Column(name = "Позиция")
    private String position;
     @Column(name = "Пункт Но.")
    private String checkpoint_id;
     @Column(name = "Пункт Описание")
    private String checkpoint_description;
     @Column(name = "Операция Тип")
    private String procedure_type;
     @Column(name = "Приб. Ож. Дата")
    private String expected_arrival_date;
     @Column(name = "Приб. Факт. Дата")
    private String actual_arrival_date;
     @Column(name = "Приб. Факт. Время")
    private String actual_arrival_time;
     @Column(name = "Убыт. Факт. Дата")
    private String actual_departure_date;
     @Column(name = "Убыт. Факт. Время")
    private String actual_departure_time;
     @Column(name = "Убыт. Ож. Дата")
    private String expected_departure_date;
     @Column(name = "Убыт. Ож. Время")
    private String expected_departure_time;
     @Column(name = "Код Страны")
    private String country_code;
     @Column(name = "Адрес")
    private String address;
     @Column(name = "Пункт Тип Расшир.")
    private String checkpoint_type;
     @Column(name = "Исполнитель")
    private String performer;
     @Column(name = "Отдел Исполнителя")
    private String performer_dept;
     @Column(name = "Активная")
    private String active;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public RouteRow() {
    }

    public RouteRow(String id) {
        this.id = id;
    }

    public RouteRow(String id, String delivery_id, String string_number, String position, String checkpoint_id, String checkpoint_description, String procedure_type, String expected_arrival_date, String actual_arrival_date, String actual_arrival_time, String actual_departure_date, String actual_departure_time, String expected_departure_date, String expected_departure_time, String country_code, String address, String checkpoint_type, String performer, String performer_dept, String active) {
        this.id = id;
        this.delivery_id = delivery_id;
        this.string_number = string_number;
        this.position = position;
        this.checkpoint_id = checkpoint_id;
        this.checkpoint_description = checkpoint_description;
        this.procedure_type = procedure_type;
        this.expected_arrival_date = expected_arrival_date;
        this.actual_arrival_date = actual_arrival_date;
        this.actual_arrival_time = actual_arrival_time;
        this.actual_departure_date = actual_departure_date;
        this.actual_departure_time = actual_departure_time;
        this.expected_departure_date = expected_departure_date;
        this.expected_departure_time = expected_departure_time;
        this.country_code = country_code;
        this.address = address;
        this.checkpoint_type = checkpoint_type;
        this.performer = performer;
        this.performer_dept = performer_dept;
        this.active = active;
    }

    /** Not-null value. */
    public String getId() {
        return id;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setId(String id) {
        this.id = id;
    }

    public String getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(String delivery_id) {
        this.delivery_id = delivery_id;
    }

    public String getString_number() {
        return string_number;
    }

    public void setString_number(String string_number) {
        this.string_number = string_number;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCheckpoint_id() {
        return checkpoint_id;
    }

    public void setCheckpoint_id(String checkpoint_id) {
        this.checkpoint_id = checkpoint_id;
    }

    public String getCheckpoint_description() {
        return checkpoint_description;
    }

    public void setCheckpoint_description(String checkpoint_description) {
        this.checkpoint_description = checkpoint_description;
    }

    public String getProcedure_type() {
        return procedure_type;
    }

    public void setProcedure_type(String procedure_type) {
        this.procedure_type = procedure_type;
    }

    public String getExpected_arrival_date() {
        return expected_arrival_date;
    }

    public void setExpected_arrival_date(String expected_arrival_date) {
        this.expected_arrival_date = expected_arrival_date;
    }

    public String getActual_arrival_date() {
        return actual_arrival_date;
    }

    public void setActual_arrival_date(String actual_arrival_date) {
        this.actual_arrival_date = actual_arrival_date;
    }

    public String getActual_arrival_time() {
        return actual_arrival_time;
    }

    public void setActual_arrival_time(String actual_arrival_time) {
        this.actual_arrival_time = actual_arrival_time;
    }

    public String getActual_departure_date() {
        return actual_departure_date;
    }

    public void setActual_departure_date(String actual_departure_date) {
        this.actual_departure_date = actual_departure_date;
    }

    public String getActual_departure_time() {
        return actual_departure_time;
    }

    public void setActual_departure_time(String actual_departure_time) {
        this.actual_departure_time = actual_departure_time;
    }

    public String getExpected_departure_date() {
        return expected_departure_date;
    }

    public void setExpected_departure_date(String expected_departure_date) {
        this.expected_departure_date = expected_departure_date;
    }

    public String getExpected_departure_time() {
        return expected_departure_time;
    }

    public void setExpected_departure_time(String expected_departure_time) {
        this.expected_departure_time = expected_departure_time;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCheckpoint_type() {
        return checkpoint_type;
    }

    public void setCheckpoint_type(String checkpoint_type) {
        this.checkpoint_type = checkpoint_type;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getPerformer_dept() {
        return performer_dept;
    }

    public void setPerformer_dept(String performer_dept) {
        this.performer_dept = performer_dept;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    // KEEP METHODS - put your custom methods here
    @Override
    public void save() {
        if (getId()==null) {
            setId(getDelivery_id()+getString_number());
        }
        DaoTask.getInstance().getSession().getRouteRowDao().insertOrReplace(this);

    }
    // KEEP METHODS END

}
