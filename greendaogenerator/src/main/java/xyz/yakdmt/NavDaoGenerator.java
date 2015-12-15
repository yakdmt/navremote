package xyz.yakdmt;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Index;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;

public class NavDaoGenerator {

    public static void main(String args[]) throws Exception {

        Schema schema = new Schema(4, "xyz.yakdmt.navremote.database");
        schema.enableKeepSectionsByDefault();


        Entity order = schema.addEntity("Order");
        order.implementsSerializable();
        order.implementsInterface("Saveable");
        //checked
        order.addStringProperty("id").codeBeforeField(getAnnotation("Заявка Но.")).unique().primaryKey();
        order.addStringProperty("date").codeBeforeField(getAnnotation("Дата Документа"));
        order.addStringProperty("time").codeBeforeField(getAnnotation("Время Документа"));

        order.addStringProperty("client_id").codeBeforeField(getAnnotation("Клиент Но."));
        order.addStringProperty("contact_id").codeBeforeField(getAnnotation("Контакт"));

        order.addStringProperty("arrival_date").codeBeforeField(getAnnotation("Требуемая Дата Доставки"));
        order.addStringProperty("performer_code").codeBeforeField(getAnnotation("Исполнитель"));
        order.addStringProperty("state").codeBeforeField(getAnnotation("Состояние"));
        order.addStringProperty("transport").codeBeforeField(getAnnotation("Вид Транспорта"));
        order.addStringProperty("departure_date").codeBeforeField(getAnnotation("Дата отправки"));
        order.addStringProperty("departure_country_code").codeBeforeField(getAnnotation("Отправление Код Страны"));
        order.addStringProperty("departure_checkpoint_type").codeBeforeField(getAnnotation("Отправление  Тип Пункта"));
        order.addStringProperty("destination_checkpoint_type").codeBeforeField(getAnnotation("Назначение Тип Пункта"));
        order.addStringProperty("departure_country_name").codeBeforeField(getAnnotation("Отправление Страна Название"));
        order.addStringProperty("departure_checkpoint_name").codeBeforeField(getAnnotation("Место Отправления"));
        order.addStringProperty("departure_checkpoint_address").codeBeforeField(getAnnotation("Отправление Адрес"));
        order.addStringProperty("destination_checkpoint_code").codeBeforeField(getAnnotation("Назначение Код Пункта"));
        order.addStringProperty("destination_checkpoint_name").codeBeforeField(getAnnotation("Назначение Название Пункта"));
        order.addStringProperty("destination_checkpoint_address").codeBeforeField(getAnnotation("Назначение Адрес Пункта"));
        order.addStringProperty("destination_country_code").codeBeforeField(getAnnotation("Назначение Код Страны"));
        order.addStringProperty("destination_country_name").codeBeforeField(getAnnotation("Назначение Название Страны"));

        order.addStringProperty("brutto_weight").codeBeforeField(getAnnotation("Вес брутто(кг)"));
        order.addStringProperty("volume").codeBeforeField(getAnnotation("Объем (м3)"));
        order.addStringProperty("count").codeBeforeField(getAnnotation("Кол-во Мест"));

        order.addStringProperty("cargo_description").codeBeforeField(getAnnotation("Описание Груза"));
        order.addStringProperty("client_name").codeBeforeField(getAnnotation("Клиент Название"));
        order.addStringProperty("performer_name").codeBeforeField(getAnnotation("Имя Исполнителя"));


        ///checked
        Entity client = schema.addEntity("Client");
        client.implementsInterface("Saveable");
        client.implementsSerializable();
        client.addStringProperty("id").codeBeforeField(getAnnotation("Но.")).unique().primaryKey();
        client.addStringProperty("name").codeBeforeField(getAnnotation("Название"));
        client.addStringProperty("address_actual").codeBeforeField(getAnnotation("Адрес (факт.) "));
        client.addStringProperty("address_legal").codeBeforeField(getAnnotation("Адрес(юрид.)"));
        client.addStringProperty("contact").codeBeforeField(getAnnotation("Контакт"));
        client.addStringProperty("phone").codeBeforeField(getAnnotation("Телефон"));
        client.addStringProperty("priority_group").codeBeforeField(getAnnotation("Приоритет Группа"));
        client.addStringProperty("inn").codeBeforeField(getAnnotation("ИНН"));
        client.addStringProperty("email").codeBeforeField(getAnnotation("E-Mail"));
        client.addStringProperty("kpp").codeBeforeField(getAnnotation("КПП"));
        client.addStringProperty("manager").codeBeforeField(getAnnotation("Персонал.  Менеджер"));
        client.addStringProperty("external_name").codeBeforeField(getAnnotation("Расш. Название"));
        client.addStringProperty("extended_address").codeBeforeField(getAnnotation("Расш. Адрес"));



        //order.addToOne(client, clientId);

        //checked
        Entity contact = schema.addEntity("Contact");
        contact.implementsSerializable();
        contact.implementsInterface("Saveable");
        contact.addStringProperty("id").unique().primaryKey().codeBeforeField(getAnnotation("Но."));
        contact.addStringProperty("name").codeBeforeField(getAnnotation("Название"));
        contact.addStringProperty("client_id").codeBeforeField(getAnnotation("Клиент"));
        contact.addStringProperty("client_name").codeBeforeField(getAnnotation("Название Фирмы"));
        contact.addStringProperty("postal_index").codeBeforeField(getAnnotation("Почтовый Индекс"));
        contact.addStringProperty("region_code").codeBeforeField(getAnnotation("Код страны/региона"));
        contact.addStringProperty("phone").codeBeforeField(getAnnotation("Телефон"));
        contact.addStringProperty("mobile_phone").codeBeforeField(getAnnotation("Мобильный Телефон"));
        contact.addStringProperty("fax").codeBeforeField(getAnnotation("Факс"));
        contact.addStringProperty("manager_code").codeBeforeField(getAnnotation("Код Менеджера"));


        ///////////checked
        Entity cargo = schema.addEntity("Cargo");
        cargo.implementsSerializable();
        cargo.implementsInterface("Saveable");
        cargo.addStringProperty("id").unique().primaryKey().codeBeforeField(getAnnotation("Груз ID"));
        cargo.addStringProperty("transport").codeBeforeField(getAnnotation("Транспорт"));
        cargo.addStringProperty("master_document").codeBeforeField(getAnnotation("Мастер Документ"));
        cargo.addStringProperty("sender_code").codeBeforeField(getAnnotation("Отправитель Код"));
        cargo.addStringProperty("sender_name").codeBeforeField(getAnnotation("Отправитель Имя"));
        cargo.addStringProperty("appearance_date").codeBeforeField(getAnnotation("Дата Появления"));
        cargo.addStringProperty("destination_checkpoint_code").codeBeforeField(getAnnotation("Место Назначения"));
        cargo.addStringProperty("transport_line_code").codeBeforeField(getAnnotation("Транспортная Линия Код"));
        cargo.addStringProperty("transport_line_name").codeBeforeField(getAnnotation("Транспортная Линия Имя"));
        cargo.addStringProperty("client_id").codeBeforeField(getAnnotation("Клиент Но."));
        cargo.addStringProperty("client_name").codeBeforeField(getAnnotation("Клиент Имя"));
        cargo.addStringProperty("standard_description").codeBeforeField(getAnnotation("Станд. Описание"));
        cargo.addStringProperty("description").codeBeforeField(getAnnotation("Общее Описание"));
        cargo.addStringProperty("insurance").codeBeforeField(getAnnotation("Страховка"));
        cargo.addStringProperty("insurance_amount").codeBeforeField(getAnnotation("Страховая Сумма"));
        cargo.addStringProperty("count").codeBeforeField(getAnnotation("Кол-во Мест"));
        cargo.addStringProperty("weight").codeBeforeField(getAnnotation("Вес (кг)"));
        cargo.addStringProperty("volume").codeBeforeField(getAnnotation("Объем (м3)"));
        cargo.addStringProperty("occurence_checkpoint_type").codeBeforeField(getAnnotation("Тип Места Появления"));
        cargo.addStringProperty("occurence_checkpoint_code").codeBeforeField(getAnnotation("Код Места Появления"));
        cargo.addStringProperty("destination_checkpoint_type").codeBeforeField(getAnnotation("Тип Места Назначения"));
        cargo.addStringProperty("currency_code").codeBeforeField(getAnnotation("Валюта Код"));
        cargo.addStringProperty("cost").codeBeforeField(getAnnotation("Стоимость"));
        cargo.addStringProperty("customs_clearance").codeBeforeField(getAnnotation("Таможенное Оформление"));
        cargo.addStringProperty("broker_code").codeBeforeField(getAnnotation("Брокер Код"));
        cargo.addStringProperty("broker_name").codeBeforeField(getAnnotation("Брокер Название"));
        cargo.addStringProperty("consignee_code").codeBeforeField(getAnnotation("Получатель Код"));
        cargo.addStringProperty("consignee_name").codeBeforeField(getAnnotation("Получатель Название"));
        cargo.addStringProperty("delivery_conditions").codeBeforeField(getAnnotation("Условия Поставки"));
        cargo.addStringProperty("terminal").codeBeforeField(getAnnotation("Терминал"));
        cargo.addStringProperty("order_id").codeBeforeField(getAnnotation("Заявка Клиента"));
        cargo.addStringProperty("container_number").codeBeforeField(getAnnotation("Контейнер Но."));
        cargo.addStringProperty("dt_number").codeBeforeField(getAnnotation("ДТ Но."));
        cargo.addStringProperty("department_name").codeBeforeField(getAnnotation("Отдел"));
        cargo.addStringProperty("wagon_number").codeBeforeField(getAnnotation("Вагон Но."));
        cargo.addStringProperty("release_date").codeBeforeField(getAnnotation("Выпуск ДТ"));
        cargo.addStringProperty("product_count").codeBeforeField(getAnnotation("Количество Товаров"));
        cargo.addStringProperty("dt_registration_date").codeBeforeField(getAnnotation("Регистрация ДТ"));


        ///checked
        Entity delivery = schema.addEntity("Delivery");
        delivery.implementsSerializable();
        delivery.implementsInterface("Saveable");
        delivery.addStringProperty("id").unique().codeBeforeField(getAnnotation("Но.")).primaryKey();
        delivery.addStringProperty("transportation_method").codeBeforeField(getAnnotation("Метод Перевозки"));
        delivery.addStringProperty("status").codeBeforeField(getAnnotation("Статус"));
        delivery.addStringProperty("auto_train_number").codeBeforeField(getAnnotation("Автопоезд Но."));
        delivery.addStringProperty("auto_carrier").codeBeforeField(getAnnotation("АвтоПеревозчик"));
        delivery.addStringProperty("description").codeBeforeField(getAnnotation("Доставка Описание"));
        delivery.addStringProperty("cargo_id").codeBeforeField(getAnnotation("Груз Но."));
        delivery.addStringProperty("client_name").codeBeforeField(getAnnotation("Клиент Название"));
        delivery.addStringProperty("cargo_description").codeBeforeField(getAnnotation("Доставка Описание Груза"));
        delivery.addStringProperty("expected_start_date").codeBeforeField(getAnnotation("Ож. Начало Дата"));
        delivery.addStringProperty("actual_start_date").codeBeforeField(getAnnotation("Факт. Начало Дата"));
        delivery.addStringProperty("start_checkpoint_name").codeBeforeField(getAnnotation("Первый Пункт Название"));
        delivery.addStringProperty("finish_checkpoint_name").codeBeforeField(getAnnotation("Посл. Пункт Название"));
        delivery.addStringProperty("start_country").codeBeforeField(getAnnotation("Страна Начало Маршрута"));
        delivery.addStringProperty("expected_arrival_terminal_date").codeBeforeField(getAnnotation("Ож. Приход Терминал Дата"));
        delivery.addStringProperty("actual_arrival_terminal_date").codeBeforeField(getAnnotation("Факт. Приход Терминал Дата"));
        delivery.addStringProperty("terminal_name").codeBeforeField(getAnnotation("Терминал"));
        delivery.addStringProperty("receiver_name").codeBeforeField(getAnnotation("Получатель"));
        delivery.addStringProperty("actual_release_terminal_date").codeBeforeField(getAnnotation("Факт. Выпуск Терминал Дата"));
        delivery.addStringProperty("actual_finish_date").codeBeforeField(getAnnotation("Факт. Заверш. Дата"));
        delivery.addStringProperty("performer_name").codeBeforeField(getAnnotation("Исполнитель"));
        delivery.addStringProperty("gtd_release_date").codeBeforeField(getAnnotation("ГТД Дата Выпуска"));
        delivery.addStringProperty("gtd_number").codeBeforeField(getAnnotation("ГТД Но."));
        delivery.addStringProperty("tl_number").codeBeforeField(getAnnotation("ТЛ Рейс Но."));
        delivery.addStringProperty("tl_transport_type").codeBeforeField(getAnnotation("ТЛ Тип Транспорта"));
        delivery.addStringProperty("tl_transport_number").codeBeforeField(getAnnotation("ТЛ Транспорт Но."));
        delivery.addStringProperty("container_number").codeBeforeField(getAnnotation("Контейнер Но."));
        delivery.addStringProperty("wagon_number").codeBeforeField(getAnnotation("Вагон Но."));


        //checked
        Entity product = schema.addEntity("Product");
        product.implementsInterface("Saveable");
        product.addStringProperty("id").notNull().primaryKey().unique();
        Property propertyOrderId = product.addStringProperty("order_id").codeBeforeField(getAnnotation("Заявка Но.")).getProperty();
        Property propertyStringNumber = product.addStringProperty("string_number").codeBeforeField(getAnnotation("Строка Но.")).getProperty();
        Index indexProduct = new Index();
        indexProduct.addProperty(propertyOrderId);
        indexProduct.addProperty(propertyStringNumber);
        indexProduct.makeUnique();
        product.addStringProperty("brutto_weight").codeBeforeField(getAnnotation("Вес Брутто(кг)"));
        product.addStringProperty("count").codeBeforeField(getAnnotation("Количество"));
        product.addStringProperty("description").codeBeforeField(getAnnotation("Описание/Комментарий"));
        product.addStringProperty("measure_unit").codeBeforeField(getAnnotation("Ед. Измерения"));


        //checked
        Entity document = schema.addEntity("Document");
        document.implementsInterface("Saveable");
        document.addStringProperty("id").notNull().primaryKey().unique();
        Property propertyOrderId1 = document.addStringProperty("order_id").codeBeforeField(getAnnotation("Объект Но.")).getProperty();
        Property propertyStringNumber1 = document.addStringProperty("string_number").codeBeforeField(getAnnotation("Line No.")).getProperty();
        Index indexDocument = new Index();
        indexDocument.addProperty(propertyOrderId1);
        indexDocument.addProperty(propertyStringNumber1);
        indexDocument.makeUnique();
        document.addStringProperty("type").codeBeforeField(getAnnotation("Тип"));
        document.addStringProperty("document_name").codeBeforeField(getAnnotation("Документ Но."));
        document.addStringProperty("comment").codeBeforeField(getAnnotation("Комментарий"));
        document.addStringProperty("document_path").codeBeforeField(getAnnotation("Имя Файла"));
        document.addStringProperty("creator").codeBeforeField(getAnnotation("Создал"));

        //checked
        Entity checkpoint = schema.addEntity("Checkpoint");
        checkpoint.implementsInterface("Saveable");
        checkpoint.addStringProperty("id").codeBeforeField(getAnnotation("Код")).primaryKey();
        checkpoint.addStringProperty("name").codeBeforeField(getAnnotation("Название"));
        checkpoint.addStringProperty("country_code").codeBeforeField(getAnnotation("Код страны"));
        checkpoint.addStringProperty("info").codeBeforeField(getAnnotation("Доп. Информация"));
        checkpoint.addStringProperty("type").codeBeforeField(getAnnotation("Тип"));


        //checked
        Entity routeRow = schema.addEntity("RouteRow");
        routeRow.implementsInterface("Saveable");
        routeRow.addStringProperty("id").notNull().primaryKey().unique();
        Property property1 = routeRow.addStringProperty("delivery_id").codeBeforeField(getAnnotation("Доставка Но.")).getProperty();
        Property property2 = routeRow.addStringProperty("string_number").codeBeforeField(getAnnotation("Строка Но.")).getProperty();
        Index index = new Index();
        index.addProperty(property1);
        index.addProperty(property2);
        index.makeUnique();
        routeRow.addIndex(index);
        routeRow.addStringProperty("position").codeBeforeField(getAnnotation("Позиция"));
        routeRow.addStringProperty("checkpoint_id").codeBeforeField(getAnnotation("Пункт Но."));
        routeRow.addStringProperty("checkpoint_description").codeBeforeField(getAnnotation("Пункт Описание"));
        routeRow.addStringProperty("procedure_type").codeBeforeField(getAnnotation("Операция Тип"));
        routeRow.addStringProperty("expected_arrival_date").codeBeforeField(getAnnotation("Приб. Ож. Дата"));
        routeRow.addStringProperty("actual_arrival_date").codeBeforeField(getAnnotation("Приб. Факт. Дата"));
        routeRow.addStringProperty("actual_arrival_time").codeBeforeField(getAnnotation("Приб. Факт. Время"));
        routeRow.addStringProperty("actual_departure_date").codeBeforeField(getAnnotation("Убыт. Факт. Дата"));
        routeRow.addStringProperty("actual_departure_time").codeBeforeField(getAnnotation("Убыт. Факт. Время"));
        routeRow.addStringProperty("expected_departure_date").codeBeforeField(getAnnotation("Убыт. Ож. Дата"));
        routeRow.addStringProperty("expected_departure_time").codeBeforeField(getAnnotation("Убыт. Ож. Время"));
        routeRow.addStringProperty("country_code").codeBeforeField(getAnnotation("Код Страны"));
        routeRow.addStringProperty("address").codeBeforeField(getAnnotation("Адрес"));
        routeRow.addStringProperty("checkpoint_type").codeBeforeField(getAnnotation("Пункт Тип Расшир."));
        routeRow.addStringProperty("performer").codeBeforeField(getAnnotation("Исполнитель"));
        routeRow.addStringProperty("performer_dept").codeBeforeField(getAnnotation("Отдел Исполнителя"));
        routeRow.addStringProperty("active").codeBeforeField(getAnnotation("Активная"));


        ////checked
        Entity comment = schema.addEntity("Comment");
        comment.implementsInterface("Saveable");
        comment.addStringProperty("id").codeBeforeField(getAnnotation("Запись Но.")).unique().primaryKey();
        comment.addStringProperty("object_id").codeBeforeField(getAnnotation("Объект ID"));
        comment.addStringProperty("date").codeBeforeField(getAnnotation("Дата"));
        comment.addStringProperty("object_type").codeBeforeField(getAnnotation("Тип Объекта"));
        comment.addStringProperty("text").codeBeforeField(getAnnotation("Комментарий"));
        comment.addStringProperty("author").codeBeforeField(getAnnotation("Автор"));
        comment.addStringProperty("department").codeBeforeField(getAnnotation("Отдел"));


        //checked
        Entity work = schema.addEntity("Work");
        work.implementsInterface("Saveable");
        work.addStringProperty("id").unique().primaryKey().codeBeforeField(getAnnotation("Операция Но."));
        work.addStringProperty("work_code").codeBeforeField(getAnnotation("Работа Код"));
        work.addStringProperty("work_type").codeBeforeField(getAnnotation("Работа Тип"));
        work.addStringProperty("measure_unit").codeBeforeField(getAnnotation("Единица Измерения Код"));
        work.addStringProperty("count").codeBeforeField(getAnnotation("Количество"));
        work.addStringProperty("responsible_worker").codeBeforeField(getAnnotation("Ответственный Работник"));
        work.addStringProperty("comment").codeBeforeField(getAnnotation("Комментарий"));
        work.addStringProperty("working_place").codeBeforeField(getAnnotation("Место выполнения работы"));
        work.addStringProperty("description").codeBeforeField(getAnnotation("Работа Описание"));
        work.addStringProperty("cargo_id").codeBeforeField(getAnnotation("Груз ID"));
        work.addStringProperty("delivery_id").codeBeforeField(getAnnotation("Доставка Но."));
        work.addStringProperty("actual_finish_date").codeBeforeField(getAnnotation("Факт. Дата Завершения"));
        work.addStringProperty("actual_finish_time").codeBeforeField(getAnnotation("Факт. Время Завершения"));
        work.addStringProperty("responsible_department").codeBeforeField(getAnnotation("Ответствен. Отдел"));

        Entity sort = schema.addEntity("Sort");
        sort.addIntProperty("id").primaryKey();
        sort.addStringProperty("name").unique();

        new DaoGenerator().generateAll(schema, "../navremote/app/src/main/java/");

    }

    public static String getAnnotation(String entityName) {
        System.out.println(entityName);
        return "@Column(name = \""+entityName+"\")";
    }


}
