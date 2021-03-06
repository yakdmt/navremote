package xyz.yakdmt.navremote.database;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
import android.text.TextUtils;

import xyz.yakdmt.navremote.utils.Column;
import xyz.yakdmt.navremote.utils.Saveable;
// KEEP INCLUDES END
/**
 * Entity mapped to table "CARGO".
 */
public class Cargo implements java.io.Serializable, Saveable {

     @Column(name = "Груз ID")
    private String id;
     @Column(name = "Транспорт")
    private String transport;
     @Column(name = "Мастер Документ")
    private String master_document;
     @Column(name = "Отправитель Код")
    private String sender_code;
     @Column(name = "Отправитель Имя")
    private String sender_name;
     @Column(name = "Дата Появления")
    private String appearance_date;
     @Column(name = "Место Назначения")
    private String destination_checkpoint_code;
     @Column(name = "Транспортная Линия Код")
    private String transport_line_code;
     @Column(name = "Транспортная Линия Имя")
    private String transport_line_name;
     @Column(name = "Клиент Но.")
    private String client_id;
     @Column(name = "Клиент Имя")
    private String client_name;
     @Column(name = "Станд. Описание")
    private String standard_description;
     @Column(name = "Общее Описание")
    private String description;
     @Column(name = "Страховка")
    private String insurance;
     @Column(name = "Страховая Сумма")
    private String insurance_amount;
     @Column(name = "Кол-во Мест")
    private String count;
     @Column(name = "Вес (кг)")
    private String weight;
     @Column(name = "Объем (м3)")
    private String volume;
     @Column(name = "Тип Места Появления")
    private String occurence_checkpoint_type;
     @Column(name = "Код Места Появления")
    private String occurence_checkpoint_code;
     @Column(name = "Тип Места Назначения")
    private String destination_checkpoint_type;
     @Column(name = "Валюта Код")
    private String currency_code;
     @Column(name = "Стоимость")
    private String cost;
     @Column(name = "Таможенное Оформление")
    private String customs_clearance;
     @Column(name = "Брокер Код")
    private String broker_code;
     @Column(name = "Брокер Название")
    private String broker_name;
     @Column(name = "Получатель Код")
    private String consignee_code;
     @Column(name = "Получатель Название")
    private String consignee_name;
     @Column(name = "Условия Поставки")
    private String delivery_conditions;
     @Column(name = "Терминал")
    private String terminal;
     @Column(name = "Заявка Клиента")
    private String order_id;
     @Column(name = "Контейнер Но.")
    private String container_number;
     @Column(name = "ДТ Но.")
    private String dt_number;
     @Column(name = "Отдел")
    private String department_name;
     @Column(name = "Вагон Но.")
    private String wagon_number;
     @Column(name = "Выпуск ДТ")
    private String release_date;
     @Column(name = "Количество Товаров")
    private String product_count;
     @Column(name = "Регистрация ДТ")
    private String dt_registration_date;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public Cargo() {
    }

    public Cargo(String id) {
        this.id = id;
    }

    public Cargo(String id, String transport, String master_document, String sender_code, String sender_name, String appearance_date, String destination_checkpoint_code, String transport_line_code, String transport_line_name, String client_id, String client_name, String standard_description, String description, String insurance, String insurance_amount, String count, String weight, String volume, String occurence_checkpoint_type, String occurence_checkpoint_code, String destination_checkpoint_type, String currency_code, String cost, String customs_clearance, String broker_code, String broker_name, String consignee_code, String consignee_name, String delivery_conditions, String terminal, String order_id, String container_number, String dt_number, String department_name, String wagon_number, String release_date, String product_count, String dt_registration_date) {
        this.id = id;
        this.transport = transport;
        this.master_document = master_document;
        this.sender_code = sender_code;
        this.sender_name = sender_name;
        this.appearance_date = appearance_date;
        this.destination_checkpoint_code = destination_checkpoint_code;
        this.transport_line_code = transport_line_code;
        this.transport_line_name = transport_line_name;
        this.client_id = client_id;
        this.client_name = client_name;
        this.standard_description = standard_description;
        this.description = description;
        this.insurance = insurance;
        this.insurance_amount = insurance_amount;
        this.count = count;
        this.weight = weight;
        this.volume = volume;
        this.occurence_checkpoint_type = occurence_checkpoint_type;
        this.occurence_checkpoint_code = occurence_checkpoint_code;
        this.destination_checkpoint_type = destination_checkpoint_type;
        this.currency_code = currency_code;
        this.cost = cost;
        this.customs_clearance = customs_clearance;
        this.broker_code = broker_code;
        this.broker_name = broker_name;
        this.consignee_code = consignee_code;
        this.consignee_name = consignee_name;
        this.delivery_conditions = delivery_conditions;
        this.terminal = terminal;
        this.order_id = order_id;
        this.container_number = container_number;
        this.dt_number = dt_number;
        this.department_name = department_name;
        this.wagon_number = wagon_number;
        this.release_date = release_date;
        this.product_count = product_count;
        this.dt_registration_date = dt_registration_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getMaster_document() {
        return master_document;
    }

    public void setMaster_document(String master_document) {
        this.master_document = master_document;
    }

    public String getSender_code() {
        return sender_code;
    }

    public void setSender_code(String sender_code) {
        this.sender_code = sender_code;
    }

    public String getSender_name() {
        return sender_name;
    }

    public void setSender_name(String sender_name) {
        this.sender_name = sender_name;
    }

    public String getAppearance_date() {
        return appearance_date;
    }

    public void setAppearance_date(String appearance_date) {
        this.appearance_date = appearance_date;
    }

    public String getDestination_checkpoint_code() {
        return destination_checkpoint_code;
    }

    public void setDestination_checkpoint_code(String destination_checkpoint_code) {
        this.destination_checkpoint_code = destination_checkpoint_code;
    }

    public String getTransport_line_code() {
        return transport_line_code;
    }

    public void setTransport_line_code(String transport_line_code) {
        this.transport_line_code = transport_line_code;
    }

    public String getTransport_line_name() {
        return transport_line_name;
    }

    public void setTransport_line_name(String transport_line_name) {
        this.transport_line_name = transport_line_name;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getStandard_description() {
        return standard_description;
    }

    public void setStandard_description(String standard_description) {
        this.standard_description = standard_description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getInsurance_amount() {
        return insurance_amount;
    }

    public void setInsurance_amount(String insurance_amount) {
        this.insurance_amount = insurance_amount;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getOccurence_checkpoint_type() {
        return occurence_checkpoint_type;
    }

    public void setOccurence_checkpoint_type(String occurence_checkpoint_type) {
        this.occurence_checkpoint_type = occurence_checkpoint_type;
    }

    public String getOccurence_checkpoint_code() {
        return occurence_checkpoint_code;
    }

    public void setOccurence_checkpoint_code(String occurence_checkpoint_code) {
        this.occurence_checkpoint_code = occurence_checkpoint_code;
    }

    public String getDestination_checkpoint_type() {
        return destination_checkpoint_type;
    }

    public void setDestination_checkpoint_type(String destination_checkpoint_type) {
        this.destination_checkpoint_type = destination_checkpoint_type;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getCustoms_clearance() {
        return customs_clearance;
    }

    public void setCustoms_clearance(String customs_clearance) {
        this.customs_clearance = customs_clearance;
    }

    public String getBroker_code() {
        return broker_code;
    }

    public void setBroker_code(String broker_code) {
        this.broker_code = broker_code;
    }

    public String getBroker_name() {
        return broker_name;
    }

    public void setBroker_name(String broker_name) {
        this.broker_name = broker_name;
    }

    public String getConsignee_code() {
        return consignee_code;
    }

    public void setConsignee_code(String consignee_code) {
        this.consignee_code = consignee_code;
    }

    public String getConsignee_name() {
        return consignee_name;
    }

    public void setConsignee_name(String consignee_name) {
        this.consignee_name = consignee_name;
    }

    public String getDelivery_conditions() {
        return delivery_conditions;
    }

    public void setDelivery_conditions(String delivery_conditions) {
        this.delivery_conditions = delivery_conditions;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getContainer_number() {
        return container_number;
    }

    public void setContainer_number(String container_number) {
        this.container_number = container_number;
    }

    public String getDt_number() {
        return dt_number;
    }

    public void setDt_number(String dt_number) {
        this.dt_number = dt_number;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getWagon_number() {
        return wagon_number;
    }

    public void setWagon_number(String wagon_number) {
        this.wagon_number = wagon_number;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getProduct_count() {
        return product_count;
    }

    public void setProduct_count(String product_count) {
        this.product_count = product_count;
    }

    public String getDt_registration_date() {
        return dt_registration_date;
    }

    public void setDt_registration_date(String dt_registration_date) {
        this.dt_registration_date = dt_registration_date;
    }

    // KEEP METHODS - put your custom methods here
    @Override
    public void save() {
        DaoTask.getInstance().getSession().getCargoDao().insertOrReplace(this);
    }

    public Order getOrder() {
        if (TextUtils.isEmpty(getOrder_id())) {
            return null;
        }
        return DaoTask.getInstance().getSession().getOrderDao().queryBuilder().where(OrderDao.Properties.Id.eq(getOrder_id())).unique();
    }
    // KEEP METHODS END

}
