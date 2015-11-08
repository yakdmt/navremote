package xyz.yakdmt.navremote.database;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table "WORK".
 */
public class Work {

    private String id;
    private String work_code;
    private String work_type;
    private String measure_unit;
    private String count;
    private String responsible_worker;
    private String comment;
    private String working_place;
    private String description;
    private String delivery_id;
    private String cargo_id;
    private String actual_finish_date;
    private String actual_finish_time;
    private String creator;
    private String responsible_department;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public Work() {
    }

    public Work(String id) {
        this.id = id;
    }

    public Work(String id, String work_code, String work_type, String measure_unit, String count, String responsible_worker, String comment, String working_place, String description, String delivery_id, String cargo_id, String actual_finish_date, String actual_finish_time, String creator, String responsible_department) {
        this.id = id;
        this.work_code = work_code;
        this.work_type = work_type;
        this.measure_unit = measure_unit;
        this.count = count;
        this.responsible_worker = responsible_worker;
        this.comment = comment;
        this.working_place = working_place;
        this.description = description;
        this.delivery_id = delivery_id;
        this.cargo_id = cargo_id;
        this.actual_finish_date = actual_finish_date;
        this.actual_finish_time = actual_finish_time;
        this.creator = creator;
        this.responsible_department = responsible_department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWork_code() {
        return work_code;
    }

    public void setWork_code(String work_code) {
        this.work_code = work_code;
    }

    public String getWork_type() {
        return work_type;
    }

    public void setWork_type(String work_type) {
        this.work_type = work_type;
    }

    public String getMeasure_unit() {
        return measure_unit;
    }

    public void setMeasure_unit(String measure_unit) {
        this.measure_unit = measure_unit;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getResponsible_worker() {
        return responsible_worker;
    }

    public void setResponsible_worker(String responsible_worker) {
        this.responsible_worker = responsible_worker;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getWorking_place() {
        return working_place;
    }

    public void setWorking_place(String working_place) {
        this.working_place = working_place;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(String delivery_id) {
        this.delivery_id = delivery_id;
    }

    public String getCargo_id() {
        return cargo_id;
    }

    public void setCargo_id(String cargo_id) {
        this.cargo_id = cargo_id;
    }

    public String getActual_finish_date() {
        return actual_finish_date;
    }

    public void setActual_finish_date(String actual_finish_date) {
        this.actual_finish_date = actual_finish_date;
    }

    public String getActual_finish_time() {
        return actual_finish_time;
    }

    public void setActual_finish_time(String actual_finish_time) {
        this.actual_finish_time = actual_finish_time;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getResponsible_department() {
        return responsible_department;
    }

    public void setResponsible_department(String responsible_department) {
        this.responsible_department = responsible_department;
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}
