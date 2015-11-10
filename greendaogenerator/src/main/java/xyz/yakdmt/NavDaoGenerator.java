package xyz.yakdmt;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;

public class NavDaoGenerator {

    public static void main(String args[]) throws Exception {

        Schema schema = new Schema(4, "xyz.yakdmt.navremote.database");
        schema.enableKeepSectionsByDefault();
        Entity order = schema.addEntity("Order");
        order.implementsSerializable();
        order.addStringProperty("id").unique().primaryKey();
        order.addStringProperty("date");
        order.addStringProperty("time");
        order.addStringProperty("manager");
        ///order.addStringProperty("client_id");
        //order.addStringProperty("contact_id");
        order.addStringProperty("document_path");
        order.addStringProperty("performer_code");
        order.addStringProperty("performer_name");
        order.addStringProperty("state");
        order.addStringProperty("dangerous");
        order.addStringProperty("receiver_code");
        order.addStringProperty("receiver_name");
        order.addStringProperty("declarant_code");
        order.addStringProperty("declarant_name");
        order.addStringProperty("declarant_department");
        order.addStringProperty("transport");
        order.addStringProperty("departure_date");
        order.addStringProperty("departure_country_code");
        order.addStringProperty("departure_country_name");
        order.addStringProperty("departure_checkpoint_type");
        order.addStringProperty("departure_checkpoint_code");
        order.addStringProperty("departure_checkpoint_name");
        order.addStringProperty("departure_checkpoint_address");
        order.addStringProperty("destination_country_code");
        order.addStringProperty("destination_country_name");
        order.addStringProperty("destination_checkpoint_type");
        order.addStringProperty("destination_checkpoint_code");
        order.addStringProperty("destination_checkpoint_name");
        order.addStringProperty("destination_checkpoint_address");
        //order.addStringProperty("cargo_id");
        //order.addStringProperty("delivery_id");
        order.addStringProperty("brutto_weight");
        order.addStringProperty("netto_weight");
        order.addStringProperty("volume");
        order.addStringProperty("count");
        order.addStringProperty("cargo_description");
        order.addStringProperty("client_name");
        order.addStringProperty("comment");

        Entity client = schema.addEntity("Client");
        client.addStringProperty("id").unique().primaryKey();
        client.addStringProperty("name");
        client.addStringProperty("last_comment");
        client.addStringProperty("email");
        client.addStringProperty("phone");
        client.addStringProperty("contact");
        client.addStringProperty("address");

        Property clientId = order.addStringProperty("client_id").getProperty();
        order.addToOne(client, clientId);

        Entity contact = schema.addEntity("Contact");
        contact.addStringProperty("id").unique().primaryKey();
        contact.addStringProperty("client_id");
        contact.addStringProperty("name");
        contact.addStringProperty("client_name");
        contact.addStringProperty("postal_index");
        contact.addStringProperty("region_code");
        contact.addStringProperty("phone");
        contact.addStringProperty("mobile_phone");
        contact.addStringProperty("manager_code");

        Property contactId = order.addStringProperty("contact_id").getProperty();
        order.addToOne(contact, contactId);

        Entity cargo = schema.addEntity("Cargo");
        cargo.implementsSerializable();
        cargo.addStringProperty("id").unique().primaryKey();
        cargo.addStringProperty("transport");
        cargo.addStringProperty("master_document");
        cargo.addStringProperty("sender_code");
        cargo.addStringProperty("sender_name");
        cargo.addStringProperty("appearance_date");
        cargo.addStringProperty("destination_checkpoint_code");
        cargo.addStringProperty("transport_line_code");
        cargo.addStringProperty("transport_line_name");
        //cargo.addStringProperty("client_id");
        cargo.addStringProperty("client_name");
        cargo.addStringProperty("description");
        cargo.addStringProperty("insurance_amount");
        cargo.addStringProperty("insurance");
        cargo.addStringProperty("count");
        cargo.addStringProperty("weight");
        cargo.addStringProperty("volume");
        cargo.addStringProperty("occurence_checkpoint_type");
        cargo.addStringProperty("occurence_checkpoint_code");
        cargo.addStringProperty("destination_checkpoint_type");
        cargo.addStringProperty("currency_code");
        cargo.addStringProperty("cost");
        cargo.addStringProperty("customs_clearance");
        cargo.addStringProperty("broker_code");
        cargo.addStringProperty("broker_name");
        cargo.addStringProperty("delivery_conditions");
        cargo.addStringProperty("priority");
        cargo.addStringProperty("processing_mode");
        cargo.addStringProperty("consignee_code");
        cargo.addStringProperty("consignee_name");
        cargo.addStringProperty("route");
        cargo.addStringProperty("contract_number");
        cargo.addStringProperty("performer_type");
        cargo.addStringProperty("performer_id");
        cargo.addStringProperty("performer_name");
        cargo.addStringProperty("status");
        cargo.addStringProperty("expected_departure_date");
        cargo.addStringProperty("expected_arrival_date");
        cargo.addStringProperty("ready_state");
        //cargo.addStringProperty("order_id");
        cargo.addStringProperty("container_number");
        cargo.addStringProperty("department_name");
        cargo.addStringProperty("product_count");
        cargo.addStringProperty("dt_registration_date");
        cargo.addStringProperty("documents_check_date");
        cargo.addStringProperty("customs_payment_date");
        cargo.addStringProperty("release_date");
        cargo.addStringProperty("inspectial_date");
        cargo.addStringProperty("terminal");
        cargo.addStringProperty("extradited_from_stock");
        cargo.addStringProperty("customs_start_date");
        cargo.addStringProperty("customs_end_date");
        cargo.addStringProperty("executed_works");
        Property cargoId = order.addStringProperty("cargo_id").getProperty();
        order.addToOne(cargo, cargoId);
        Property cargoClientId = cargo.addStringProperty("client_id").getProperty();
        cargo.addToOne(client, cargoClientId);
        Property cargoOrderId = cargo.addStringProperty("order_id").getProperty();
        cargo.addToOne(order, cargoOrderId);

        Entity delivery = schema.addEntity("Delivery");
        delivery.implementsSerializable();
        delivery.addStringProperty("id").unique().primaryKey();
        delivery.addStringProperty("transportation_method");
        delivery.addStringProperty("status");
        delivery.addStringProperty("auto_train_number");
        delivery.addStringProperty("auto_carrier");
        delivery.addStringProperty("description");
        delivery.addStringProperty("cargo_id");
        delivery.addStringProperty("client_name");
        delivery.addStringProperty("cargo_description");
        delivery.addStringProperty("expected_start_date");
        delivery.addStringProperty("actual_start_date");
        delivery.addStringProperty("start_checkpoint_name");
        delivery.addStringProperty("finish_checkpoint_name");
        delivery.addStringProperty("start_country");
        delivery.addStringProperty("expected_arrival_terminal_date");
        delivery.addStringProperty("actual_arrival_terminal_date");
        delivery.addStringProperty("terminal_name");
        delivery.addStringProperty("receiver_name");
        delivery.addStringProperty("actual_release_terminal_date");
        delivery.addStringProperty("actual_finish_date");
        delivery.addStringProperty("performer_name");
        delivery.addStringProperty("gtd_release_date");
        delivery.addStringProperty("gtd_number");
        delivery.addStringProperty("container_number");
        delivery.addStringProperty("wagon_number");
        Property deliveryId = order.addStringProperty("deliveryId").getProperty();
        order.addToOne(delivery, deliveryId);

        Entity product = schema.addEntity("Product");
        Property orderId = product.addStringProperty("orderId").getProperty();
        product.addToOne(order, orderId);
        product.addStringProperty("stringNo");
        product.addStringProperty("brutto_weight");
        product.addStringProperty("count");
        product.addStringProperty("description");


        Entity document = schema.addEntity("Document");
        Property orderId1 = document.addStringProperty("orderId").getProperty();
        document.addToOne(order, orderId1);
        document.addStringProperty("id");
        document.addStringProperty("document_name");
        document.addStringProperty("document_path");
        document.addStringProperty("creator");


        Entity checkpoint = schema.addEntity("Checkpoint");
        checkpoint.addStringProperty("id").primaryKey();
        checkpoint.addStringProperty("name");
        checkpoint.addStringProperty("country_code");
        checkpoint.addStringProperty("info");
        checkpoint.addStringProperty("type");
        checkpoint.addStringProperty("city_name");



        Entity user = schema.addEntity("User");
        user.addStringProperty("id").unique().primaryKey();
        user.addStringProperty("password");
        user.addStringProperty("username");

        Entity routeRow = schema.addEntity("RouteRow");
        routeRow.addStringProperty("id").unique().primaryKey();
        routeRow.addStringProperty("delivery_id");
        routeRow.addStringProperty("string_number");
        routeRow.addStringProperty("position");
        routeRow.addStringProperty("checkpoint_id");
        routeRow.addStringProperty("checkpoint_description");
        routeRow.addStringProperty("procedure_type");
        routeRow.addStringProperty("expected_arrival_date");
        routeRow.addStringProperty("actual_arrival_date");
        routeRow.addStringProperty("actual_arrival_time");
        routeRow.addStringProperty("actual_departure_date");
        routeRow.addStringProperty("actual_departure_time");
        routeRow.addStringProperty("expected_departure_date");
        routeRow.addStringProperty("expected_departure_time");
        routeRow.addStringProperty("country_code");
        routeRow.addStringProperty("country_name");
        routeRow.addStringProperty("address");

        Entity comment = schema.addEntity("Comment");
        comment.addStringProperty("id").unique().primaryKey();
        comment.addStringProperty("object_id");
        comment.addStringProperty("object_type");
        comment.addStringProperty("date");
        comment.addStringProperty("text");
        comment.addStringProperty("author");
        comment.addStringProperty("department");

        Entity work = schema.addEntity("Work");
        work.addStringProperty("id").unique().primaryKey();
        work.addStringProperty("work_code");
        work.addStringProperty("work_type");
        work.addStringProperty("measure_unit");
        work.addStringProperty("count");
        work.addStringProperty("responsible_worker");
        work.addStringProperty("comment");
        work.addStringProperty("working_place");
        work.addStringProperty("description");
        work.addStringProperty("delivery_id");
        work.addStringProperty("cargo_id");
        work.addStringProperty("actual_finish_date");
        work.addStringProperty("actual_finish_time");
        work.addStringProperty("creator");
        work.addStringProperty("responsible_department");

        //ToMany podcastToUrls = podcast.addToMany(podcastUrl, podcastId);

        new DaoGenerator().generateAll(schema, "../navremote/app/src/main/java/");
    }
}
