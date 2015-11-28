package xyz.yakdmt.navremote.database;

import de.greenrobot.dao.DaoException;
import xyz.yakdmt.navremote.utils.Saveable;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table "ORDER".
 */
public class Order implements java.io.Serializable, Saveable {

    private String id;
    private String date;
    private String time;
    private String manager;
    private String document_path;
    private String performer_code;
    private String performer_name;
    private String state;
    private String dangerous;
    private String receiver_code;
    private String receiver_name;
    private String declarant_code;
    private String declarant_name;
    private String declarant_department;
    private String transport;
    private String departure_date;
    private String departure_country_code;
    private String departure_country_name;
    private String departure_checkpoint_type;
    private String departure_checkpoint_code;
    private String departure_checkpoint_name;
    private String departure_checkpoint_address;
    private String destination_country_code;
    private String destination_country_name;
    private String destination_checkpoint_type;
    private String destination_checkpoint_code;
    private String destination_checkpoint_name;
    private String destination_checkpoint_address;
    private String brutto_weight;
    private String netto_weight;
    private String volume;
    private String count;
    private String cargo_description;
    private String client_name;
    private String comment;
    private String client_id;
    private String contact_id;
    private String cargo_id;
    private String deliveryId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient OrderDao myDao;

    private Client client;
    private String client__resolvedKey;

    private Contact contact;
    private String contact__resolvedKey;

    private Cargo cargo;
    private String cargo__resolvedKey;

    private Delivery delivery;
    private String delivery__resolvedKey;


    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public Order() {
    }

    public Order(String id) {
        this.id = id;
    }

    public Order(String id, String date, String time, String manager, String document_path, String performer_code, String performer_name, String state, String dangerous, String receiver_code, String receiver_name, String declarant_code, String declarant_name, String declarant_department, String transport, String departure_date, String departure_country_code, String departure_country_name, String departure_checkpoint_type, String departure_checkpoint_code, String departure_checkpoint_name, String departure_checkpoint_address, String destination_country_code, String destination_country_name, String destination_checkpoint_type, String destination_checkpoint_code, String destination_checkpoint_name, String destination_checkpoint_address, String brutto_weight, String netto_weight, String volume, String count, String cargo_description, String client_name, String comment, String client_id, String contact_id, String cargo_id, String deliveryId) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.manager = manager;
        this.document_path = document_path;
        this.performer_code = performer_code;
        this.performer_name = performer_name;
        this.state = state;
        this.dangerous = dangerous;
        this.receiver_code = receiver_code;
        this.receiver_name = receiver_name;
        this.declarant_code = declarant_code;
        this.declarant_name = declarant_name;
        this.declarant_department = declarant_department;
        this.transport = transport;
        this.departure_date = departure_date;
        this.departure_country_code = departure_country_code;
        this.departure_country_name = departure_country_name;
        this.departure_checkpoint_type = departure_checkpoint_type;
        this.departure_checkpoint_code = departure_checkpoint_code;
        this.departure_checkpoint_name = departure_checkpoint_name;
        this.departure_checkpoint_address = departure_checkpoint_address;
        this.destination_country_code = destination_country_code;
        this.destination_country_name = destination_country_name;
        this.destination_checkpoint_type = destination_checkpoint_type;
        this.destination_checkpoint_code = destination_checkpoint_code;
        this.destination_checkpoint_name = destination_checkpoint_name;
        this.destination_checkpoint_address = destination_checkpoint_address;
        this.brutto_weight = brutto_weight;
        this.netto_weight = netto_weight;
        this.volume = volume;
        this.count = count;
        this.cargo_description = cargo_description;
        this.client_name = client_name;
        this.comment = comment;
        this.client_id = client_id;
        this.contact_id = contact_id;
        this.cargo_id = cargo_id;
        this.deliveryId = deliveryId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getOrderDao() : null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getDocument_path() {
        return document_path;
    }

    public void setDocument_path(String document_path) {
        this.document_path = document_path;
    }

    public String getPerformer_code() {
        return performer_code;
    }

    public void setPerformer_code(String performer_code) {
        this.performer_code = performer_code;
    }

    public String getPerformer_name() {
        return performer_name;
    }

    public void setPerformer_name(String performer_name) {
        this.performer_name = performer_name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDangerous() {
        return dangerous;
    }

    public void setDangerous(String dangerous) {
        this.dangerous = dangerous;
    }

    public String getReceiver_code() {
        return receiver_code;
    }

    public void setReceiver_code(String receiver_code) {
        this.receiver_code = receiver_code;
    }

    public String getReceiver_name() {
        return receiver_name;
    }

    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name;
    }

    public String getDeclarant_code() {
        return declarant_code;
    }

    public void setDeclarant_code(String declarant_code) {
        this.declarant_code = declarant_code;
    }

    public String getDeclarant_name() {
        return declarant_name;
    }

    public void setDeclarant_name(String declarant_name) {
        this.declarant_name = declarant_name;
    }

    public String getDeclarant_department() {
        return declarant_department;
    }

    public void setDeclarant_department(String declarant_department) {
        this.declarant_department = declarant_department;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(String departure_date) {
        this.departure_date = departure_date;
    }

    public String getDeparture_country_code() {
        return departure_country_code;
    }

    public void setDeparture_country_code(String departure_country_code) {
        this.departure_country_code = departure_country_code;
    }

    public String getDeparture_country_name() {
        return departure_country_name;
    }

    public void setDeparture_country_name(String departure_country_name) {
        this.departure_country_name = departure_country_name;
    }

    public String getDeparture_checkpoint_type() {
        return departure_checkpoint_type;
    }

    public void setDeparture_checkpoint_type(String departure_checkpoint_type) {
        this.departure_checkpoint_type = departure_checkpoint_type;
    }

    public String getDeparture_checkpoint_code() {
        return departure_checkpoint_code;
    }

    public void setDeparture_checkpoint_code(String departure_checkpoint_code) {
        this.departure_checkpoint_code = departure_checkpoint_code;
    }

    public String getDeparture_checkpoint_name() {
        return departure_checkpoint_name;
    }

    public void setDeparture_checkpoint_name(String departure_checkpoint_name) {
        this.departure_checkpoint_name = departure_checkpoint_name;
    }

    public String getDeparture_checkpoint_address() {
        return departure_checkpoint_address;
    }

    public void setDeparture_checkpoint_address(String departure_checkpoint_address) {
        this.departure_checkpoint_address = departure_checkpoint_address;
    }

    public String getDestination_country_code() {
        return destination_country_code;
    }

    public void setDestination_country_code(String destination_country_code) {
        this.destination_country_code = destination_country_code;
    }

    public String getDestination_country_name() {
        return destination_country_name;
    }

    public void setDestination_country_name(String destination_country_name) {
        this.destination_country_name = destination_country_name;
    }

    public String getDestination_checkpoint_type() {
        return destination_checkpoint_type;
    }

    public void setDestination_checkpoint_type(String destination_checkpoint_type) {
        this.destination_checkpoint_type = destination_checkpoint_type;
    }

    public String getDestination_checkpoint_code() {
        return destination_checkpoint_code;
    }

    public void setDestination_checkpoint_code(String destination_checkpoint_code) {
        this.destination_checkpoint_code = destination_checkpoint_code;
    }

    public String getDestination_checkpoint_name() {
        return destination_checkpoint_name;
    }

    public void setDestination_checkpoint_name(String destination_checkpoint_name) {
        this.destination_checkpoint_name = destination_checkpoint_name;
    }

    public String getDestination_checkpoint_address() {
        return destination_checkpoint_address;
    }

    public void setDestination_checkpoint_address(String destination_checkpoint_address) {
        this.destination_checkpoint_address = destination_checkpoint_address;
    }

    public String getBrutto_weight() {
        return brutto_weight;
    }

    public void setBrutto_weight(String brutto_weight) {
        this.brutto_weight = brutto_weight;
    }

    public String getNetto_weight() {
        return netto_weight;
    }

    public void setNetto_weight(String netto_weight) {
        this.netto_weight = netto_weight;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getCargo_description() {
        return cargo_description;
    }

    public void setCargo_description(String cargo_description) {
        this.cargo_description = cargo_description;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getContact_id() {
        return contact_id;
    }

    public void setContact_id(String contact_id) {
        this.contact_id = contact_id;
    }

    public String getCargo_id() {
        return cargo_id;
    }

    public void setCargo_id(String cargo_id) {
        this.cargo_id = cargo_id;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }

    /** To-one relationship, resolved on first access. */
    public Client getClient() {
        String __key = this.client_id;
        if (client__resolvedKey == null || client__resolvedKey != __key) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ClientDao targetDao = daoSession.getClientDao();
            Client clientNew = targetDao.load(__key);
            synchronized (this) {
                client = clientNew;
            	client__resolvedKey = __key;
            }
        }
        return client;
    }

    public void setClient(Client client) {
        synchronized (this) {
            this.client = client;
            client_id = client == null ? null : client.getId();
            client__resolvedKey = client_id;
        }
    }

    /** To-one relationship, resolved on first access. */
    public Contact getContact() {
        String __key = this.contact_id;
        if (contact__resolvedKey == null || contact__resolvedKey != __key) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ContactDao targetDao = daoSession.getContactDao();
            Contact contactNew = targetDao.load(__key);
            synchronized (this) {
                contact = contactNew;
            	contact__resolvedKey = __key;
            }
        }
        return contact;
    }

    public void setContact(Contact contact) {
        synchronized (this) {
            this.contact = contact;
            contact_id = contact == null ? null : contact.getId();
            contact__resolvedKey = contact_id;
        }
    }

    /** To-one relationship, resolved on first access. */
    public Cargo getCargo() {
        String __key = this.cargo_id;
        if (cargo__resolvedKey == null || cargo__resolvedKey != __key) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CargoDao targetDao = daoSession.getCargoDao();
            Cargo cargoNew = targetDao.load(__key);
            synchronized (this) {
                cargo = cargoNew;
            	cargo__resolvedKey = __key;
            }
        }
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        synchronized (this) {
            this.cargo = cargo;
            cargo_id = cargo == null ? null : cargo.getId();
            cargo__resolvedKey = cargo_id;
        }
    }

    /** To-one relationship, resolved on first access. */
    public Delivery getDelivery() {
        String __key = this.deliveryId;
        if (delivery__resolvedKey == null || delivery__resolvedKey != __key) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            DeliveryDao targetDao = daoSession.getDeliveryDao();
            Delivery deliveryNew = targetDao.load(__key);
            synchronized (this) {
                delivery = deliveryNew;
            	delivery__resolvedKey = __key;
            }
        }
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        synchronized (this) {
            this.delivery = delivery;
            deliveryId = delivery == null ? null : delivery.getId();
            delivery__resolvedKey = deliveryId;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

    // KEEP METHODS - put your custom methods here
    @Override
    public void save() {
        DaoTask.getInstance().getSession().getOrderDao().insertOrReplace(this);
    }
    // KEEP METHODS END

}
