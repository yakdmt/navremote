package xyz.yakdmt.navremote.utils;

import android.content.Context;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

import xyz.yakdmt.navremote.R;

/**
 * Created by yakdmt on 07/11/15.
 */
public class SchemeParser {

    private static class InstanceHolder {
        public static SchemeParser instance = new SchemeParser();
    }

    private SchemeParser(){

    }

    public static SchemeParser getInstance() {
        return InstanceHolder.instance;
    }

    public void doParse(Context context) throws XmlPullParserException {
        XmlPullParser parser = prepareParser(context);
        StringBuilder builder = new StringBuilder();
        builder.append("package xyz.yakdmt;\n\n");
        builder.append("public class Template {\n\n");
        int count = 0;
        while (parser.getEventType()!= XmlPullParser.END_DOCUMENT) {
            if (parser.getEventType() == XmlPullParser.START_TAG
                    && parser.getName().equals("mxCell")) {
                if (parser.getAttributeCount()>1 && parser.getAttributeName(1).equals("value")) {
                    if (parser.getAttributeCount()>2 && parser.getAttributeName(2).equals("style") &&
                            parser.getAttributeValue(2).startsWith("swimlane")) {
                        if (count>0) {
                            builder.append("};\n\n");
                        }
                        builder.append("public static String[] ");
                        builder.append(parser.getAttributeValue(1)).append(" = { ");
                        count++;
                        Log.i("XmlParser","----------");
                        Log.i("XmlParser", parser.getAttributeValue(1));
                        Log.i("XmlParser","----------");
                    } else {
                        builder.append(parser.getAttributeValue(1)).append(", ");
                        Log.i("XmlParser", parser.getAttributeValue(1));
                    }
                }
            }
            try {
                parser.next();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        builder.append("};\n\n}");
        //writeToFile(builder);
    }

    private XmlPullParser prepareParser(Context context) {
        return context.getResources().getXml(R.xml.database);
    }

    private void writeToFile(StringBuilder builder) {
        Log.i("XmlParser", builder.toString());
    }


}
