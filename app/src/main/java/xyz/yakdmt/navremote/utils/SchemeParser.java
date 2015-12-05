package xyz.yakdmt.navremote.utils;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

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
        return context.getResources().getXml(R.xml.db_template);
    }

    private void writeToFile(StringBuilder builder) {
        Log.i("XmlParser", builder.toString());
    }

    public void createXml() {
        try {
            File root = new File(Environment.getExternalStorageDirectory(), "navremote");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, "db_schema");
            FileWriter writer = new FileWriter(gpxfile);
            StringBuilder builder = new StringBuilder();
            builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            builder.append("<mxGraphModel dx=\"1954\" dy=\"1571\" grid=\"1\" gridSize=\"10\" guides=\"1\" tooltips=\"1\" connect=\"1\" arrows=\"1\" fold=\"1\" page=\"1\" pageScale=\"1\" pageWidth=\"1826\" pageHeight=\"2169\" background=\"#ffffff\" math=\"0\"><root><mxCell id=\"0\"/><mxCell id=\"1\" parent=\"0\"/>");
            int id = 2;
            for (int i=0; i<Constants.CLASSES_ARRAY.length; i++) {
                Class clazz = Constants.CLASSES_ARRAY[i];
                builder.append("<mxCell id=\"" + id + "\" value=\"" + Constants.FILENAME_ARRAY[i] + "\" style=\"swimlane;html=1;fontStyle=0;childLayout=stackLayout;horizontal=1;startSize=26;fillColor=#e0e0e0;horizontalStack=0;resizeParent=1;resizeLast=0;collapsible=1;marginBottom=0;swimlaneFillColor=#ffffff;rounded=1;\" vertex=\"1\" parent=\"1\"><mxGeometry x=\"" + i * 100 + "\" y=\"33\" width=\"160\" height=\"" + clazz.getFields().length * 26 + "\" as=\"geometry\"/></mxCell>");
                int parentId = id;
                id++;
                for (int j=0; j<clazz.getDeclaredFields().length; j++) {
                    Field field = clazz.getDeclaredFields()[j];
                    Column columnName = field.getAnnotation(Column.class);
                    if (columnName!=null) {
                        String name = columnName.name();
                        name = name+"("+field.getName()+")";
                        builder.append("<mxCell id=\""+id+"\" value=\""+name+"\" style=\"text;html=1;strokeColor=none;fillColor=none;spacingLeft=4;spacingRight=4;whiteSpace=wrap;overflow=hidden;rotatable=0;points=[[0,0.5],[1,0.5]];portConstraint=eastwest;\" vertex=\"1\" parent=\""+parentId+"\"><mxGeometry y=\""+(++j*26)+"\" width=\"160\" height=\"26\" as=\"geometry\"/></mxCell>");
                        id++;
                    }
                }
            }
            builder.append("</root></mxGraphModel>");
            writer.append(builder.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
