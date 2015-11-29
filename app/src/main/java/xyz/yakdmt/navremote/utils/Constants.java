package xyz.yakdmt.navremote.utils;

import xyz.yakdmt.navremote.database.Cargo;
import xyz.yakdmt.navremote.database.Checkpoint;
import xyz.yakdmt.navremote.database.Client;
import xyz.yakdmt.navremote.database.Comment;
import xyz.yakdmt.navremote.database.Contact;
import xyz.yakdmt.navremote.database.Delivery;
import xyz.yakdmt.navremote.database.Order;
import xyz.yakdmt.navremote.database.RouteRow;
import xyz.yakdmt.navremote.database.Work;

/**
 * Created by yakdmt on 27/11/15.
 */
public class Constants {

    public final static String FILE_EXTENSION = ".xlsx";

    public final static String SERVER_PATH = "/public_html/base/";

    public final static String[] FILENAME_ARRAY = {"Пример Грузы", "Пример Доставки", "Пример Заявки","Пример Клиенты", "Пример Комментарии",
            "Пример Контакты", "Пример Маршруты", "Пример Пункты", "Пример Работы" };

    public final static Class[] CLASSES_ARRAY = {Cargo.class, Delivery.class, Order.class, Client.class, Comment.class,
            Contact.class, RouteRow.class, Checkpoint.class, Work.class};

    public final static String SERVER_NAME = "31.220.16.199";
    public final static String USER_NAME = "u201936004";
    public final static String PASS = "ftp_pass";

    public final static int PORT = 21;


}
